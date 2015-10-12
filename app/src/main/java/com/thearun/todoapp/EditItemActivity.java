package com.thearun.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String editItem = getIntent().getStringExtra("editItem");

        TextView editText = (TextView) findViewById(R.id.editText);
        editText.setText(editItem);
    }

    public void onSubmit(View v) {
        TextView editedItem = (TextView) findViewById(R.id.editText);
        System.out.print("editedItem : " + editedItem.getText().toString());
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("editedItem", editedItem.getText().toString());
        int position = getIntent().getIntExtra("position", 0);
        data.putExtra("position",position);
        setResult(RESULT_OK, data);
        finish();
    }

}
