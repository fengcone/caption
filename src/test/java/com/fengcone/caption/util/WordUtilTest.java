package com.fengcone.caption.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class WordUtilTest {
	@Autowired
	WordUtil wordUtil;
	@Test
	public void testGetMean() throws Exception{
		System.out.println(wordUtil.getMean("cup"));
	} 
}