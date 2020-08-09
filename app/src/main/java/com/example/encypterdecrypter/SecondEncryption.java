package com.example.encypterdecrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.view.View.*;

public class SecondEncryption extends AppCompatActivity implements OnClickListener {
    String textToEncrypt,  textToDecrypt;
    int keyToEncryptWith, keyToDecryptWith;
    EditText encryptionBoxText2;
    EditText encryptionKeyBoxText2;
    EditText decryptionBoxText2;
    EditText decryptionKeyBoxText2;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_encryption);
        encryptionBoxText2 = (EditText)findViewById(R.id.encryptionBox2);
        encryptionKeyBoxText2 = (EditText) findViewById(R.id.encryptionKeyBox2);
        decryptionBoxText2 =(EditText) findViewById(R.id.decryptionBox2);
        decryptionKeyBoxText2 = (EditText) findViewById(R.id.decryptionKeyBox2);
        Button encrypt2 = findViewById(R.id.encryptionButton2);
        encrypt2.setOnClickListener(this);
        Button decrypt2 = findViewById(R.id.decryptionButton2);
        decrypt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v1) {
        switch (v1.getId()) {
            case R.id.encryptionButton2:
                textToEncrypt = encryptionBoxText2.getText().toString();
                keyToEncryptWith = Integer.parseInt(encryptionKeyBoxText2.getText().toString());
                String encryptedMessage2 = EncryptThis(textToEncrypt, keyToEncryptWith);
                encryptionBoxText2.setText(encryptedMessage2);
                break;
            case R.id.decryptionButton2:
                textToDecrypt = decryptionBoxText2.getText().toString();
                keyToDecryptWith = Integer.parseInt(decryptionKeyBoxText2.getText().toString());
                String decryptedMessage2 = DecryptThis(textToDecrypt, keyToDecryptWith);
                decryptionBoxText2.setText(decryptedMessage2);
                break;
        }
    }

    public String EncryptThis(String plainText, int shiftKey){
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;

    }

    public String DecryptThis(String cipherText, int shiftKey){
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }

}
