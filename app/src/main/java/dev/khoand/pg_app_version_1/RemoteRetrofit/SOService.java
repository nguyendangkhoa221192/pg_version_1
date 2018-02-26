package dev.khoand.pg_app_version_1.RemoteRetrofit;

import dev.khoand.pg_app_version_1.ItemData.LoginInfo;
import dev.khoand.pg_app_version_1.ItemData.Role;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by khoam on 2/26/2018.
 */

public interface SOService {

    @FormUrlEncoded
    @POST("index.php?r=api%2Flogin")
    Call<LoginInfo> getLoginInfo(@Field("username") String user, @Field("password") String pass);
}
