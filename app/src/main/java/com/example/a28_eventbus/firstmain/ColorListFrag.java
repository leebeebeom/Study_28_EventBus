package com.example.a28_eventbus.firstmain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.List;

public class ColorListFrag extends ListFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> colorList = Arrays.asList("Red", "Green", "Blue");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        String color = (String) l.getAdapter().getItem(position);
        Log.d("로그", "onListItemClick: "+color);
        EventBus.getDefault().post(color);

    }
}
