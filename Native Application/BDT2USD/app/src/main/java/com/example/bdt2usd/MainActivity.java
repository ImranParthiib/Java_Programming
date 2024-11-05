package com.example.bdt2usd;

import static java.lang.String.format;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText bdtAmount;
    Button convertButton;
    TextView usdAmount;
    String formatedUsd; // Define as a class-level variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bdtAmount = findViewById(R.id.bdtAmountId);
        convertButton = findViewById(R.id.convertButtonId);
        usdAmount = findViewById(R.id.usdAmountId);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bdt = Double.parseDouble(bdtAmount.getText().toString());
                double usd = bdt / 119.56;
                usd = Math.round(usd * 100.0) / 100.0; // Round to two decimals

                formatedUsd = format("%.2f", usd); // Assign to class member
                usdAmount.setText("USD = " + formatedUsd);
                bdtAmount.setText("");
            }
        });
    }

    public void showToast(View view) {
        Toast.makeText(this, "Your BDT TO USD Converted Money " + formatedUsd, Toast.LENGTH_SHORT).show();
    }
}
