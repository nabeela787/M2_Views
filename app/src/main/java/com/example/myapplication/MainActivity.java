package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView resultGpa;
    Button button;
    EditText[] courseEditTestFields;
    int totalGpa;
    int sumOfGrades;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        resultGpa = findViewById(R.id.textView);

        button.setOnClickListener(this::calculateGpa);
    }

    public void calculateGpa(View view) {

        courseEditTestFields = new EditText[]{
                findViewById(R.id.EditTextcourse1),
                findViewById(R.id.EditTextcourse2),
                findViewById(R.id.EditTextcourse3),
                findViewById(R.id.EditTextcourse4),
                findViewById(R.id.EditTextcourse5)
        };

        for (int i = 0; i < courseEditTestFields.length; i++) {
            String grade = courseEditTestFields[i].getText().toString();

            if (grade.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter the course grade", Toast.LENGTH_SHORT).show();
                return;
            }

            sumOfGrades += Double.parseDouble(grade);
        }

        totalGpa = sumOfGrades / courseEditTestFields.length;
        resultGpa.setText(String.valueOf(totalGpa));

        relativeLayout = findViewById(R.id.main);

        if (totalGpa <= 60) {
            relativeLayout.setBackgroundResource(R.color.red);
        } else if (totalGpa <= 79) {
            relativeLayout.setBackgroundResource(R.color.yellow);
        } else {
            relativeLayout.setBackgroundResource(R.color.green);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
