package dev.khoand.pg_app_version_1.ItemData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by khoam on 2/26/2018.
 */

public class Role {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
    @SerializedName("password_hash")
    @Expose
    private String passwordHash;
    @SerializedName("password_reset_token")
    @Expose
    private Object passwordResetToken;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_online")
    @Expose
    private Integer isOnline;
    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("listshop")
    @Expose
    private Object listshop;
    @SerializedName("listarea")
    @Expose
    private Object listarea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Object getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(Object passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Object getListshop() {
        return listshop;
    }

    public void setListshop(Object listshop) {
        this.listshop = listshop;
    }

    public Object getListarea() {
        return listarea;
    }

    public void setListarea(Object listarea) {
        this.listarea = listarea;
    }
}
