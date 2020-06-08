package com.hang.search.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class BaseAdapter<F extends TypeFactory> extends RecyclerView.Adapter<AbstractViewHolder> {

    private final F adapterTypeFactory;
    private final ArrayList<Visitable> visitables;

    public BaseAdapter(F adapterTypeFactory, ArrayList<Visitable> visitables) {
        this.adapterTypeFactory = adapterTypeFactory;
        this.visitables = visitables;
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return adapterTypeFactory.createViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder holder, int position) {
        holder.bind(visitables.get(position));
    }

    @Override
    public int getItemCount() {
        return visitables.size();
    }
}
