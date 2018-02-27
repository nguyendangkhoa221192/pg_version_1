package dev.khoand.pg_app_version_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import dev.khoand.pg_app_version_1.Global.GlobalInfo;
import dev.khoand.pg_app_version_1.ItemData.LoginInfo;
import dev.khoand.pg_app_version_1.ItemData.Role;
import dev.khoand.pg_app_version_1.RemoteRetrofit.ApiUtils;
import dev.khoand.pg_app_version_1.RemoteRetrofit.SOService;
import dev.khoand.pg_app_version_1.Utils.Common;
import dev.khoand.pg_app_version_1.Utils.CustomToast;
import dev.khoand.pg_app_version_1.Utils.HidenKeyboard;
import dev.khoand.pg_app_version_1.Utils.SharedPrefUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.loginBtn) Button btnLogin;

    private SOService mService;
    private SharedPrefUtils share;

    @BindView(R.id.login_userid) TextView txt_user;
    @BindView(R.id.login_password) TextView txt_pass;
    @BindView(R.id.login_remember) CheckBox cb_remember;

    @BindString(R.string.author_message_loading) String message_loading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        // Use library http://jakewharton.github.io/butterknife/
        ButterKnife.bind(this);

        // Hidden soft keyboard
        HidenKeyboard.setupUI(this);

        // View
        mdialog = new ProgressDialog(this);

        // Global Info
        share = new SharedPrefUtils(this);
        info = (GlobalInfo) getApplicationContext();

        // Load info login
        if (share.isExist(SharedPrefUtils.USERNAME_KEY))
            txt_user.setText(share.getStringValue(SharedPrefUtils.USERNAME_KEY));
        if (share.isExist(SharedPrefUtils.PASSWORD_KEY))
            txt_pass.setText(share.getStringValue(SharedPrefUtils.PASSWORD_KEY));

        // Button submit login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show progress dialog
                Common.showProgressDialogWithMessage(mdialog, "", message_loading);
                // Login action
                mService = ApiUtils.getSOService();
                final String username = txt_user.getText().toString();
                final String password = txt_pass.getText().toString();
                mService.getLoginInfo(username, password).enqueue(new Callback<LoginInfo>() {
                    @Override
                    public void onResponse(Call<LoginInfo> call, Response<LoginInfo> response) {
                        if (response.isSuccessful() && response.body().getStatus() == 1) {
                            handleLoginAction(response.body().getRole(), username, password, cb_remember.isChecked());
                        } else {
                            new CustomToast().Show_Toast(LoginActivity.this, getResources().getString(R.string.error_login));
                        }
                        Common.FinishProgressDialog(mdialog);
                    }

                    @Override
                    public void onFailure(Call<LoginInfo> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                        Common.FinishProgressDialog(mdialog);
                    }
                });
            }
        });
    }

    // Function handle login action
    private void handleLoginAction(Role role, String user, String pass, boolean isRemember) {
        info.setStaffInfo(role);

        if (share.isExist(SharedPrefUtils.USERNAME_KEY))
            share.removeValue(SharedPrefUtils.USERNAME_KEY);
        if (share.isExist(SharedPrefUtils.PASSWORD_KEY))
            share.removeValue(SharedPrefUtils.PASSWORD_KEY);
        if (isRemember) {
            share.setValue(SharedPrefUtils.USERNAME_KEY, user);
            share.setValue(SharedPrefUtils.PASSWORD_KEY, pass);
        }

        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.finish();
        startActivity(i);
    }
}
