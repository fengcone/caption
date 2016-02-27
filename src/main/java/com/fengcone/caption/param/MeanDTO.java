package com.fengcone.caption.param;

import java.util.List;

import com.fengcone.caption.domain.Word;

public class MeanDTO extends Param{
	private List<Word> words;

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}
	
}
