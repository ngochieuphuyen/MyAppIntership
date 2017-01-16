package com.example.ngochieu.myappinternship.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngochieu.myappinternship.Activity.DetailEventActivity;
import com.example.ngochieu.myappinternship.Adapter.AdapterEventList;
import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyEvent;

import java.util.List;

/**
 * Created by NgocHieu on 1/17/2017.
 */

public class FragmentSearchData extends Fragment {
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_search_data, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listSearch);
        Bundle bundle = getArguments();
        String dataSearch = bundle.getString("datasearch");

        MyEventDAO myEventDAO = new MyEventDAO(context);
        List<MyEvent> eventList = myEventDAO.getAllDateSearch(dataSearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        AdapterEventList adapterEventList = new AdapterEventList(context, eventList);
        recyclerView.setAdapter(adapterEventList);

        adapterEventList.setMyEventOnClickListener(new AdapterEventList.MyEventOnClickListener() {
            @Override
            public void myOnClick(final MyEvent myEvent) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(myEvent.getNameEvent());
                builder.setMessage(myEvent.getStartTime()+ " - "+ myEvent.getEndTime());
                builder.setPositiveButton("Detail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, DetailEventActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("myevent", myEvent);
                        bundle.putParcelable("endDate",myEvent.getEndDate());
                        bundle.putParcelable("startDate",myEvent.getStartDate());
                        intent.putExtra("bundle",bundle);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
            }
        });

        return view;
    }
}
