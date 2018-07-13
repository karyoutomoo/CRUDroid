package com.itsjustfaiq.crudroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.itsjustfaiq.crudroid.Database.Database;
import com.itsjustfaiq.crudroid.Model.Item;

public class CRU_Activity extends AppCompatActivity {

    TextView textViewName, textViewPriority;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cru_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewName = findViewById(R.id.enter_name);
        textViewPriority = findViewById(R.id.enter_priority);

        database = new Database(CRU_Activity.this);

        FloatingActionButton fab = (FloatingActionButton)
                findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String name = textViewName.getText().toString();
                int prio = Integer.parseInt(textViewPriority.getText().toString());
                Item item = new Item(name, prio);                database.addItem(item);
            Intent intent = new Intent(CRU_Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
