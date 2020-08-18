package com.example.apprentise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edt);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResult=findViewById(R.id.tvResult);
        tvResult.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = edt.getText().toString().trim();
                String dob = idNumber.substring(0, 6);
                int gender=Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sgender ;
                if(gender<5)
                {
                    sgender= getString(R.string.female);
                }
                else
                {
                    sgender=getString(R.string.male);
                }
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if(nationality ==0)
                {
                    sNationality=getString(R.string.sacit);
                }
                else
                {
                    sNationality=getString(R.string.permanentr);
                }
                String text = getString(R.string.dob)+ dob +"\n"+
                        getString(R.string.gender)+ sgender +"\n"+
                        getString(R.string.nationality)+sNationality;
                tvResult.setText(text);
                tvResult.setVisibility(View.VISIBLE);
            }
        });

    }

}