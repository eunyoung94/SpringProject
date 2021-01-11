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
	

	//목록 폼
	//등록된 상품목록 리스트
	//@GetMapping("/admin/product/list")
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET )
	public ModelAndView getProductList() {
		ModelAndView mav = new ModelAndView("admin/product/product_list");
		
		List productList = productService.selectAll();	
		mav.addObject("productList", productList);
	
		logger.debug("productList.size()"+productList.size());

	
		return mav;
	}
	
	//상품 상세보기
	@RequestMapping(value="/admin/product/detail", method=RequestMethod.GET )
	public ModelAndView getProductDetail(int product_id) {
	List topList = topCategoryService.selectAll();//상품카테고리 목록
		
		Product product = productService.select(product_id);//상품 한건 가져오기
		
		ModelAndView mav = new ModelAndView("admin/product/detail");
	
		mav.addObject("product",product);
		
		return mav;
	}
	
	//등록 폼
		@RequestMapping(value="/admin/product/registform")
		public ModelAndView registForm() {
			List topList=topCategoryService.selectAll();
			ModelAndView mav = new ModelAndView("admin/product/regist_form");
			mav.addObject("topList", topList);
			
			return mav;
		}
		
		//하위 카테고리 가져오기
		@GetMapping("/admin/product/sublist")
		@ResponseBody
		public List getSubList(int topcategory_id) {
			List<SubCategory> subList=subCategoryService.selectAllById(topcategory_id);
			return subList;
		}
		
		//상품 등록 
		@RequestMapping(value="/admin/product/regist", method=RequestMethod.POST, produces ="text/html;charset=utf8")
		@ResponseBody
		public String registProduct(Product product, String[] test) {
			logger.debug("하위카테고리 "+product.getSubcategory_id().getSubcategory_id());
			logger.debug("상품명 "+product.getProduct_name());
			logger.debug("가격 "+product.getPrice());
			logger.debug("상세내용 "+product.getDetail());
	
			for(Psize psize : product.getPsize()) {
				logger.debug(psize.getPetfit());
			}
			for(Color color : product.getColorList()) {
				logger.debug(color.getPicker());
			}
			
			productService.regist(fileManager, product); //상품등록 서비스에게 요청
			
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"result\":1,");
			sb.append("\"msg\":\"상품등록 성공\"");
			sb.append("}");
			
			return sb.toString();
		}

	 
}