package com.example.app;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.zzy.learn.aspectj.annotation.DebugTrace;
import com.zzy.learn.aspectj.annotation.Permission;
import com.zzy.learn.aspectj.util.MPermissionUtil;

/**
 * Package: com.example.app
 * Class: LoginActivity
 * Description: 登录界面
 * Author: zhaoyangzhou
 * Email: zhaoyangzhou@126.com
 * Created on: 2017/12/8 8:54
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button mAccountSignInButton = (Button) findViewById(R.id.account_sign_in_button);
        mAccountSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toNextView();
            }
        });
    }

    @Permission({Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    @DebugTrace
    public void toNextView() {
        Toast.makeText(this, "申请权限 用户已授权", Toast.LENGTH_SHORT).show();
    }

    /**
     * Method: onRequestPermissionsResult
     * Description: 授权结果回调方法
     * @param requestCode 请求参数
     * @param permissions 权限列表
     * @param grantResults 授权结果
     * @return  void
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MPermissionUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

