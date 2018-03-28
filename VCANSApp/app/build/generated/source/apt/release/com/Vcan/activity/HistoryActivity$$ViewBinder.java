// Generated code from Butter Knife. Do not modify!
package com.Vcan.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HistoryActivity$$ViewBinder<T extends com.Vcan.activity.HistoryActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624159, "field 'GridView'");
    target.GridView = finder.castView(view, 2131624159, "field 'GridView'");
    view = finder.findRequiredView(source, 2131624043, "field 'tvActtitle'");
    target.tvActtitle = finder.castView(view, 2131624043, "field 'tvActtitle'");
    view = finder.findRequiredView(source, 2131624158, "field 'pop_layout'");
    target.pop_layout = finder.castView(view, 2131624158, "field 'pop_layout'");
    view = finder.findRequiredView(source, 2131624796, "field 'btn_fx'");
    target.btn_fx = finder.castView(view, 2131624796, "field 'btn_fx'");
    view = finder.findRequiredView(source, 2131624798, "field 'btn_xz'");
    target.btn_xz = finder.castView(view, 2131624798, "field 'btn_xz'");
    view = finder.findRequiredView(source, 2131624800, "field 'btn_sc'");
    target.btn_sc = finder.castView(view, 2131624800, "field 'btn_sc'");
    view = finder.findRequiredView(source, 2131624802, "field 'btn_cancel'");
    target.btn_cancel = finder.castView(view, 2131624802, "field 'btn_cancel'");
    view = finder.findRequiredView(source, 2131624795, "field 'img_fx'");
    target.img_fx = finder.castView(view, 2131624795, "field 'img_fx'");
    view = finder.findRequiredView(source, 2131624797, "field 'img_xz'");
    target.img_xz = finder.castView(view, 2131624797, "field 'img_xz'");
    view = finder.findRequiredView(source, 2131624799, "field 'img_sc'");
    target.img_sc = finder.castView(view, 2131624799, "field 'img_sc'");
    view = finder.findRequiredView(source, 2131624801, "field 'img_cancel'");
    target.img_cancel = finder.castView(view, 2131624801, "field 'img_cancel'");
  }

  @Override public void unbind(T target) {
    target.GridView = null;
    target.tvActtitle = null;
    target.pop_layout = null;
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
