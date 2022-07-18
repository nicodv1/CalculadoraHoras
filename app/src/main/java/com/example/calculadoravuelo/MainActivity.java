package com.example.calculadoravuelo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToCalculoActivity(View view){
        Intent myIntent = new Intent(this, CalculoActivity.class);
        startActivity(myIntent);

    }

}