package com.qm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
private File[] upload;
private String[] uploadContentType;
private String uploadFileName;
private String savePath;
	//…省略set和get方法


public String execute() throws Exception {
	System.out.println(uploadFileName);
	String path=ServletActionContext.getRequest().getServletContext().getRealPath("/upload");
	System.out.println(path);
/*	byte[] buffer=new byte[1024];
FileInputStream fis=new FileInputStream(getUpload());
FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+this.getUploadFileName());
*/
		for (int i = 0; i < upload.length; i++) {
			
			File savePath=new File(path, uploadFileName);
			FileUtils.copyFile(upload[i], savePath);
	
			//需要把文件上传成功的动作保存到数据库中
			//执行insert语句把用户名和图片名字保存到数据库
		
		}
return SUCCESS;
}


public File[] getUpload() {
	return upload;
}






public void setUpload(File[] upload) {
	this.upload = upload;
}





public String[] getUploadContentType() {
	return uploadContentType;
}


public void setUploadContentType(String[] uploadContentType) {
	this.uploadContentType = uploadContentType;
}


public String getUploadFileName() {
	return uploadFileName;
}


public void setUploadFileName(String uploadFileName) {
	this.uploadFileName = uploadFileName;
}


public String getSavePath() {
	return savePath;
}


public void setSavePath(String savePath) {
	this.savePath = savePath;
}	
}