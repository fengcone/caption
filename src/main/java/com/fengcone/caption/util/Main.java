package com.fengcone.caption.util;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

public class Main {
	public static void main(String[] args) throws Exception {
//		File file = new File("D://lucy.txt");
//		PrintWriter writer = new PrintWriter(file);
//		for (int i = 0; i < 3000; i++) {
//			String str = UUID.randomUUID().toString().substring(4, 13).replaceAll("-", "");
//			str = "id:"+str;
//			writer.println(str);
//			System.out.println(str);
//		}
//		writer.close();
		
		File file = new File("D://download.txt");
		PrintWriter writer = new PrintWriter(file);
		for (int i = 266659; i > 260659; i--) {
			String text = "http://www.subom.net/index.php?m=down&a=sub&id=";
			text = text+i+"&s_id="+(i+8541);
			String html = HttpClientUtil.getInstance().httpGet(text,"utf-8");
			if (!html.startsWith("ERROR.")) {
				writer.println(text);
				System.out.println(text);
			}
			System.out.println(html);
		}
		writer.close();
	}
}
