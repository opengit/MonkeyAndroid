package com.sunjiajia.monkeyandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 《Monkey Android》第6课点击事件的四种写法
 * http://sunjiajia.com/2015/08/10/monkey-android-6/
 */
public class LinearLayoutActivity extends BaseActivity implements View.OnClickListener {

  @Override public int giveViewResId() {
    return R.layout.activity_linear_layout;
  }

  private Button mButton01;
  private Button mButton02;
  private Button mButton03;
  private Button mButton04;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mButton01 = (Button) findViewById(R.id.btn01);
    mButton02 = (Button) findViewById(R.id.btn02);
    mButton03 = (Button) findViewById(R.id.btn03);
    mButton04 = (Button) findViewById(R.id.btn04);

    // 第1种写法：
    mButton01.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Toast.makeText(LinearLayoutActivity.this, mButton01.getClass().toString() + "--> Button01",
            Toast.LENGTH_SHORT).show();
      }
    });

    // 第2种写法：主类实现OnClickListener接口，并在主类中复写方法onClick
    mButton02.setOnClickListener(this);

    // 第3种写法：内部类实现OnClickListener接口，复写方法onClick
    MyButtonClickListener mButtonClickListener = new MyButtonClickListener();
    mButton03.setOnClickListener(mButtonClickListener);
  }

  // 第4种写法：在布局文件中给Button04添加android:onClick="clickButton04"属性，并指定了点击触发的方法clickButton04
  public void clickButton04(View view) {

    Toast.makeText(this, mButton04.getClass().toString() + "--> Button04", Toast.LENGTH_SHORT)
        .show();
  }

  class MyButtonClickListener implements View.OnClickListener {

    @Override public void onClick(View v) {
      Toast.makeText(LinearLayoutActivity.this, mButton03.getClass().toString() + "--> Button03",
          Toast.LENGTH_SHORT).show();
    }
  }

  @Override public void onClick(View v) {

    Toast.makeText(LinearLayoutActivity.this, mButton02.getClass().toString() + "--> Button02",
        Toast.LENGTH_SHORT).show();
  }
}
