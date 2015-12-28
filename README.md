# CustomsView
Android自定义UI控件
简单一个实现一个带图片和文字的头部栏

1、首先设置自定义控件的属性：

一般写在资源文件下的attr.xml内部；

<?xml version="1.0" encoding="utf-8"?>
<resources>

<declare-styleable name="CustomsView">
<attr name="titleTextCenter" format="string"></attr>
<attr name="titleTextCentercolor" format="color"></attr>
<attr name="titleTextCenterSize" format="float"></attr>
<attr name="titleImage" format="reference"></attr>
<attr name="titlebg" format="color"></attr>
<attr name="titleTextRight" format="string"></attr>
<attr name="titleTextRightcolor" format="color"></attr>
<attr name="titleTextRightSize" format="float"></attr>
</declare-styleable>

</resources>

2、写自定义控件的显示布局样本：

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:id="@+id/layout"
android:layout_width="match_parent"
android:layout_height="55dp" >

<ImageView
android:id="@+id/image"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentLeft="true"
android:layout_centerVertical="true"
android:layout_marginLeft="20dp"
android:src="@drawable/back" />

<TextView
android:id="@+id/text_center"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_centerHorizontal="true"
android:layout_centerVertical="true" />

<TextView
android:id="@+id/text_right"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentRight="true"
android:layout_centerVertical="true"
android:layout_marginRight="20dp" />

</RelativeLayout>

3、java代码属性设置赋值：

package com.example.customsview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomsView extends LinearLayout {
private View view;
private TextView text_center, text_right;
private ImageView imageview;
private String str_text_center, str_text_right;
private int drawablecolor, drawablecentercolor, drawablerightcolor, drawableimage;
private float textcenterSize, textrightSize;
private String namespace = "http://schemas.android.com/apk/res/com.example.customsview";
private RelativeLayout layout;

public CustomsView(Context context) {
super(context);
}

public CustomsView(Context context, AttributeSet attrs) {
super(context, attrs);
view = LayoutInflater.from(context).inflate(R.layout.customs, this, true);
text_center = (TextView) view.findViewById(R.id.text_center);
text_right = (TextView) view.findViewById(R.id.text_right);
imageview = (ImageView) view.findViewById(R.id.image);
layout = (RelativeLayout) view.findViewById(R.id.layout);

str_text_center = attrs.getAttributeValue(namespace, "titleTextCenter");
textcenterSize = attrs.getAttributeFloatValue(namespace, "titleTextCenterSize", 12);
drawablecentercolor = attrs.getAttributeResourceValue(namespace, "titleTextCentercolor", R.color.green);

str_text_right = attrs.getAttributeValue(namespace, "titleTextRight");
textrightSize = attrs.getAttributeFloatValue(namespace, "titleTextRightSize", 12);
drawablerightcolor = attrs.getAttributeResourceValue(namespace, "titleTextRightcolor", R.color.black);

drawablecolor = attrs.getAttributeResourceValue(namespace, "titlebg", R.color.black);
drawableimage = attrs.getAttributeResourceValue(namespace, "titleImage", R.drawable.ic_launcher);

text_center.setText(str_text_center);
text_center.setTextSize(textcenterSize);
text_center.setTextColor(context.getResources().getColor(drawablecentercolor));

text_right.setText(str_text_right);
text_right.setTextSize(textrightSize);
text_right.setTextColor(context.getResources().getColor(drawablerightcolor));

layout.setBackgroundColor(context.getResources().getColor(drawablecolor));
imageview.setImageDrawable(context.getResources().getDrawable(drawableimage));
}
}

4、使用自定义控件：

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:customs="http://schemas.android.com/apk/res/com.example.customsview"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:background="@color/white"
android:orientation="vertical" >

<com.example.customsview.CustomsView
android:layout_width="match_parent"
android:layout_height="wrap_content"
customs:titleImage="@drawable/back"
customs:titleTextCenter="中间标题红黄色18"
customs:titleTextCenterSize="18"
customs:titleTextCentercolor="@color/red"
customs:titleTextRight="右边标题黑色14"
customs:titleTextRightSize="14"
customs:titleTextRightcolor="@color/black"
customs:titlebg="@color/green" >
</com.example.customsview.CustomsView>

</LinearLayout>
