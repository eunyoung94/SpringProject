package com.koreait.petshop.model.domain;

public class OrderState extends OrderSummary{
	private int order_state_id;
	private String state;
	private OrderSummary orderSummary;
	
	public int getOrder_state_id() {
		return order_state_id;
	}
	public void setOrder_state_id(int order_state_id) {
		this.order_state_id = order_state_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public OrderSummary getOrderSummary() {
		return orderSummary;
	}
	public void setOrderSummary(OrderSummary orderSummary) {
		this.orderSummary = orderSummary;
	}
	

	
	
	
}