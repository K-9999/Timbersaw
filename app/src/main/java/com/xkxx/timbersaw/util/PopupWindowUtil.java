package com.xkxx.timbersaw.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xkxx.timbersaw.R;

public class PopupWindowUtil {

    public static PopupWindow mPopupWindow;

    private String title ;
    private String content ;



    public static void initPopQuit(Context context, View v, String title, String content, final OnPopBtnClickListener cancel, final OnPopBtnClickListener confirm) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View mView = layoutInflater.inflate(R.layout.pop_confirm, null);
        TextView tv_title = mView.findViewById(R.id.tv_title);
        TextView tv_content = mView.findViewById(R.id.tv_content);
        tv_title.setText(title);
        tv_content.setText(content);
        Button outCancel = (Button) mView.findViewById(R.id.pop_out_cancel);
        outCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (cancel != null) {
                    cancel.onClick(v);
                }
            }
        });
        Button outConfirm = (Button) mView.findViewById(R.id.pop_out_confirm);

        outConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (confirm != null) {
                    confirm.onClick(v);
                }
            }
        });
        mPopupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
    }

    public static void initPopPurchase(Context context, View v, final OnPopBtnClickListener man, final OnPopBtnClickListener woman) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View mView = layoutInflater.inflate(R.layout.pop_purchase_manage, null);
        TextView tvMan = mView.findViewById(R.id.tv_man);
        TextView tvWoman = mView.findViewById(R.id.tv_woman);
        TextView outCancel = mView.findViewById(R.id.cancel);

        outCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });

        tvMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (man != null) {
                    man.onClick(v);
                }
            }
        });
        tvWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (woman != null) {
                    woman.onClick(v);
                }
            }
        });

        mPopupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mPopupWindow.dismiss();
            }
        });
        mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    mPopupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });

        mPopupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
    }


    public static void initPopQuit2(Context context, View v, String title, String content, final OnPopBtnClickListener cancel, final OnPopBtnClickListener confirm) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View mView = layoutInflater.inflate(R.layout.pop_confirm, null);
        TextView tv_title = mView.findViewById(R.id.tv_title);
        TextView tv_content = mView.findViewById(R.id.tv_content);
        View view = mView.findViewById(R.id.view_line);
        tv_title.setText(title);
        tv_content.setText(content);
        Button outCancel = (Button) mView.findViewById(R.id.pop_out_cancel);
        outCancel.setVisibility(View.GONE);
        view.setVisibility(View.GONE);
        outCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (cancel != null) {
                    cancel.onClick(v);
                }
            }
        });
        Button outConfirm = (Button) mView.findViewById(R.id.pop_out_confirm);

        outConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (confirm != null) {
                    confirm.onClick(v);
                }
            }
        });
        mPopupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
    }

    public interface OnPopBtnClickListener {
        void onClick(View v);
    }

}
