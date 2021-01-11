package com.koreait.petshop.model.product.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.petshop.exception.ProductRegistException;
import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Psize;
import com.koreait.petshop.model.domain.Color;
import com.koreait.petshop.model.domain.Image;
import com.koreait.petshop.model.product.repository.ColorDAO;
import com.koreait.petshop.model.product.repository.ImageDAO;
import com.koreait.petshop.model.product.repository.ProductDAO;
import com.koreait.petshop.model.product.repository.PsizeDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	PsizeDAO psizeDAO;
	@Autowired
	ColorDAO colorDAO;
	@Autowired
	ImageDAO imageDAO;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return productDAO.selectAll();
	}

	@Override
	public List selectById(int subcategory_id) {
		return productDAO.selectById(subcategory_id);
	}

	@Override
	public Product select(int product_id) {
		return productDAO.select(product_id);
	}

	@Override
	public void regist(FileManager fileManager, Product product) throws ProductRegistException {
		String ext = fileManager.getExtend(product.getRepImg().getOriginalFilename());
		product.setFilename(ext);// 확장자 결정하고
		// db에 넣는것은 dao시키기
		productDAO.insert(product);

		// 파일 업로드!
		// 대표이미지 업로드
		/*
		 * 운영체제에 따라서 다른 파일구분자(‘\’, ‘/‘, ‘:’)를 사용하고 있는데, 이를 문자열로 처리하기는 힘이 들다. 전에는
		 * File.separtor’를 문자열 중간중간에 넣으면서 필요한 경로를 만들었다면,
		 */
		String basicImg = product.getProduct_id() + "." + ext;
		fileManager.saveFile(fileManager.getSaveBasicDir() + File.separator + basicImg, product.getRepImg());

		// 추가이미지 업로드 (FileManager에게 추가이미지 갯수만큼 업로드 업무를 시키면 된다!!)

		for (int i = 0; i < product.getAddImg().length; i++) {
			MultipartFile file = product.getAddImg()[i];
			ext = fileManager.getExtend(file.getOriginalFilename());

			// ImageTable에 넣기
			Image image = new Image();
			image.setProduct_id(product.getProduct_id());
			image.setFilename(ext);
			imageDAO.insert(image);

			// 메니저의 저장 메서드 호출
			String addImg = image.getImage_id() + "." + ext;
			fileManager.saveFile(fileManager.getSaveAddonDir() + File.separator + addImg, file);
		}

		// 기타 옵션 중 색상 사이즈 넣기
		// 사이즈
		for (Psize psize : product.getPsize()) {
			psize.setProduct_id(product.getProduct_id());
			psizeDAO.insert(psize);
		}

		// 색상
		for (Color color : product.getColor()) {
			color.setProduct_id(product.getProduct_id());
			colorDAO.insert(color);
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
