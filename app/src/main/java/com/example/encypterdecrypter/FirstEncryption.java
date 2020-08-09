package com.example.encypterdecrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstEncryption extends AppCompatActivity implements View.OnClickListener {

    String textToEncrypt, keyToEncryptWith, textToDecrypt, keyToDecryptWith;
    EditText encryptionBoxText;
    EditText encryptionKeyBoxText;
    EditText decryptionBoxText;
    EditText decryptionKeyBoxText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_encryption);
        encryptionBoxText = (EditText)findViewById(R.id.encryptionBox);
        encryptionKeyBoxText = (EditText) findViewById(R.id.encryptionKeyBox);
        decryptionBoxText =(EditText) findViewById(R.id.decryptionBox);
        decryptionKeyBoxText = (EditText) findViewById(R.id.decryptionKeyBox);
        Button encrypt = findViewById(R.id.encryptionButton);
        encrypt.setOnClickListener(this);
        Button decrypt = findViewById(R.id.decryptionButton);
        decrypt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.encryptionButton:
                 textToEncrypt = encryptionBoxText.getText().toString();
                 keyToEncryptWith = encryptionKeyBoxText.getText().toString();
                 String encryptedMessage = EncryptThis(textToEncrypt, keyToEncryptWith);
                 encryptionBoxText.setText(encryptedMessage);
                 break;
            case R.id.decryptionButton:
                 textToDecrypt = decryptionBoxText.getText().toString();
                 keyToDecryptWith = decryptionKeyBoxText.getText().toString();
                 String decryptedMessage = DecryptThis(textToDecrypt, keyToDecryptWith);
                 decryptionBoxText.setText(decryptedMessage);
        }
    }

    public String EncryptThis(String text, String key){
        String res = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public String DecryptThis(String text, String key){
        String res = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

}

