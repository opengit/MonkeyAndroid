/*
 *
 *  *
 *  *  * ===================================
 *  *  * Copyright (c) 2016.
 *  *  * 作者：安卓猴
 *  *  * 微博：@安卓猴
 *  *  * 博客：http://sunjiajia.com
 *  *  * Github：https://github.com/opengit
 *  *  *
 *  *  * 注意**：如果您使用或者修改该代码，请务必保留此版权信息。
 *  *  * ===================================
 *  *
 *  *
 *
 */

package com.sunjiajia.monkeyandroid.baselearn.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sunjiajia.monkeyandroid.R;

/**
 * Created by monkey on 12/6/15.
 */
public class ToastActivity extends BaseActivity implements View.OnClickListener {
  private Button mBtnToast1;
  private Button mBtnToast2;
  private Button mBtnToast3;
  private Button mBtnToast4;

  @Override public int giveViewResId() {
    return R.layout.activity_toast;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBtnToast1 = (Button) findViewById(R.id.btn_toast1);
    mBtnToast2 = (Button) findViewById(R.id.btn_toast2);
    mBtnToast3 = (Button) findViewById(R.id.btn_toast3);
    mBtnToast4 = (Button) findViewById(R.id.btn_toast4);

    mBtnToast1.setOnClickListener(this);
    mBtnToast2.setOnClickListener(this);
    mBtnToast3.setOnClickListener(this);
    mBtnToast4.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_toast1:
        Toast.makeText(this, "我是短时间土司1号！我的显示时长是Toast.LENGTH_SHORT", Toast.LENGTH_SHORT).show();
        break;
      case R.id.btn_toast2:
        Toast.makeText(this, "我是长时间土司2号！我的显示时长是Toast.LENGTH_LONG", Toast.LENGTH_LONG).show();
        break;
      case R.id.btn_toast3:
        // Toast的一个实例
        Toast toast3 = new Toast(this);
        // 显示图片的控件ImageView，并且给它设置图片
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.mipmap.ic_launcher);
        // 将图片控件设置到Toast中
        toast3.setView(imageView1);
        // 设置Toast的显示时间长短
        toast3.setDuration(Toast.LENGTH_SHORT);
        // 设置Toast显示的位置
        toast3.setGravity(Gravity.LEFT | Gravity.CENTER, 50, 100);
        // 让Toast显示出来
        toast3.show();
        break;
      case R.id.btn_toast4:

        Toast toast4 = Toast.makeText(this, "我是图文土司4号的文字", Toast.LENGTH_SHORT);
        // 显示图片的控件ImageView，并且给它设置图片
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.mipmap.ic_launcher);
        // 获得Toast的布局
        LinearLayout toast4View = (LinearLayout) toast4.getView();
        // 设置此布局为横向的
        toast4View.setOrientation(LinearLayout.HORIZONTAL);
        // 将图片视图添加到此布局中的第一个位置
        toast4View.addView(imageView2, 0);
        // 设置Toast显示的位置
        toast4.setGravity(Gravity.RIGHT | Gravity.CENTER, 50, 100);
        toast4.show();
        break;
    }
  }
}
