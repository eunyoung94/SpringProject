package com.koreait.petshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.exception.ProductRegistException;
import com.koreait.petshop.model.domain.Product;

@Repository
public class MybatisProductDAO implements ProductDAO{

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() { // product_id를 통해서 list 전체를 가져오기 
		return sqlSessionTemplate.selectList("Product.selectAll");
		// sqlSession을 통해서 리스트를 가져오기
	}

	@Override
	public List selectById(int subcategory_id) { //subcategory_id를 통해서 리스트 가져오기  
		return sqlSessionTemplate.selectList("Product.selectBySubCategoryId", subcategory_id);
	}

	@Override
	public Product select(int product_id) {
		return sqlSessionTemplate.selectOne("Product.select", product_id);
	}

	@Override
	public void insert(Product product) {//테이블에 입력하기 , 반환값은 없음 
		int result=sqlSessionTemplate.insert("Product.insert", product);
		if(result==0) {
			throw new ProductRegistException("상품테이블 입력실패");
		}
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		
	}

}
