package com.fengcone.caption.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dingding.idmaker.IdMaker;
import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.mapper.CaptionMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class MovieDaoTest {
	@Autowired
	CaptionMapper mapper;

	@Test
	public void testInsert() {
		Caption caption = new Caption();
		caption.setId(IdMaker.getId());
		caption.setChinese("哈哈");
		caption.setEnglish("xxxx");
		System.out.println(mapper.insert(caption));
	}

}
