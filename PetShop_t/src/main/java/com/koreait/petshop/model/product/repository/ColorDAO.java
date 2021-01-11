package com.koreait.petshop.model.product.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Color;

public interface ColorDAO {
	public List selectAll();
	public List selectById(int product_id); //fk가 소속된 목록
	public Color select(int color_id); //color_id를 갖고 Color 를 가져오기 
	public void insert(Color color);
	public void update(Color color);
	public void delete(int product_id);
}
