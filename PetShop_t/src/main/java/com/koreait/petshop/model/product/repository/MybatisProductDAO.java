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
	public List selectAll() { // product_id�� ���ؼ� list ��ü�� �������� 
		return sqlSessionTemplate.selectList("Product.selectAll");
		// sqlSession�� ���ؼ� ����Ʈ�� ��������
	}

	@Override
	public List selectById(int subcategory_id) { //subcategory_id�� ���ؼ� ����Ʈ ��������  
		return sqlSessionTemplate.selectList("Product.selectBySubCategoryId", subcategory_id);
	}

	@Override
	public Product select(int product_id) {
		return sqlSessionTemplate.selectOne("Product.select", product_id);
	}

	@Override
	public void insert(Product product) {//���̺� �Է��ϱ� , ��ȯ���� ���� 
		int result=sqlSessionTemplate.insert("Product.insert", product);
		if(result==0) {
			throw new ProductRegistException("��ǰ���̺� �Է½���");
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
