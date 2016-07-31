package com.jikexueyuan.lockscreen;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by zhangqiang on 16/7/30.
 */
public class MainAcitivity extends Activity {

    private DevicePolicyManager devicePolicyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //start service
        Intent i=new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        i.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,new ComponentName(this,DeviceManager.class));
        startActivity(i);
        devicePolicyManager= (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        //lock screen
        devicePolicyManager.lockNow();
        //finish the activity
        this.finish();
    }
}
