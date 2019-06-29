package com.imooc.o2o.util;

public class PathUtil {
	// 获取目的系统文件路径的书写方法
	private static String seperator = System.getProperty("file.separator");

	// 会根据不同的执行环境 处理图片根目录
	public static String getImgBasePath() {
		// 获取系统类型
		String os = System.getProperty("os.name");
		String basePath = "";
		// windows 环境下
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image";
		} else {
			basePath = "/Users/baidu/work/image";
		}
		basePath = basePath.replace("/", seperator);
		// 返回路径
		return basePath;
	}

	// 相对子路径
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
	

	
}
