package com.sudipasarkar.kisanseva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

public class RegisterActivity extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText phone;
    Button nxtbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //userLogedin();
        phone = (EditText)findViewById(R.id.phone);
        ccp=(CountryCodePicker)findViewById(R.id.ccp);
        ccp.registerPhoneNumberTextView(phone);
        nxtbtn=(Button)findViewById(R.id.nextBtn);
        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,manageotp.class);
                intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });
    }

    /*private void userLogedin() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            startActivity(new Intent(this,MainActivity.class));
            finish();
            return;
        }
    }*/
}