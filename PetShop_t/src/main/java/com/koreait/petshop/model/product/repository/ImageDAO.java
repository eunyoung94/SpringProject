package com.koreait.petshop.model.product.repository;


import java.util.List;

import com.koreait.petshop.model.domain.Image;

public interface ImageDAO {
	public List selectAll();// 모든이미지 
	public List selectById(int product_id); //fk에 소속된 모든이미지
	public Image insert(Image image);
	public void update(Image image);
	public void delete(int image_id);
	
}
