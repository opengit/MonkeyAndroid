/*
 *
 *  *
 *  *  *
 *  *  *  * ===================================
 *  *  *  * Copyright (c) 2016.
 *  *  *  * 作者：安卓猴
 *  *  *  * 微博：@安卓猴
 *  *  *  * 博客：http://sunjiajia.com
 *  *  *  * Github：https://github.com/opengit
 *  *  *  *
 *  *  *  * 注意**：如果您使用或者修改该代码，请务必保留此版权信息。
 *  *  *  * ===================================
 *  *  *
 *  *  *
 *  *
 *
 */

package com.sunjiajia.monkeyandroid.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by monkey on 16-4-29.
 *
 * 工具类
 */
public class Utils {
  /**
   * 从输入流中读取数据为文本
   * @param inputStream
   *    输入流
   * @return
   *    文本
   */
  public static String getTextFromStream(InputStream inputStream) {
    byte[] bytes = new byte[1024];
    int len = 0;
    // 创建字节数组输出流，读取输入流的文本数据时，同步把数据写入数组输入流
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
      while ((len = inputStream.read(bytes)) != -1) {
        baos.write(bytes, 0, len);
      }
      return new String(baos.toByteArray());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 从文件网址链接中获取文件的名称（包括扩展名）
   * @param url
   *    网址链接
   * @return
   *    文件的名称（包括扩展名）
   */
  public static String getFileNameFromUrl(String url) {
    return url.substring(url.lastIndexOf("/") + 1);
  }
}
