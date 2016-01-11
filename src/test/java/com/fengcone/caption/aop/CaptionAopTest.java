package com.fengcone.caption.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengcone.caption.controller.EditController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class CaptionAopTest {
	@Autowired
	EditController controller;
	
	@Test
	public void test(){
		controller.test();
	}
}
