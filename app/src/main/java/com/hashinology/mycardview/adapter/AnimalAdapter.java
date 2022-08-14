package com.hashinology.mycardview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashinology.mycardview.R;
import com.hashinology.mycardview.models.Animal;
import com.hashinology.mycardview.ui.MyInterface;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViews> {
    private List<Animal> mData;
    private LayoutInflater mInflater;
    private MyInterface myInterface;

    public AnimalAdapter(List<Animal> mData, Context context) {
        this.mData = mData;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViews onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.animal_list, parent, false);
        return new MyViews(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViews holder, int position) {
        Animal animal = mData.get(position);
        holder.tvName.setText(animal.getName());
        holder.tvColour.setText(animal.getColour());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViews extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvName, tvColour;
        public MyViews(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvColour = itemView.findViewById(R.id.tvColour);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (myInterface != null){
                myInterface.myInterfaceClick(view, getAdapterPosition());
            }
        }
    }
    public void getInterface(MyInterface myInterface){
        this.myInterface = myInterface;
    }
}
