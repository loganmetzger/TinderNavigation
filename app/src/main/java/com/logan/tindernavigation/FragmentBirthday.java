package com.logan.tindernavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class FragmentBirthday extends Fragment {
    EditText etBirthday;
    Button next;

    public FragmentBirthday() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_birthday, container, false);

        etBirthday = view.findViewById(R.id.edittext_birthday);
        next = view.findViewById(R.id.button_continue);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        next.setOnClickListener(v -> {
            Bundle fragmentGenderArgs = new FragmentGenderArgs.Builder().setEmail(requireArguments().get("email").toString())
                    .setName(requireArguments().get("name").toString())
                    .setBirthday(etBirthday.getText().toString()).build().toBundle();
            NavHostFragment.findNavController(this).navigate(R.id.destination_gender_fragment, fragmentGenderArgs);
        });
    }
}
