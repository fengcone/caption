package com.fengcone.caption.util;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fengcone.caption.domain.Word;
import com.fengcone.caption.mapper.WordMapper;

@Component
public class WordUtil {
	@Autowired
	private WordMapper wordDao;
	private SAXReader reader = new SAXReader();
	private static final String WORD_URL = "http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx/getEnCnTwoWayTranslator?Word=";

	public String getMean(String word) throws Exception {
		String xml = HttpClientUtil.getInstance().httpGet(WORD_URL + word, "utf-8");
		Document document = reader.read(new ByteArrayInputStream(xml
				.getBytes("utf-8")));
		@SuppressWarnings("unchecked")
		List<Element> elements = document.getRootElement().elements("string");
		String str = elements.get(0).getText();
		Word word1 = new Word();
		word1.setEnglish(str.split(": ")[0]);
		word1.setSoundMark(str.split(": ")[1]);
		str = elements.get(1).getText();
		word1.setChinese(str);
		wordDao.insert(word1);
		return word1.getChinese();
	}
}
