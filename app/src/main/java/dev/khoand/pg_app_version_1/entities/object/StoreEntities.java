package dev.khoand.pg_app_version_1.entities.object;

/**
 * Created by khoam on 2/28/2018.
 */

public class StoreEntities {

    private String mien_code;
    private String vung_code;
    private String shop_code;
    private String shop_name;
    private String team_code;
    private String team_name;
    private long user_id;
    private String na_code;
    private String na_name;
    private String channel_code;
    private String parent_channel_code;
    private long id_store;
    private String store_code;
    private String store_name;
    private String address;
    private String phone;
    private String title;
    private String description;
    private long userid;
    private String created_begin;
    private String created_end;
    private long store_id;
    private long customer_id;
    private double lat;
    private double lng;
    private String checkin;
    private String checkout;
    private String ca_title;

    public String getCa_title() {
        return ca_title;
    }

    public void setCa_title(String ca_title) {
        this.ca_title = ca_title;
    }

    public String getMien_code() {
        return mien_code;
    }

    public void setMien_code(String mien_code) {
        this.mien_code = mien_code;
    }

    public String getVung_code() {
        return vung_code;
    }

    public void setVung_code(String vung_code) {
        this.vung_code = vung_code;
    }

    public String getShop_code() {
        return shop_code;
    }

    public void setShop_code(String shop_code) {
        this.shop_code = shop_code;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getTeam_code() {
        return team_code;
    }

    public void setTeam_code(String team_code) {
        this.team_code = team_code;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getNa_code() {
        return na_code;
    }

    public void setNa_code(String na_code) {
        this.na_code = na_code;
    }

    public String getNa_name() {
        return na_name;
    }

    public void setNa_name(String na_name) {
        this.na_name = na_name;
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code;
    }

    public String getParent_channel_code() {
        return parent_channel_code;
    }

    public void setParent_channel_code(String parent_channel_code) {
        this.parent_channel_code = parent_channel_code;
    }

    public long getId_store() {
        return id_store;
    }

    public void setId_store(long id_store) {
        this.id_store = id_store;
    }

    public String getStore_code() {
        return store_code;
    }

    public void setStore_code(String store_code) {
        this.store_code = store_code;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getCreated_begin() {
        return created_begin;
    }

    public void setCreated_begin(String created_begin) {
        this.created_begin = created_begin;
    }

    public String getCreated_end() {
        return created_end;
    }

    public void setCreated_end(String created_end) {
        this.created_end = created_end;
    }

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCa() {
        String ca = getCa_title();
        return ca.split(":")[0];
    }

}
