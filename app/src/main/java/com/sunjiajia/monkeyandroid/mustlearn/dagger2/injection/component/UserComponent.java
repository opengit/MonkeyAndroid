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

package com.sunjiajia.monkeyandroid.mustlearn.dagger2.injection.component;

import com.sunjiajia.monkeyandroid.mustlearn.dagger2.Dagger2Activity;
import com.sunjiajia.monkeyandroid.mustlearn.dagger2.injection.ActivityScope;
import com.sunjiajia.monkeyandroid.mustlearn.dagger2.injection.modules.UserModule;
import dagger.Component;

/**
 * Created by monkey on 16-4-26.
 */
@ActivityScope @Component(modules = { UserModule.class }) public interface UserComponent {
  void inject22(Dagger2Activity activity);
}
