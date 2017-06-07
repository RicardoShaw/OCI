package com.oci.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oci.handler.GroupHandler;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/applicationContext.xml")
public class HandlerTest {
	@Autowired
	private GroupHandler groupHandler;
	
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
