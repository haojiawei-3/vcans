package com.vcans.adapter;

import java.util.List;
import java.util.Map;

import com.Vcan.activity.R;
import com.vcans.tool.ColorUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * 自定义的适配器  支持显示位图，更改资源文件Item的背景颜色和标题
 * @author vcans
 *
 */
public class ImageSimpleAdapter extends SimpleAdapter {
	private int[] mTo;
	private String[] mFrom;
	private ViewBinder mViewBinder;
	private List<? extends Map<String, ?>> mData;
	private int mResource;
	private int mDropDownResource;
	private LayoutInflater mInflater;
	private Context mContext;
	private Integer[] szResColor;//资源文件的背景颜色
	private ItemTitleListener mItemTitle=null;

	public void addItemTitleListener(ItemTitleListener itemTitle)
	{
		mItemTitle=itemTitle;
	}



	public interface ItemTitleListener
	{
		public void SetItemTitle(View view);
	}

	public ImageSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,
							  int[] to) {
		super(context, data, resource, from, to);
		mTo = to;
		mFrom = from;
		mData = data;
		mContext = context;
		mResource = mDropDownResource = resource;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public ImageSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,
							  int[] to, Integer[] resColor) {
		super(context, data, resource, from, to);
		mTo = to;
		mFrom = from;
		mData = data;
		mContext = context;
		szResColor = resColor;
		mResource = mDropDownResource = resource;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		return createViewFromResource(position, convertView, parent, mResource);
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return createViewFromResource(position, convertView, parent, mDropDownResource);
	}

	private View createViewFromResource(int position, View convertView, ViewGroup parent, int resource) {
		View v;
		if (convertView == null) {
			v = mInflater.inflate(resource, parent, false);
		} else {
			v = convertView;
		}

		bindView(position, v);

		return v;
	}

	private void bindView(int position, View view) {
		final Map dataSet = mData.get(position);
		if (dataSet == null) {
			return;
		}
		if(mItemTitle!=null)
			mItemTitle.SetItemTitle(view);

		final ViewBinder binder = mViewBinder;
		final String[] from = mFrom;
		final int[] to = mTo;
		final int count = to.length;

		for (int i = 0; i < count; i++) {
			final View v = view.findViewById(to[i]);
			if (v != null) {
				final Object data = dataSet.get(from[i]);
				String text = data == null ? "" : data.toString();
				if (text == null) {
					text = "";
				}

				boolean bound = false;
				if (binder != null) {
					bound = binder.setViewValue(v, data, text);
				}

				if (!bound) {
					if (v instanceof Checkable) {
						if (data instanceof Boolean) {
							((Checkable) v).setChecked((Boolean) data);
						} else if (v instanceof TextView) {
							setViewText((TextView) v, text);
						} else {
							throw new IllegalStateException(
									v.getClass().getName() + " should be bound to a Boolean, not a "
											+ (data == null ? "<unknown type>" : data.getClass()));
						}
					} else if (v instanceof TextView) {
						setViewText((TextView) v, text);
					} else if (v instanceof ImageView) {
						if (data instanceof Integer) {
							{
								setViewImage((ImageView) v, (Integer) data);

								// 设置背景颜色
								if (szResColor != null) {
									if (position < szResColor.length) {
										GradientDrawable bgShape = (GradientDrawable) v.getBackground();
										if (bgShape != null)
											bgShape.setColor(ColorUtil.getResourcesColor(mContext, this.szResColor[position]));
									}
								}

							}
						} else if (data instanceof Bitmap) {// 仅仅添加这一步
							setViewImage((ImageView) v, (Bitmap) data);
						} else {
							setViewImage((ImageView) v, text);
						}
					} else {
						throw new IllegalStateException(
								v.getClass().getName() + " is not a view that can be bounds by this SimpleAdapter");
					}
				}
			}
		}
	}

	/**
	 * 添加这个方法来处理Bitmap类型参数
	 *
	 * @param v
	 * @param bitmap
	 */
	public void setViewImage(ImageView v, Bitmap bitmap) {
		v.setImageBitmap(bitmap);
	}
}