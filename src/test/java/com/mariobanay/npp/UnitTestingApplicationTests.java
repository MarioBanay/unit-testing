package com.mariobanay.npp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mariobanay.npp.UnitTestingApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestingApplicationTests {

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void applicationContextTest() {
		UnitTestingApplication.main(new String[] {});
	}

}
