package com.example.simplegymapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.simplegymapp.Entities.Difficulty;
import com.example.simplegymapp.Entities.Exercise;
import com.example.simplegymapp.Entities.User;
import com.example.simplegymapp.Entities.UserFitnessInfo;
import com.example.simplegymapp.Entities.Workout;
import com.example.simplegymapp.Entities.WorkoutType;
import com.example.simplegymapp.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;



public class UserInfoFragment  extends Fragment {

    private FragmentSecondBinding binding;

    // Array of strings...
    ListView simpleList;
    List<UserFitnessInfo> list=new ArrayList<UserFitnessInfo>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        super.onCreate(savedInstanceState);



        binding = FragmentSecondBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(UserInfoFragment.this)
//                        .navigate(R.id.userInfo_to_first_fragment);
                FirstFragment firstFragment = new FirstFragment ();
                Bundle args = new Bundle();
                args.putString("key", "value");
                firstFragment.setArguments(args);

                //Inflate the fragment
                int id = UserInfoFragment.this.getId();
                FragmentTransaction trans = getParentFragmentManager().beginTransaction();
                trans.replace(id, firstFragment).commit();
            }
        });

        simpleList = (ListView)getView().findViewById(R.id.simpleListView);

        UserFitnessInfo userFitnessInfo1 = new UserFitnessInfo(2, WorkoutType.RUNNING, Difficulty.EASY);

        list.add(userFitnessInfo1);
        Object[] exArray = list.toArray();

        ArrayAdapter<UserFitnessInfo> arrayAdapter = new ArrayAdapter<UserFitnessInfo>(getActivity(), android.R.layout.simple_list_item_1, list);

        // new ArrayAdapter<String>(this, R.layout.activity_main, R.id.textView, android.R.layout.simple_list_item_1);

        simpleList.setAdapter(arrayAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
