package com.fengcone.caption.domain;

public class Word {
    private String id;

    private String english;

    private String chinese;

    private String wordType;

    private String soundMark;

    private String type;

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

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType == null ? null : wordType.trim();
    }

    public String getSoundMark() {
        return soundMark;
    }

    public void setSoundMark(String soundMark) {
        this.soundMark = soundMark == null ? null : soundMark.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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