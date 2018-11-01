package com.project.tank.outmove.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.project.tank.outmove.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @description: activity for login
 * @auther linweijie 
 * @time 2018/10/31 19:20
 */

public class LoginActivity extends BaseActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.btn_login)
    AppCompatButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        init();
    }

    private void init(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, LaunchActivity.class);
                startActivity(intent);
            }
        });
    }

}
