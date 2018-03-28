// Generated code from Butter Knife. Do not modify!
package com.Vcan.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GDQuery3Result$$ViewBinder<T extends com.Vcan.activity.GDQuery3Result> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624797, "field 'btn_fx'");
    target.btn_fx = finder.castView(view, 2131624797, "field 'btn_fx'");
    view = finder.findRequiredView(source, 2131624799, "field 'btn_xz'");
    target.btn_xz = finder.castView(view, 2131624799, "field 'btn_xz'");
    view = finder.findRequiredView(source, 2131624801, "field 'btn_sc'");
    target.btn_sc = finder.castView(view, 2131624801, "field 'btn_sc'");
    view = finder.findRequiredView(source, 2131624803, "field 'btn_cancel'");
    target.btn_cancel = finder.castView(view, 2131624803, "field 'btn_cancel'");
    view = finder.findRequiredView(source, 2131624796, "field 'img_fx'");
    target.img_fx = finder.castView(view, 2131624796, "field 'img_fx'");
    view = finder.findRequiredView(source, 2131624798, "field 'img_xz'");
    target.img_xz = finder.castView(view, 2131624798, "field 'img_xz'");
    view = finder.findRequiredView(source, 2131624800, "field 'img_sc'");
    target.img_sc = finder.castView(view, 2131624800, "field 'img_sc'");
    view = finder.findRequiredView(source, 2131624802, "field 'img_cancel'");
    target.img_cancel = finder.castView(view, 2131624802, "field 'img_cancel'");
  }

  @Override public void unbind(T target) {
    target.btn_fx = null;
    target.btn_xz = null;
    target.btn_sc = null;
    target.btn_cancel = null;
    target.img_fx = null;
    target.img_xz = null;
    target.img_sc = null;
    target.img_cancel = null;
  }
}
