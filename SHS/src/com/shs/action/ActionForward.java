package com.shs.action;

public class ActionForward {
	//view page(결과값을 어디로 넘길지 결정)
	private String path;
	
	//페이지 넘길때 2가지 방법
	//1) sendRedirect
	//2) forward
	//true > sendRedirect
	//false > forward
	
	private boolean isRedirect;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
