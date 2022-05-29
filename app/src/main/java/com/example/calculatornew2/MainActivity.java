package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView out, out2;
    Button one, two, three, four, five, six, seven, eight, nine, note, ac, percentage, multiple,
            divide, mine, plus, point, equal, back, change;

    float val1, val2, val3;
    String clear;
    boolean Plus, Plus2, Divide, Subtract, Multiply, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out = findViewById(R.id.txtout);
        out2 = findViewById(R.id.txtout2);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        note = findViewById(R.id.btn0);
        ac = findViewById(R.id.btnac);
        percentage = findViewById(R.id.btnpercent);
        multiple = findViewById(R.id.btnmulti);
        divide = findViewById(R.id.btndiv);
        mine = findViewById(R.id.btnmin);
        plus = findViewById(R.id.btnplus);
        point = findViewById(R.id.btnpoint);
        equal = findViewById(R.id.btnequal);
        back = findViewById(R.id.btnback);
        change = findViewById(R.id.button17);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        out.requestFocus();
        out2.requestFocus();

        database myDB = new database(this);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "1");
                out2.setText(out2.getText() +"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "2");
                out2.setText(out2.getText() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "3");
                out2.setText(out2.getText() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "4");
                out2.setText(out2.getText() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "5");
                out2.setText(out2.getText() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "6");
                out2.setText(out2.getText() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "7");
                out2.setText(out2.getText() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "8");
                out2.setText(out2.getText() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "9");
                out2.setText(out2.getText() + "9");
            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + "0");
                out2.setText(out2.getText() + "0");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(out.getText() + ".");
                out2.setText(out2.getText() + ".");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(out.getText().toString().equals(""))
                {
                    out.setText("");
                }else
                {
                    val1 = Float.parseFloat(out.getText() + "");
                    Plus = true;
                    out.setText(null);
                    out2.setText(val1 + "+");
                }
            }
        });
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(out.getText().toString().equals(""))
                {
                    out.setText("");
                }
                else
                {
                    val1 = Float.parseFloat(out.getText() + "");
                    Subtract = true;
                    out.setText(null);
                    out2.setText(val1 + "-");
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(out.getText().toString().equals(""))
                {
                    out.setText("");
                }
                else
                {
                    val1 = Float.parseFloat(out.getText() + "");
                    Divide = true;
                    out.setText(null);
                    out2.setText(val1 + "/");
                }
            }
        });
        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(out.getText().toString().equals(""))
                {
                    out.setText("");
                }
                else
                {
                    val1 = Float.parseFloat(out.getText() + "");
                    Multiply = true;
                    out.setText(null);
                    out2.setText(val1 + "*");
                }
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(out.getText().toString().equals(""))
                {
                    out.setText("");
                }
                else
                {
                    val1 = Float.parseFloat(out.getText() + "");
                    out.setText(val1/100 + "");
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (out.getText().toString().equals(""))
                {
                    out.setText("");
                }
                else
                {
                    val2 = Float.parseFloat(out.getText() + "");
                    if (Plus)
                    {
                        out.setText(val1 + val2 + "");
                        Plus = false;
                    }
                    if (Subtract)
                    {
                        out.setText(val1 - val2 + "");
                        Subtract = false;
                    }
                    if (Divide)
                    {
                        out.setText(val1 / val2 +"");
                        Divide = false;
                    }
                    if (Multiply)
                    {
                        out.setText(val1 * val2 + "");
                        Multiply = false;
                    }
                }

            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText(null);
                out2.setText(null);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (out.getText().toString().equals(""))
                {
                    out.setText("");
                }else
                {
                    clear = out.getText().toString();
                    Back = true;
                    out.setText(clear.substring(0, clear.length() -1));
                }
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!out.getText().toString().equals(""))
                {
                    Cursor check = myDB.viewPinDet();
                    if(check.getCount()==0)
                    {
                        Intent i = new Intent(MainActivity.this,createPinFirstTimeUse.class); //create new pin
                        startActivity(i);
                        out.setText(null);
                        out2.setText(null);
                    }
                    else
                    {
                        Cursor hideFrame = myDB.viewPinDet();
                        if(hideFrame.getCount()!=0)
                        {
                            while (hideFrame.moveToNext())
                            {
                                if(out.getText().toString().equals(hideFrame.getString(1)))
                                {
                                    Intent i = new Intent(MainActivity.this,hideFrame.class);
                                    startActivity(i);
                                    out.setText(null);
                                    out2.setText(null);
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this, "Incorrect PIN! try again", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(MainActivity.this, frm2.class);
                                    startActivity(i);
                                }
                            }
                        }
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Type pin and click to enter valet", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, frm2.class);
                    startActivity(i);
                }
            }
        });
    }
}