package com.fengcone.caption.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fengcone.caption.common.Response;
import com.fengcone.caption.domain.Word;
import com.fengcone.caption.mapper.WordMapper;
import com.fengcone.caption.param.GetMeanParam;
import com.fengcone.caption.param.MeanDTO;
import com.fengcone.caption.util.HttpClientUtil;
@Component
public class WordService {
	@Autowired
	WordMapper wordDao;
	private SAXReader reader = new SAXReader();
	private static final String WORD_URL = "http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx/getEnCnTwoWayTranslator?Word=";

	public Response<MeanDTO> getMean(GetMeanParam param) {
		Response<MeanDTO> response = new Response<MeanDTO>();
		String english = param.getEnglish();
		
		return response;
	}
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
