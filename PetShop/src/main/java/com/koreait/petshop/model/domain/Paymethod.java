package com.koreait.petshop.model.domain;

public class Paymethod extends OrderSummary{
	private int paymethod_id;
	private String method;
	private OrderSummary orderSummary; //��ü vo�� �޾ƿ´� 
	
	public int getPaymethod_id() {
		return paymethod_id;
	}
	public void setPaymethod_id(int paymethod_id) {
		this.paymethod_id = paymethod_id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public OrderSummary getOrderSummary() {
		return orderSummary;
	}
	public void setOrderSummary(OrderSummary orderSummary) {
		this.orderSummary = orderSummary;
	}
	
	
	
	
}