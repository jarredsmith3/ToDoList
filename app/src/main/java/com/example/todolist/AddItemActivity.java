package com.example.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    Spinner monthSpinner;
    Spinner daySpinner;
    ArrayList<String> returnItems = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_activity);

        createSpinners();

        EditText userInput = (EditText) findViewById(R.id.userTask);
        Button addItemButton = (Button)findViewById(R.id.addTaskButton);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String returnItem = userInput.getEditableText().toString();
                System.out.println("here");
                returnItems.add(returnItem);
                returnItems.add(monthSpinner.getSelectedItem().toString());
                returnItems.add(daySpinner.getSelectedItem().toString());
                System.out.println(returnItems.get(0));
                System.out.println(returnItems.get(1));
                System.out.println(returnItems.get(2));
                Intent resultIntent = new Intent();
                resultIntent.putExtra("userTask", returnItems);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });



    }

    public void createSpinners () {
        monthSpinner = (Spinner) findViewById(R.id.monthSpinner);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(AddItemActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.month_array));
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        daySpinner = (Spinner) findViewById(R.id.daySpinner);
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(AddItemActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.year_array));
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);
    }


}
