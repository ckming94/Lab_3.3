package com.example.taruc.lab_33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private TextView textViewTotal;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxSmoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);

        // Create an array adapter
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, // location to show, this => this activity
                        R.array.age, // where the resource come from
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // how you want the output to be display
        spinnerAge.setAdapter(adapter);
        // Assign dynamic loading of spinner content
        spinnerAge.setOnItemSelectedListener(this);

        textViewTotal = (TextView)findViewById(R.id.textViewTotal);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
    }

    public void calculatePremium (View v) {
        double premium = 0.0;
        int age = spinnerAge.getSelectedItemPosition();
        int gender = radioGroupGender.getCheckedRadioButtonId();
        boolean male = false;

        if (gender == R.id.radioButtonMale) {
            male = true;
        }


        switch (age) {
            case 0:
                premium = 50;
                break;
            case 1:
                premium = 55;
                break;
            case 2:
                premium = 60;
                if(male){
                    premium += 50;
                }
                break;
            case 3:
                premium = 70;
                if(male)
                    premium += 100;
                if(checkBoxSmoker.isChecked())
                    premium += 100;
                break;
            case 4:
                premium = 120;
                if(male)
                    premium += 100;
                if(checkBoxSmoker.isChecked())
                    premium += 150;
                break;
            case 5:
                premium = 160;
                if(male)
                    premium += 50;
                if(checkBoxSmoker.isChecked())
                    premium += 150;
                break;
            case 6:
                premium = 200;
                if(checkBoxSmoker.isChecked())
                    premium += 250;
                break;
            case 7:
                premium = 250;
                if(checkBoxSmoker.isChecked())
                    premium += 250;
                break;
        }


        textViewTotal.setText("RM " + String.format("%.2f", premium));
    }

    public void ResetAll(View v){
        spinnerAge.setSelection(0);
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewTotal.setText("");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(id == R.id.spinnerAge) // if you have more than 1 spinner, use id to differentiate it
        {
            if(position == 0){ // use to determine which selection have user selected

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
