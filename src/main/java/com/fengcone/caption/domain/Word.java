package com.fengcone.caption.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class Word {
    private String id;

    private String english;

    private String chinese;

    private Byte wordType;

    private String soundMark;

    private Byte type;

    private Byte weight;

    private String example;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
    @Override
   	public String toString() {
   		return ReflectionToStringBuilder.toString(this,
   				ToStringStyle.SHORT_PREFIX_STYLE);
   	}
    
}