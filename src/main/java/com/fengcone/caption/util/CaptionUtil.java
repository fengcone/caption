package com.fengcone.caption.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.mapper.CaptionMapper;

public class CaptionUtil {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"ctx.xml");
		CaptionMapper captionDao = ctx.getBean(CaptionMapper.class);
		File file = new File("D:\\Caption\\caption\\The Shawshank Redemption.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String temp = null;
		Integer index = 1;
		while ((temp = reader.readLine()) != null) {
			if (temp.contains("-->")) {
				String chinese = reader.readLine();
				String english = reader.readLine();
				if (StringUtils.isEmpty(english.trim())) {
					continue;
				}
				if ('A' > english.charAt(0) || 'z' < english.charAt(0)) {
					continue;
				}
				Caption caption = new Caption();
				caption.setId(UUID.randomUUID().toString().substring(0, 8));
				caption.setOrderNo(index++);
				String[] time = temp.split("-->");
				caption.setStartTime(getTime(time[0].trim()));
				caption.setEndTime(getTime(time[1].trim()));
				caption.setChinese(chinese);
				caption.setEnglish(english);
				caption.setMovieId("Shawshank0001");
				System.out.println(chinese);
				System.out.println(english);
				captionDao.insert(caption);
			}

		}
		reader.close();

	}

	private static Integer getTime(String time) {
		Integer result = 0;
		String times[] = time.split("[,:]");
		result = result + Integer.valueOf(times[0]) * 60 * 60 * 1000
				+ Integer.valueOf(times[1]) * 60 * 1000
				+ Integer.valueOf(times[2]) * 1000 + Integer.valueOf(times[3]);
		return result;
	}

}
