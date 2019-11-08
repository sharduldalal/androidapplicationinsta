package com.example.mypost3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Username , password;
    String name , pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Username = (EditText)findViewById(R.id.editText);
        EditText password =  (EditText)findViewById(R.id.editText2);

    }

    public void  button1 (View view){
        Intent intent = new Intent(this , Main2Activity.class);
        startActivity(intent);
        String name = Username.getText().toString();
        pass = password.getText().toString();
        String method = "register";
        BackGroundTask backGroundTask = new BackGroundTask(this);
        backGroundTask.execute(method,name,pass);
        finish();
    }
}
