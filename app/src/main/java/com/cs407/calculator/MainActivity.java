package com.cs407.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText, secondNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = findViewById(R.id.firstNumberEditText);
        secondNumberEditText = findViewById(R.id.secondNumberEditText);
        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);

        addButton.setOnClickListener(v -> operate("+"));
        subtractButton.setOnClickListener(v -> operate("-"));
        multiplyButton.setOnClickListener(v -> operate("*"));
        divideButton.setOnClickListener(v -> operate("/"));
    }

    private void operate(String operation) {
        String firstInput = firstNumberEditText.getText().toString();
        String secondInput = secondNumberEditText.getText().toString();

        if (firstInput.isEmpty() || secondInput.isEmpty()) {
            Toast.makeText(this, "Both numbers are required", Toast.LENGTH_SHORT).show();
            return;
        }

        int firstNumber = Integer.parseInt(firstInput);
        int secondNumber = Integer.parseInt(secondInput);

        if (operation.equals("/") && secondNumber == 0) {
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            return;
        }

        int result = 0;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }

        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtra("result", result);
        startActivity(resultIntent);
    }
}
