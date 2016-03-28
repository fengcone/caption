package com.fengcone.caption.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.domain.Package;
import com.fengcone.caption.mapper.CaptionMapper;
import com.fengcone.caption.vo.CaptionVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class CaptionDaoTest {
	@Autowired
	CaptionMapper captionDao;
	private Map<String, Integer> wordsRank = new HashMap<String, Integer>();

	private ObjectMapper mapper = new ObjectMapper();

	@PostConstruct
	public void init() throws Exception{
		
		File file = new File("D:/CaptionData/result.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String word = null;
		Integer rank = 1;
		while ((word = reader.readLine())!=null) {
			word = word.split(" ")[0];
			wordsRank.put(word, rank);
			rank++;
		}
		reader.close();
	}
	@Test
	public void testCaptionDao() throws Exception {
		File file;
		PrintWriter writer;
		Caption caption1 = new Caption();
		caption1.setMovieId("lucy0001");
		List<Caption> captions = captionDao.selectByCondition(caption1);
		List<CaptionVo> vos = new ArrayList<CaptionVo>();
		for (Caption caption : captions) {
			CaptionVo vo = new CaptionVo();
			vo.setCaption(caption);
			List<Package> packages = new ArrayList<Package>();
			for (int i = 1; i <= 5; i++) {
				Package package1 = new Package();
				package1.setCaptionId(caption.getId());
				package1.setId(UUID.randomUUID().toString().substring(4, 13)
						.replaceAll("-", ""));
				// 其实这个又有多大的意义呢？ 字幕加载不还是用的Caption的吗？
				// package1.setStartTime(start+avg * (i-1));
				package1.setChinese(" ");
				if (i <= 3) {
					package1.setEnglish("");
				}
				// package1.setEndTime(start+avg * i);
				packages.add(package1);
			}
			vo.setPackages(packages);
			Map<String, Integer> map = new HashMap<String, Integer>(); 
			String [] words = caption.getEnglish().split("[^abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ']");
			for (String word : words) {
				map.put(word, wordsRank.get(word.toLowerCase()));
			}
			caption.setWordsRank(map);
			vo.setCaption(caption);
			vos.add(vo);
			if ((caption.getOrderNo() % 20) == 0) {
				String filepath = "D:/CaptionData//lucy";
				file = new File(filepath + (caption.getOrderNo() - 20) + "-"
						+ caption.getOrderNo()+".json");
				writer = new PrintWriter(file);
				String str = mapper.writeValueAsString(vos);
				writer.println(str);
				vos.clear();
				writer.close();
			}
		}
	}
}
