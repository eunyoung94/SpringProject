package com.koreait.petshop.model.payment.service;
import java.util.List;

import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.domain.OrderSummary;
import com.koreait.petshop.model.domain.Receiver;

//��ٱ��� ���� ���� 
public interface PaymentService {
	//��ٱ��� ���� ����
	public List selectCartList();//ȸ�� ���о��� ��� ������ �������� 
	public List selectCartList(int member_id);//Ư�� ȸ���� ��ٱ��� ����
	public Cart selectCart(int cart_id);
	public void insert(Cart cart);
	public void update(List<Cart> cartList); //�ϰ� ����
	public void delete(Cart cart); //pk�� ���� ������ �����ҿ���
	public void delete(Member member); //ȸ���� ���� ������ �����ҿ���
	
	//���� ����
	public List selectPaymethodList();
	public void registOrder(OrderSummary orderSummary, Receiver receiver);//Ʈ����� ó���� �䱸�Ǵ� �޼���...
}
