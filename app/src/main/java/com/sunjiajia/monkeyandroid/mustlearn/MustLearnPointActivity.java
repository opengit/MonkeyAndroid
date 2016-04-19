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

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.domain.Message;
import com.sunjiajia.monkeyandroid.utils.PermissionsUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

  private View mContentView;
  private List<Message> smsList;
  private List<Message> smsParseList;
  private String path = "";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mContentView = LayoutInflater.from(this).inflate(R.layout.activity_must_learn_point, null);
    setContentView(mContentView);
    ButterKnife.bind(this);

    PermissionsUtil.checkAndRequestPermissions(this);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
  }

  @OnClick({ R.id.btn_sdcard_avail, R.id.btn_sms_backup, R.id.btn_xml_parse, R.id.btn_unit_debug })
  void btnClicked(View v) {
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
        parseXml();
        break;
    }
  }

  private String formatSize(long size) {
    return Formatter.formatFileSize(this, size);
  }

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
