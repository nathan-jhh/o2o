package com.imooc.o2o.util;

public class PathUtil {
	private static String separator = System.getProperty("file.separator");
	
	//返回项目图片的根路径
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {
			basePath = "E:/oto_resourse/image";
		}else {
			basePath = "/home/work/image";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}
	
	//返回项目图片子路径
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload1/item/shop/" + shopId + "/";
		return imagePath.replace("/", separator);
	}
}
