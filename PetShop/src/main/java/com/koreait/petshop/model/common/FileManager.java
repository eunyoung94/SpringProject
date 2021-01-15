package com.koreait.petshop.model.common;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Component //root-context�� �ø��� ����,component-scan�� ��� �� �ϳ���
public class FileManager {
	private static final Logger logger = LoggerFactory.getLogger(FileManager.class);
	
	private String saveBasicDir="/resources/data/basic";
	private String saveAddonDir="/resources/data/addon";
	
	
	public static String getExtend(String path) {
		int lastIndex = path.lastIndexOf(".");
		String ext = path.substring(lastIndex+1, path.length());
		//System.out.println(ext);		
		return ext;
	}
	
	public static boolean deleteFile(String path) {
		File file = new File(path);
		return file.delete();
	}
	
	//���� �����ϱ�
	public void saveFile(String realDir, MultipartFile multi) {
		try {
			multi.transferTo(new File(realDir));//�������ϱ�
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSaveBasicDir() {
		return saveBasicDir;
	}

	public void setSaveBasicDir(String saveBasicDir) {
		this.saveBasicDir = saveBasicDir;
	}

	public String getSaveAddonDir() {
		return saveAddonDir;
	}

	public void setSaveAddonDir(String saveAddonDir) {
		this.saveAddonDir = saveAddonDir;
	}

	public static Logger getLogger() {
		return logger;
	}
	
	
}



