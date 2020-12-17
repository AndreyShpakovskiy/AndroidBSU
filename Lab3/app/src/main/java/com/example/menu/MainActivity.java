package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CalculatorService calculatorService;
    boolean isMainServiceBound = false;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            CalculatorService.ServiceBinder binder = (CalculatorService.ServiceBinder) service;
            calculatorService = binder.getService();
            isMainServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isMainServiceBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, CalculatorService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        isMainServiceBound = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        TextView resultView = (TextView) findViewById(R.id.result);
        EditText firstNumber = (EditText) findViewById(R.id.firstNumber);
        EditText secondNumber = (EditText) findViewById(R.id.secondNumber);
        switch (item.getItemId()) {
            case R.id.addition:
                resultView.setText(Integer.toString(CalculatorService.additionTwoNumbers(
                        Integer.parseInt(firstNumber.getText().toString())
                        ,Integer.parseInt(secondNumber.getText().toString()))));
                return true;
            case R.id.subtraction:
                resultView.setText(Integer.toString(CalculatorService.subtractionTwoNumbers(
                        Integer.parseInt(firstNumber.getText().toString())
                        ,Integer.parseInt(secondNumber.getText().toString()))));
                return true;
            case R.id.division:
                resultView.setText(Integer.toString(CalculatorService.divisionTwoNumbers(
                        Integer.parseInt(firstNumber.getText().toString())
                        ,Integer.parseInt(secondNumber.getText().toString()))));
                return true;
            case R.id.remainder:
                resultView.setText(Integer.toString(CalculatorService.remainderFromDivisionTwoNumbers(
                        Integer.parseInt(firstNumber.getText().toString())
                        ,Integer.parseInt(secondNumber.getText().toString()))));
                return true;
            case R.id.multiplication:
                resultView.setText(Integer.toString(CalculatorService.multiplicationTwoNumbers(
                        Integer.parseInt(firstNumber.getText().toString())
                        ,Integer.parseInt(secondNumber.getText().toString()))));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}