package com.example.simplegymapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.simplegymapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Svona nær maður í difficulty
        SharedPreferences sh = this.getActivity().getSharedPreferences("MySharedPref",0);
        String difficulty = sh.getString("difficulty", "");

        // Svona setur maður nýtt difficulty
        SharedPreferences.Editor editor = sh.edit();
        editor.putString("difficulty", "hard");
        editor.commit();

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment ();
                Bundle args = new Bundle();
                args.putString("workoutType", "swim");
                secondFragment.setArguments(args);

                //Inflate the fragment
                int id = FirstFragment.this.getId();
                FragmentTransaction trans = getParentFragmentManager().beginTransaction();
                trans.replace(id, secondFragment).commit();

            }
        });

        binding.buttonFirstRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment ();
                Bundle args = new Bundle();
                args.putString("workoutType", "run");
                secondFragment.setArguments(args);

                //Inflate the fragment
                int id = FirstFragment.this.getId();
                FragmentTransaction trans = getParentFragmentManager().beginTransaction();
                trans.replace(id, secondFragment).commit();

            }
        });

        binding.buttonFirstLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment ();
                Bundle args = new Bundle();
                args.putString("workoutType", "lift");
                secondFragment.setArguments(args);

                //Inflate the fragment
                int id = FirstFragment.this.getId();
                FragmentTransaction trans = getParentFragmentManager().beginTransaction();
                trans.replace(id, secondFragment).commit();

            }
        });

        binding.buttonUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoFragment userInfoFragment = new UserInfoFragment ();
                Bundle args = new Bundle();
                args.putString("key", "value");
                userInfoFragment.setArguments(args);

                //Inflate the fragment
                int id = FirstFragment.this.getId();
                FragmentTransaction trans = getParentFragmentManager().beginTransaction();
                trans.replace(id, userInfoFragment).commit();
//
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.first_fragment_to_userInfo_fragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}