package com.fengcone.caption.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dingding.idmaker.IdMaker;
import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.domain.Movie;
import com.fengcone.caption.mapper.CaptionMapper;
import com.fengcone.caption.mapper.MovieMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class MovieDaoTest {
	@Autowired
	private CaptionMapper captionDao;
	@Autowired
	private MovieMapper movieDao;

	@Test
	public void testInsert() {
		Caption caption = new Caption();
		caption.setId(IdMaker.getId());
		caption.setChinese("哈哈");
		caption.setEnglish("xxxx");
		System.out.println(captionDao.insert(caption));
	}
	@Test
	public void testSelectAll(){
		List<Movie> movies = movieDao.selectAll();
		System.out.println(movies);
	}

}
