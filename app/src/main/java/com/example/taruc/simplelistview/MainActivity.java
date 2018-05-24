package com.example.taruc.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private Button buttonSave;
    private ListView listView;
    private ArrayList<String>array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonSave = (Button) findViewById(R.id.buttoSave);
        listView = (ListView) findViewById(R.id.listView);

        array =new ArrayList<String>();
        buttonSave.setOnClickListener(this);
    }

        @Override
                public void onClick(View v){

            String input = editTextName.getText().toString();

         if(input.trim().equals("")) {
             Toast.makeText(getApplicationContext(), "Input is empty", Toast.LENGTH_LONG).show();


         }else if(array.contains(input)){
              Toast.makeText(getApplicationContext(), "Already Exist", Toast.LENGTH_LONG).show();
         }else {
             array.add(input);
             ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, array);
             listView.setAdapter(adapter);
         }
    }
}
