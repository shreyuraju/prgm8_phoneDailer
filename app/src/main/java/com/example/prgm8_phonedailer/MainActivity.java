package com.example.prgm8_phonedailer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editPhone;
    TextView textInfo;
    Button btnDel, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnStar, btnHash, btnCall, btnSave;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPhone = findViewById(R.id.phoneNo);
        textInfo = findViewById(R.id.textInfo);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnStar = findViewById(R.id.btnStar);
        btnHash = findViewById(R.id.btnHash);
        btnCall = findViewById(R.id.btnCall);
        btnSave = findViewById(R.id.btnSave);
        btnDel = findViewById(R.id.btnDel);

        btnCall.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnStar.setOnClickListener(this);
        btnHash.setOnClickListener(this);
        btnDel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        phone = editPhone.getText().toString().trim();
        textInfo.setText("");
        try {
            if (v.equals(btnOne)) {
                phone+="1";
                editPhone.setText(phone);
            } else if (v.equals(btnTwo)) {
                phone+="2";
                editPhone.setText(phone);
            } else if (v.equals(btnThree)) {
                phone+="3";
                editPhone.setText(phone);
            } else if (v.equals(btnFour)) {
                phone+="4";
                editPhone.setText(phone);
            } else if (v.equals(btnFive)) {
                phone+="5";
                editPhone.setText(phone);
            } else if (v.equals(btnSix)) {
                phone+="6";
                editPhone.setText(phone);
            } else if (v.equals(btnSeven)) {
                phone+="7";
                editPhone.setText(phone);
            } else if (v.equals(btnEight)) {
                phone+="8";
                editPhone.setText(phone);
            } else if (v.equals(btnNine)) {
                phone+="9";
                editPhone.setText(phone);
            } else if (v.equals(btnZero)) {
                phone+="0";
                editPhone.setText(phone);
            } else if (v.equals(btnStar)) {
                phone+="*";
                editPhone.setText(phone);
            } else if (v.equals(btnHash)) {
                phone+="#";
                editPhone.setText(phone);
            } else if (v.equals(btnCall)) {
                if(phone.trim().equals("")) {
                    textInfo.setText("Please enter a Number to call!!!");
                } else {
                    Uri uri = Uri.parse("tel:"+phone);
                    Intent i = new Intent(Intent.ACTION_DIAL, uri);
                    try {
                        startActivity(i);
                    } catch (SecurityException e) {
                        Toast.makeText(this, "ERROR :"+e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            } else if (v.equals(btnSave)) {
                if(!phone.isEmpty()) {
                    Intent i = new Intent(ContactsContract.Intents.Insert.ACTION);
                    i.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    i.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                    startActivity(i);
                }
            }  else if(v.equals(btnDel)){
                if(!phone.isEmpty() && phone.length()>0){
                    phone = phone.substring(0, phone.length() - 1);
                    editPhone.setText(phone);
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "ERROR: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}