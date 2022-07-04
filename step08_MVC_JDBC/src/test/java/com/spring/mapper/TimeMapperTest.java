package com.spring.mapper;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//메인메소드 없이 실행시킬 것이기 때문에 누구에의해 실행될지 적어주는 어노테이션
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//등록한 설정파일들에 대해 읽어들이겠다는것,root-context.xml
public class TimeMapperTest {
	@Inject//말그대로 무엇인가를 주입해주는 어노테이션
	private TimeMapper timeMapper;
	@Test // JUNIT에서 제공하고있는 TEST 어노테이션
	public void testGetTime() {
		System.out.println("KYJ TIME  : "+timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		System.out.println("KYJ TIME  : "+timeMapper.getTime2());
	}
}