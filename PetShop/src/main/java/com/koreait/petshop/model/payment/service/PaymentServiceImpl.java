package com.koreait.petshop.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.exception.CartException;
import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.domain.OrderDetail;
import com.koreait.petshop.model.domain.OrderSummary;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Receiver;
import com.koreait.petshop.model.payment.repository.CartDAO;
import com.koreait.petshop.model.payment.repository.OrderDetailDAO;
import com.koreait.petshop.model.payment.repository.OrderSummaryDAO;
import com.koreait.petshop.model.payment.repository.PaymethodDAO;
import com.koreait.petshop.model.payment.repository.ReceiverDAO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private PaymethodDAO paymethodDAO;

	@Autowired
	private OrderSummaryDAO orderSummaryDAO;

	@Autowired
	private ReceiverDAO receiverDAO;

	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Override
	public List selectCartList() {
		return cartDAO.selectAll();
	}

	@Override
	public List selectCartList(int member_id) { //멤버id로 카트리스트 전부 가져오기 
		return cartDAO.selectAll(member_id);
	}

	@Override
	public Cart selectCart(int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Cart cart) throws CartException {
		cartDAO.duplicateCheck(cart);
		cartDAO.insert(cart);
	}

	@Override
	public void update(List<Cart> cartList) throws CartException {
		// 상품 갯수만큼 수정요청
		for (Cart cart : cartList) {
			cartDAO.update(cart);
		}
	}

	@Override
	public void delete(Cart cart) {
		cartDAO.delete(cart);
	}

	public void delete(Member member) throws CartException {
		cartDAO.delete(member);
	}

	@Override
	public List selectPaymethodList() { //배송방법 전부가져오기 
		return paymethodDAO.selectAll();
	}

	// 주문등록
	public void registOrder(OrderSummary orderSummary, Receiver receiver, OrderDetail orderDetail, Product product) {
		orderSummaryDAO.insert(orderSummary);  // 1.dao에 insert해서 orderSummary 가져온다 
		//[내가필요한것]
		//상품 이름 , 가격, 구매개수, 받을사람이름, 연락처, 주소, 결제방법, 총결제액
		
		//2. orderSummary 정보빼낸다
		int order_summary_id = orderSummary.getOrder_summary_id();
		int member_id = orderSummary.getMember_id();
		int total_price = orderSummary.getTotal_price();
		String orderdate = orderSummary.getOrderdate();
		int order_state_id = orderSummary.getOrder_state_id();
		int paymethod_id = orderSummary.getPaymethod_id();
		
		//3.배송정보에 order_summary_id(key)를 넣어준다! 
		receiver.setOrder_summary_id(orderSummary.getOrder_summary_id());// 주문번호 전달해주기..
		receiverDAO.insert(receiver);
			
		List<Cart> cartList = cartDAO.selectAll(member_id); //member_id를 통해 카트 전체를 가져온다! 
		//특정 사람의 id를 통해서 select! --> 그 사람의 카트리스트 목록이 조회됨! 
		
		// 주문상세등록 order_summary_id(key)를 넣어준다! 
		orderDetail.setOrder_summary_id(orderSummary.getOrder_summary_id()); // 주문 상세등록 전담
		orderDetailDAO.insert(orderDetail);
		
	}

	@Override
	public List selectOrderList(int member_id) { //멤버아이디로 특정 orderSummary만 조회
		return orderSummaryDAO.select(member_id);
	}

	@Override
	public List selectOrderList() { //orderSummary 전체조회 
		// TODO Auto-generated method stub
		return orderSummaryDAO.selectAll();
	}


}
