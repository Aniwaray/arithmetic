package com.example.arithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int counter, a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = getIntent().getIntExtra("counter", 0);
        setContentView(R.layout.activity_main);
        Random random = new Random();

        do{
            a = random.nextInt(100);
            b = random.nextInt(100);

        }while (b > a);
        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView result = (TextView) findViewById(R.id.result);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        result.setText(String.valueOf(counter));
        textView.setText(String.valueOf(a) + "+" + String.valueOf(b) + "=");
        textView2.setText(String.valueOf(a) + "-" + String.valueOf(b) + "=");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Введите значение", Toast.LENGTH_LONG).show();
                }else if (Integer.parseInt(editText2.getText().toString()) == (a+b)&& Integer.parseInt(editText.getText().toString()) == (a-b) ){
                    Intent intent = new Intent(MainActivity.this, Sucseed.class);
                    intent.putExtra("counter", ++counter);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, Fail.class);
                    intent.putExtra("answer", a+b);
                    intent.putExtra("answer2", a-b);
                    startActivity(intent);
                }
            }
        });

    }
}