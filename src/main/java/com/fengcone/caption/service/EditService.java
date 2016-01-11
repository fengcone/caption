package com.fengcone.caption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.domain.Movie;
import com.fengcone.caption.mapper.MovieMapper;
import com.fengcone.caption.param.ChooseData;

@Service
public class EditService {
	@Autowired
	MovieMapper movieDao;
	public Response<ChooseData> choose(){
		Response<ChooseData> response = new Response<ChooseData>();
		List<Movie> movies = movieDao.selectAll();
		ChooseData data = new ChooseData();
		data.setMovies(movies);
		response.setData(data);
		return response;
	}
	public void test() {
		System.out.println("hahahahhahahahahahhahahahahha");
	}
}
