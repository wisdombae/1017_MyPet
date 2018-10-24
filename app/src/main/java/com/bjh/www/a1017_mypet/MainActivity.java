package com.bjh.www.a1017_mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkAgree;
    RadioGroup RGroup;
    RadioButton radioDog, radioCat, radioRabbit;
    Button buttonOK;
    ImageView imagePet;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        checkAgree = (CheckBox) findViewById(R.id.checkAgree);
        this.RGroup = (RadioGroup) findViewById(R.id.Rgroup1);
        this.radioDog = (RadioButton) findViewById(R.id.radioDog);
        this.radioCat = (RadioButton) findViewById(R.id.radioCat);
        this.radioRabbit = (RadioButton) findViewById(R.id.radioRabbit);
        this.buttonOK = (Button) findViewById(R.id.buttonOK);
        this.imagePet = (ImageView) findViewById(R.id.imagePet);

        checkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkAgree.isChecked()) {
                    text2.setVisibility(View.VISIBLE);
                    RGroup.setVisibility(View.VISIBLE);
                    buttonOK.setVisibility(View.VISIBLE);
                    imagePet.setVisibility(View.VISIBLE);
                }
                else {
                    text2.setVisibility(View.INVISIBLE);
                    RGroup.setVisibility(View.INVISIBLE);
                    buttonOK.setVisibility(View.INVISIBLE);
                    imagePet.setVisibility(View.INVISIBLE);
                }
            }
        });

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (RGroup.getCheckedRadioButtonId()) {
                    case R.id.radioDog:
                        imagePet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioCat:
                        imagePet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioRabbit:
                        imagePet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplication(), "동물을 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
