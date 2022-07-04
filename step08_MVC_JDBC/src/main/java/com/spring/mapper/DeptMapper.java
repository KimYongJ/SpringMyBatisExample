package com.spring.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.dto.Dept;

public interface DeptMapper {
	// resultType
	// String
	public String getDeptNameByDeptno(int deptno);
	
	// 객체
	public Dept getDeptByDeptno(int deptno);
	
	// HashMap
	public HashMap<String, Object> getDeptMap(int deptno);
	
	// List
	public List<Dept> getAllDepts();
	
	// List<HashMap<String.Object>>
	List<HashMap<String, Object>> getAllDeptsMap();
	
	// parameter와 관련된 부분 실험, 
	// 객체를 insert 한다.
	public void insertDept(Dept dept);

	/*
	 * // Param을 이용해 키를 지정해주는 방법 
	 * public void updateDept(@Param("deptno") int deptno,@Param("dname") String dname);
	 */
	// Map으로 2개의 데이터를 전달하는 방법 
	public void updateDept(Map data);
	
	// 객체를 삭제 한다. delete
	public void deleteDept(int deptno);
	public void UpdateDeptReact(@Param("deptno") int deptno,@Param("dname")String dname,@Param("loc") String loc);
}
