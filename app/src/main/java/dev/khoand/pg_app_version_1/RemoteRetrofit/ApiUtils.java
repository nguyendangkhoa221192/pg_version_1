package dev.khoand.pg_app_version_1.RemoteRetrofit;

/**
 * Created by khoam on 2/26/2018.
 */

public class ApiUtils {
    public static SOService getSOService() {
        return RetrofitClient.getClient().create(SOService.class);
    }
}
