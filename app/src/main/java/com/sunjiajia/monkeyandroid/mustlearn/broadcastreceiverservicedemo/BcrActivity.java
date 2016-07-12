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

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sunjiajia.monkeyandroid.R;

public class BcrActivity extends AppCompatActivity {

  @Bind(R.id.btn_ip_dialer) Button mBtnIpDialer;
  @Bind(R.id.btn_sms_blocker) Button mBtnSmsBlocker;
  @Bind(R.id.btn_open_service) Button mBtnOpenService;
  @Bind(R.id.btn_close_service) Button mBtnCloseService;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bcr);
    ButterKnife.bind(this);
    getSupportActionBar().setTitle("广播接收者与服务示例");
  }

  @OnClick({
      R.id.btn_ip_dialer, R.id.btn_sms_blocker, R.id.btn_open_service, R.id.btn_close_service
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_ip_dialer:

        SharedPreferences sp = getSharedPreferences("ip", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("ip", "101010");
        editor.commit();
        Toast.makeText(this, "ip前缀设置完毕，拨打所有电话将更加便宜，\n请去拨号！", Toast.LENGTH_SHORT).show();

        break;
      case R.id.btn_sms_blocker:

        Toast.makeText(this, "拦截的短信号码为168168，请用这个号码在模拟发送短信！", Toast.LENGTH_SHORT).show();

        break;
      case R.id.btn_open_service:

        // 显式启动服务
        startService(new Intent(this, MyService.class));

        break;
      case R.id.btn_close_service:
        // 关闭服务
        stopService(new Intent(this, MyService.class));
        break;
    }
  }
}
