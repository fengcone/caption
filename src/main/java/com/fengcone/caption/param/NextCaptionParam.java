package com.fengcone.caption.param;

public class NextCaptionParam extends Param {
	private String movieId;
	// 当前Caption的order
	private Integer orderNo;

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer order) {
		this.orderNo = order;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

}
