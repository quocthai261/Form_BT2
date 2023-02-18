package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spLv;
    EditText edName, edPhone;
    Switch sSex;
    Slider slAge;
    CheckBox cbSport;
    RadioGroup rd_grMusic;
    RadioButton radioButton;
    Button btnReg, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spLv = this.findViewById(R.id.sp_Level);
        edName= this.findViewById(R.id.et_Name);
        edPhone= this.findViewById(R.id.et_Phone);
        sSex= this.findViewById(R.id.s_Sex);
        slAge= this.findViewById(R.id.sl_Age);
        cbSport = this.findViewById(R.id.cb_Sport);
        rd_grMusic = this.findViewById(R.id.rd_gr_Music);
        btnCancel = this.findViewById(R.id.btn_Cancel);
        btnReg = this.findViewById(R.id.btn_Reg);

        ArrayList<String> lv_item = new ArrayList<String>();
        lv_item.add("Đại học");
        lv_item.add("Cao đẳng");
        lv_item.add("Trung cấp");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lv_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spLv.setAdapter(arrayAdapter);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextAct();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    private void nextAct() {
        People.Name = edName.getText().toString();
        People.Phone = edPhone.getText().toString();
        if (sSex.isChecked()){
            People.Sex = sSex.getTextOn().toString();
        } else {
            People.Sex = sSex.getTextOff().toString();
        }
        People.Level = spLv.getSelectedItem().toString();
        People.Age = slAge.getValue();
        if(cbSport.isChecked()){
            People.Sport = cbSport.getText().toString();
        } else {
            People.Sport = "Không";
        }
        int radio_Id = rd_grMusic.getCheckedRadioButtonId();
        radioButton = findViewById(radio_Id);
        People.Music = radioButton.getText().toString();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    private void clear() {
        edName.setText("");
        edPhone.setText("");
        if (sSex.isChecked()){
            sSex.setChecked(false);
        }
        spLv.setSelection(0);
        slAge.setValue(22);
        if (cbSport.isChecked()){
            cbSport.setChecked(false);
        }
        rd_grMusic.check(R.id.rd_Pop);
    }
}