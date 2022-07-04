// 실행법 : 해당 파일 우클릭 Run AS ==> JUnit Test 클릭
package com.spring.mapper;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//메인메소드 없이 실행시킬 것이기 때문에 누구에의해 실행될지 적어주는 어노테이션
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//등록한 설정파일들에 대해 읽어들이겠다는것,root-context.xml
public class DBconnectionTest {
	@Inject//말그대로 무엇인가를 주입해주는 어노테이션
	private DataSource ds;
	@Test // JUNIT에서 제공하고있는 TEST 어노테이션
	public void testConnection() {
		try(Connection con = ds.getConnection()){
			System.out.println("KYJ Con 값 ======="+con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
