package com.esprit.recapapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {
    private Button callButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.frag_two, container, false);
        callButton = rootView.findViewById(R.id.buttonCamera);
        callButton.setOnClickListener(l -> callNumber());
        return rootView;
    }

    private void callNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
}
