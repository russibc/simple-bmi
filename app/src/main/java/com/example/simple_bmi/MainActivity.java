package com.example.simple_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_height, et_weight;
    private String name;
    private Double weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.txtName);
        et_weight = findViewById(R.id.txtWeight);
        et_height = findViewById(R.id.txtHeight);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, BmiCalculator.class);

        name = et_name.getText().toString();
        weight = Double.parseDouble(et_weight.getText().toString());
        height = Double.parseDouble(et_height.getText().toString());

        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}