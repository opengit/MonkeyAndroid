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

package com.sunjiajia.monkeyandroid.mustlearn.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by monkey on 16-4-26.
 *
 * SQLite的打开帮助类
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

  private Context mContext;

  /**
   * 构造方法
   *
   * @param context
   *  上下文
   * @param name
   *  数据库文件的名字
   * @param factory
   *  游标工厂
   * @param version
   *  数据库的初始版本
   */
  public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
      int version) {
    super(context, name, factory, version);
    this.mContext = context;
  }

  /**
   * 数据库创建时调用
   * @param db
   */
  @Override public void onCreate(SQLiteDatabase db) {
    Toast.makeText(mContext, "--->数据库被【创建】了---", Toast.LENGTH_SHORT).show();

    //创建表
    String sql =
        "create table person(_id integer primary key autoincrement,name char(10),salary char(20),phone integer(20))";
    db.execSQL(sql);
  }

  /**
   * 数据库的升级
   * @param db
   * @param oldVersion
   * @param newVersion
   */
  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Toast.makeText(mContext, "--->数据库被【升级】了---", Toast.LENGTH_SHORT).show();
  }
}
