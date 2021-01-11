package com.koreait.petshop.model.product.repository;


import java.util.List;

import com.koreait.petshop.model.domain.Image;

public interface ImageDAO {
	public List selectAll();// ����̹��� 
	public List selectById(int product_id); //fk�� �Ҽӵ� ����̹���
	public Image insert(Image image);
	public void update(Image image);
	public void delete(int image_id);
	
}