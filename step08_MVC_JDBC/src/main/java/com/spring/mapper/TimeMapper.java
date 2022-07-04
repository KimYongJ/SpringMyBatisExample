package com.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("Select NOW()") //db랑 연결을 쉽게도와주는 것
	public String getTime();
	
	public String getTime2();
}
