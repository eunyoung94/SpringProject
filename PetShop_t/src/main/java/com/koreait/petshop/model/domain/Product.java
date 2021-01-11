package com.koreait.petshop.model.domain;

import java.awt.Image;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int product_id;
	private SubCategory subcategory_id;
	private String product_name;
	private int price;
	private String detail;
	private String filename;

	
	//�̹��� �ϳ��� �ڵ����� ó���ϴ� ��ü 
	//�� �̸��� html�� ���ε� ������Ʈ �Ķ���͸�� ��ġ���Ѿ� �ڵ����� ���ε�ó�� 
	private MultipartFile repImg; //��ǥ�̹��� 
	private MultipartFile[] addImg;//�߰� �̹����� ���û����̸�, ���ÿ� �迭
	
	//�����Ҷ� ������͵� 
	private List<Psize>psizeList;
	private List<Color>colorList;
	private List<Image>imageList;
	
	//insert�Ҷ� ��Ծ��� 
	private Color[] color;//���󰪵� 
	private Psize[] psize;//������ 
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public SubCategory getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(SubCategory subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public MultipartFile getRepImg() {
		return repImg;
	}
	public void setRepImg(MultipartFile repImg) {
		this.repImg = repImg;
	}
	public MultipartFile[] getAddImg() {
		return addImg;
	}
	public void setAddImg(MultipartFile[] addImg) {
		this.addImg = addImg;
	}
	public List<Psize> getPsizeList() {
		return psizeList;
	}
	public void setPsizeList(List<Psize> psizeList) {
		this.psizeList = psizeList;
	}
	public List<Color> getColorList() {
		return colorList;
	}
	public void setColorList(List<Color> colorList) {
		this.colorList = colorList;
	}
	public List<Image> getImageList() {
		return imageList;
	}
	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	public Color[] getColor() {
		return color;
	}
	public void setColor(Color[] color) {
		this.color = color;
	}
	public Psize[] getPsize() {
		return psize;
	}
	public void setPsize(Psize[] psize) {
		this.psize = psize;
	}
	
	
	
	
}
