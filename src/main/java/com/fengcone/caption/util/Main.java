package com.fengcone.caption.util;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

public class Main {
	public static void main(String[] args) throws Exception {
		File file = new File("D://lucy.txt");
		PrintWriter writer = new PrintWriter(file);
		for (int i = 0; i < 3000; i++) {
			String str = UUID.randomUUID().toString().substring(4, 13).replaceAll("-", "");
			str = "id:"+str;
			writer.println(str);
			System.out.println(str);
		}
		writer.close();
	}
}
