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

package com.sunjiajia.monkeyandroid.mustlearn.databinding.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by monkey on 16-7-14.
 */
public class User extends BaseObservable {
  private String username;
  private String password;
  private int age;
  private String email;
  private boolean vip;

  public User(String username, String password, int age, String email, boolean vip) {
    this.username = username;
    this.password = password;
    this.age = age;
    this.email = email;
    this.vip = vip;
  }

  @Bindable public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
    notifyPropertyChanged(BR.username);
  }

  @Bindable public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
    notifyPropertyChanged(BR.password);
  }

  @Bindable public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
    notifyPropertyChanged(BR.age);
  }

  @Bindable public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
    notifyPropertyChanged(BR.email);
  }

  @Bindable public boolean isVip() {
    return vip;
  }

  public void setVip(boolean vip) {
    this.vip = vip;
    notifyPropertyChanged(BR.vip);
  }

  @Override public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", age=" + age +
        ", email='" + email + '\'' +
        ", vip=" + vip +
        '}';
  }
}
