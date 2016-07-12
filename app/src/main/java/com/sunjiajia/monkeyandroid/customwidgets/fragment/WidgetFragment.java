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

package com.sunjiajia.monkeyandroid.customwidgets.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.customwidgets.widgets.RatioImageView;

/**
 * Created by monkey on 16-7-12.
 */
public class WidgetFragment extends Fragment {

  @Bind(R.id.ratio_imageview) RatioImageView mRatioImageview;
  @Bind(R.id.btn_sixteen_nine) Button mBtnSixteenNine;

  public static WidgetFragment fragment;
  private View mView;

  public static WidgetFragment newInstance(int fragType) {

    if (fragment == null) {
      fragment = new WidgetFragment();
    }

    Bundle bundle = new Bundle();
    bundle.putInt("fragType", fragType);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    int fragType = getArguments().getInt("fragType");
    int viewResId = 0;
    switch (fragType) {
      case R.id.btn_ratio_imageview:
        viewResId = R.layout.frag_ratio_imageview;
        break;
    }

    if (viewResId <= 0) {
      throw new IllegalArgumentException("Fragment需要填充的View的布局文件Id参数错误。");
    }

    mView = inflater.inflate(viewResId, container, false);
    ButterKnife.bind(this, mView);
    return mView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    mRatioImageview.setRatio(1, 1);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  @OnClick({
      R.id.btn_sixteen_nine
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_sixteen_nine:
        mRatioImageview.setRatio(16, 9);
        break;
    }
    mRatioImageview.setScaleType(ScaleType.FIT_XY);
  }
}
