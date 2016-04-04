package com.fengcone.caption.dao;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.domain.Movie;
import com.fengcone.caption.domain.Package;
import com.fengcone.caption.mapper.CaptionMapper;
import com.fengcone.caption.mapper.MovieMapper;
import com.fengcone.caption.mapper.PackageMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class MovieDaoTest {
	@Autowired
	private CaptionMapper captionDao;
	@Autowired
	private MovieMapper movieDao;
	@Autowired
	private PackageMapper packageDao;

	@Test
	public void testInsert() {
		Caption caption = new Caption();
		caption.setId(UUID.randomUUID().toString());
		caption.setChinese("哈哈");
		caption.setEnglish("xxxx");
		System.out.println(captionDao.insert(caption));
	}

	@Test
	public void testSelectAll() {
		List<Movie> movies = movieDao.selectAll();
		System.out.println(movies);
	}

	@Test
	public void testGenerateCaption() throws Exception {
		Caption caption0 = new Caption();
		caption0.setMovieId("lucy0001");
		List<Caption> captions = captionDao.selectByCondition(caption0);
		Collections.sort(captions, new Comparator<Caption>() {
			@Override
			public int compare(Caption item1, Caption item2) {
				return item1.getOrderNo() - item2.getOrderNo();
			}
		});
		PrintWriter writer = new PrintWriter(new File("D:\\CaptionData\\Lucy.srt"));
		for (Caption caption : captions) {
			Package package0 = new Package();
			package0.setCaptionId(caption.getId());
			List<Package> packages = packageDao.selectByCondition(package0);
			writer.println(caption.getOrderNo().toString());
			writer.println(getTimeStr(caption.getStartTime()) + " --> " + getTimeStr(caption.getEndTime()));
			String line3 = getLine3(caption.getEnglish(), packages);
			if (line3.trim() != "") {
				writer.println(line3);
			}
			writer.println(caption.getEnglish());
			writer.println();
		}
		writer.close();
	}

	private String caption2Str(Caption caption, List<Package> packages) {
		String line1 = caption.getOrderNo().toString();
		String line2 = getTimeStr(caption.getStartTime()) + " --> " + getTimeStr(caption.getEndTime());
		String line3 = getLine3(caption.getEnglish(), packages);
		String line4 = caption.getEnglish();
		return line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n";
	}

	private String getLine3(String english, List<Package> packages) {
		String result = "";
		List<PackageVo> vos = new ArrayList<PackageVo>();
		for (Package package1 : packages) {
			PackageVo vo = new PackageVo();
			vo.package1 = package1;
			String[] strs = english.split(package1.getEnglish());
			if (strs.length <= 1) {
				vo.sort = 0;
				continue;
			}
			vo.sort = strs[0].length();
			vos.add(vo);
		}
		Collections.sort(vos);
		for (PackageVo packageVo : vos) {
			Package package1 = packageVo.package1;
			String strs[] = english.split(package1.getEnglish());
			if (strs.length <= 1) {
				continue;
			}
			result = result + getSpace(strs[0].length()) + package1.getChinese();
			english = strs[1];
		}
		return result;
	}

	private String getSpace(Integer number) {
		String result = "";
		for (int i = 0; i < number; i++) {
			result = result + " ";
		}
		return result;

	}

	private static String getTimeStr(Integer time) {
		String mills = String.valueOf(time % 1000);
		String seconds = String.valueOf((time / 1000) % 60);
		String minutes = String.valueOf((time / (60 * 1000)) % 60);
		String hours = String.valueOf((time / (1000 * 60 * 60)) % 60);
		for (int i = 0; i < 3 - mills.length(); i++) {
			mills = "0" + mills;
		}
		if (seconds.length() == 1) {
			seconds = "0" + seconds;
		}
		if (minutes.length() == 1) {
			minutes = "0" + minutes;
		}
		if (hours.length() == 1) {
			hours = "0" + hours;
		}
		return hours + ":" + minutes + ":" + seconds + "," + mills;
	}

	public static void main(String[] args) {
		System.out.println("women\nnimen\ntamen");
	}

}

class PackageVo implements Comparable<PackageVo> {
	Package package1;
	Integer sort;

	@Override
	public int compareTo(PackageVo o) {
		return this.sort - o.sort;
	}

}
