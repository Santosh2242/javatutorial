package com.baiju.learnjavatutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class Mocktest_1 extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Btn,Option2Btn,Option3Btn,Option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;

    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocktest_1);

        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        Option2Btn = findViewById(R.id.idBtnOption2);
        Option3Btn = findViewById(R.id.idBtnOption3);
        Option4Btn = findViewById(R.id.idBtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        Option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(Option2Btn.getText().toString().trim().toLowerCase())){

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        Option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(Option3Btn.getText().toString().trim().toLowerCase())){

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        Option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(Option4Btn.getText().toString().trim().toLowerCase())){

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });
    }

    private void showBottomSheet(){

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Mocktest_1.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your score is \n"+currentScore+"/10");
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.dismiss();
    }
    private void setDataToViews(int currentPos) {
        questionNumberTV.setText("Question Attempted: " + questionAttempted + "/10");
        if (questionAttempted == 10) {
            showBottomSheet();
        } else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            Option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            Option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            Option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }
    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {

        quizModelArrayList.add(new QuizModel("What is your Name","Santosh","Shiva","Sachin","Ankur","Santosh"));
        quizModelArrayList.add(new QuizModel("What is your Father Name","Santosh","Shiva","Sachin","Ankur","Santosh"));
        quizModelArrayList.add(new QuizModel("What is your mother Name","Santosh","Shiva","Sachin","Ankur","Santosh"));
        quizModelArrayList.add(new QuizModel("What is your brother Name","Santosh","Shiva","Sachin","Ankur","Santosh"));
    }
}



