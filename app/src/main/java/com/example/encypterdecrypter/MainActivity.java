package com.example.encypterdecrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button:
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                goToAvailableEncrpytions();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void goToAvailableEncrpytions() {

        Intent intent = new Intent(this, AvailableEncrpytions.class);

        startActivity(intent);

    }
}
