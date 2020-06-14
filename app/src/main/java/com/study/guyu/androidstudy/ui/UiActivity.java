package com.study.guyu.androidstudy.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.ui.uiitem.AlertDialogActivity;
import com.study.guyu.androidstudy.ui.uiitem.ButtonActivity;
import com.study.guyu.androidstudy.ui.uiitem.CheckBoxActivity;
import com.study.guyu.androidstudy.ui.uiitem.DialogActivity;
import com.study.guyu.androidstudy.ui.uiitem.EditTextActivity;
import com.study.guyu.androidstudy.ui.uiitem.gridview.GridViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.ImageViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.listview.ListViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.PopUpWindowActivity;
import com.study.guyu.androidstudy.ui.uiitem.ProgressActivity;
import com.study.guyu.androidstudy.ui.uiitem.RadioButtonActivity;
import com.study.guyu.androidstudy.ui.uiitem.recyclerview.RecyclerViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.ScrollViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.TextViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.ToastActivity;
import com.study.guyu.androidstudy.ui.uiitem.WebViewActivity;

public class UiActivity extends ActionBarActivity {

    private Button mBtnTextView;
    private Button mBtnEditView;
    private Button mBtnButton;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnScrollView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnAlertDialog;
    private Button mBtnProgress;
    private Button mBtnDialog;
    private Button mBtnPopUpWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView= (Button) findViewById(R.id.textview);
        mBtnEditView= (Button) findViewById(R.id.edittext);
        mBtnButton= (Button) findViewById(R.id.button);
        mBtnRadioButton= (Button) findViewById(R.id.radiobutton);
        mBtnCheckBox= (Button) findViewById(R.id.checkbox);
        mBtnImageView= (Button) findViewById(R.id.imageview);
        mBtnListView= (Button) findViewById(R.id.listview);
        mBtnGridView= (Button) findViewById(R.id.gridview);
        mBtnScrollView= (Button) findViewById(R.id.scrollview);
        mBtnRecyclerView= (Button) findViewById(R.id.recyclerview);
        mBtnWebView= (Button) findViewById(R.id.webview);
        mBtnToast= (Button) findViewById(R.id.toast);
        mBtnAlertDialog= (Button) findViewById(R.id.alertdialog);
        mBtnProgress= (Button) findViewById(R.id.progress);
        mBtnDialog= (Button) findViewById(R.id.dialog);
        mBtnPopUpWindow= (Button) findViewById(R.id.popupwindow);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick=new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnEditView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnScrollView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnAlertDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnPopUpWindow.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.textview:
                    intent=new Intent(UiActivity.this, TextViewActivity.class);
                    break;
                case R.id.button:
                    intent=new Intent(UiActivity.this, ButtonActivity.class);
                    break;
                case R.id.edittext:
                    intent=new Intent(UiActivity.this, EditTextActivity.class);
                    break;
                case R.id.radiobutton:
                    intent=new Intent(UiActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.checkbox:
                    intent=new Intent(UiActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.scrollview:
                    intent=new Intent(UiActivity.this, ScrollViewActivity.class);
                    break;
                case R.id.imageview:
                    intent=new Intent(UiActivity.this, ImageViewActivity.class);
                    break;
                case R.id.listview:
                    intent=new Intent(UiActivity.this, ListViewActivity.class);
                    break;
                case R.id.gridview:
                    intent=new Intent(UiActivity.this, GridViewActivity.class);
                    break;
                case R.id.recyclerview:
                    intent=new Intent(UiActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.webview:
                    intent=new Intent(UiActivity.this, WebViewActivity.class);
                    break;
                case R.id.toast:
                    intent=new Intent(UiActivity.this, ToastActivity.class);
                    break;
                case R.id.alertdialog:
                    intent=new Intent(UiActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.dialog:
                    intent=new Intent(UiActivity.this, DialogActivity.class);
                    break;
                case R.id.progress:
                    intent=new Intent(UiActivity.this, ProgressActivity.class);
                    break;
                case R.id.popupwindow:
                    intent=new Intent(UiActivity.this, PopUpWindowActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
