package com.koreait.petshop.model.payment.repository;

import java.util.List;

import com.koreait.petshop.model.domain.OrderSummary;

public interface OrderSummaryDAO {
	public void insert(OrderSummary orderSummary); //오더써머리 넣기 
	public List selectAll(); // 전체 조회하기 
	public List select(int member_id); // 특정멤버만 조회

	
}
