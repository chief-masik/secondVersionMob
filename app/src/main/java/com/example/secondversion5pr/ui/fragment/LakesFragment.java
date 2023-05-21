package com.example.secondversion5pr.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondversion5pr.R;
import com.example.secondversion5pr.data.model.Lake;
import com.example.secondversion5pr.ui.adapter.LakeAdapter;
import com.example.secondversion5pr.ui.viewmodel.LakeViewModel;

public class LakesFragment extends Fragment {
    private static final String TAG = "LakesFr";
    private RecyclerView recyclerView;
    private LakeAdapter lakeAdapter;
    private LakeViewModel lakeViewModel;
    private String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lakeViewModel = new ViewModelProvider(this).get(LakeViewModel.class);
        name = getArguments().getString("name");
        Log.d(TAG,"onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_lakes,container,false);
        recyclerView = (RecyclerView) view1.findViewById(R.id.LakesRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        lakeAdapter = new LakeAdapter(getContext(), new LakeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Lake lake, int position, View view) {
                Bundle bundle = new Bundle();
                bundle.putString("item", lake.getNameItem());
                bundle.putString("name", name);

                Navigation.findNavController(view).navigate(R.id.action_lakesFragment_to_bookingFragment, bundle);
                Log.i("ListView", "element number " + position +" click");
            }
        });
        recyclerView.setAdapter(lakeAdapter);

        Toast.makeText(getContext(), "Эксклюзивный список для " + name, Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onCreateView");
        return view1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        //  Подписка на изменения данных в списке
        lakeViewModel.lakes.observe(getViewLifecycleOwner(), lakeAdapter::updateLakes);
        Log.d(TAG,"onViewCreated");
    }

}