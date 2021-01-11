package com.koreait.petshop.model.payment.repository;

import com.koreait.petshop.model.domain.OrderSummary;

public interface OrderSummaryDAO { // 상품 등록! 

	public void insert(OrderSummary orderSummary);
}
