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

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.sunjiajia.monkeyandroid.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkey on 16-4-27.
 *
 * 用来显示从数据库中读取出来读的数据，必须在MustLearnPointActivity中，
 * 多次点击“SQLite数据库的使用方法”，来使数据库中有更多的数据，显示出来才明显
 */
public class SqliteActivity extends AppCompatActivity {
  @Bind(R.id.listview_sqlite) ListView mListviewSqlite;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sqlite);
    ButterKnife.bind(this);

    // 创建数据库
    MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this, "students.db", null, 1);
    SQLiteDatabase db = helper.getWritableDatabase();

    initDbData(db);
    List<String> dbData = getDbData(db);
    mListviewSqlite.setAdapter(new SqliteListViewAdapter(this, dbData));
  }

  private List<String> getDbData(SQLiteDatabase db) {
    List<String> dataList = new ArrayList<>();
    Cursor cursor = db.query("person", null, null, null, null, null, null, null);
    while (cursor.moveToNext()) {
      String name = cursor.getString(cursor.getColumnIndex("name"));
      String salary = cursor.getString(cursor.getColumnIndex("salary"));
      String phone = cursor.getString(cursor.getColumnIndex("phone"));
      dataList.add("name->" + name + ",salary->" + salary + ",phone->" + phone);
    }
    return dataList;
  }

  private void initDbData(SQLiteDatabase db) {
    insert(db);
  }

  private void insert(SQLiteDatabase db) {
    ContentValues values = new ContentValues();
    for (int i = 1; i <= 100; i++) {
      values.put("name", "小豆" + i);
      values.put("phone", "1380000X" + i);
      values.put("salary", i + "000");
      db.insert("person", null, values);
    }
  }
}
