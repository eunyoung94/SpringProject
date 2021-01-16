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
	public List selectCartList(int member_id) { //���id�� īƮ����Ʈ ���� �������� 
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
		// ��ǰ ������ŭ ������û
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
	public List selectPaymethodList() { //��۹�� ���ΰ������� 
		return paymethodDAO.selectAll();
	}

	// �ֹ����
	public void registOrder(OrderSummary orderSummary, Receiver receiver, OrderDetail orderDetail, Product product) {
		orderSummaryDAO.insert(orderSummary);  // 1.dao�� insert�ؼ� orderSummary �����´� 
		//[�����ʿ��Ѱ�]
		//��ǰ �̸� , ����, ���Ű���, ��������̸�, ����ó, �ּ�, �������, �Ѱ�����
		
		//2. orderSummary ����������
		int order_summary_id = orderSummary.getOrder_summary_id();
		int member_id = orderSummary.getMember_id();
		int total_price = orderSummary.getTotal_price();
		String orderdate = orderSummary.getOrderdate();
		int order_state_id = orderSummary.getOrder_state_id();
		int paymethod_id = orderSummary.getPaymethod_id();
		
		//3.��������� order_summary_id(key)�� �־��ش�! 
		receiver.setOrder_summary_id(orderSummary.getOrder_summary_id());// �ֹ���ȣ �������ֱ�..
		receiverDAO.insert(receiver);
			
		List<Cart> cartList = cartDAO.selectAll(member_id); //member_id�� ���� īƮ ��ü�� �����´�! 
		//Ư�� ����� id�� ���ؼ� select! --> �� ����� īƮ����Ʈ ����� ��ȸ��! 
		
		// �ֹ��󼼵�� order_summary_id(key)�� �־��ش�! 
		orderDetail.setOrder_summary_id(orderSummary.getOrder_summary_id()); // �ֹ� �󼼵�� ����
		orderDetailDAO.insert(orderDetail);
		
	}

	@Override
	public List selectOrderList(int member_id) { //������̵�� Ư�� orderSummary�� ��ȸ
		return orderSummaryDAO.select(member_id);
	}

	@Override
	public List selectOrderList() { //orderSummary ��ü��ȸ 
		// TODO Auto-generated method stub
		return orderSummaryDAO.selectAll();
	}


}
