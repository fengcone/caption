package com.fengcone.caption.util;

import java.io.File;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private static String URL = "http://www.zimuzu.tv/subtitle/";

	public static void main(String[] args) throws Exception {
		File file = new File("D://Down//download.txt");
		PrintWriter writer = new PrintWriter(file);
		try {
			for (int i = 45800; i > 0; i--) {
				try {
					String url = URL + i;
					String html = HttpClientUtil.getInstance().httpGet(url,
							"utf-8");
					Document document = Jsoup.parse(html);
					Elements elements = document.body().getElementsByTag("h3");
					String element = elements.get(1).child(0).attr("href");
					writer.println(element);
					System.out.println(element);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				if (i % 50 == 1) {
					writer.close();
					writer = new PrintWriter(new File("D://Down//download" + i
							+ ".txt"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}
