package com.example.a123.verrecycler;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemRecyclerClick {

    private PersonAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 123; i++) {
            personList.add(new Person(i, " Чувак номер " + (i + 1), true));
        }//сделать загрузку из БД так как будет всегда создавать новые записи  проверка что еще не создана
        mAdapter = new PersonAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.addAll(personList);
        final Button btnOk = (Button) findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOk.setText(getString(R.string.oleg));
                List<Person> pers = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    pers.add(new Person(2 * (i + 1), getString(R.string.oleg) + " " + i, false));
                }
                mAdapter.addAll(pers);
            }
        });
    }

    @Override
    public void onClick(int position, Person person) {
        Toast.makeText(this, "Position = " + position + " Name: " + person.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PersonInfoActivity.class);
        intent.putExtra("PERSON", person);
        startActivity(intent);
    }

    @Override
    public void onRemoveClick(int position) {
        mAdapter.remove(position);
    }
}
