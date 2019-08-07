package com.imooc.o2o.util;

import java.io.File;

public class PathUtil {
	private static String seperator = System.getProperty(File.separator);
	
	//返回项目图片的根路径
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {
			basePath = "E:/oto_resourse/image/";
		}else {
			basePath = "/home/jhh/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	
	//返回项目图片子路径
	public static String getShopImagePath(long shopId) {
		String imagePath = "E:/oto_resourse/image/upload/images/item/shop" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
