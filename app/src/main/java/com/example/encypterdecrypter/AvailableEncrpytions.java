package com.example.encypterdecrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AvailableEncrpytions extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_encrpytions);
        Button button1 = findViewById(R.id.First);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.Second);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.Third);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.Fourth);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.First:
                Toast.makeText(this, "Vigenere Cipher Selected", Toast.LENGTH_SHORT).show();
                goToFirstEncryption();
                break;
            case R.id.Second:
                Toast.makeText(this, "Caesar Cipher Selected", Toast.LENGTH_SHORT).show();
                goToSecondEncryption();
                break;
            case R.id.Third:
                Toast.makeText(this, "RailFence Cipher Selected", Toast.LENGTH_SHORT).show();
                goToThirdEncryption();
                break;
            case R.id.Fourth:
                Toast.makeText(this, "Product Cipher Selected", Toast.LENGTH_SHORT).show();
                goToFourthEncryption();
                break;
        }
    }

    private void goToFirstEncryption() {
        Intent intent = new Intent(this, FirstEncryption.class);

        startActivity(intent);
    }
    private void goToSecondEncryption() {
        Intent intent2 = new Intent(this, SecondEncryption.class);

        startActivity(intent2);
    }
    private void goToThirdEncryption() {
        Intent intent3 = new Intent(this, ThirdEncryption.class);

        startActivity(intent3);
    }
    private void goToFourthEncryption() {
        Intent intent4 = new Intent(this, FourthEncryption.class);

        startActivity(intent4);
    }
}
