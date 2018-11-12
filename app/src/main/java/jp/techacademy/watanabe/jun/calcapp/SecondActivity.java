package jp.techacademy.watanabe.jun.calcapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent1 = getIntent();

        Double value1 = intent1.getDoubleExtra("VALUE1", 0);
        Double value2 = intent1.getDoubleExtra("VALUE2", 0);
        String value3 = intent1.getStringExtra("VALUE3");
        String value4 = intent1.getStringExtra("VALUE4");
        String value5 = intent1.getStringExtra("VALUE5");

        TextView textView = (TextView) findViewById(R.id.textView);




            if (value3.equals("たす")) {
                textView.setText(String.valueOf(value1 + value2));
            } else if (value3.equals("ひく")) {
                textView.setText(String.valueOf(value1 - value2));
            } else if (value3.equals("かける")) {
                textView.setText(String.valueOf(value1 * value2));
            } else {

                if (value2 == 0) {
                    textView.setText("計算を表示できません");
                } else {
                    textView.setText(String.valueOf(value1 % value2));
                }

            }



        }


    }
