package com.fengcone.caption.param;

public class AddPackageParam extends Param{
	private String captionId;
	private Integer startTime;
	private Integer endTime;
	private String english;
	private String chinese;
	public String getCaptionId() {
		return captionId;
	}
	public void setCaptionId(String captionId) {
		this.captionId = captionId;
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
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
}
