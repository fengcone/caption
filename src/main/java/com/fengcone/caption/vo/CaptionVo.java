package com.fengcone.caption.vo;

import java.util.List;

import com.fengcone.caption.domain.Caption;
import com.fengcone.caption.domain.Package;

public class CaptionVo {
	private Caption caption;
	private List<Package> packages;

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public Caption getCaption() {
		return caption;
	}

	public void setCaption(Caption caption) {
		this.caption = caption;
	}
}
