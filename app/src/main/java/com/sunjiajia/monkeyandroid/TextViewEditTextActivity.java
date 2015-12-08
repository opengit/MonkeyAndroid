package com.sunjiajia.monkeyandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by monkey on 12/8/15.
 */
public class TextViewEditTextActivity extends BaseActivity {
  private EditText mEtUname;
  private EditText mEtPwd;

  @Override public int giveViewResId() {
    return R.layout.activity_textview_edittext;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mEtUname = (EditText) findViewById(R.id.et_uname);
    mEtPwd = (EditText) findViewById(R.id.et_pwd);

    /**
     * EditText中文本输入变化的监听
     */
    mEtUname.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(TextViewEditTextActivity.this, "beforeTextChanged-->s-->" + s,
            Toast.LENGTH_SHORT).show();
      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(TextViewEditTextActivity.this, "onTextChanged-->s-->" + s,
            Toast.LENGTH_SHORT).show();
      }

      @Override public void afterTextChanged(Editable s) {
        Toast.makeText(TextViewEditTextActivity.this, "afterTextChanged-->s-->" + s,
            Toast.LENGTH_SHORT).show();
      }
    });

    /**
     * 回车键监听事件
     */
    mEtUname.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        Toast.makeText(TextViewEditTextActivity.this, "onEditorAction-->" + v.getText(),
            Toast.LENGTH_SHORT).show();
        return true;
      }
    });
  }
}
