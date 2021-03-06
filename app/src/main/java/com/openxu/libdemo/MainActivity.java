package com.openxu.libdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.openxu.libdemo.evenbus.EventBusActivity1;
import com.openxu.libdemo.evenbus.MessageEvent;
import com.openxu.oxlib.base.BaseActivity;
import com.openxu.oxlib.utils.LogUtil;
import com.openxu.oxlib.utils.ToastAlone;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btn_eventbus)
    Button btn_eventbus;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        //lambda表达式
        btn_eventbus.setOnClickListener(v->{
            startActivity(new Intent(this, EventBusActivity1.class));
        });
    }

    @Override
    protected void initData() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        LogUtil.e(this, "收到事件通知了");
        LogUtil.i(this, event.toString());
        ToastAlone.show(event.toString());
    }


}
