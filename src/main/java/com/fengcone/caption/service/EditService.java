package com.fengcone.caption.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fengcone.caption.common.CodeEnum;
import com.fengcone.caption.common.Response;
import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.domain.Movie;
import com.fengcone.caption.domain.Package;
import com.fengcone.caption.mapper.CaptionMapper;
import com.fengcone.caption.mapper.MovieMapper;
import com.fengcone.caption.mapper.PackageMapper;
import com.fengcone.caption.mapper.WordMapper;
import com.fengcone.caption.param.AddPackageParam;
import com.fengcone.caption.param.ChooseDTO;
import com.fengcone.caption.param.NextCaptionParam;
import com.fengcone.caption.param.Param;

@Service
public class EditService {
	@Autowired
	MovieMapper movieDao;
	@Autowired
	CaptionMapper captionDao;
	@Autowired
	WordMapper wordDao;
	@Autowired
	PackageMapper packageDao;

	public Response<ChooseDTO> choose() {
		Response<ChooseDTO> response = new Response<ChooseDTO>();
		List<Movie> movies = movieDao.selectAll();
		ChooseDTO data = new ChooseDTO();
		data.setMovies(movies);
		response.setData(data);
		return response;
	}
	public Response<Param> addPackage(AddPackageParam param){
		Package pac = new Package();
		pac.setCaptionId(param.getCaptionId());
		pac.setEndTime(param.getEndTime());
		pac.setChinese(param.getChinese());
		pac.setEnglish(param.getEnglish());
		pac.setId(UUID.randomUUID().toString().substring(0, 8));
		pac.setStartTime(param.getStartTime());
		packageDao.insert(pac);
		Response<Param> response = new Response<Param>();
		return response;
	}
	public Response<Caption> nextCaption(NextCaptionParam param){
		Response<Caption> response = new Response<Caption>();
		Caption condition = new Caption();
		condition.setMovieId(param.getMovieId());
		condition.setOrderNo(param.getOrderNo());
		List<Caption> captions = captionDao.selectByCondition(condition);
		if (!CollectionUtils.isEmpty(captions)) {
			response.setData(captions.get(0));
		}else {
			response.setCodeEnum(CodeEnum.NO_MORE_CAPTION);
		}
		return response;
	}
}
