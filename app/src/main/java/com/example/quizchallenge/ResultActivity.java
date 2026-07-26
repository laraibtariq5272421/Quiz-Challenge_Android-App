package com.example.quizchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 10);
        int incorrect = total - score;

        TextView tvScore = findViewById(R.id.tvScore);
        TextView tvCorrect = findViewById(R.id.tvCorrect);
        TextView tvIncorrect = findViewById(R.id.tvIncorrect);
        Button btnRestart = findViewById(R.id.btnRestart);

        tvScore.setText(score + " / " + total);
        tvCorrect.setText("Correct Answers: " + score);
        tvIncorrect.setText("Incorrect Answers: " + incorrect);

        btnRestart.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}