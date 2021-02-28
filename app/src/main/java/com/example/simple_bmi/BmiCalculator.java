package com.example.simple_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BmiCalculator extends AppCompatActivity {

    private TextView tv_name, tv_height, tv_weight, tv_imc;
    private String name;
    private Double height, weight;
    private DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        Bundle bundle = getIntent().getExtras();
        height = bundle.getDouble("height");
        weight = bundle.getDouble("weight");
        name = bundle.getString("name");

        tv_name = findViewById(R.id.txtOutputName);
        tv_height = findViewById(R.id.txtOutputHeight);
        tv_weight = findViewById(R.id.txtOutputWeight);
        tv_imc = findViewById(R.id.txtOutputIMC);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tv_name.setText(name);
        tv_weight.setText(String.valueOf(weight));
        tv_height.setText(String.valueOf(height));
        tv_imc.setText("Your BMI is:\n"+ decimalFormat.format(calculate(weight, height)));
    }

    public double calculate(double weight, double height) {
        return weight / (height * height);
    }
}