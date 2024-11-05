package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button checkButton;
    TextView answerTextView;

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

        radioGroup = findViewById(R.id.answerOptionsRadioGroup);
        checkButton = findViewById(R.id.checkAnswerButton);
        answerTextView = findViewById(R.id.answerTextView);

        checkButton.setOnClickListener(this::onClick);
    }

    @SuppressLint("SetTextI18n")
    private void onClick(View v) {
        int checkedId = radioGroup.getCheckedRadioButtonId();

        // Check if the selected option is the correct answer
        if (checkedId == -1) {
            // If no option is selected, show a message to the user
            answerTextView.setText("Select an answer!");
        } else if (checkedId == R.id.correctAnswerRadioButton) {
            answerTextView.setText("Right answer!");
        } else {
            answerTextView.setText("Wrong answer!");
        }
    }
}
