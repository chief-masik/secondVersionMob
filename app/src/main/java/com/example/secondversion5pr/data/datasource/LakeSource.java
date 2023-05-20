package com.example.secondversion5pr.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.secondversion5pr.R;
import com.example.secondversion5pr.data.model.Lake;

import java.util.ArrayList;
import java.util.List;

public class LakeSource {
    public static LiveData<List<Lake>> getLakes() {
        MutableLiveData<List<Lake>> list = new MutableLiveData<>();
        List<Lake> arrayList = new ArrayList<>();

        for(int i = 0; i < 67; i++) {
            arrayList.add(new Lake(R.drawable.lake_bobrovoe,"Озеро Бобровое"));
            arrayList.add(new Lake(R.drawable.lake_parshino,"Озеро Паршино"));
            arrayList.add(new Lake(R.drawable.lake_peschanoe,"Озеро Песчаное"));
        }
        list.setValue(arrayList);

        return list;
    }
}
