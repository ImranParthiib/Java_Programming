package com.example.currencyconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputEditText;
    TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputEditText = findViewById(R.id.inputTextID);
        outputTextView = findViewById(R.id.outputTextViewID);
    }

    private double getInputAmount() {
        String inputText = inputEditText.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return -1;
        }
        return Double.parseDouble(inputText);
    }

    public void usdFunction(View view) {
        double bdt = getInputAmount();
        if (bdt == -1) return;   

        double usd = bdt / 119.51;
        String formattedUsd = String.format("%.2f", usd);
        outputTextView.setText("USD= " + formattedUsd);
    }

    public void rupeeFunction(View view) {
        double bdt = getInputAmount();
        if (bdt == -1) return;

        double rupee = bdt / 1.42;
        String formattedRupee = String.format("%.2f", rupee);
        outputTextView.setText("Rupee= " + formattedRupee);
    }

    public void ukFunction(View view) {
        double bdt = getInputAmount();
        if (bdt == -1) return;

        double uk = bdt / 155.22;
        String formattedUk = String.format("%.2f", uk);
        outputTextView.setText("GBP= " + formattedUk);
    }
}
