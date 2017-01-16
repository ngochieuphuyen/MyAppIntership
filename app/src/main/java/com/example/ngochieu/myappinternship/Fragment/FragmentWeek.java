package com.example.ngochieu.myappinternship.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngochieu.myappinternship.Activity.DateActivity;
import com.example.ngochieu.myappinternship.Adapter.AdapterFragmentWeek;
import com.example.ngochieu.myappinternship.Database.MyDateDAO;
import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.Support.MyEvent;
import com.example.ngochieu.myappinternship.Support.Support;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgocHieu on 1/14/2017.
 */

public class FragmentWeek extends Fragment {
    Context context;
    RecyclerView recyclerView;
    AdapterFragmentWeek adapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_week, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_week);
        recyclerView.setLayoutManager( new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<MyDate> data = Support.getListDateWeek(context);
        adapter = new AdapterFragmentWeek(context,data);
        recyclerView.setAdapter(adapter);
        adapter.setMyOnCLick(new AdapterFragmentWeek.MyOnCLick() {
            @Override
            public void onClick(MyDate myDate) {
                Intent intent = new Intent(context, DateActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("mydate", myDate);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
    }
}
