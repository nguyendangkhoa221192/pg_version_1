package dev.khoand.pg_app_version_1.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;

/**
 * Created by khoam on 24/05/2017.
 */

public class Common {

    public static void showProgressDialogWithMessage(final ProgressDialog progressDialog, String title, String message) {
        if (message != null && !message.equals("")) {
            progressDialog.setMessage(message);
        }
        if (title != null && !title.equals("")) {
            progressDialog.setTitle(title);
        }
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        // Set timeout for progress dialog
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, Constants.TIME_OUT);
    }

    public static void showProgressDialogWithoutMessage(final ProgressDialog progressDialog) {
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        // Set timeout for progress dialog
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, Constants.TIME_OUT);
    }

    public static void FinishProgressDialog(ProgressDialog progressDialog) {
        progressDialog.dismiss();
    }
}
