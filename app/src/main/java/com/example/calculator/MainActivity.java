package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enterNumber,answer;
    private TextView heading;
    private TableRow tableRow1,tableRow3,tableRow4,tableRow5,tableRow6,tableRow7;
    private TableRow tableRow2;
    private Button pi,e,factorial,power,blank,cos,log,sin,tan,root,ln,inverse,radian;
    private ImageButton expand_btn;
    private Boolean isText=false;
    private TableLayout tableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterNumber = findViewById(R.id.enterDigit_editText);
        enterNumber.setShowSoftInputOnFocus(false);
        tableRow1=findViewById(R.id.rowOne);
        tableRow2=findViewById(R.id.rowTwo);
        pi = findViewById(R.id.pi);
        e = findViewById(R.id.e);
        factorial = findViewById(R.id.factorial);
        power= findViewById(R.id.power);
        blank = findViewById(R.id.blank);
        expand_btn = findViewById(R.id.expend);
        cos = findViewById(R.id.cos);
        log = findViewById(R.id.log);
        sin = findViewById(R.id.sin);
        tan = findViewById(R.id.tan);
        root = findViewById(R.id.root);
        ln = findViewById(R.id.ln);
        inverse = findViewById(R.id.inverse);
        radian = findViewById(R.id.rad);
        tableRow3=findViewById(R.id.threeRow);
        tableRow4 = findViewById(R.id.FourRow);
        tableRow5 = findViewById(R.id.FiveRow);
        tableRow6 = findViewById(R.id.SixRow);
        tableRow7 = findViewById(R.id.SevenRow);
        answer = findViewById(R.id.finalAnswer);
        heading = findViewById(R.id.calculator);

    enterNumber.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            enterNumber.setCursorVisible(true);
            Log.d("TAG", "onClick: ");
            isText = false;
            int position = enterNumber.length();
            enterNumber.setSelection(position);
        }
    });
    }

    public void update(String number){
            enterNumber.setVisibility(View.VISIBLE);
             heading.setVisibility(View.GONE);
             answer.setText("");
             enterNumber.setTextSize(55);
        answer.setTextSize(25);
             if(isText){
                 enterNumber.setText(number);
                 answer.setText("");
                 int cursorPos = enterNumber.getSelectionStart();
                 enterNumber.setSelection(cursorPos+1);
                 isText=false;
             }else{
        String text= enterNumber.getText().toString();
        int cursorPos = enterNumber.getSelectionStart();
        String oldString = text.substring(0,cursorPos);
        String newString = text.substring(cursorPos);
        enterNumber.setText(String.format("%s%s%s", oldString, number, newString));
        enterNumber.setSelection(cursorPos+1);}

    }
    public void cos(View view) {
        if(inverse.getCurrentTextColor()==Color.BLACK) {
            update("cos(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+3);
        }else{
            update("acos(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+4);
        }

    }

    public void equal(View view) {
        enterNumber.setCursorVisible(false);
        String userExp = enterNumber.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
         enterNumber.setTextSize(25);
        answer.setText(result);
        answer.setTextSize(55);
         int cursorPos = enterNumber.length();
        enterNumber.setSelection(cursorPos);
        isText=true;

    }

    public void point(View view) {update(".");}

    public void zero(View view) {update(("0"));}

    public void expand(View view) {
        if(tableRow2.getVisibility()==View.VISIBLE){
            expand_btn.setImageResource(R.drawable.ic_baseline_expand_less_24);
            tableRow1.setVisibility(View.GONE);
            pi.setVisibility(View.GONE);
            e.setVisibility(View.GONE);
            factorial.setVisibility(View.GONE);
            power.setVisibility(View.GONE);
            blank.setVisibility(View.GONE);
            tableRow2.setVisibility(View.GONE);
            tableRow3.setBackgroundColor(getResources().getColor(R.color.bg));
         tableRow4.setBackgroundColor(getResources().getColor(R.color.bg));
          tableRow5.setBackgroundColor(getResources().getColor(R.color.bg));
           tableRow6.setBackgroundColor(getResources().getColor(R.color.bg));
            tableRow7.setBackgroundColor(getResources().getColor(R.color.bg));

        }else{
            expand_btn.setImageResource(R.drawable.ic_baseline_expand_more_24);
            tableRow1.setVisibility(View.VISIBLE);
            pi.setVisibility(View.VISIBLE);
            e.setVisibility(View.VISIBLE);
            factorial.setVisibility(View.VISIBLE);
            power.setVisibility(View.VISIBLE);
            blank.setVisibility(View.VISIBLE);
            tableRow2.setVisibility(View.VISIBLE);
            tableRow3.setBackgroundColor(getResources().getColor(R.color.white));
         tableRow4.setBackgroundColor(getResources().getColor(R.color.white));
          tableRow5.setBackgroundColor(getResources().getColor(R.color.white));
           tableRow6.setBackgroundColor(getResources().getColor(R.color.white));
            tableRow7.setBackgroundColor(getResources().getColor(R.color.white));

        }

    }

    public void plus(View view) {update("+");}

    public void power(View view) {update("^");}

    public void three(View view) {update("3");}

    public void two(View view) {update("2");}

    public void one(View view) {update("1");}

    public void minus(View view) {update("-");}

    public void factorial(View view) {update("!");}

    public void six(View view) {update("6");}

    public void five(View view) {
        update("5");}

    public void four(View view) {update("4");}

    public void multiply(View view) {update("*");}

    public void e(View view) {update("e");}

    public void nine(View view) {update("9");}

    public void eight(View view) {update("8");}

    public void seven(View view) {update("7");}

    public void divide(View view) {update("/");}

    public void pi(View view) {update(String.valueOf(Math.PI));}

    public void percent(View view) {update("%");
    }

    public void Backspace(View view) {
        String oldText = enterNumber.getText().toString();
        int cursorPos = enterNumber.length();
        if(!oldText.isEmpty() && cursorPos !=0) {
            String newText = oldText.substring(0, oldText.length() - 1);
            enterNumber.setText(newText);
            enterNumber.setSelection(cursorPos-1);

        }
    }

    public void AllClear(View view) {
        heading.setVisibility(View.VISIBLE);
        enterNumber.setVisibility(View.GONE);
        enterNumber.setText("");
    answer.setText("");}

    public void inverse(View view) {
        if(inverse.getCurrentTextColor()==Color.BLACK) {
            inverse.setTextColor(Color.RED);
            cos.setText(R.string.trigArcCosText);
            sin.setText(R.string.trigArcSinText);
            log.setText(R.string.xPowerYText);
            tan.setText(R.string.trigArcTanText);
            root.setText(R.string.xSquaredText);
            ln.setText(R.string.eSquaredText);
        }else{
            inverse.setTextColor(Color.BLACK);
            cos.setText(R.string.cos);
            sin.setText(R.string.sin);
            log.setText(R.string.log);
            tan.setText(R.string.tan);
            root.setText(R.string.root);
            ln.setText(R.string.ln);
        }
    }

    public void ln(View view) {
        if (inverse.getCurrentTextColor() == Color.BLACK) {
            update("ln(");
            int cursorPos = enterNumber.getSelectionStart();
            enterNumber.setSelection(cursorPos + 2);
        } else {
            update("e^");
            int cursorPos = enterNumber.getSelectionStart();
            enterNumber.setSelection(cursorPos + 1);
        }
    }


    public void root(View view) {
        if(inverse.getCurrentTextColor()==Color.BLACK) {
            update("sqrt(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+4);
        }else{
            update("^2");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+1);
        }
    }

    public void tan(View view) {
        if(inverse.getCurrentTextColor()==Color.BLACK) {
            update("tan(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+3);
        }else{
            update("atan(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+4);
        }
    }

    public void sin(View view) {
       if(inverse.getCurrentTextColor()==Color.BLACK) {
            update("sin(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+3);
        }else{
            update("asin(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+4);
        }
        }

    public void radian(View view) {
        if(radian.getText()==getResources().getString(R.string.radian)){
            radian.setText(R.string.deg);
        }else{
            radian.setText(R.string.radian);
        }
    }

    public void closeBracket(View view) {update(")");}

    public void openBracket(View view) {update("(");}

    public void log(View view) {
        if(inverse.getCurrentTextColor()==Color.BLACK) {
            update("log10(");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+5);
        }else{
            update("10^");
             int cursorPos = enterNumber.getSelectionStart();
        enterNumber.setSelection(cursorPos+2);
        }
    }

}