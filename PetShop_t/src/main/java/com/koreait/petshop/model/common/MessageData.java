package com.koreait.petshop.model.common;

public class MessageData {
	private int resultCode;// ����, ���� ������ �Ǵ� �ڵ�
	private String msg;//Ŭ���̾�Ʈ�� ���Ե� �޼��� 
	private String url; //Ŭ���̾�Ʈ�� ��û�� �������� url
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
