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
		product.setFilename(ext);// Ȯ���� �����ϰ�
		// db�� �ִ°��� dao��Ű��
		productDAO.insert(product);

		// ���� ���ε�!
		// ��ǥ�̹��� ���ε�
		/*
		 * �ü���� ���� �ٸ� ���ϱ�����(��\��, ��/��, ��:��)�� ����ϰ� �ִµ�, �̸� ���ڿ��� ó���ϱ�� ���� ���. ������
		 * File.separtor���� ���ڿ� �߰��߰��� �����鼭 �ʿ��� ��θ� ������ٸ�,
		 */
		String basicImg = product.getProduct_id() + "." + ext;
		fileManager.saveFile(fileManager.getSaveBasicDir() + File.separator + basicImg, product.getRepImg());

		// �߰��̹��� ���ε� (FileManager���� �߰��̹��� ������ŭ ���ε� ������ ��Ű�� �ȴ�!!)

		for (int i = 0; i < product.getAddImg().length; i++) {
			MultipartFile file = product.getAddImg()[i];
			ext = fileManager.getExtend(file.getOriginalFilename());

			// ImageTable�� �ֱ�
			Image image = new Image();
			image.setProduct_id(product.getProduct_id());
			image.setFilename(ext);
			imageDAO.insert(image);

			// �޴����� ���� �޼��� ȣ��
			String addImg = image.getImage_id() + "." + ext;
			fileManager.saveFile(fileManager.getSaveAddonDir() + File.separator + addImg, file);
		}

		// ��Ÿ �ɼ� �� ���� ������ �ֱ�
		// ������
		for (Psize psize : product.getPsize()) {
			psize.setProduct_id(product.getProduct_id());
			psizeDAO.insert(psize);
		}

		// ����
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
