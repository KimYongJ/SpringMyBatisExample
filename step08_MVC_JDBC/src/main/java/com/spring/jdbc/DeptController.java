package com.spring.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@Controller
@SessionAttributes({"dname","loc","deptno"})
public class DeptController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	
	//이 함수는 Mybatis와 java의 연결을 테스트 하는 함수이다.
	@RequestMapping(value = "/j", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
	//	System.out.println(deptService.getDeptByDeptno(10));
	//	System.out.println(deptService.getDeptNameByDeptno(10));
	//	System.out.println(deptService.getDeptMap(10));
	//	System.out.println(deptService.getAllDepts());
	//	System.out.println(deptService.getAllDeptsMap());
		// 이하 insert 코드 
	//	deptService.insertDept(new Dept(60,"DUMMY","SEONGNAM"));
		
		// 이하 update 코드 : where deptno =60 and dname="DUMMY"인것의 loc를 moon으로 변경
//		deptService.updateDept(60,"DUMMY");
	//	Map<String, Object> data=new HashMap<String, Object>();
	//	data.put("deptno", 60);
	//	data.put("dname", "DUMMY");
		//deptService.updateDept(data);
		// 이하 delete 코드 : where loc="moon"
//		deptService.deleteDept("moon");
		
		return "home";
//		return "../../home"; //이걸 해제 해주어야 한다. 그래야 내가만든 home.jsp로 넘어감
	}
	
	
	// 이 함수는 home.jsp에서 데이터 전달하는 것을 확인하는 것이다.
	@RequestMapping("start.do")
	public String start(HttpServletRequest request,SessionStatus status) {
		HttpSession session = request.getSession();
		String deptnoValue = request.getParameter("deptnoValue");
		Dept dept=deptService.getDeptByDeptno(Integer.parseInt(deptnoValue));
		request.setAttribute("deptno", dept.getDeptno());
		request.setAttribute("dname", dept.getDname());
		request.setAttribute("loc", dept.getLoc());
		return "showView";
	}

}
