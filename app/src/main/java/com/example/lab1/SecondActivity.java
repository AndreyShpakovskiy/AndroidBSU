package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity {

    Button btnActOne;
    TextView textview;
    EditText numText;
    int sum;
    int firstnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstnum=getIntent().getIntExtra("number",0);
        textview=(TextView) findViewById(R.id.textView);
        textview.setText(String.valueOf(firstnum));
        btnActOne = (Button) findViewById(R.id.btnActTwo);
        btnActOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numText=findViewById(R.id.number);
                int number = Integer.parseInt(numText.getText().toString());
                sum=number+firstnum;
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", sum);
                setResult(RESULT_OK, returnIntent);
                finish();
                /*Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("number", sum);
                startActivity(intent);*/
            }
        });
    }

}