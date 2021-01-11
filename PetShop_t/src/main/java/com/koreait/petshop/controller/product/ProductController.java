package com.koreait.petshop.controller.product;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Color;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Psize;
import com.koreait.petshop.model.domain.SubCategory;
import com.koreait.petshop.model.product.service.ProductService;
import com.koreait.petshop.model.product.service.SubCategoryService;
import com.koreait.petshop.model.product.service.TopCategoryService;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileManager fileManager;
	

	//��� ��
	//��ϵ� ��ǰ��� ����Ʈ
	//@GetMapping("/admin/product/list")
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET )
	public ModelAndView getProductList() {
		ModelAndView mav = new ModelAndView("admin/product/product_list");
		
		List productList = productService.selectAll();	
		mav.addObject("productList", productList);
	
		logger.debug("productList.size()"+productList.size());

	
		return mav;
	}
	
	//��ǰ �󼼺���
	@RequestMapping(value="/admin/product/detail", method=RequestMethod.GET )
	public ModelAndView getProductDetail(int product_id) {
	List topList = topCategoryService.selectAll();//��ǰī�װ� ���
		
		Product product = productService.select(product_id);//��ǰ �Ѱ� ��������
		
		ModelAndView mav = new ModelAndView("admin/product/detail");
	
		mav.addObject("product",product);
		
		return mav;
	}
	
	//��� ��
		@RequestMapping(value="/admin/product/registform")
		public ModelAndView registForm() {
			List topList=topCategoryService.selectAll();
			ModelAndView mav = new ModelAndView("admin/product/regist_form");
			mav.addObject("topList", topList);
			
			return mav;
		}
		
		//���� ī�װ� ��������
		@GetMapping("/admin/product/sublist")
		@ResponseBody
		public List getSubList(int topcategory_id) {
			List<SubCategory> subList=subCategoryService.selectAllById(topcategory_id);
			return subList;
		}
		
		//��ǰ ��� 
		@RequestMapping(value="/admin/product/regist", method=RequestMethod.POST, produces ="text/html;charset=utf8")
		@ResponseBody
		public String registProduct(Product product, String[] test) {
			logger.debug("����ī�װ� "+product.getSubcategory_id().getSubcategory_id());
			logger.debug("��ǰ�� "+product.getProduct_name());
			logger.debug("���� "+product.getPrice());
			logger.debug("�󼼳��� "+product.getDetail());
	
			for(Psize psize : product.getPsize()) {
				logger.debug(psize.getPetfit());
			}
			for(Color color : product.getColorList()) {
				logger.debug(color.getPicker());
			}
			
			productService.regist(fileManager, product); //��ǰ��� ���񽺿��� ��û
			
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"result\":1,");
			sb.append("\"msg\":\"��ǰ��� ����\"");
			sb.append("}");
			
			return sb.toString();
		}

	 
}