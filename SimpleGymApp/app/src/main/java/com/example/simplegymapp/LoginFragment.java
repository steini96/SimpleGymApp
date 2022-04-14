package com.example.simplegymapp;

import android.annotation.SuppressLint;
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
import com.example.simplegymapp.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;


public class LoginFragment extends Fragment {
    private String email, password;

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editEmail = (EditText) getView().findViewById(R.id.editTextTextEmailAddress);
                email = editEmail.getText().toString();
                EditText editPassword = (EditText) getView().findViewById(R.id.editTextTextPassword);
                password = editPassword.getText().toString();
                Log.d("login", email);
                Log.d("login", password);
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_FirstFragment);
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editEmail = (EditText) getView().findViewById(R.id.editTextTextEmailAddress);
                email = editEmail.getText().toString();
                EditText editPassword = (EditText) getView().findViewById(R.id.editTextTextPassword);
                password = editPassword.getText().toString();
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}