package com.spring.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;
@Service // 그냥 하나의 bean이 되는 것이다. 
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptMapper deptMapper;
	@Override
	public Dept getDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}
	@Override
	public String getDeptNameByDeptno(int deptno) {
		return deptMapper.getDeptNameByDeptno(deptno);
	}
	@Override
	public HashMap<String, Object> getDeptMap(int deptno) {
		return deptMapper.getDeptMap(deptno);
	}
	@Override
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}
	@Override
	public List<HashMap<String, Object>> getAllDeptsMap() {
		return deptMapper.getAllDeptsMap();
	}
	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	}

	/*
	 * // Param을 이용해 키를 지정해주는 방법
	 * 
	 * @Override public void updateDept(@Param("deptno") int deptno,@Param("dname")
	 * String dname) { deptMapper.updateDept(deptno,dname); }
	 */
	// Map으로 2개의 데이터를 전달하는 방법 
	@Override
	public void updateDept(Map data) {
		deptMapper.updateDept(data);		
	}
	
	@Override
	public void deleteDept(int deptno) {
		deptMapper.deleteDept(deptno);
	}
	@Override
	public void UpdateDeptReact(int deptno,String dname, String loc) {
		deptMapper.UpdateDeptReact(deptno,dname,loc);
	}
}
