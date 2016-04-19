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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import com.sunjiajia.monkeyandroid.R;

/**
 * Created by monkey on 1/3/16.
 */
public class SpinnerAutoCompleteTextViewActivity extends BaseActivity {
  private Spinner mSpinnerCity;
  private String[] mDatas;
  private AutoCompleteTextView tvAc;

  @Override public int giveViewResId() {
    return R.layout.activity_spinner_autocompletetextview;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    intViews();
    initData();
    confingViews();
  }

  private void confingViews() {
    setSpinner();
    setAutoCompleteTextView();
  }

  private void setAutoCompleteTextView() {

    ArrayAdapter<CharSequence> adapter03 =
        ArrayAdapter.createFromResource(this, R.array.av_male, android.R.layout.simple_list_item_1);
    tvAc.setAdapter(adapter03);
  }

  private void setSpinner() {
    //通过适配器来进行动态的数据填充
    // 第一种：
/*    ArrayAdapter<String> adapter01 =
        new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mDatas);
    mSpinnerCity.setAdapter(adapter01);*/

    ArrayAdapter<CharSequence> adapter02 =
        ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_list_item_1);
    mSpinnerCity.setAdapter(adapter02);
  }

  private void intViews() {
    mSpinnerCity = (Spinner) findViewById(R.id.spinner_city);
    tvAc = (AutoCompleteTextView) findViewById(R.id.tv_autocomplete);
  }

  protected void initData() {
    mDatas = new String[] { "动态数据Spinner", "北京", "上海", "深圳", "广州", "洛杉矶", "纽约", "华盛顿" };
  }
}
