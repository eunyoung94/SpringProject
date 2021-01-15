package com.koreait.petshop.model.member.service;

import java.util.List;

import com.koreait.petshop.model.domain.Member;

public interface MemberService {
	public List selectAll(); //��� ȸ����������
	public Member select(Member member);//ȸ�� 1�� ��������
	public void regist(Member member); //ȸ����� �� ��Ÿ�ʿ���� ó��
	public void update(Member member); //ȸ������
	public void delete(Member Member); //ȸ������
	
	public int duplicateCheck(String user_id);
}