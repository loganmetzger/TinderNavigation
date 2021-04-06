package com.logan.tindernavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentProfile extends Fragment {
    MainViewModel mainViewModel;

    private TextView name;
    private TextView birthday;
    private TextView school;
    private TextView gender;

    public FragmentProfile() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.tv_name);
        birthday = view.findViewById(R.id.tv_birthday);
        school = view.findViewById(R.id.tv_school);

        name.setText(mainViewModel.getName());
        birthday.setText(mainViewModel.getBirthday());
        school.setText(mainViewModel.getSchool());
    }
}
