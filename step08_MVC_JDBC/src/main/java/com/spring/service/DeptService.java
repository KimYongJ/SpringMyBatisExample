package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.Dept;


public interface DeptService {
	public Dept getDeptByDeptno(int deptno);
	public String getDeptNameByDeptno(int deptno);
	public HashMap<String, Object> getDeptMap(int deptno);
	public List<Dept> getAllDepts();
	List<HashMap<String, Object>> getAllDeptsMap();
	public void insertDept(Dept dept);	
//	public void updateDept(int deptno,String dname);
	public void updateDept(Map data);
	public void deleteDept(int deptno);
	public void UpdateDeptReact(int deptno,String dname, String loc);
}
