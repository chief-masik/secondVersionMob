package com.example.secondversion5pr.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.secondversion5pr.R;

public class AddRiverFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_river, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextName = view.findViewById(R.id.editTextAddRiver);
        Button buttonUpload = view.findViewById(R.id.buttomAddRiver);
        buttonUpload.setOnClickListener(v -> {
            String riverName = editTextName.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(riverName) ) {
                editTextName.setError(null);
                bundle.putString("NAME_RESULT_OK",riverName);
                bundle.putInt("IMG_RESULT_OK", R.drawable.river_tyra);
                Navigation.findNavController(view).navigate(R.id.action_addRiverFragment_to_riversFragment, bundle);
            }
            else
                editTextName.setError("Пустая строка!");
        });
    }
}