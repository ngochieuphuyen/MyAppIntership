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

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class FragmentDay extends Fragment{
    Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_day, container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_day);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        List<MyEvent> data = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            data.add(new MyEvent(i,new MyDate(1,String.valueOf(i),"Sun",1,2017),"hoc "+i,"7:00 AM","8:30 AM"));
        }

        AdapterFragmentDay adapter = new AdapterFragmentDay(context,data);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
