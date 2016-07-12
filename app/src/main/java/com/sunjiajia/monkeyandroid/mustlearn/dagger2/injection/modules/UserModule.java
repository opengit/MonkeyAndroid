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

package com.sunjiajia.monkeyandroid.mustlearn.dagger2.injection.modules;

import android.content.Context;
import com.sunjiajia.monkeyandroid.mustlearn.dagger2.injection.ActivityScope;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkey on 16-4-26.
 */
@Module public class UserModule {

  private static final int USER_COUNT = 100;

  private Context context;

  public UserModule(Context context) {
    this.context = context;
  }

  @ActivityScope @Provides Context provideContext() {
    return context;
  }

  @ActivityScope @Provides List<String> provideUsers() {
    List<String> users = new ArrayList<>(USER_COUNT);
    for (int i = 0; i < USER_COUNT; i++) {
      users.add("user:Jack#" + i);
    }
    return users;
  }
}
