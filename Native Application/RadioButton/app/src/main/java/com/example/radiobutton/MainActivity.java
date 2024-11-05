package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView outputText;
    Button checkButton;

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

        radioGroup = findViewById(R.id.questionOptionsID);
        outputText = findViewById(R.id.answerID);
        checkButton = findViewById(R.id.checkAnswerId);

      /*  radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.correctAnswerID) {
                outputText.setText("Correct");
            } else {
                outputText.setText("Incorrect");
            }
        }); */

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                if (checkedId == -1){
                    outputText.setText("Please Select an option");
                }
                else{
                    if(checkedId == R.id.correctAnswerID){
                        outputText.setText("Correct Answer");
                    }
                    else{
                        outputText.setText("Wrong Answer");
                    }
                }
            }
        });
    }
}

