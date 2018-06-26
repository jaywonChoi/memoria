package com.example.scitmaster.memoria;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class GameSub extends Activity{
    ImageButton one;
    ImageButton two;
    ImageButton three;
    ImageButton four;
    ImageButton five;
    ImageButton six;
    ImageButton seven;
    ImageButton eight;
    ImageButton nine;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamesub1_activity); //◆ Number Game

        one = (ImageButton) findViewById(R.id.one);
        two = (ImageButton) findViewById(R.id.two);
        three =(ImageButton) findViewById(R.id.three);
        four =(ImageButton)findViewById(R.id.four);
        five =(ImageButton)findViewById(R.id.five);
        six =(ImageButton)findViewById(R.id.six);
        seven =(ImageButton)findViewById(R.id.seven);
        eight =(ImageButton)findViewById(R.id.eight);
        nine =(ImageButton)findViewById(R.id.nine);
    }

    int count = 0;
    public void NumberClick(View v){

        switch (v.getId()){
            case R.id.one:
                 //Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
                 if(count == 0) {
                     one.setVisibility(View.INVISIBLE);
                     count++;
                 }
                break;
            case R.id.two:
                if(count == 1)
                {
                    //Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
                    two.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.three:
                if(count == 2)
                {
                    //Toast.makeText(this,"3",Toast.LENGTH_SHORT).show();
                    three.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.four:
                if(count == 3)
                {
                    //Toast.makeText(this,"4",Toast.LENGTH_SHORT).show();
                    four.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.five:
                if(count == 4)
                {
                    //Toast.makeText(this,"5",Toast.LENGTH_SHORT).show();
                    five.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.six:
                if(count == 5)
                {
                    //Toast.makeText(this,"6",Toast.LENGTH_SHORT).show();
                    six.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.seven:
                if(count == 6)
                {
                    //Toast.makeText(this,"7",Toast.LENGTH_SHORT).show();
                    seven.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.eight:
                if(count == 7)
                {
                    //Toast.makeText(this,"8",Toast.LENGTH_SHORT).show();
                    eight.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nine:
                if(count == 8)
                {
                   // Toast.makeText(this,"9",Toast.LENGTH_SHORT).show();
                    nine.setVisibility(View.INVISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this,"다시 눌러주세요.",Toast.LENGTH_SHORT).show();
                break;
        }
        if(count == 9){
            //Toast.makeText(this,"끝",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder b1 = new AlertDialog.Builder(GameSub.this);
            b1.setTitle("잘하셨습니다.");
            b1.setMessage("다음 레벨로 가시겠습니까?");
            b1.setNegativeButton("홈", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            b1.setPositiveButton("다음", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(GameSub.this,GameSub1_2.class);
                    startActivity(intent);
                }
            });
            b1.show();
        }
    }



}
