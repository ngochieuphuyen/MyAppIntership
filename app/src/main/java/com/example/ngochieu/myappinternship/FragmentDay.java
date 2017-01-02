package com.example.ngochieu.myappinternship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by NgocHieu on 1/1/2017.
 */

public class FragmentDay extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ListDay);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(inflater.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // get data
            //hardcode
        List<MyEvent> data = new ArrayList<>();
        for (int i=0;i<24;i++){
            data.add(new MyEvent("Work "+i,(i)+":00 - "+(i+1)+":00","address "+i));
        }
        RecycleViewDay recycleViewDay = new RecycleViewDay(inflater.getContext(),data);
        recyclerView.setAdapter(recycleViewDay);

        return view;
    }


}
