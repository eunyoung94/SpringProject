package com.koreait.petshop.model.domain;

public class Cart extends Product{ //extends는 부모에서 선언! , 자식은 부모의것을 그대로 사용가능, 즉! product는 cart를 부모로 두었기 때문에 , product에 있는것을 전부 사용가능! 
	private int cart_id;
	private int quantity;
	private int member_id;
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	
}