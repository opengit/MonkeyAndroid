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

package com.sunjiajia.monkeyandroid.mustlearn.activitydata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.sunjiajia.monkeyandroid.R;
import java.util.Random;

public class TwoActivity extends AppCompatActivity {

  @Bind(R.id.tv_yinyuan) TextView mTvYinyuan;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_two);
    ButterKnife.bind(this);
    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("TwoActivity");

    // 获取intent中的数据
    Intent intent = getIntent();
    String maleName = intent.getStringExtra("malename");
    String femaleName = intent.getStringExtra("femalename");

    Random random = new Random();
    int yinyuan1 = random.nextInt(100);

    Bundle bundle = intent.getExtras();
    String male2 = bundle.getString("malename2");
    String female2 = bundle.getString("femalename2");
    int yinyuan2 = random.nextInt(100);

    mTvYinyuan.setText(maleName
        + "和"
        + femaleName
        + "的姻缘值为 "
        + yinyuan1
        + ",\n"
        + male2
        + "和"
        + female2
        + "的姻缘值为 "
        + yinyuan2);
  }
}
