package jp.techacademy.watanabe.jun.calcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // ①メンバ変数を定義
    EditText EditText1;
    EditText EditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("+");
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("-");
        button2.setOnClickListener(this);


        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("×");
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText("÷");
        button4.setOnClickListener(this);

        EditText1 = (EditText) findViewById(R.id.editText1);
        EditText2 = (EditText) findViewById(R.id.editText2);


    }

    @Override
    public void onClick(View v) {
        String operator = "";


        if (v.getId()==R.id.button1){
            operator = "たす";

        }
        else if (v.getId()==R.id.button2) {
            operator = "ひく";
        }
        else if(v.getId()==R.id.button3){
            operator = "かける";
        }
        else{
            operator="わる";
        }

        String text1 = EditText1.getText().toString();
        String text2 = EditText2.getText().toString();

        if(text1.equals("") ||  text2.equals("")) {
            showAlertDialog();
            return;

        }


        Intent intent1 = new Intent(this, SecondActivity.class);

        intent1.putExtra("VALUE1", Double.parseDouble(EditText1.getText().toString()) );
        intent1.putExtra("VALUE2", Double.parseDouble(EditText2.getText().toString()) );
        intent1.putExtra("VALUE3", operator);

        startActivity(intent1);


        Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("UI-PARTS", "Snackbarをタップした");
                    }
                }).show();

            }
    private void showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("数値を入力してから計算を実行してください");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

        }


