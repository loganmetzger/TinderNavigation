package com.logan.tindernavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class FragmentGender extends Fragment {
    private Button btnMale;
    private Button btnFemale;
    private Button next;

    public FragmentGender() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_gender, container, false);

        btnFemale = view.findViewById(R.id.button_woman);
        btnMale = view.findViewById(R.id.button_man);
        next = view.findViewById(R.id.button_continue);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        next.setOnClickListener(v -> {
            Bundle fragmentSchoolArgs = new FragmentSchoolArgs.Builder().setEmail(requireArguments().get("email").toString())
                    .setName(requireArguments().get("name").toString())
                    .setBirthday(requireArguments().get("birthday").toString())
                    .setGender(btnMale.getText().toString()).build().toBundle();
            NavHostFragment.findNavController(this).navigate(R.id.destination_gender_fragment, fragmentSchoolArgs);
        });
    }
}
