package dev.khoand.pg_app_version_1.Global;

import android.app.Application;

import dev.khoand.pg_app_version_1.ItemData.Role;

/**
 * Created by khoam on 2/26/2018.
 */

public class GlobalInfo extends Application{

    private Role staffInfo;

    public Role getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(Role staffInfo) {
        this.staffInfo = staffInfo;
    }
}
