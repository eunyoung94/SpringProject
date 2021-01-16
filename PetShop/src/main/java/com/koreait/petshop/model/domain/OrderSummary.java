package com.koreait.petshop.model.domain;

public class OrderSummary {
	private int order_summary_id;
	private int member_id;
	private int total_price;
	private String orderdate;
	private int order_state_id;
	
	private Paymethod paymethod;
	private int paymethod_id;
	
	public int getOrder_summary_id() {
		return order_summary_id;
	}
	public void setOrder_summary_id(int order_summary_id) {
		this.order_summary_id = order_summary_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getOrder_state_id() {
		return order_state_id;
	}
	public void setOrder_state_id(int order_state_id) {
		this.order_state_id = order_state_id;
	}
	public Paymethod getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(Paymethod paymethod) {
		this.paymethod = paymethod;
	}
	public int getPaymethod_id() {
		return paymethod_id;
	}
	public void setPaymethod_id(int paymethod_id) {
		this.paymethod_id = paymethod_id;
	}
	

	
}