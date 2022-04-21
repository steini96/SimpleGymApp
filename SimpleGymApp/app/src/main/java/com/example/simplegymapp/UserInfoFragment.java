package com.example.simplegymapp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

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
import com.example.simplegymapp.databinding.UserinfoBinding;

import java.util.ArrayList;
import java.util.List;



public class UserInfoFragment  extends Fragment {
    private String email, password, workoutFreq = "0";
    private Difficulty workoutDiff;
    private SharedPreferences sh;


    private UserinfoBinding binding;


    // Array of strings...
    ListView simpleList;
    List<UserFitnessInfo> list=new ArrayList<UserFitnessInfo>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        this.sh = this.getActivity().getSharedPreferences("MySharedPref",0);

        binding = UserinfoBinding.inflate(inflater, container, false);

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




        binding.button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                RadioGroup radioGroup = (RadioGroup) getView().findViewById(R.id.radioGroup);
                        switch (radioGroup.getCheckedRadioButtonId()) {
                            case R.id.radioButton6:
                                workoutDiff = Difficulty.EASY;
                                break;
                            case R.id.radioButton7:
                                workoutDiff = Difficulty.MEDIUM;
                                break;
                            case R.id.radioButton8:
                                workoutDiff = Difficulty.HARD;
                                break;
                        }
                EditText editEmail = (EditText) getView().findViewById(R.id.editTextTextEmailAddress2);
                email = editEmail.getText().toString();
                EditText editPassword = (EditText) getView().findViewById(R.id.editTextTextPassword2);
                password = editPassword.getText().toString();
                EditText editWorkoutFreq = (EditText) getView().findViewById(R.id.editTextNumber);
                workoutFreq = editWorkoutFreq.getText().toString();
                Log.d("email", email);
                Log.d("password", password);
                Log.d("workoutFreq", workoutFreq);
                Log.d("workoutDiff",  "" + workoutDiff);

                if(workoutDiff == null) workoutDiff =  workoutDiff.valueOf(sh.getString("difficulty", ""));
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("difficulty","" + workoutDiff);
                editor.commit();
                Log.d("diff", sh.getString("difficulty", ""));

                if(workoutFreq.length() <1){
                    workoutFreq = "0";
                }
                simpleList = (ListView)getView().findViewById(R.id.simpleListView);
                UserFitnessInfo userFitnessInfo1 = new UserFitnessInfo(Integer.parseInt(workoutFreq), WorkoutType.RUNNING,workoutDiff.valueOf(sh.getString("difficulty", "")));
                list.add(userFitnessInfo1);
                Object[] exArray = list.toArray();

                ArrayAdapter<UserFitnessInfo> arrayAdapter = new ArrayAdapter<UserFitnessInfo>(getActivity(), android.R.layout.simple_list_item_1, list);

                // new ArrayAdapter<String>(this, R.layout.activity_main, R.id.textView, android.R.layout.simple_list_item_1);

                simpleList.setAdapter(arrayAdapter);


            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
