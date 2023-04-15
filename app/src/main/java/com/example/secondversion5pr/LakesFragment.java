package com.example.secondversion5pr;

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

public class LakesFragment extends Fragment {
    static final private String TAG = "ThirdFr";
    private String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        Log.d(TAG,"LakesFragment onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_lakes,container,false);

        Button button3 = (Button) view1.findViewById(R.id.buttomAdd);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText itemText = (EditText) view1.findViewById(R.id.editTextTextPersonName3);
                Bundle bundle = new Bundle();
                bundle.putString("item",itemText.getText().toString());
                bundle.putString("name", name);
                Navigation.findNavController(view).navigate(R.id.action_lakesFragment_to_bookingFragment, bundle);
            }
        });

        if (name != null)
            Toast.makeText(getContext(),"Эксклюзивный список для " + name, Toast.LENGTH_SHORT).show();
        return view1;
    }
}