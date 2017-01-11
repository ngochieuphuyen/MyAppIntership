package com.example.ngochieu.myappinternship.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngochieu.myappinternship.Adapter.AdapterCalenderView;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class FragmentCalenderView extends Fragment {
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calender_view, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.list_calender_view);
        List<MyDate> dataCal = new ArrayList<>();
        for (int i = 0; i <31 ; i++) {
            dataCal.add(new MyDate(i,i,i));
        }

        rv.setLayoutManager(new GridLayoutManager(context,7));
//
        AdapterCalenderView adapterCalenderMonth = new AdapterCalenderView(context,dataCal);
        rv.setAdapter(adapterCalenderMonth);


        return view;
    }
}
