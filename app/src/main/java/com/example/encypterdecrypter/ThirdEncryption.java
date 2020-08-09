package com.example.encypterdecrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.view.View.*;

public class ThirdEncryption extends AppCompatActivity implements OnClickListener {
    String textToEncrypt,  textToDecrypt;
    int keyToEncryptWith, keyToDecryptWith;
    EditText encryptionBoxText3;
    EditText encryptionKeyBoxText3;
    EditText decryptionBoxText3;
    EditText decryptionKeyBoxText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_encryption);
        encryptionBoxText3 = (EditText)findViewById(R.id.encryptionBox3);
        encryptionKeyBoxText3 = (EditText) findViewById(R.id.encryptionKeyBox3);
        decryptionBoxText3 =(EditText) findViewById(R.id.decryptionBox3);
        decryptionKeyBoxText3 = (EditText) findViewById(R.id.decryptionKeyBox3);
        Button encrypt2 = findViewById(R.id.encryptionButton3);
        encrypt2.setOnClickListener(this);
        Button decrypt2 = findViewById(R.id.decryptionButton3);
        decrypt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v1) {
        switch (v1.getId()) {
            case R.id.encryptionButton3:
                textToEncrypt = encryptionBoxText3.getText().toString();
                keyToEncryptWith = Integer.parseInt(encryptionKeyBoxText3.getText().toString());
                String encryptedMessage3 = EncryptThis(textToEncrypt, keyToEncryptWith);
                encryptionBoxText3.setText(encryptedMessage3);
                break;
            case R.id.decryptionButton3:
                textToDecrypt = decryptionBoxText3.getText().toString();
                keyToDecryptWith = Integer.parseInt(decryptionKeyBoxText3.getText().toString());
                String decryptedMessage3 = DecryptThis(textToDecrypt, keyToDecryptWith);
                decryptionBoxText3.setText(decryptedMessage3);
                break;
        }
    }

    public String EncryptThis(String message, int key) {
        char[][] rail = new char[key][message.length()];
        // matrix
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                continue;
            }
        }
        int row = 0;
        int check = 0;
        for (int i = 0; i < message.length(); i++) {
            if (check == 0) {
                rail[row][i] = message.charAt(i);
                row++;
                if (row == key) {
                    check = 1;
                    row--;
                }
            } else if (check == 1) {
                row--;
                rail[row][i] = message.charAt(i);
                if (row == 0) {
                    check = 0;
                    row = 1;
                }
            } // if-else
        } // for

        String encrypText = "";
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                encrypText += rail[i][j];

            }
        }
        return encrypText;
    }


    public String DecryptThis(String message, int key) {
        char[][] rail = new char[key][message.length()];

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                rail[i][j] = '.';
            }
        }

        int row = 0;
        int check = 0;
        for (int i = 0; i < message.length(); i++) {
            if (check == 0) {
                rail[row][i] = message.charAt(i);
                row++;
                if (row == key) {
                    check = 1;
                    row--;
                }
            } else if (check == 1) {
                row--;
                rail[row][i] = message.charAt(i);
                if (row == 0) {
                    check = 0;
                    row = 1;
                }
            }
        }


        int ordr = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                String temp = rail[i][j] + "";
                if (temp.matches("\\.")) {
                    continue;
                } else {
                    rail[i][j] = message.charAt(ordr);
                    ordr++;
                }
            }
        }

        System.out.println("Reorder");
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                System.out.print(rail[i][j]);
            }
            System.out.println();
        }

        String decrypText = "";
        check = 0;
        row = 0;
        for (int i = 0; i < message.length(); i++) {
            if (check == 0) {
                decrypText += rail[row][i];
                row++;
                if (row == key) {
                    check = 1;
                    row--;
                }
            }
            else if (check == 1) {
                row--;
                decrypText += rail[row][i];
                if (row == 0) {
                    check = 0;
                    row++;
                }
            }
        }
        return decrypText;
    }
}
