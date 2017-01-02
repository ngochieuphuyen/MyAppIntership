package com.example.ngochieu.myappinternship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by NgocHieu on 1/1/2017.
 */

public class FragmentWeek extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ListWeek);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(inflater.getContext(),7);
        recyclerView.setLayoutManager(layoutManager);

        // get data
        //hardcode
        List<Week> data = new ArrayList<>();
        // set day of week

        ArrayList<String> dayOfWeek = new ArrayList<>();
        for (int i=0;i<7;i++){
            data.add(new Week("thu ","aaaaaa"));
        }
        RecycleViewWeek recycleViewWeek = new RecycleViewWeek(inflater.getContext(),data);
        recyclerView.setAdapter(recycleViewWeek);

        return view;
    }
}
