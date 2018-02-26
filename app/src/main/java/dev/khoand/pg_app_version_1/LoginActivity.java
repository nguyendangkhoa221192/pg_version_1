package dev.khoand.pg_app_version_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import dev.khoand.pg_app_version_1.Global.GlobalInfo;
import dev.khoand.pg_app_version_1.ItemData.LoginInfo;
import dev.khoand.pg_app_version_1.ItemData.Role;
import dev.khoand.pg_app_version_1.RemoteRetrofit.ApiUtils;
import dev.khoand.pg_app_version_1.RemoteRetrofit.SOService;
import dev.khoand.pg_app_version_1.Utils.CustomToast;
import dev.khoand.pg_app_version_1.Utils.SharedPrefUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    private SOService mService;

    private GlobalInfo globalInfo;
    private SharedPrefUtils share;
    private TextView txt_user;
    private TextView txt_pass;
    private CheckBox cb_remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        // View
        btnLogin = findViewById(R.id.loginBtn);
        txt_user = findViewById(R.id.login_userid);
        txt_pass = findViewById(R.id.login_password);
        cb_remember = findViewById(R.id.login_remember);

        // Global Info
        share = new SharedPrefUtils(this);
        globalInfo = (GlobalInfo) getApplicationContext();

        // Load info login
        if (share.isExist(SharedPrefUtils.USERNAME_KEY))
            txt_user.setText(share.getStringValue(SharedPrefUtils.USERNAME_KEY));
        if (share.isExist(SharedPrefUtils.PASSWORD_KEY))
            txt_pass.setText(share.getStringValue(SharedPrefUtils.PASSWORD_KEY));

        //
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //
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
                    }

                    @Override
                    public void onFailure(Call<LoginInfo> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });
            }
        });
    }

    private void handleLoginAction(Role role, String user, String pass, boolean isRemember) {
        globalInfo.setStaffInfo(role);

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
