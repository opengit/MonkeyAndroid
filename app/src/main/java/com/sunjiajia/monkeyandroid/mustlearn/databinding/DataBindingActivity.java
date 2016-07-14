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

package com.sunjiajia.monkeyandroid.mustlearn.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.databinding.ActivityDataBindingBinding;
import com.sunjiajia.monkeyandroid.mustlearn.databinding.adapter.RecyclerAdapter;
import com.sunjiajia.monkeyandroid.mustlearn.databinding.bean.User;

/**
 * 这个Activity我们来学习DataBinding的用法，关于教程，这里给出一个链接，可以跟着边看文章遍阅读这个示例，理解更深。
 *
 * https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/README.md
 */
public class DataBindingActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle(getIntent().getStringExtra("title"));
    //setContentView(R.layout.activity_data_binding);
    ActivityDataBindingBinding binding =
        DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
    User user = new User("Jack", "123456", 18, "jack@jack.com", false);
    user.setVip(true);
    binding.setUser(user);

    binding.recycler.setLayoutManager(new LinearLayoutManager(this));
    binding.recycler.setHasFixedSize(true);
    binding.recycler.setAdapter(new RecyclerAdapter());
  }
}
