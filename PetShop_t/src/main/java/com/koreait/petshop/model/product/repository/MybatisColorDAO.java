package com.koreait.petshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.exception.ProductRegistException;
import com.koreait.petshop.model.domain.Color;

@Repository
public class MybatisColorDAO implements ColorDAO{
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectById(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color select(int color_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Color color)throws ProductRegistException{
		int result=sqlSessionTemplate.insert("Color.insert", color);
		if(result==0) {
			throw new ProductRegistException("색상등록에 실패했습니다.");
		}
	}

	@Override
	public void update(Color color) throws ProductRegistException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) throws ProductRegistException{
		// TODO Auto-generated method stub
		
	}
	

}
