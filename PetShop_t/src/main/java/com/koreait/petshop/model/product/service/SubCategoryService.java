package com.koreait.petshop.model.product.service;

import java.util.List;

import com.koreait.petshop.model.domain.SubCategory;

public interface SubCategoryService {
	public List selectAll();//��緹�ڵ� �������� 
	public List selectAllById(int topcategory_id);
	public SubCategory select(int topcategory_id);//topcategory_id�� ���� ���õ� ���� SubCategory vo�� �־��ֱ� 
	public void insert(SubCategory subCategory);
	public void update(SubCategory subCategory);
	public void delete(int topcategory_id);
}
