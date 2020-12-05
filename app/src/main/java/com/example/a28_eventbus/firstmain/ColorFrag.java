package com.example.a28_eventbus.firstmain;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a28_eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ColorFrag extends Fragment {

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_color, container, false);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setColor(String color){
        Log.d("로그", "setColor: 호출");
        TextView textView = getView().findViewById(R.id.color_frag_text);
        int colorCode = 0;
        switch (color){
            case "Red":
                colorCode = Color.RED;
                break;
            case "Green":
                colorCode = Color.GREEN;
                break;
            case "Blue":
                colorCode = Color.BLUE;
                break;
        }
        textView.setBackgroundColor(colorCode);

    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}