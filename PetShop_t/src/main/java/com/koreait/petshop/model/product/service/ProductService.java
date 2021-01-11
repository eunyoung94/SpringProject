package com.koreait.petshop.model.product.service;

import java.util.List;

import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Product;

public interface ProductService {
	public List selectAll();
	public List selectById(int subcategory_id);//하위 카테고리에 소속된 모든상품 
	public Product select(int product_id); 
	public void regist(FileManager fileManager, Product product);
	public void update(Product product);
	public void delete(int product_id);
}
