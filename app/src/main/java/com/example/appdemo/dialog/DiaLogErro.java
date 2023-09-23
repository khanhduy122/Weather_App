package com.example.appdemo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DiaLogErro{
    private static AlertDialog.Builder Dialogero;
    public static void ShowDialogErro(Context context){
        Dialogero = new AlertDialog.Builder(context);
        Dialogero.setTitle("Notification");
        Dialogero.setMessage("Something went wrong or try again");
        Dialogero.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialogero.show();
    }

    public static void ShowDiaLogNoInternet(Context context){
        Dialogero = new AlertDialog.Builder(context);
        Dialogero.setTitle("NO INTERNET");
        Dialogero.setMessage("Please check your Internet connection again");
        Dialogero.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialogero.show();
    }
}
