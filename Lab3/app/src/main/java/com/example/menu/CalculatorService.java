package com.example.menu;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;


public class CalculatorService extends Service {

    public class ServiceBinder extends Binder {
        public CalculatorService getService(){
            return CalculatorService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        return  START_STICKY;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service destroyed", Toast.LENGTH_SHORT).show();

    }
    public static int additionTwoNumbers(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public static int subtractionTwoNumbers(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

    public static int multiplicationTwoNumbers(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

    public static int divisionTwoNumbers(int firstNumber, int secondNumber){
        if(secondNumber == 0){
            return 0;
        }
        return firstNumber / secondNumber;
    }

    public static int remainderFromDivisionTwoNumbers(int firstNumber, int secondNumber){
        if(secondNumber == 0) {
            return 0;
        }
        return firstNumber % secondNumber;
    }
}
