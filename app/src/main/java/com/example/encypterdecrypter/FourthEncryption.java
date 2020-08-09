package com.example.encypterdecrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import static android.view.View.*;

public class FourthEncryption extends AppCompatActivity implements OnClickListener {
    String textToEncrypt, textToDecrypt;
    int keyToEncryptWith, keyToDecryptWith;
    EditText encryptionBoxText3;
    EditText encryptionKeyBoxText3;
    EditText decryptionBoxText3;
    EditText decryptionKeyBoxText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_encryption);
        encryptionBoxText3 = (EditText) findViewById(R.id.encryptionBox3);
        encryptionKeyBoxText3 = (EditText) findViewById(R.id.encryptionKeyBox3);
        decryptionBoxText3 = (EditText) findViewById(R.id.decryptionBox3);
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

    private String EncryptThis(String textToEncrypt, int keyToEncryptWith) {
        String res;
        res=additive_enc(textToEncrypt,keyToEncryptWith);
        res=transposition_enc(res, keyToEncryptWith);
        return res;
    }

    private String DecryptThis(String textToDecrypt, int keyToDecryptWith) {
        String res="";
        res= additive_dec(textToDecrypt, keyToDecryptWith);
        res= transposition_dec(res, keyToDecryptWith);
        return res;
    }



    public String additive_enc(String ip, int k){
        StringBuilder s = new StringBuilder();
        int len = ip.length();
        char temp;
        int t1;
        for(int i=0;i<len;i++)
        {
            temp = ip.charAt(i);
            if(Character.isUpperCase(temp))
            {
                t1 = (int)temp - (int)'A';
                t1 = (t1 + k)%26;
                t1 = t1 + (int)'A';
                temp = (char)t1;
                s.append(temp);
            }
            else if(Character.isLowerCase(temp))
            {
                t1 = (int)temp - (int)'a';
                t1 = (t1 + k)%26;
                t1 = t1 + (int)'a';
                temp = (char)t1;
                s.append(temp);
            }
            else
            {
                s.append(temp);
            }
        }
        String op = s.toString();
        return op;
    }

    public String transposition_enc(String ip,int m_row)
    {
        char op[][]=new char[100][100];
        int len = ip.length();
        String op2="";
        int i1,i2,i;

        //calculate columns from rows
        int m_col = (int)Math.ceil((float)len/m_row);

        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i2][i1]=ip.charAt(i);
            i2++;
            if(i2==m_row)
            {
                i2=0;
                i1++;
            }
        }

        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                op2 = op2+op[i1][i2];
            }
        }
        return (op2);
    }

    String additive_dec(String ip, int k){
        StringBuilder s = new StringBuilder();
        int len = ip.length();
        char temp;
        int t1;
        for(int i=0;i<len;i++)
        {
            temp = ip.charAt(i);
            if(Character.isUpperCase(temp))
            {
                t1 = (int)temp - (int)'A';
                t1 = (t1 - k +26)%26;
                t1 = t1 + (int)'A';
                temp = (char)t1;
                s.append(temp);
            }
            else if(Character.isLowerCase(temp))
            {
                t1 = (int)temp - (int)'a';
                t1 = (t1 - k+26)%26;
                t1 = t1 + (int)'a';
                temp = (char)t1;
                s.append(temp);
            }
            else
            {
                s.append(temp);
            }
        }
        String op = s.toString();
        return op;
    }

    String transposition_dec(String ip,int m_row)
    {
        char op[][]=new char[100][100];
        int len = ip.length();
        String op2="";
        int i1,i2,i;

        //calculate columns from rows
        int m_col = (int)Math.ceil((float)len/m_row);

        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i1][i2]=ip.charAt(i);
            i2++;
            if(i2==m_col)
            {
                i2=0;
                i1++;
            }
        }

        for(i1=0;i1<m_col;i1++)
        {
            for(i2=0;i2<m_row;i2++)
            {
                op2 = op2+op[i2][i1];
            }
        }
        return (op2);
    }
}

