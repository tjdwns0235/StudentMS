package com.shs.action;

public class ActionForward {
	//view page(������� ���� �ѱ��� ����)
	private String path;
	
	//������ �ѱ涧 2���� ���
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
