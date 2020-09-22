package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class signup extends AppCompatActivity {
private EditText nameEt,cityEt,phoneEt,bloodGroupEt,passwordEt;
private Button signup;
 private  TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nameEt=findViewById(R.id.name);
        cityEt=findViewById(R.id.city);
        phoneEt=findViewById(R.id.number);
        bloodGroupEt=findViewById(R.id.blood_group);
        passwordEt=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.tv2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signup.this,login.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        String name,city,blood_group,password,phone;
                        name=nameEt.getText().toString();
                        city=cityEt.getText().toString();
                        blood_group=bloodGroupEt.getText().toString();
                        password=passwordEt.getText().toString();
                        phone=phoneEt.getText().toString();
                        if (isValid(name,city,blood_group,password,phone)){


                        }

               else {

                            Intent homeintent=new Intent(signup.this,home.class);
                            startActivity(homeintent);

                        }



            }
        });
    }
    private boolean isValid(String name,String city, String blood_group,String password,String phone){
        List<String>valid_blood_groub=new ArrayList<>();
        valid_blood_groub.add("A+");
        valid_blood_groub.add("A-");
        valid_blood_groub.add("B+");
        valid_blood_groub.add("B-");
        valid_blood_groub.add("AB+");
        valid_blood_groub.add("AB-");
        valid_blood_groub.add("O+");
        valid_blood_groub.add("O-");
        if(name.isEmpty())
        {
            showMessage("Name is empty");
            return  false;
        }
        else if(city.isEmpty()){
            showMessage("City is empty");
            return  false;
        }

        else if(!valid_blood_groub.contains(blood_group)){
            showMessage("Blood group is Invalid");
            return  false;
        }
        else if(password.isEmpty()||phone.length()!=10){
            showMessage("Invalid phone Number");
            return  false;

        }



        return true;


    }
    private  void showMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
