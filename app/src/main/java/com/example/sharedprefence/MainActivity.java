package com.example.sharedprefence;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button btnSave, btnShow;
    TextView tvResult;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        tvResult = findViewById(R.id.tvResult);



        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.apply();
                tvResult.setText("نام ذخیره شد!");
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sharedPreferences.getString("name", "نامی ذخیره نشده است");
                tvResult.setText(name);
            }
        });
    }
}
