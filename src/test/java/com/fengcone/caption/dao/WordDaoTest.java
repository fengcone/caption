package com.fengcone.caption.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengcone.caption.domain.Word;
import com.fengcone.caption.mapper.WordMapper;
import com.fengcone.caption.service.WordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class WordDaoTest {
	@Autowired
	WordService wordService;
	@Test 
	public void testGetByEnglish() throws Exception{
		String english = "mean";
		List<Word> words = wordService.getMean(english);
		System.out.println(words);
	}
}
