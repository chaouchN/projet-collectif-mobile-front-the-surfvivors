package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListSpotFragment extends Fragment {

    private ListView listView;
    private String spots[];
    private ArrayAdapter<String> arrayAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_spot);
        listView = listView.findViewById(R.id.list_view_id);

        spots = getResources().getStringArray(R.array.Spots);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, spots);

        listView.setAdapter(arrayAdapter);
    }

    private void setContentView(int fragmentListSpot) {
    }
}