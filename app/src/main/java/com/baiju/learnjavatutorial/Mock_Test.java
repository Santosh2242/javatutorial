package com.baiju.learnjavatutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mock_Test extends AppCompatActivity {

    private Button mock_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock__test);

        mock_1 = findViewById(R.id.mock_1);

        mock_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mock_Test.this, Mocktest_1.class);
                startActivity(intent);
            }
        });
    }
}