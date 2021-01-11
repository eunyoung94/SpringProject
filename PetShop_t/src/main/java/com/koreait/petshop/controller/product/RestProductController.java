package com.koreait.petshop.controller.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.common.MessageData;
import com.koreait.petshop.model.domain.Color;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Psize;
import com.koreait.petshop.model.product.service.ProductService;
import com.koreait.petshop.model.product.service.SubCategoryService;
import com.koreait.petshop.model.product.service.TopCategoryService;

@Controller
@RequestMapping("/async")
public class RestProductController {
	private static final Logger logger = LoggerFactory.getLogger(RestProductController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileManager fileManager;
	
	
	
	//���
	@RequestMapping(value="/admin/product/regist", method=RequestMethod.POST)
	@ResponseBody
	public MessageData getProductRegist(Product product) {
		logger.debug("����ī�װ��� "+product.getSubcategory_id().getSubcategory_id());
		logger.debug("��ǰ�� "+product.getProduct_name());
		logger.debug("���� "+product.getPrice());
		logger.debug("�󼼳��� "+product.getDetail());
		

		
		for(Color color : product.getColor() ) {
			logger.debug("����  "+color.getPicker());
		}
		for(Psize psize : product.getPsize() ) {
			logger.debug("������  "+psize.getPetfit());
		}
		
		productService.regist(fileManager, product);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("��ϼ���.");
		messageData.setUrl("/admin/product/list");

		return messageData;
	}
}