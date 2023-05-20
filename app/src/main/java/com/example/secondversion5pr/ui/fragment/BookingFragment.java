package com.example.secondversion5pr.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.secondversion5pr.R;

public class BookingFragment extends Fragment {
    static final private String TAG = "SecondFr";
    private String name;
    private String password;
    private String item;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        password = getArguments().getString("password");
        item = getArguments().getString("item");
        Log.d(TAG,"BookingFragment onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_booking,container,false);

        Button buttonRiver = (Button) view1.findViewById(R.id.buttonRiver);
        Button buttonLake = (Button) view1.findViewById(R.id.buttonLake);

        buttonRiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                Navigation.findNavController(view).navigate(R.id.action_bookingFragment_to_riversFragment, bundle);
            }
        });
        buttonLake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                Navigation.findNavController(view).navigate(R.id.action_bookingFragment_to_lakesFragment, bundle);
            }
        });

        if(item != null) {
            TextView nameText = (TextView) view1.findViewById(R.id.textViewContent);
            nameText.setText(item);
        }
        if (name != null)
            Toast.makeText(getContext(),"Привет, " + name + "!", Toast.LENGTH_SHORT).show();
        return view1;
    }
}