package com.vcans.tool;

import android.content.Context;

public class ColorUtil {

	public static int getResourcesColor(Context text,int color) {

        int ret = 0x00ffffff;
        try {
            ret = text.getResources().getColor(color);
        } catch (Exception e) {
        }

        return ret;
    }
}
