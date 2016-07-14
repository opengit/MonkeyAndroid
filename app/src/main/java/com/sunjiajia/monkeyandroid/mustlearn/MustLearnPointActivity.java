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

package com.sunjiajia.monkeyandroid.mustlearn;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.domain.Message;
import com.sunjiajia.monkeyandroid.mustlearn.activitydata.FirstActivity;
import com.sunjiajia.monkeyandroid.mustlearn.broadcastreceiverservicedemo.BcrActivity;
import com.sunjiajia.monkeyandroid.mustlearn.dagger2.Dagger2Activity;
import com.sunjiajia.monkeyandroid.mustlearn.databinding.DataBindingActivity;
import com.sunjiajia.monkeyandroid.mustlearn.recyclerview.SuperRecyclerActivity;
import com.sunjiajia.monkeyandroid.mustlearn.sqlite.MySQLiteOpenHelper;
import com.sunjiajia.monkeyandroid.mustlearn.sqlite.SqliteActivity;
import com.sunjiajia.monkeyandroid.utils.PermissionsUtil;
import com.sunjiajia.monkeyandroid.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/**
 * 此Activity容纳了一些必学的知识点
 */
public class MustLearnPointActivity extends AppCompatActivity
    implements ActivityCompat.OnRequestPermissionsResultCallback {

  @Bind(R.id.btn_sdcard_avail) Button mBtnSdcardAvail;
  @Bind(R.id.btn_sms_backup) Button mBtnSmsBackup;
  @Bind(R.id.btn_xml_parse) Button mBtnXmlParse;
  @Bind(R.id.btn_unit_debug) Button mBtnUnitDebug;
  @Bind(R.id.btn_sqlite) Button mBtnSqlite;
  @Bind(R.id.btn_sqlite_activity) Button mBtnSqliteActivity;
  @Bind(R.id.btn_dagger2) Button mBtnDagger2;
  @Bind(R.id.btn_download_image) Button mBtnDownloadImage;
  @Bind(R.id.btn_html) Button mBtnHtml;
  @Bind(R.id.btn_super_download) Button mBtnSuperDownload;
  @Bind(R.id.btn_activity_data) Button mBtnActivityData;
  @Bind(R.id.btn_activity_broadcastreceiver) Button mBtnActivityBroadcastreceiver;
  @Bind(R.id.btn_activity_super_recyclerview) Button mBtnActivitySuperRecyclerView;
  @Bind(R.id.btn_activity_data_binding) Button mBtnActivityDataBinding;

  private View mContentView;
  private List<Message> smsList;
  private List<Message> smsParseList;
  private String path = "";

  // 数据库的名字
  private static final String DB_NAME = "people.db";
  private static final int DB_VERSION = 2;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mContentView = LayoutInflater.from(this).inflate(R.layout.activity_must_learn_point, null);
    setTitle(getIntent().getStringExtra("title"));
    setContentView(mContentView);
    ButterKnife.bind(this);

    // 检查并且引导授予权限
    PermissionsUtil.checkAndRequestPermissions(this);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
  }

  @OnClick({
      R.id.btn_sdcard_avail, R.id.btn_sms_backup, R.id.btn_xml_parse, R.id.btn_unit_debug,
      R.id.btn_dagger2, R.id.btn_sqlite, R.id.btn_sqlite_activity, R.id.btn_download_image,
      R.id.btn_html, R.id.btn_super_download, R.id.btn_activity_data,
      R.id.btn_activity_broadcastreceiver, R.id.btn_activity_super_recyclerview,
      R.id.btn_activity_data_binding
  }) void btnClicked(View v) {
    switch (v.getId()) {
      case R.id.btn_sdcard_avail:
        getSdcardAvail();
        break;
      case R.id.btn_sms_backup:
        backupSmsByXml();
        break;
      case R.id.btn_xml_parse:
        parseXml();
        break;
      case R.id.btn_unit_debug:
        unitTest();
        break;
      case R.id.btn_dagger2:
        dagger2Demo();
        break;
      case R.id.btn_sqlite:
        sqliteDemo();
        break;
      case R.id.btn_sqlite_activity:
        startActivity(new Intent(MustLearnPointActivity.this, SqliteActivity.class));
        break;
      case R.id.btn_download_image:
        downloadImage(this);
        break;
      case R.id.btn_html:
        lookHtml(this);
        break;
      case R.id.btn_super_download:
        superDownload();
        break;
      case R.id.btn_activity_data:
        startActivity(new Intent(MustLearnPointActivity.this, FirstActivity.class));
        break;
      case R.id.btn_activity_broadcastreceiver:
        startActivity(new Intent(MustLearnPointActivity.this, BcrActivity.class));
        break;
      case R.id.btn_activity_super_recyclerview:
        Intent intent = new Intent(MustLearnPointActivity.this, SuperRecyclerActivity.class);
        intent.putExtra("title", mBtnActivitySuperRecyclerView.getText().toString());
        startActivity(intent);
        break;
      case R.id.btn_activity_data_binding:
        Intent intent01 = new Intent(MustLearnPointActivity.this, DataBindingActivity.class);
        intent01.putExtra("title", mBtnActivityDataBinding.getText().toString());
        startActivity(intent01);
        break;
    }
  }

  /**
   * 多线程断点下载
   */
  private void superDownload() {
    // 1.确定下载地址，以及下载线程的数目
    //String path = "http://dldir1.qq.com/qqfile/qq/QQ8.2/17724/QQ8.2.exe";
    String path = "http://192.168.31.160:4000/re.apk";
    int downloadThreadNums = 3;

    MyDownloadAsyncTask task = new MyDownloadAsyncTask(downloadThreadNums);
    task.execute(path);
  }

  @OnClick(R.id.btn_activity_data_binding) public void onClick() {
  }

  /**
   * 下载线程
   */
  class DownloadThread extends Thread {

    String path;
    int startIndex;
    int endIndex;
    int threadId;
    int count;

    int finishedThread = 0;// 一开始没有任何线程完成下载

    public DownloadThread(String path, int startIndex, int endIndex, int threadId, int count) {
      this.path = path;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
      this.threadId = threadId;
      this.count = count;
    }

    @Override public void run() {
      try {

        // 12. 判断进度临时文件是否存在，如果存在，则读取保存的下载进度
        File fileProgress = new File(Environment.getExternalStorageDirectory(),
            Utils.getFileNameFromUrl(path) + "_" + threadId + ".sdl.txt");

        if (fileProgress.exists()) {
          FileInputStream fis = new FileInputStream(fileProgress);
          BufferedReader br = new BufferedReader(new InputStreamReader(fis));
          startIndex += Integer.parseInt(br.readLine());
          fis.close();
        }

        // 7.再次发送http请求，下载源文件，每个线程下载不同的部分，从而实现多线程加速下载
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.setRequestMethod("GET");

        // 8.设置当前这个线程所请求的数据的区间
        conn.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
        if (conn.getResponseCode() == 206) {// 注：请求部分数据的状态码是206
          // 9.请求资源成功，获取输入流，输入流中的数据是每个当前线程所负责下载的区间（块）
          InputStream inputStream = conn.getInputStream();
          byte[] bytes = new byte[1024];
          int len = 0;
          int total = 0;// 当前线程下载的总字节
          // 10.拿到临时文件的输出流，写入到临时文件中
          File fileTemp = new File(Environment.getExternalStorageDirectory(),
              Utils.getFileNameFromUrl(path) + ".sdl");
          RandomAccessFile raf = new RandomAccessFile(fileTemp, "rwd");
          // 将每个线程下载写入的开始位置移动到正确位置
          raf.seek(startIndex);

          while ((len = inputStream.read(bytes)) != -1) {
            raf.write(bytes, 0, len);
            total += len;

            // 11.生成一个专门用来记录下载的进度临时文件，作用是为了实现断点续传
            File fileProgressTemp = new File(Environment.getExternalStorageDirectory(),
                Utils.getFileNameFromUrl(path) + "_" + threadId + ".sdl.txt");
            RandomAccessFile rafProgressTemp = new RandomAccessFile(fileProgressTemp, "rwd");
            rafProgressTemp.write((total + "").getBytes());
            rafProgressTemp.close();
          }
          raf.close();

          // 14.删除临时文件
          finishedThread++;
          synchronized (path) {
            if (finishedThread == count) {
              for (int i = 0; i < count; i++) {
                File temp = new File(Environment.getExternalStorageDirectory(),
                    Utils.getFileNameFromUrl(path) + "_" + i + ".sdl.txt");
                temp.delete();
              }
              finishedThread = 0;
            }
          }

          // 15.讲将下载好的目标文件改为正常的扩展名
          File downloadedFileTemp = new File(Environment.getExternalStorageDirectory(),
              Utils.getFileNameFromUrl(path) + ".sdl");
          File newFileName =
              new File(Environment.getExternalStorageDirectory(), Utils.getFileNameFromUrl(path));
          downloadedFileTemp.renameTo(newFileName);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  class MyDownloadAsyncTask extends AsyncTask<String, Integer, Object> {

    int downloadThreadNums;

    public MyDownloadAsyncTask(int count) {
      this.downloadThreadNums = count;
    }

    @Override protected Object doInBackground(String... params) {

      String path = params[0];

      // 2.获取远程服务器文件的大小
      int fileLength;
      try {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() == 200) {
          fileLength = conn.getContentLength();

          // 3.生成临时文件，并且设置临时文件的大小和远程服务器上的大小一致
          File fileTemp = new File(Environment.getExternalStorageDirectory(), "temp.sdl");
          RandomAccessFile raf = new RandomAccessFile(fileTemp, "rwd");
          raf.setLength(fileLength);
          raf.close();

          // 4.计算每个线程应该下载多少字节
          int size = fileLength / downloadThreadNums;

          for (int i = 0; i < downloadThreadNums; i++) {
            //5 .计算每个线程下载的开始位置和结束的位置
            int startIndex = i * size;
            int endIndex = (i + 1) * size - 1;
            if (i == downloadThreadNums - 1) {
              endIndex = fileLength - 1;
            }

            // 6. 开启线程进行下载
            DownloadThread downloadThread =
                new DownloadThread(path, startIndex, endIndex, i, downloadThreadNums);
            downloadThread.start();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      return null;
    }

    @Override protected void onPostExecute(Object o) {
      super.onPostExecute(o);
    }
  }

  /**
   * HTML源码查看
   * @param context
   *  上下文
   */
  private void lookHtml(Context context) {

    // 1.确定网络地址
    String path = "https://www.baidu.com/index.html";
    // 2. 异步请求网络
    MyHtmlAsyncTask task = new MyHtmlAsyncTask(context);
    task.execute(path);
  }

  class MyHtmlAsyncTask extends AsyncTask<String, Integer, String> {

    Context mContext;
    String path;

    public MyHtmlAsyncTask(Context context) {
      this.mContext = context;
    }

    @Override protected String doInBackground(String... params) {

      path = params[0];

      try {
        URL url = new URL(params[0]);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        if (connection.getResponseCode() == 200) {
          // 流里面的数据就是HTML源码
          InputStream inputStream = connection.getInputStream();
          String htmlText = Utils.getTextFromStream(inputStream);
          return htmlText;
        } else {
          return null;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      return null;
    }

    @Override protected void onPostExecute(String s) {
      if (s != null) {

        TextView textView = new TextView(mContext);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(10);
        textView.setText(s);

        ScrollView scrollView = new ScrollView(mContext);
        scrollView.addView(textView);

        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.addView(scrollView);

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(linearLayout);
        builder.setTitle(path);
        builder.setMessage("HTML源码");
        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        });
        builder.create().show();
      } else {
        Toast.makeText(mContext, "请求失败！", Toast.LENGTH_SHORT).show();
      }
    }
  }

  /**
   * 下载网络图片 地址：http://sunjiajia.com/img/author.jpg
   *
   * 注意点：
   *    1.请求网络数据的过程是一个耗时操作，需要在异步线程中操作；
   */
  private void downloadImage(Context context) {

    // 1.确定下载地址
    String path = "http://sunjiajia.com/img/author.jpg";

    MyImageAsyncTask task = new MyImageAsyncTask(context);
    task.execute(path);
  }

  /**
   * 异步请求网络图片类
   */
  private class MyImageAsyncTask extends AsyncTask<String, Integer, Bitmap> {

    private Context mContext;

    public MyImageAsyncTask(Context context) {
      this.mContext = context;
    }

    @Override protected Bitmap doInBackground(String... params) {

      Bitmap bitmap = null;

      try {
        // 2.把网址封装成一个url对象
        URL url = new URL(params[0]);
        // 3.获取客户端和服务器的连接对象，此时没有产生网络连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 4.对连接对象进行初始化，设置参数
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);
        // 5.发送请求，与服务器建立连接，通过响应码来判断是否连接成功
        if (connection.getResponseCode() == 200) {// 响应码为200表示成功
          // 6.得到输入流
          InputStream is = connection.getInputStream();

          // 7. 从输入流中读取位图Bitmap
          bitmap = BitmapFactory.decodeStream(is);
        } else {
          bitmap = null;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      return bitmap;
    }

    @Override protected void onPostExecute(Bitmap bitmap) {

      if (bitmap != null) {
        // 8. 把bitmap显示到ImageView中
        ImageView iv = new ImageView(mContext);
        iv.setImageBitmap(bitmap);

        // 9.弹出对话框来显示ImageView
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(iv);
        builder.setTitle("从网络下载并显示图片");
        builder.setMessage("图片下载完毕");
        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        });
        builder.create().show();
      } else {
        Toast.makeText(mContext, "请求图片失败！", Toast.LENGTH_SHORT).show();
      }
    }
  }

  /**
   * SQLite数据库的使用方法
   */
  private void sqliteDemo() {

    // 初始化SQLite打开帮助类,如果更改DB_VERSION的值（只能变大），会调用MySQLiteOpenHelper中的onUpgrade方法
    MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this, DB_NAME, null, DB_VERSION);

    //获取一个可写可读的数据库对象（通常用这个）
    // 如果，数据库不存在，先创建这个数据库，如果数据库存在，则直接打开
    SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
    //getReadableDatabase函数在手机存储空间满了的时候，会返回一个只读数据库对象
    //SQLiteDatabase sqLiteDatabase = helper.getReadableDatabase();

    // 插入数据
    insert(sqLiteDatabase);
    //删除数据
    delete(sqLiteDatabase);
    //修改数据
    update(sqLiteDatabase);
    // 查询数据
    select(sqLiteDatabase);

    /*****************************************************/
    // 用API进行增删改查
    insertApi(sqLiteDatabase);
    updateApi(sqLiteDatabase);
    deleteApi(sqLiteDatabase);
    selectApi(sqLiteDatabase);

    // 开启事务
    beginTransation(sqLiteDatabase);

    // 用完数据库记得关闭
    sqLiteDatabase.close();
  }

  /**
   * 执行一项事务，先给指定对象修改电话，然后再修改薪水。
   * @param db
   */
  public void beginTransation(SQLiteDatabase db) {

    try {
      // 开启事务
      db.beginTransaction();
      ContentValues values = new ContentValues();
      values.put("phone", "888999");
      db.update("person", values, "name=?", new String[] { "黄色金毛" });

      // values需要清空一下，避免数据混乱
      values.clear();

      values.put("phone", "13777888999");
      db.update("person", values, "name=?", new String[] { "黄色金毛" });

      // 设置事务执行成功，如果不执行该句，则事务不会执行成功
      db.setTransactionSuccessful();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 关闭事务，同时提交，如果已经设置事务执行成功，那么sql就生效了。
      db.endTransaction();
    }
  }

  private void selectApi(SQLiteDatabase db) {
    Cursor cursor = db.query("person", null, null, null, null, null, null, null);
    List<String> name = new ArrayList<>();
    while (cursor.moveToNext()) {
      name.add(cursor.getString(cursor.getColumnIndex("name")));
    }
    System.out.println("--selectApi--nameList--" + name.toString());
  }

  private void updateApi(SQLiteDatabase db) {
    ContentValues values = new ContentValues();
    values.put("salary", "99999.99");
    int updateRowsNum = db.update("person", values, "name=?", new String[] { "Jack003" });
    System.out.println("--updateApi---" + updateRowsNum);
  }

  private void deleteApi(SQLiteDatabase db) {
    int deletedRowsNum = db.delete("person", "name=?", new String[] { "Jack002" });
    System.out.println("--deleteApi---" + deletedRowsNum);
  }

  private void insertApi(SQLiteDatabase db) {
    ContentValues values = new ContentValues();
    values.put("name", "黄色金毛");
    values.put("phone", "999");
    values.put("salary", "10.0");

    db.insert("person", null, values);
  }

  private void select(SQLiteDatabase db) {
    Cursor cursor = db.rawQuery("select name from person where phone=?", new String[] { "110" });
    while (cursor.moveToNext()) {
      System.out.println("--select()--name--" + cursor.getString(cursor.getColumnIndex("name")));
    }
  }

  private void update(SQLiteDatabase db) {
    db.execSQL("update person set phone=? where name=?", new Object[] { "110", "Jack002" });
  }

  private void delete(SQLiteDatabase db) {
    db.execSQL("delete from person where name=?", new Object[] { "Jack001" });
  }

  private void insert(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("insert into person (name,salary,phone)values(?,?,?)",
        new Object[] { "Jack001", "1300.0", 15512345 });
    sqLiteDatabase.execSQL("insert into person (name,salary,phone)values(?,?,?)",
        new Object[] { "Jack002", 1500.0, "15512345" });
    sqLiteDatabase.execSQL("insert into person (name,salary,phone)values(?,?,?)",
        new Object[] { "Jack003", "1400.0", 15512345 });
  }

  /**
   * 打开dagger2的示例Activity
   */
  private void dagger2Demo() {
    startActivity(new Intent(MustLearnPointActivity.this, Dagger2Activity.class));
  }

  /**
   * 单元测试
   * **按照岗位划分：
   * *****黑盒测试：测试逻辑业务
   * *****白盒测试：测试逻辑方法
   * **按测试粒度划分：
   * *****方法测试：function test
   * *****单元测试：unit test
   * *****集成测试：integration test
   * *****系统测试：system test
   * **按测试的暴力程度划分：
   * *****冒烟测试：smoke test
   * *****压力测试：pressure test
   */
  private void unitTest() {

  }

  /**
   * 解析XML
   */
  public void parseXml() {
    // 解析xml
    File file = new File(path);
    Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
    if (file.exists()) {
      try {
        FileInputStream fis = new FileInputStream(file);
        XmlPullParser parser = Xml.newPullParser();

        parser.setInput(fis, "utf-8");

        int type = parser.getEventType();
        Message sms = null;
        while (type != XmlPullParser.END_DOCUMENT) {
          switch (type) {
            case XmlPullParser.START_TAG:
              if ("message".equals(parser.getName())) {
                smsParseList = new ArrayList<Message>();
              } else if ("sms".equals(parser.getName())) {
                sms = new Message();
              } else if ("body".equals(parser.getName())) {
                sms.setBody(parser.nextText());
              } else if ("date".equals(parser.getName())) {
                sms.setDate(parser.nextText());
              } else if ("address".equals(parser.getName())) {
                sms.setAddress(parser.nextText());
              } else if ("type".equals(parser.getName())) {
                sms.setType(Integer.parseInt(parser.nextText()));
              }
              break;
            case XmlPullParser.END_TAG:
              if ("sms".equals(parser.getName())) {
                smsParseList.add(sms);
              }
              break;
          }

          type = parser.next();
        }

        for (Message message : smsParseList) {
          System.out.println("-->" + message.toString());
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void backupSmsByXml() {
    initSmsData();
    backupSms();
  }

  private void backupSms() {

    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
      path = Environment.getExternalStorageDirectory() + File.separator + "sms_bak.xml";
      Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
    } else {
      path = getFilesDir() + File.separator + "sms_bak.xml";
      Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
    }

    try {
      File fileXml = new File(path);
      FileOutputStream fos = new FileOutputStream(fileXml);

      XmlSerializer serializer = Xml.newSerializer();
      serializer.setOutput(fos, "utf-8");
      serializer.startDocument("utf-8", true);

      serializer.startTag(null, "message");

      for (Message sms : smsList) {
        serializer.startTag(null, "sms");

        serializer.startTag(null, "body");
        serializer.text(sms.getBody());
        serializer.endTag(null, "body");

        serializer.startTag(null, "date");
        serializer.text(sms.getDate());
        serializer.endTag(null, "date");

        serializer.startTag(null, "address");
        serializer.text(sms.getAddress());
        serializer.endTag(null, "address");

        serializer.startTag(null, "type");
        serializer.text(sms.getType() + "");
        serializer.endTag(null, "type");

        serializer.endTag(null, "sms");
      }

      serializer.endTag(null, "message");

      serializer.endDocument();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void initSmsData() {

    smsList = new ArrayList<>();
    for (int i = Toast.LENGTH_SHORT; i < 20; i++) {
      Message sms = new Message("猴子吃香蕉 ##" + i, System.currentTimeMillis() + "", "138****" + i, 1);
      smsList.add(sms);
    }
  }

  private String formatSize(long size) {
    return Formatter.formatFileSize(this, size);
  }

  /**
   * 获取sdcard剩余空间
   * <p/>
   * sdcard总大小 = 区块大小 * 区块数量
   */
  public void getSdcardAvail() {

    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

      try {
        File sdFile = Environment.getExternalStorageDirectory();
        StatFs statFs = new StatFs(sdFile.getPath());

        long totalSize;
        long availSize;

        // API 18(Android4.3)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
          long blockSize = statFs.getBlockSizeLong();// 块的大小
          long totalBlocks = statFs.getBlockCountLong();// 块的总数
          long availBlocks = statFs.getAvailableBlocksLong();// 块的可用数目

          totalSize = blockSize * totalBlocks;
          availSize = blockSize * availBlocks;
        } else {
          long blockSize = statFs.getBlockSize();// 块的大小
          long totalBlocks = statFs.getBlockCount();// 块的总数
          long availBlocks = statFs.getAvailableBlocks();// 块的可用数目

          totalSize = blockSize * totalBlocks;
          availSize = blockSize * availBlocks;
        }

        Toast.makeText(this, "sdcard的总大小为：" + formatSize(totalSize), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "sdcard的剩余大小为：" + formatSize(availSize), Toast.LENGTH_SHORT).show();
      } catch (Exception e) {
        e.printStackTrace();
        Toast.makeText(this, "获取sdcard大小失败", Toast.LENGTH_SHORT).show();
      }
    } else {
      Toast.makeText(this, "SDcard没有准备好，请检查", Toast.LENGTH_SHORT).show();
    }
  }

  private class BtnClickedListener implements View.OnClickListener {

    @Override public void onClick(View v) {
      switch (v.getId()) {
        case R.id.btn_sdcard_avail:
          getSdcardAvail();
          break;
        case R.id.btn_sms_backup:
          backupSmsByXml();
          break;
        case R.id.btn_xml_parse:

          if (!path.equals("")) {
            parseXml();
          } else {
            Toast.makeText(MustLearnPointActivity.this, "path is null", Toast.LENGTH_SHORT).show();
          }

          break;
        case R.id.btn_unit_debug:
          parseXml();
          break;
      }
    }
  }
}
