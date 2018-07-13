package com.itsjustfaiq.crudroid.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsjustfaiq.crudroid.Model.Item;
import com.itsjustfaiq.crudroid.R;

import java.util.ArrayList;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    ArrayList<Item> itemArrayList;
    Context context;

    public TodoListAdapter(ArrayList<Item> itemArrayList, Context context){
        this.itemArrayList = itemArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new TodoViewHolder(view);
    };

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder todoViewHolder, int i) {
        Item item = itemArrayList.get(i);
        todoViewHolder.textViewTodo.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTodo;
        ImageView imageViewEdit;
        ImageView imageViewDone;

        public TodoViewHolder(View itemView){
            super(itemView);

            textViewTodo = itemView.findViewById(R.id.todo_text);
            imageViewEdit = itemView.findViewById(R.id.edit_todo);
            imageViewDone = itemView.findViewById(R.id.done_todo);
        }
    }
}
