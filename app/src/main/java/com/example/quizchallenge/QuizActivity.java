package com.example.quizchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion, tvQuestionCounter, tvFeedback;
    private RadioButton optionA, optionB, optionC, optionD;
    private RadioGroup radioGroup;
    private Button btnNext;
    private ProgressBar progressBar;

    private List<Question> questionList;
    private int currentIndex = 0;
    private int score = 0;
    private boolean answered = false;

    private boolean isLoadingQuestion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvQuestionCounter = findViewById(R.id.tvQuestionCounter);
        tvFeedback = findViewById(R.id.tvFeedback);
        radioGroup = findViewById(R.id.radioGroup);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        btnNext = findViewById(R.id.btnNext);
        progressBar = findViewById(R.id.progressBar);

        questionList = QuestionBank.getQuestions();
        progressBar.setMax(questionList.size());

        loadQuestion();

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (isLoadingQuestion) {
                return;
            }

            if (checkedId == -1) {
                return;
            }

            if (answered) {
                return;
            }
            checkAnswer(checkedId);
        });

        btnNext.setOnClickListener(v -> {
            currentIndex++;
            if (currentIndex < questionList.size()) {
                loadQuestion();
            } else {
                goToResult();
            }
        });
    }

    private void loadQuestion() {
        isLoadingQuestion = true;
        answered = false;

        resetOptions();

        Question q = questionList.get(currentIndex);
        tvQuestion.setText(q.getQuestionText());
        optionA.setText("A. " + q.getOptionA());
        optionB.setText("B. " + q.getOptionB());
        optionC.setText("C. " + q.getOptionC());
        optionD.setText("D. " + q.getOptionD());

        tvQuestionCounter.setText("Question " + (currentIndex + 1) + " of " + questionList.size());
        progressBar.setProgress(currentIndex + 1);

        tvFeedback.setVisibility(View.GONE);
        tvFeedback.setText("");
        btnNext.setEnabled(false);

        radioGroup.clearCheck();

        isLoadingQuestion = false;
    }
    private void resetOptions() {

        optionA.setChecked(false);
        optionB.setChecked(false);
        optionC.setChecked(false);
        optionD.setChecked(false);

        optionA.setBackgroundResource(R.drawable.option_background);
        optionB.setBackgroundResource(R.drawable.option_background);
        optionC.setBackgroundResource(R.drawable.option_background);
        optionD.setBackgroundResource(R.drawable.option_background);

        int black = ContextCompat.getColor(this, android.R.color.black);
        optionA.setTextColor(black);
        optionB.setTextColor(black);
        optionC.setTextColor(black);
        optionD.setTextColor(black);

        optionA.jumpDrawablesToCurrentState();
        optionB.jumpDrawablesToCurrentState();
        optionC.jumpDrawablesToCurrentState();
        optionD.jumpDrawablesToCurrentState();
        radioGroup.jumpDrawablesToCurrentState();
    }

    private void checkAnswer(int checkedId) {
        answered = true;
        Question q = questionList.get(currentIndex);
        String correct = q.getCorrectAnswer();

        RadioButton selectedBtn = findViewById(checkedId);
        String selectedLetter = getLetterFromId(checkedId);
        RadioButton correctBtn = getButtonFromLetter(correct);

        int white = ContextCompat.getColor(this, R.color.white);
        int green = ContextCompat.getColor(this, R.color.correct_green);
        int red = ContextCompat.getColor(this, R.color.wrong_red);

        if (selectedLetter.equals(correct)) {
            selectedBtn.setBackgroundColor(green);
            selectedBtn.setTextColor(white);
            tvFeedback.setText("Correct!");
            tvFeedback.setBackgroundColor(green);
            tvFeedback.setTextColor(white);
            score++;
        } else {
            selectedBtn.setBackgroundColor(red);
            selectedBtn.setTextColor(white);
            correctBtn.setBackgroundColor(green);
            correctBtn.setTextColor(white);
            tvFeedback.setText("Wrong! Correct answer is " + correct + ". " + getOptionText(correct, q));
            tvFeedback.setBackgroundColor(red);
            tvFeedback.setTextColor(white);
        }

        tvFeedback.setVisibility(View.VISIBLE);
        btnNext.setEnabled(true);
    }

    private String getLetterFromId(int id) {
        if (id == R.id.optionA) return "A";
        if (id == R.id.optionB) return "B";
        if (id == R.id.optionC) return "C";
        return "D";
    }

    private RadioButton getButtonFromLetter(String letter) {
        switch (letter) {
            case "A": return optionA;
            case "B": return optionB;
            case "C": return optionC;
            default: return optionD;
        }
    }

    private String getOptionText(String letter, Question q) {
        switch (letter) {
            case "A": return q.getOptionA();
            case "B": return q.getOptionB();
            case "C": return q.getOptionC();
            default: return q.getOptionD();
        }
    }

    private void goToResult() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("total", questionList.size());
        startActivity(intent);
        finish();
    }
}