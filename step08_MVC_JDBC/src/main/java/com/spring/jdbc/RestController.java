package com.spring.jdbc;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.Dept;
import com.spring.service.DeptService;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController// @Controller 와 @ResponseBody가 같이 붙어 있는 형태이다.
public class RestController {
	
	@Autowired
	private DeptServiceImpl deptService;
////////////////////////////////////////////////////////////////////// 데  이  터  조  회   ////////////////////////////////////////
	// 테스트 url 주소 : 포스트맨에서 방식을 get으로 바꾸고 http://localhost:8080/jdbc/api/test 입력.
	@GetMapping(value = "/api/test") // get은 데이터를 조회하는 것
	public String apiTest() {
		return "test"; // 특정자원(java.jsp등)을 의미함
	}
	// 테스트 url 주소 : 포스트맨에서 방식을 get으로 바꾸고 http://localhost:8080/jdbc/api/test2?deptno=10&dname=hihi&loc=busan
	@GetMapping(value = "/api/test2") // get은 데이터를 조회하는 것
	public String printDept(Dept dept) {
		System.out.println(dept.toString());
		return dept.toString(); // 특정자원(java.jsp등)을 의미함
	}
	////////////////////////////////////////////////////////////////////// 데  이  터  생  성   ////////////////////////////////////////	
	// 테스트 url 주소 : 포스트맨에서 방식을 post로 바꾸고 http://localhost:8080/jdbc/api/dept 입력.
	// 포스트 맨에서 데이터 전달 방법 : 카테고리 Body 선택 -> x-www-form-urlencoded 선택 후 값 입력
	@PostMapping(value = "/api/dept") // Post는 값을 생성을 해주는 것
	public void insertDept(Dept dept) {
		System.out.println(dept);
//		deptService.insertDept(dept);
	}
	// 테스트 url 주소 : 포스트맨에서 방식을 post로 바꾸고 http://localhost:8080/jdbc/api/deptjson
	// 포스트 맨에서 body 카테고리에서 raw를 선택 하고 타입을 JSON으로 바꿔준뒤 데이터를 {"deptno" : 80,"dname" : "JSON","loc" : "SPRING"} 입력해줌
	@PostMapping(value = "/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE) // Post는 값을 생성을 해주는 것 
	public void insertDeptJSON(@RequestBody Dept dept) {
		System.out.println(dept);
//		deptService.insertDept(dept);
	}
	
	// 테스트 url 주소 : 포스트맨에서 방식을 post로 바꾸고 http://localhost:8080/jdbc/api/deptjson
	// 포스트 맨에서 body 카테고리에서 x-www-form-urlencoded를 선택,키와 벨류를 {"deptno" : 80,"dname" : "JSON","loc" : "SPRING"}에 맞게입력함
	// 리액트와 연결 데이터 삽입 
	@PostMapping(value = "/api/deptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) // Post는 값을 생성을 해주는 것
	public Dept insertDeptForm(Dept dept) {
		deptService.insertDept(dept);
		return dept;
	}
	// 리액트와 연결 모든 데이터 검색 
	@RequestMapping(value = "/api/search", method = RequestMethod.GET)
	public List<Dept> getAllDepts(Locale locale, Model model) {
		return deptService.getAllDepts();
	}
	// 리액트와 연결 특정 데이터 검색 
	@GetMapping(value="/api/deptnoSearch.do/{id}") // url 전달시 슬래시 다음 숫자를 바로 쓰면 {id}에 값이 바로 저장된다.
	public Dept deptnoSearch(@PathVariable String id) {
		return deptService.getDeptByDeptno(Integer.parseInt(id));
	}
	// 리액트와 연결 데이터삭제 
	@GetMapping(value="/api/deptnoDelete.do/{deptno}") // url 전달시 슬래시 다음 숫자를 바로 쓰면 {id}에 값이 바로 저장된다.
	public void deleteData(@PathVariable String deptno) {
		deptService.deleteDept(Integer.parseInt(deptno));
	}
	// 리액트와 연결 데이터 업데이트
	@PostMapping(value = "/api/updatedeptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) // Post는 값을 생성을 해주는 것
	public Dept updateDeptForm(Dept dept) {
		deptService.UpdateDeptReact(dept.getDeptno(),dept.getDname(),dept.getLoc());
		return dept;
	}	
	
	
////////////////////////////////////////예시/////////////////////////////////////
//	// 주소 전달 법 : http://localhost:8080/url/urlTest.do/1
//	@GetMapping(value="urlTest.do/{id}") // url 전달시 슬래시 다음 숫자를 바로 쓰면 {id}에 값이 바로 저장된다.
//	public String urlTest1(@PathVariable String id) {
//		System.out.println("value = "+id);
//		return "forward:../view.jsp";
//	}
////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value = "/api/proxy")
	public String proxy() {
		System.out.println("/proxy");
		return "proxy";
	}
	
	@GetMapping(value = "/api/no-proxy")
	public String noProxy() {
		System.out.println("/no-proxy");
		return "no-proxy";
	}
	
	@GetMapping(value = "/api/no-cors")
	public String noCors() {
		System.out.println("/api/no-cors");
		return "api/no-cors";
	}
	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/api/cors")
	public String cors() {
		System.out.println("/api/cors");
		return "api/cors";
	}
	
}
