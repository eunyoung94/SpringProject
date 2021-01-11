package com.koreait.petshop.model.product.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Product;

public interface ProductDAO {
	public List selectAll();
	public List selectById(int subcategory_id);//하위 카테고리에 소속된 모든상품 
	public Product select(int product_id); //
	public void insert(Product product);
	public void update(Product product);
	public void delete(int product_id);
}
