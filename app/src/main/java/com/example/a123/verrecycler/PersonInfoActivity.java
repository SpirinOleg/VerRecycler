package com.example.a123.verrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PersonInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

        Person p = getIntent().getParcelableExtra("PERSON");
        TextView age = (TextView) findViewById(R.id.personAgeView);
        TextView name = (TextView) findViewById(R.id.personNameView);
        TextView sex = (TextView) findViewById(R.id.personSex);
        age.setText(String.valueOf(p.getAge()));//приведение перемнной к строке, так как обязательно должен быть string
        name.setText(p.getName());
        sex.setText(String.valueOf(p.isSex()));

       // Toast.makeText(this, p.toString(), Toast.LENGTH_SHORT).show();
    }
}
