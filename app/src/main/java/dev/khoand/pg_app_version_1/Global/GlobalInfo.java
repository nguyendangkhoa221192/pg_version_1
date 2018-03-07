package dev.khoand.pg_app_version_1.Global;

import android.app.Application;
import android.location.Location;

import dev.khoand.pg_app_version_1.ItemData.Role;
import dev.khoand.pg_app_version_1.entities.object.StoreEntities;

/**
 * Created by khoam on 2/26/2018.
 */

public class GlobalInfo extends Application{

    private Role staffInfo;
    private Location currentBestLocation;
    private StoreEntities curStore;

    public Role getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(Role staffInfo) {
        this.staffInfo = staffInfo;
    }

    public Location getCurrentBestLocation() {
        return currentBestLocation;
    }

    public void setCurrentBestLocation(Location currentBestLocation) {
        this.currentBestLocation = currentBestLocation;
    }

    public StoreEntities getCurStore() {
        return curStore;
    }

    public void setCurStore(StoreEntities curStore) {
        this.curStore = curStore;
    }
}
