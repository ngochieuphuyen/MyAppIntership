package com.example.ngochieu.myappinternship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgocHieu on 1/7/2017.
 */

public class FragmentMonth extends Fragment {
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_month,container,false);

        List<MyDate> data = new ArrayList<>();
        for (int i = 0; i <31 ; i++) {
            data.add(new MyDate(i,i,i,i,i,String.valueOf(i)));
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_month);
        recyclerView.setLayoutManager(new GridLayoutManager(context,7));

        AdapterCalenderMonth adapterCalenderMonth = new AdapterCalenderMonth(context,data);
        recyclerView.setAdapter(adapterCalenderMonth);


        return view;
    }
}
