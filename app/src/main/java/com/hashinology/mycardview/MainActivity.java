package com.hashinology.mycardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hashinology.mycardview.adapter.AnimalAdapter;
import com.hashinology.mycardview.models.Animal;
import com.hashinology.mycardview.ui.MyInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyInterface {
    ArrayList<Animal> animalList;
    RecyclerView recyclerView;
    AnimalAdapter animalAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.idRecylerview);
        animalList = new ArrayList<>();

        animalList.add(0, new Animal("Cat", "White"));
        animalList.add(1, new Animal("Dog", "Blue"));
        animalList.add(2, new Animal("Duck", "Black"));
        animalList.add(3, new Animal("Cat", "White"));
        animalList.add(4, new Animal("Dog", "Blue"));
        animalList.add(5, new Animal("Duck", "Black"));
        animalList.add(5, new Animal("Cat", "White"));
        animalList.add(6, new Animal("Dog", "Blue"));
        animalList.add(7, new Animal("Duck", "Black"));
        animalList.add(8, new Animal("Cat", "White"));
        animalList.add(9, new Animal("Dog", "Blue"));
        animalList.add(10, new Animal("Duck", "Black"));

        animalAdapter = new AnimalAdapter(animalList, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(animalAdapter);
        animalAdapter.getInterface(this);
    }

    @Override
    public void myInterfaceClick(View view, int position) {
        Toast.makeText(this, "Current Position Clicked on: " +position, Toast.LENGTH_SHORT).show();
    }
}