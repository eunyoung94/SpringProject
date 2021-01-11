package com.koreait.petshop.model.product.service;

import java.util.List;

import com.koreait.petshop.model.domain.SubCategory;

public interface SubCategoryService {
	public List selectAll();//모든레코드 가져오기 
	public List selectAllById(int topcategory_id);
	public SubCategory select(int topcategory_id);//topcategory_id를 통해 선택된 값을 SubCategory vo에 넣어주기 
	public void insert(SubCategory subCategory);
	public void update(SubCategory subCategory);
	public void delete(int topcategory_id);
}
