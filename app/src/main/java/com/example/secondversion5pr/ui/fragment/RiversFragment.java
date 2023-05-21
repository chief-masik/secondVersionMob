package com.example.secondversion5pr.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondversion5pr.R;
import com.example.secondversion5pr.data.model.River;
import com.example.secondversion5pr.ui.adapter.RiverAdapter;
import com.example.secondversion5pr.ui.viewmodel.RiverViewModel;

public class RiversFragment extends Fragment {
    private static final String TAG = "RiversFr";
    private RecyclerView recyclerView;
    private RiverAdapter riverAdapter;
    private RiverViewModel riverViewModel;
    private String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        riverViewModel = new ViewModelProvider(this).get(RiverViewModel.class);
        name = getArguments().getString("name");
        Log.d(TAG,"onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_rivers,container,false);
        recyclerView = (RecyclerView) view1.findViewById(R.id.RecyclerView);

        // Добавление нового элемента
        Bundle args = getArguments();
        if (args != null && args.containsKey("IMG_RESULT_OK") && args.containsKey("NAME_RESULT_OK")) {
            River river = new River(args.getInt("IMG_RESULT_OK"), args.getString("NAME_RESULT_OK"));
            riverViewModel.insert(river);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        riverAdapter = new RiverAdapter(getContext(), new RiverAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(River river, int position, View view) {
                Bundle bundle = new Bundle();
                bundle.putString("item", river.getNameItem());
                bundle.putString("name", name);

                Navigation.findNavController(view).navigate(R.id.action_riversFragment_to_bookingFragment, bundle);
                Log.i("ListView", "element number " + position +" click");
            }
        });
        recyclerView.setAdapter(riverAdapter);

        Button buttonToAddRiver = view1.findViewById(R.id.buttonToAddRiver);
        buttonToAddRiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_riversFragment_to_addRiverFragment);
            }
        });

        Toast.makeText(getContext(), "Эксклюзивный список для " + name, Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onCreateView");
        return view1;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        //  Подписка на изменения данных в списке
        riverViewModel.rivers.observe(getViewLifecycleOwner(), riverAdapter::updateRivers);
        Log.d(TAG,"onViewCreated");
    }

}