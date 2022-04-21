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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.simplegymapp.Entities.Exercise;
import com.example.simplegymapp.Entities.Workout;
import com.example.simplegymapp.databinding.FragmentLoginBinding;
import com.example.simplegymapp.databinding.FragmentRegisterBinding;
import com.example.simplegymapp.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;


public class RegisterFragment extends Fragment {
    private String email, password;

    private FragmentRegisterBinding binding;
    private SharedPreferences sh;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        this.sh = this.getActivity().getSharedPreferences("MySharedPref",0);
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editEmail = (EditText) getView().findViewById(R.id.editTextTextEmailAddress);
                email = editEmail.getText().toString();
                EditText editPassword = (EditText) getView().findViewById(R.id.editTextTextPassword);
                password = editPassword.getText().toString();

                SharedPreferences.Editor myEdit = sh.edit();
                myEdit.putString(email, password);
                myEdit.commit();
                    NavHostFragment.findNavController(RegisterFragment.this)
                            .navigate(R.id.action_registerFragment_to_LoginFragment);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}