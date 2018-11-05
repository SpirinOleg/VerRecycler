package com.example.a123.verrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> persons = new ArrayList<>();
    private OnItemRecyclerClick listener;

    PersonAdapter(OnItemRecyclerClick listener) {
        this.listener = listener;
    }

    PersonAdapter(List<Person> data, OnItemRecyclerClick listener) {
        persons = data;
        this.listener = listener;
    }


    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PersonAdapter.ViewHolder holder, final int position) {
        holder.myBigPenis(persons.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(position, persons.get(position));
            }
        });

    holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onRemoveClick(holder.getAdapterPosition());
            //persons.remove(position);
           // listener.onClick(position, persons.remove(position));
         //   persons.remove(position);
          //  notifyItemRemoved(position);
           // notifyDataSetChanged(); //ест много ресурсов лучше испольовать notifyItemRemoved
        }
    });
    }

    public void addAll(List<Person> data) {
        int startPosition = persons.size();
        persons.addAll(data);
        notifyItemRangeChanged(startPosition, data.size());
        //notifyAll()
    }


    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void remove(int position) {
        persons.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView age;
        private ImageButton mRemoveButton;
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            age = (TextView) itemView.findViewById(R.id.personAgeView);
            name = (TextView) itemView.findViewById(R.id.personNameView);
            mRemoveButton = (ImageButton) itemView.findViewById(R.id.btn_remove);
        }

        void myBigPenis(Person person) {
            age.setText("Возраст: " + person.getAge());
            name.setText("Имя: " + person.getName());

        }
    }
}
