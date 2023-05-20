package com.example.secondversion5pr.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.secondversion5pr.R;
import com.example.secondversion5pr.data.model.River;

import java.util.ArrayList;
import java.util.List;

public class RiverSource {
    public static LiveData<List<River>> getRivers() {
        MutableLiveData<List<River>> list = new MutableLiveData<>();
        List<River> arrayList = new ArrayList<>();

        for(int i = 0; i < 67; i++) {
            arrayList.add(new River(R.drawable.river_ob,"Река Обь"));
            arrayList.add(new River(R.drawable.river_volga,"Река Волга"));
            arrayList.add(new River(R.drawable.river_yenisey,"Река Енисей"));
        }
        list.setValue(arrayList);

        return list;
    }
}
