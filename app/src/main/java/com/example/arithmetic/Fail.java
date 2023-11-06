package com.example.arithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Верный ответ: \n" + String.valueOf(getIntent().getIntExtra("answer", 0)) +"  и  "+ String.valueOf(getIntent().getIntExtra("answer2", 0)));
        Button but = (Button) findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fail.this, MainActivity.class);
                intent.putExtra("counter", getIntent().getIntExtra("counter", 0));
                startActivity(intent);
            }
        });
    }
}