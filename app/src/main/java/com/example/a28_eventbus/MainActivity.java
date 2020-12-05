package com.example.a28_eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_next).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity2.class));
        });
        //이벤트 버스의 장점.
        //인터페이스 안만들어도 됨ㅋ
    }
}