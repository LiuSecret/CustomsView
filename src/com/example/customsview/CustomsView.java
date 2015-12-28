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
