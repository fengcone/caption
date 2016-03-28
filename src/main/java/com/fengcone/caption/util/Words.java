package com.fengcone.caption.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.StringUtils;

public class Words {
	Map<String, Integer> map = new HashMap<String, Integer>();
	Set<String> Myword = new HashSet<String>();
	Integer number = 0;
	public static void main(String[] args) throws Exception {
		Words words = new Words();
		words.createMySet(new File("D:\\Caption\\MyWord.txt"));// 拿到所有已知单词
		words.reverse(new File("D:\\CaptionData\\筛选出来的字幕srt文件"));// 需要遍历的文件夹
		words.deleteMap();
		// words.handleMap();
		words.writeToFile(new File("D:/CaptionData/result.txt"));// 写出到最后的结果
	}

	private void createMySet(File file) throws Exception {// 从文件中拿到所有已知单词
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String string;
		while ((string = br.readLine()) != null) {
			String[] strings = string.split("[\\W0123456789_]");
			for (String string2 : strings) {
				if (!Myword.contains(string2))
					Myword.add(string2);
			}
		}
		br.close();
	}

	private void deleteMap() {// 从map中删除所有已知单词
		for (String string : Myword) {
			string = string.toLowerCase();
			Set<String> set = handleString(string);
			for (String string2 : set) {
				if (map.containsKey(string2)) {
					map.remove(string2);
				}
			}
		}
	}

	private void writeToFile(File file) throws Exception {
		PrintWriter pw = new PrintWriter(file);
		Set<String> set = map.keySet();
		List<Word> list = new LinkedList<Word>();
		for (String string : set) {
			if (map.get(string) > 0) {// 定义筛选个数的条件
				list.add(new Word(string, map.get(string)));// 遍历map集合并将元素封装到Word类添加到list
			}
		}
		Collections.sort(list);// 对list进行排序
		for (Word word : list) {
			pw.println(word.toString());// 写到文件
		}
		pw.close();
	}

	private Set<String> handleString(String string) {
		Set<String> set = new HashSet<String>();
		String[] strings = { "es", "ed", "d", "s" };// 设置单词可能出现的后缀
		set.add(string);
		for (String string2 : strings) {
			set.add(string + string2);
			if (string.endsWith(string2)) {
				set.add(string.substring(0, string.length() - string2.length()));
				System.out.println(string);
				System.out.println(string.substring(0, string.length() - string2.length()));
			}
		}
		return set;
	}

	private void handleMap() {
		Set<String> set = map.keySet();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		for (String string : set) {
			map2.put(string, map.get(string)); // 复制一个行的map 避免遍历时删除后的各种问题
		}
		set = map2.keySet();
		for (String string : set) {
			Set<String> set2 = handleString(string);// 得到所有与string相关的单词
			Set<String> set3 = new HashSet<String>();// 新建Set集合
														// 用来存放在map里出现过的与string相关的单词
			set3.add(string);
			for (String string2 : set2) {
				if (map.containsKey(string2) && map.containsKey(string)) {
					set3.add(string2);// set3 是map里包含所有与string相关的单词
				}
			}
			boolean b = false;
			int value = 0;
			String key = "";
			for (String string2 : set3) {
				if (map.containsKey(string2)) {
					b = true;
					value = value + map.get(string2);
					key = string2 + "/" + key;
					map.remove(string2);// 删除map 里所有与string 相关的单词
				}
			}
			if (b) {
				map.put(key.substring(0, key.length() - 1), value); // 放入新的key与新的value
																	// 到map
			}
		}
	}

	private void reverse(File file) throws Exception {// 递归文件夹得到所有的文件
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.isDirectory()) {
				reverse(file2);
			} else if (file2.isFile()) {
				System.out.println(number++);
				handleTextfile(file2);// 处理此文件
			}
		}
	}

	private void handleTextfile(File file2) throws Exception {// 从文件中拿到所有的单词并统计数量
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
		String string;
		int index = 0;
		while ((string = br.readLine()) != null) {
			String[] strings = string.split("[^abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ']");
			
			for (String string2 : strings) {
				
				if (!StringUtils.isEmpty(string2)&&index !=0 &&string2.charAt(0)>65 && string2.charAt(0)< 90) {
					continue;
				}
				if (string2.equals("ndrew") || string2.equals("andrew")) {
					System.out.println(string2);
				}
				if (string2.length() >= 1 && string2.length() < 14) {// 对单词的长度进行筛选
					String str = string2.substring(1, string2.length());
					if (!str.matches("[qwertyuiopasdfghjklzxcvbnm'-]+")) {
						continue;
					}
					string2 = string2.toLowerCase();
					if (map.containsKey(string2)) {
						map.put(string2, map.get(string2) + 1);
					} else {
						map.put(string2, 1);
					}
				}
				index++;
			}
			index =0;
		}
		br.close();
	}
}

class Word implements Comparable<Word> {// 封装Word类实现Comparable接口
	String word;
	int number;

	@Override
	public String toString() {
		return word + "  " + number;
	}

	@Override
	public int compareTo(Word o) {
		return o.number - this.number;
	}

	public Word(String word, int number) {
		this.number = number;
		this.word = word;
	}
}
