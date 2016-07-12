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

package com.sunjiajia.monkeyandroid.mustlearn.dagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.mustlearn.dagger2.adapter.UserAdapter;
import com.sunjiajia.monkeyandroid.mustlearn.dagger2.injection.component.DaggerUserComponent;
import com.sunjiajia.monkeyandroid.mustlearn.dagger2.injection.modules.UserModule;
import javax.inject.Inject;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Dagger2Activity extends AppCompatActivity {

  @Bind(R.id.list_view) ListView mListView;

  @Inject UserAdapter mAdapter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dagger2);
    ButterKnife.bind(this);

    DaggerUserComponent.builder().userModule(new UserModule(this)).build().inject22(this);

    mListView.setAdapter(mAdapter);
  }
}
