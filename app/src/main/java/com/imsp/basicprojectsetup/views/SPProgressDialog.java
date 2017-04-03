package com.imsp.basicprojectsetup.views;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imsp.basicprojectsetup.R;
import com.imsp.basicprojectsetup.activities.MainActivity;

/**
 * Created by SP on 03-04-2017.
 */

public class SPProgressDialog extends Dialog {

    Context context;

    SPProgressDialog dialog;
    public SPProgressDialog(Context context) {
        super(context);
        this.context = context;
        dialog = new SPProgressDialog(context,R.style.AlertDialog);
        dialog.setContentView(R.layout.layout_progress_dialog);
        dialog.setCancelable(false);
    }

    public SPProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public void showDialog(){
        dialog.show();
    }

    public void dismissDialog(){
        dialog.dismiss();
    }
}
