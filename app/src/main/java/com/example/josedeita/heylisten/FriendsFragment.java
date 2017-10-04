package com.example.josedeita.heylisten;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {
  
  
  public FriendsFragment() {
    // Required empty public constructor
  }
  
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
  
    View view = inflater.inflate(R.layout.fragment_friends, container, false);
    final String[] friendsList = {"Jose", "Kevin", "Martin", "Sargis"};
    ListView friendsListView = (ListView) view.findViewById(R.id.friendListView);
  
    ArrayAdapter<String> friendsListAdapter = new ArrayAdapter<String>(
        getActivity(),
        android.R.layout.simple_list_item_1,
        friendsList
    );
    friendsListView.setAdapter(friendsListAdapter);
    friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //This is where we will add code to give
        //each item in this list some
        //sort of functionality
        //Like displaying their phone #
        //How many times you've run into each other
        //etc
      }
    });
    
    // Inflate the layout for this fragment
    return view;
  }
  
}
