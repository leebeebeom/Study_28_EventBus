package com.example.a28_eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        HeadlineFrag headlineFrag = new HeadlineFrag();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_fraem, headlineFrag)
                .commit();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setArticle(Integer position){
        Log.d("로그", "setArticle: 호출됨");
        Bundle arg = new Bundle();
        arg.putInt("position", position);
        ArticleFrag articleFrag = new ArticleFrag();
        articleFrag.setArguments(arg);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fraem, articleFrag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}