package com.logan.tindernavigation;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;


public class FragmentName extends Fragment {
    private MainViewModel mMainViewModel;
    private EditText etName;
    private Button next;

    public FragmentName() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        View view = inflater.inflate(R.layout.fragment_name, container, false);

        etName = view.findViewById(R.id.edittext_name);
        next = view.findViewById(R.id.button_continue);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mMainViewModel.setName(etName.getText().toString());
            }
        });

        next.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.destination_birthday_fragment);
        });
    }
}
