package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity2 extends AppCompatActivity {
    TextView tvName, tvPhone, tvSex, tvLevel, tvAge, tvSport, tvMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvName = this.findViewById(R.id.tv_Name_rs);
        tvPhone = this.findViewById(R.id.tv_Phone_rs);
        tvSex = this.findViewById(R.id.tv_Sex_rs);
        tvLevel = this.findViewById(R.id.tv_Level_rs);
        tvAge = this.findViewById(R.id.tv_Age_rs);
        tvSport = this.findViewById(R.id.tv_Sport_rs);
        tvMusic = this.findViewById(R.id.tv_Music_rs);

        tvName.setText(People.Name);
        tvPhone.setText(People.Phone);
        tvSex.setText(People.Sex);
        tvLevel.setText(People.Level);
        NumberFormat format = new DecimalFormat("0.#");
        tvAge.setText(format.format(People.Age));
        tvSport.setText(People.Sport);
        tvMusic.setText(People.Music);
    }
}