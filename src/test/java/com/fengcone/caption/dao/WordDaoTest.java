package com.fengcone.caption.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CountDownLatch;

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
	@Autowired
	WordMapper wordDao;
	@Test
	public void testWashChinese(){
		List<Word> words = wordDao.selectByCondition(new Word());
		for (Word word : words) {
			if (word.getChinese().startsWith("vt")) {
				String chinese = word.getChinese();
				chinese = chinese.split("vt")[1];
				System.out.println(chinese);
				word.setChinese(chinese);
				word.setType("vt");
				wordDao.updateByPrimaryKey(word);
			}
		}
	}
	

	@Test
	public void testGetByEnglish() throws Exception {
		File file0 = new File("D:\\CaptionData\\result");
		File [] files = file0.listFiles();
		CountDownLatch latch = new CountDownLatch(files.length);
		for (File file : files) {
			String index = file.getName();
			MyThread thread = new MyThread(file, Integer.valueOf(index),latch);
			thread.start();
		}
		latch.await();
	}

	class MyThread extends Thread{
		private File file;
		private Integer index;
		CountDownLatch latch;

		public MyThread(File file, Integer index,CountDownLatch latch) {
			this.file = file;
			this.index = index;
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String str = "";
				while ((str = reader.readLine()) != null) {
					try {
						String word = str.split(" ")[0];
						List<Word> words = wordService.getMean(word, index);
						System.out.println(words.toString());
						System.out.println(index);
						index++;
					} catch (Exception e) {
						continue;
					}
				}
				reader.close();
				latch.countDown();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		File file = new File("D:\\CaptionData\\result.txt");
		Integer index = 1;
		String str = "";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		File file2 = new File("D:\\CaptionData\\result\\" + index);
		PrintWriter writer = new PrintWriter(file2);
		while ((str = reader.readLine()) != null) {
			if (index % 1000 == 0) {
				writer.close();
				file2 = new File("D:\\CaptionData\\result\\" + index );
				writer = new PrintWriter(file2);
			}
			writer.println(str.split(" ")[0]);
			index++;
		}
		writer.close();
		reader.close();
	}
}
