package com.example.appdemo.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.appdemo.R;


public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);

    }
}
