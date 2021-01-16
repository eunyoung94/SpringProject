package com.koreait.petshop.model.payment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.exception.OrderSummaryException;
import com.koreait.petshop.model.domain.OrderSummary;

@Repository
public class MybatisOrderSummaryDAO implements OrderSummaryDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(OrderSummary orderSummary) throws OrderSummaryException {
		int result = sqlSessionTemplate.insert("OrderSummary.insert", orderSummary);
		if (result == 0) {
			throw new OrderSummaryException("주문요약 실패!");
		}
	}

	@Override
	public List selectAll() { // orderSummary 전체조회 , 
		return sqlSessionTemplate.selectList("OrderSummary.selectAll");
	}

	@Override
	public List select(int member_id) { //특정멤버만 조회
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("OrderSummary.select", member_id); 
	}
	
}
