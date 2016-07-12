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

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

  @Override public IBinder onBind(Intent intent) {

    return null;
  }

  @Override public void onCreate() {
    super.onCreate();
    System.out.println("MyService-->onCreate");
  }

  @Override public void onDestroy() {
    super.onDestroy();
    System.out.println("MyService-->onDestroy");
  }

  @Override public int onStartCommand(Intent intent, int flags, int startId) {
    System.out.println("MyService-->onStartCommand");
    return super.onStartCommand(intent, flags, startId);
  }
}
