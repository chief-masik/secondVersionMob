package com.example.secondversion5pr.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.secondversion5pr.R;

public class AuthenticationFragment extends Fragment {
    private static final String TAG = "FirstFr";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"AuthenticationFragment onCreate");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_authentication,container,false);
        Button but = (Button) view1.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText) view1.findViewById(R.id.editTextTextPersonName);
                EditText passwordText = (EditText) view1.findViewById(R.id.editTextTextPersonName2);
                Bundle bundle = new Bundle();
                bundle.putString("name", nameText.getText().toString());
                bundle.putString("pass",passwordText.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_authenticationFragment_to_bookingFragment, bundle);
            }
        });
        return view1;
    }
}