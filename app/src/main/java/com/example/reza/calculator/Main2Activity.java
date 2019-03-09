package com.example.reza.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.angads25.toggle.LabeledSwitch;
import com.github.angads25.toggle.interfaces.OnToggledListener;

public class Main2Activity extends AppCompatActivity {

    private LabeledSwitch labeledSwitch;

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private Button buttonPlus,buttonSub,buttonMul,buttonDiv,buttonAc,buttonDot,buttonEqual,buttonPow,buttonFac;

    private TextView result;

    private float num1,num2;
    private String OP ="";
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        labeledSwitch = (LabeledSwitch)findViewById(R.id.button_switch_night);
        labeledSwitch.setOnToggledListener(new OnToggledListener() {
            @Override
            public void onSwitched(LabeledSwitch labeledSwitch, boolean isOn) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        result.setText("0");
        findView();
    }

    private void findView() {
        button0 = (Button) findViewById(R.id.button_zero_night);
        button1 = (Button) findViewById(R.id.button_one_night);
        button2 = (Button) findViewById(R.id.button_two_night);
        button3= (Button) findViewById(R.id.button_three_night);
        button4 = (Button) findViewById(R.id.button_four_night);
        button5 = (Button) findViewById(R.id.button_five_night);
        button6 = (Button) findViewById(R.id.button_six_night);
        button7 = (Button) findViewById(R.id.button_seven_night);
        button8 = (Button) findViewById(R.id.button_eight_night);
        button9 = (Button) findViewById(R.id.button_nine_night);

        buttonPlus = (Button)findViewById(R.id.button_add_night);
        buttonSub = (Button) findViewById(R.id.button_mines_night);
        buttonMul = (Button) findViewById(R.id.button_multiply_night);
        buttonDiv = (Button) findViewById(R.id.button_division_night);
        buttonPow = (Button) findViewById(R.id.button_power_night);
        buttonFac = (Button) findViewById(R.id.button_factorial_night);
        buttonDot = (Button) findViewById(R.id.button_dot_night);
        buttonAc = (Button) findViewById(R.id.button_ac_night);
        buttonEqual = (Button) findViewById(R.id.button_equal_night);

        result = (TextView) findViewById(R.id.display_night);

    }

    public void Button_Click(View view){

        int id = view.getId();
        if(id == R.id.button_zero_night){
            String tmp = result.getText().toString().trim();
            if (!tmp.equalsIgnoreCase("0")){
                result.append("0");
            }
        }
        else if (id == R.id.button_one_night) setNum(1);
        else if (id == R.id.button_two_night) setNum(2);
        else if (id == R.id.button_three_night) setNum(3);
        else if (id == R.id.button_four_night) setNum(4);
        else if (id == R.id.button_five_night) setNum(5);
        else if (id == R.id.button_six_night) setNum(6);
        else if (id == R.id.button_seven_night) setNum(7);
        else if (id == R.id.button_eight_night) setNum(8);
        else if (id == R.id.button_nine_night) setNum(9);

        else if (id == R.id.button_add_night){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "+";
        }
        else if (id == R.id.button_mines_night){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "-";
        }
        else if (id == R.id.button_multiply_night){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "*";
        }
        else if (id == R.id.button_division_night){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "/";
        }
        else if (id == R.id.button_equal_night){
            num2 = Float.parseFloat(result.getText().toString());
            float res=0;
            if (OP == "+"){
                res = num1 + num2;
            }
            if (OP == "-"){
                res = num1 - num2;
            }
            if (OP == "*"){
                res = num1 * num2;
            }
            if (OP == "/"){
                res = num1 / num2;
            }

            result.setText(res + "");
            num1 = num2 = 0;
            OP = "";
        }
        else if (id == R.id.button_ac_night){
            num1 = num2 = 0;
            OP = "";
            result.setText("0");
            flag = false;
        }

    }

    void setNum(int num){
        String tmp = result.getText().toString();
        if (OP == "") {
            if (tmp.equalsIgnoreCase("0")) result.setText(num + "");
            else
                result.setText(tmp + num);
        }
        else {
            if (flag == false){
                result.setText(num + "");
                flag = true;
            }
            else {
                result.setText(tmp + num);
            }


        }
    }
}
