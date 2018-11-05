package com.example.a123.verrecycler;

public interface OnItemRecyclerClick {
    void onClick(int position, Person person);
    void onRemoveClick(int position);
}
