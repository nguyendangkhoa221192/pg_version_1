package dev.khoand.pg_app_version_1.ItemData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by khoam on 2/26/2018.
 */

public class LoginInfo {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("role")
    @Expose
    private Role role;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
