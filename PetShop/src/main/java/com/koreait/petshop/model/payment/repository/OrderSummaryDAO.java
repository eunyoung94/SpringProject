package com.koreait.petshop.model.payment.repository;

import java.util.List;

import com.koreait.petshop.model.domain.OrderSummary;

public interface OrderSummaryDAO {
	public void insert(OrderSummary orderSummary); //������Ӹ� �ֱ� 
	public List selectAll(); // ��ü ��ȸ�ϱ� 
	public List select(int member_id); // Ư������� ��ȸ

	
}
