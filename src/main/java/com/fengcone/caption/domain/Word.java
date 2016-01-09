package com.fengcone.caption.domain;

public class Word {
	private Long id;

	private String english;

	private String chinese;

	private Byte wordType;

	private String soundMark;

	private Byte type;

	private Byte weight;

	private String example;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english == null ? null : english.trim();
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese == null ? null : chinese.trim();
	}

	public Byte getWordType() {
		return wordType;
	}

	public void setWordType(Byte wordType) {
		this.wordType = wordType;
	}

	public String getSoundMark() {
		return soundMark;
	}

	public void setSoundMark(String soundMark) {
		this.soundMark = soundMark == null ? null : soundMark.trim();
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte getWeight() {
		return weight;
	}

	public void setWeight(Byte weight) {
		this.weight = weight;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example == null ? null : example.trim();
	}
}