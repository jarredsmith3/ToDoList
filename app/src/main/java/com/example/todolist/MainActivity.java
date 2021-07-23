package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner monthSpinner;
    Spinner yearSpinner;
    ArrayList<Task> taskList = new ArrayList<Task>();
    ArrayList<String> taskNameList = new ArrayList<String>();
    ArrayAdapter<String> itemsAdapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == AddItemActivity.RESULT_OK){
            ArrayList<String> userTask = data.getStringArrayListExtra("userTask");
            createList(userTask);
        }
        if (resultCode == AddItemActivity.RESULT_CANCELED) {

        }

    } //onActivityResult

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.test_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addTask:
                Intent i = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(i, 1);
                return true;
            case R.id.settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void createList(ArrayList<String> userTask) {
        Task task = new Task(userTask.get(0), Integer.parseInt(userTask.get(1)), Integer.parseInt(userTask.get(2)));
        taskList.add(task);
        taskNameList.add(userTask.get(0));
        if (taskList.size() == 1) {
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList.);
            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(itemsAdapter);
        }
        else {
            itemsAdapter.notifyDataSetChanged();
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);

            }
        });

    }


}