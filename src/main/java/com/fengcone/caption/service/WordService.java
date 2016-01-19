package com.fengcone.caption.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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

	public Response<MeanDTO> getMean(GetMeanParam param) throws Exception {
		Response<MeanDTO> response = new Response<MeanDTO>();
		MeanDTO dto = new MeanDTO();
		String english = param.getEnglish();
		List<Word> words = wordDao.selectByEnglish(english);
		if (CollectionUtils.isEmpty(words)) {
			words = getMean(english);
		}
		dto.setWords(words);
		response.setData(dto);
		return response;
	}

	public List<Word> getMean(String english) throws Exception {
		String xml = HttpClientUtil.getInstance().httpGet(WORD_URL + english,
				"utf-8");
		Document document = reader.read(new ByteArrayInputStream(xml
				.getBytes("utf-8")));
		@SuppressWarnings("unchecked")
		List<Element> elements = document.getRootElement().elements("string");
		String englishStr = elements.get(0).getText();
		String soundMark = englishStr.split(":")[1];
		String chineseStr = elements.get(1).getText();
		List<Word> words = new ArrayList<Word>();
		String[] chinese = chineseStr.split("\\|");
		for (String str : chinese) {
			Word word = new Word();
			word.setId(UUID.randomUUID().toString().substring(10, 18));
			word.setEnglish(english);
			if (str.split("\\.").length>1) {
				word.setChinese(str.split("\\.")[1]);
				word.setWordType(str.split("\\.")[0]+".");
			}else {
				word.setChinese(str);
			}
			word.setSoundMark(soundMark);
			wordDao.insert(word);
		}
		return words;
	}
}
