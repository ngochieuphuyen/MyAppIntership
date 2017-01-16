package com.example.ngochieu.myappinternship.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngochieu.myappinternship.Adapter.AdapterFragmentWeek;
import com.example.ngochieu.myappinternship.Database.MyDateDAO;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgocHieu on 1/14/2017.
 */

public class FragmentWeek extends Fragment {
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_week, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_week);
        recyclerView.setLayoutManager( new LinearLayoutManager(context));
        List<MyDate> data = new ArrayList<>();
        MyDateDAO myDateDAO = new MyDateDAO(context);
        for (int i = 8; i < 15; i++) {
            int id_date =myDateDAO.getIdDate(i,1,2017);
            data.add(myDateDAO.getMyDate(id_date));
        }
        AdapterFragmentWeek adapter = new AdapterFragmentWeek(context,data);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
