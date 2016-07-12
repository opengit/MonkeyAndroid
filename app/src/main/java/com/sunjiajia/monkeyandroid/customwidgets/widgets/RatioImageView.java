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

package com.sunjiajia.monkeyandroid.customwidgets.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by monkey on 16-7-11.
 */
public class RatioImageView extends ImageView {

  private int mWidthRatio;
  private int mHeightRatio;

  public RatioImageView(Context context) {
    this(context, null);
  }

  public RatioImageView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  /**
   * 初始化好RatioImageView控件后，用这个方法来设置宽高的比例，例如：16:9，那么widthRatio就是16，heightRatio就是9
   * @param widthRatio
   * 宽在比例中占得数值，例如16:9，它的值就是16
   * @param heightRatio
   * 高在比例中占得数值，例如16:9，它的值就是9
   */
  public void setRatio(int widthRatio, int heightRatio) {
    if (widthRatio > 0 && heightRatio > 0) {
      mWidthRatio = widthRatio;
      mHeightRatio = heightRatio;
    } else {
      throw new IllegalArgumentException(
          "the parameter of setRatio(int,int) must be positive Integer!");
    }
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    int width = MeasureSpec.getSize(widthMeasureSpec);
    int height = MeasureSpec.getSize(heightMeasureSpec);

    double ratio = (double) mWidthRatio / mHeightRatio;
    if (width > 0) {
      if (mWidthRatio >= mHeightRatio) {
        height = (int) (width / ratio + 0.5f);
      } else {
        width = (int) (height * ratio + 0.5f);
      }
      setMeasuredDimension(width, height);

      System.out.println("width->" + width + ",height->" + height + ",ratio->" + ratio);
    } else {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
  }
}
