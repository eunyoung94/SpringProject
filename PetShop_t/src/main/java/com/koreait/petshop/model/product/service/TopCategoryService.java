package com.koreait.petshop.model.product.service;

import java.util.List;

import com.koreait.petshop.model.domain.TopCategory;

public interface TopCategoryService { //TopcategoryDAO�� ����
	//��� ������ü�� �ݵ�� �����ؾ��� ���� �� �ʼ����� ����� �����Ѵ� 
		public List selectAll();
		public TopCategory select(int topcategory_id);
		public void insert(TopCategory topcategory);
		public void update(TopCategory topcategory);
		public void delete(int topcategory_id);

}
