package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
	
	/**
	 * 将CommonsMultipartFile转换为File类
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			logger.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return newFile;
	}
	
	/**
	 * 处理缩略图，并返回新生成图片的相对值路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(File thumbnail, String targetAddr) {
		String realFileName = getRandomFileName(); //生成一个随机名
		String extension = getFileExtension(thumbnail); //获取扩展名
		makeDirPath(targetAddr); //生成新路径
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr is:" + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail).size(200,200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f)
			.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	/**
	 * 创建目标路径所涉及到的目录，/home/work/xxx.jpg
	 * 那么home work两个文件夹都需要自动创建
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(File cFile) {
		String originalFileName = cFile.getName();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名，当前年月日小时分钟秒钟+5位随机数
	 * @return
	 */
	private static String getRandomFileName() {
		//获取随机5位数
		int rannum = r.nextInt(89999) + 10000; //大于10000，小于99999
		String nmwTimeStr = sDateFormat.format(new Date());
		return nmwTimeStr + rannum;
	}

	public static void main(String[] args) throws IOException {
		String basePath =Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Thumbnails.of(new File("E:/oto_resourse/image/xiaohuangren.jpg"))
		.size(200,200)
		.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f).outputQuality(0.8f)
		.toFile("E:/oto_resourse/image/xiaohuangrennew.jpg");
	}
}
