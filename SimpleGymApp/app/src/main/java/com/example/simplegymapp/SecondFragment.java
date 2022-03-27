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

        simpleList = (ListView)getView().findViewById(R.id.simpleListView);

        Workout work1 = new Workout();
        Exercise ex1 = new Exercise("Synda", 400, " m á 14min", work1);
        Exercise ex2 = new Exercise("Hlaupa", 5, " km á 14min", work1);
        Exercise ex3 = new Exercise("Armbeygjur", 4, "20 stykki á 14min", work1);
        Exercise ex4 = new Exercise("Hnébeygjur", 4, "20 stykki  á 14min", work1);

        list.add(ex1);
        list.add(ex2);
        list.add(ex3);
        list.add(ex4);
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