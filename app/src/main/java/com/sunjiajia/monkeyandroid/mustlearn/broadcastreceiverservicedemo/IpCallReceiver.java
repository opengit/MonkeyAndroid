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
import android.content.SharedPreferences;

/**
 * Created by monkey on 16-5-6.
 *
 * 拨打电话加ip前缀的广播接收者
 */
public class IpCallReceiver extends BroadcastReceiver {
  /**
   * 接受到广播的时候调用
   * @param context
   * @param intent
   */
  @Override public void onReceive(Context context, Intent intent) {
    System.out.println("我是广播接收者");
    // 在打电话广播中，会携带拨打的电话的号码，我们获取到它
    String phone = getResultData();
    System.out.println("电话号码->" + phone);

    SharedPreferences sp = context.getSharedPreferences("ip", Context.MODE_PRIVATE);
    String ip = sp.getString("ip", "-");

    String newPhone = ip + phone;
    System.out.println("带有ip的电话号码->" + newPhone);

    // 把新的号码重新放入广播中
    setResultData(newPhone);
  }
}
