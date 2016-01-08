package com.fengcone.caption.domain;

public class Package {
    private Long id;

    private Long captionId;

    private String chinese;

    private String english;

    private Integer startTime;

    private Integer endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaptionId() {
        return captionId;
    }

    public void setCaptionId(Long captionId) {
        this.captionId = captionId;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese == null ? null : chinese.trim();
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english == null ? null : english.trim();
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}