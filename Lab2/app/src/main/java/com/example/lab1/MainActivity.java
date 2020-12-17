package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btnActTwo;
    TextView textview;
    EditText numText;
    int sum;
    int firstnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView) findViewById(R.id.textView);
        firstnum=Integer.parseInt(textview.getText().toString());
        textview.setText(String.valueOf(firstnum));
        btnActTwo = (Button) findViewById(R.id.btnActTwo);
        btnActTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numText=findViewById(R.id.number);
                int number = Integer.parseInt(numText.getText().toString());
                sum=number+firstnum;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("number", sum);
                startActivityForResult(intent,10);

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                int result = data.getIntExtra("result",0);
                textview.setText(String.valueOf(result));
                firstnum=Integer.parseInt(textview.getText().toString());
            }
        }
    }

}