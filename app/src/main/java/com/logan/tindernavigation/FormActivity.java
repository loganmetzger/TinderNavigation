package com.logan.tindernavigation;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.logan.tindernavigation.databinding.FormActivityBinding;

public class FormActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);

        Navigation.findNavController(this, R.id.form_nav_host_fragment)
                .setGraph(R.navigation.form_nav_graph);
    }
}