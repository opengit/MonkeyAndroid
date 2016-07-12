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

package com.sunjiajia.monkeyandroid.mustlearn.broadcastreceiverservicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by monkey on 16-5-6.
 * 垃圾短信广播接收者
 *
 * 测试短信号码：168168
 * 测试短信内容：你好，安卓猴
 */
public class SmsReceiver extends BroadcastReceiver {
  private static final String BLOCK_PHONE = "168168";

  @Override public void onReceive(Context context, Intent intent) {
    System.out.println("收到短信了。。。");
    // 你好美女
    // 拿到短信的内容，它是封装在intent中的
    Bundle bundle = intent.getExtras();
    // object数组中的每一个元素都是一条短信
    Object[] objects = (Object[]) bundle.get("pdus");
    for (Object object : objects) {
      SmsMessage message = SmsMessage.createFromPdu((byte[]) object);
      String address = message.getOriginatingAddress();
      String body = message.getMessageBody();

      System.out.println(address + " --> " + body);

      if (address.equals(BLOCK_PHONE)) {
        // 如果短信号码等于黑名单号码，则停止广播
        abortBroadcast();
      }
    }
  }
}
