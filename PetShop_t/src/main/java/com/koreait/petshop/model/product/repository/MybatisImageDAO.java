package com.koreait.petshop.model.product.repository;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.exception.ProductRegistException;
import com.koreait.petshop.model.domain.Image;

@Repository
public class MybatisImageDAO implements ImageDAO{

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
	public Image insert(Image image)throws ProductRegistException{
		int result= sqlSessionTemplate.insert("Image.insert", image);
		if(result==0) {
			throw new ProductRegistException("이미지가 등록되지 않았습니다.");
		}
		return null;
	}


	@Override
	public void delete(int image_id) throws ProductRegistException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(com.koreait.petshop.model.domain.Image image) {
		// TODO Auto-generated method stub
		
	}

	
}
