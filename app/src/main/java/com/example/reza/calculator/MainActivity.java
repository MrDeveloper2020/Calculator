package com.example.reza.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.angads25.toggle.LabeledSwitch;
import com.github.angads25.toggle.interfaces.OnToggledListener;

public class MainActivity extends AppCompatActivity {

    private LabeledSwitch labeledSwitch;

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private Button buttonPlus,buttonSub,buttonMul,buttonDiv,buttonAc,buttonDot,buttonEqual,buttonPow,buttonFac;

    public TextView result;

    private float num1,num2;
    private String OP ="";
    private boolean flag = false;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labeledSwitch = (LabeledSwitch)findViewById(R.id.button_switch_light);
        labeledSwitch.setOnToggledListener(new OnToggledListener() {
            @Override
            public void onSwitched(LabeledSwitch labeledSwitch, boolean isOn) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        findView();
        result.setText("0");


    }

    private void findView() {
        button0 = (Button) findViewById(R.id.button_zero_light);
        button1 = (Button) findViewById(R.id.button_one_light);
        button2 = (Button) findViewById(R.id.button_two_light);
        button3= (Button) findViewById(R.id.button_three_light);
        button4 = (Button) findViewById(R.id.button_four_light);
        button5 = (Button) findViewById(R.id.button_five_light);
        button6 = (Button) findViewById(R.id.button_six_light);
        button7 = (Button) findViewById(R.id.button_seven_light);
        button8 = (Button) findViewById(R.id.button_eight_light);
        button9 = (Button) findViewById(R.id.button_nine_light);

        buttonPlus = (Button)findViewById(R.id.button_add_light);
        buttonSub = (Button) findViewById(R.id.button_mines_light);
        buttonMul = (Button) findViewById(R.id.button_multiply_light);
        buttonDiv = (Button) findViewById(R.id.button_division_light);
        buttonPow = (Button) findViewById(R.id.button_power_light);
        buttonFac = (Button) findViewById(R.id.button_factorial_light);
        buttonDot = (Button) findViewById(R.id.button_dot_light);
        buttonAc = (Button) findViewById(R.id.button_ac_light);
        buttonEqual = (Button) findViewById(R.id.button_equal_light);

        result = (TextView) findViewById(R.id.display_light);

    }

    public void Button_Click(View view){

        int id = view.getId();
        if(id == R.id.button_zero_light){
            String tmp = result.getText().toString().trim();
            if (!tmp.equalsIgnoreCase("0")){
                result.append("0");
            }
        }
        else if (id == R.id.button_one_light) setNum(1);
        else if (id == R.id.button_two_light) setNum(2);
        else if (id == R.id.button_three_light) setNum(3);
        else if (id == R.id.button_four_light) setNum(4);
        else if (id == R.id.button_five_light) setNum(5);
        else if (id == R.id.button_six_light) setNum(6);
        else if (id == R.id.button_seven_light) setNum(7);
        else if (id == R.id.button_eight_light) setNum(8);
        else if (id == R.id.button_nine_light) setNum(9);
        else if(id == R.id.button_dot_light){
            if(count ==0 && result.length()!=0){
                result.setText(result.getText()+".");
                count++;
            }
        }
        else if (id == R.id.button_power_light){
            if(result.length()!=0){
                String tmp = result.getText().toString();
                result.setText("("+tmp+")^2");
            }
        }

        else if (id == R.id.button_add_light){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "+";
        }
        else if (id == R.id.button_mines_light){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "-";
        }
        else if (id == R.id.button_multiply_light){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "*";
        }
        else if (id == R.id.button_division_light){
            num1 = Float.parseFloat(result.getText().toString());
            OP = "/";
        }
        else if (id == R.id.button_equal_light){
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
        else if (id == R.id.button_ac_light){
            num1 = num2 = 0;
            OP = "";
            result.setText("0");
            flag = false;
            count=0;
        }

    }

    void setNum(int num){
        String tmp = result.getText().toString();
        if (OP == "") {
            if (tmp.equalsIgnoreCase("0")) result.setText(num);
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
