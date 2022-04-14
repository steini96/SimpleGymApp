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
import androidx.navigation.fragment.NavHostFragment;

import com.example.simplegymapp.Entities.Exercise;
import com.example.simplegymapp.Entities.Workout;
import com.example.simplegymapp.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    // Array of strings...
    ListView simpleList;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    List<Exercise> list=new ArrayList<Exercise>();

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
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        String difficulty = "hard";
        String workoutType = getArguments().getString("workoutType");

        System.out.println(workoutType);

        simpleList = (ListView)getView().findViewById(R.id.simpleListView);

        /*
        Workout work1 = new Workout();
        Exercise ex1 = new Exercise(value, 400, " m á 14min", work1);
        Exercise ex2 = new Exercise("Hlaupa", 5, " km á 14min", work1);
        Exercise ex3 = new Exercise("Armbeygjur", 4, "20 stykki á 14min", work1);
        Exercise ex4 = new Exercise("Hnébeygjur", 4, "20 stykki  á 14min", work1);
        */


        Exercise e1 = new Exercise("Push ups", "5 times");
        Exercise e2 = new Exercise("Push ups", "10 times");
        Exercise e3 = new Exercise("Push ups", "20 times");

        Exercise e4 = new Exercise("Jog", "1 km");
        Exercise e5 = new Exercise("Jog", "5 km");
        Exercise e6 = new Exercise("Jog", "10 km");

        Exercise e7 = new Exercise("Stretches", "15 minutes");

        Exercise e8 = new Exercise("Swim", "500 m");
        Exercise e9 = new Exercise("Swim", "1 km");
        Exercise e10 = new Exercise("Swim", "5 km");

        Exercise e11 = new Exercise("Benchpress", "3x3");
        Exercise e12 = new Exercise("Benchpress", "4*4");
        Exercise e13 = new Exercise("Benchpress", "5*5");

        Exercise e14 = new Exercise("Squat", "3x3");
        Exercise e15 = new Exercise("Squat", "4*4");
        Exercise e16 = new Exercise("Squat", "5*5");


        if(difficulty == "easy"){
            if(workoutType == "swim"){
                list.add(e1); list.add(e8); list.add(e7);
            }else if(workoutType == "run"){
                list.add(e1); list.add(e4); list.add(e7);
            }else if(workoutType == "lift"){
                list.add(e1); list.add(e11); list.add(e14); list.add(e7);
            }
        }else if(difficulty == "medium"){
            if(workoutType == "swim"){
                list.add(e2); list.add(e9); list.add(e7);
            }else if(workoutType == "run"){
                list.add(e2); list.add(e5); list.add(e7);
            }else if(workoutType == "lift"){
                list.add(e2); list.add(e12); list.add(e15); list.add(e7);
            }
        }else if(difficulty == "hard"){
            if(workoutType == "swim"){
                list.add(e3); list.add(e10); list.add(e7);
            }else if(workoutType == "run"){
                list.add(e3); list.add(e6); list.add(e7);
            }else if(workoutType == "lift"){
                list.add(e3); list.add(e13); list.add(e16); list.add(e7);
            }
        }

        Object[] exArray = list.toArray();

        ArrayAdapter<Exercise> arrayAdapter = new ArrayAdapter<Exercise>(getActivity(), android.R.layout.simple_list_item_1, list);

            // new ArrayAdapter<String>(this, R.layout.activity_main, R.id.textView, android.R.layout.simple_list_item_1);

        simpleList.setAdapter(arrayAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}