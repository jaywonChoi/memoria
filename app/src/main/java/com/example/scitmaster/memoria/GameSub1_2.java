package com.example.scitmaster.memoria;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by SCITMASTER on 2018-03-10.
 */

public class GameSub1_2 extends Activity {
    ImageButton bt1;
    ImageButton bt2;
    ImageButton bt3;
    ImageButton bt4;
    ImageButton bt5;
    ImageButton bt6;
    ImageButton bt7;
    ImageButton bt8;
    ImageButton bt9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamesub2);

        bt1 = (ImageButton)findViewById(R.id.bt1);
        bt2 = (ImageButton)findViewById(R.id.bt2);
        bt3 = (ImageButton)findViewById(R.id.bt3);
        bt4 = (ImageButton)findViewById(R.id.bt4);
        bt5 = (ImageButton)findViewById(R.id.bt5);
        bt6 = (ImageButton)findViewById(R.id.bt6);
        bt7 = (ImageButton)findViewById(R.id.bt7);
        bt8 = (ImageButton)findViewById(R.id.bt8);
        bt9 = (ImageButton)findViewById(R.id.bt9);
    }
    int count = 0;

    public void NumberClick2(View v){
        switch (v.getId()){
            case R.id.bt1:
                if(count == 0){
                    bt1.setVisibility(View.INVISIBLE);
                    count++;
                }
                break;
            case R.id.bt2:
                if(count == 1){
                    bt2.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt3:
                if(count == 2){
                    bt3.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt4:
                if(count == 3){
                    bt4.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt5:
                if(count == 4){
                    bt5.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt6:
                if(count == 5){
                    bt6.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt7:
                if(count == 6){
                    bt7.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt8:
                if(count == 7){
                    bt8.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt9:
                if(count == 8){
                    bt9.setVisibility(View.INVISIBLE);
                    count++;
                }
                else {
                    Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this,"다시 눌러주세요!",Toast.LENGTH_SHORT).show();
                break;
        }
        if(count == 9){
            AlertDialog.Builder b2 = new AlertDialog.Builder(GameSub1_2.this);
            b2.setTitle("잘하셨습니다.");
            b2.setMessage("홈으로 돌아가시겠습니까?");
            b2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(GameSub1_2.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            b2.setNegativeButton("재시작", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent2 = new Intent(GameSub1_2.this,GameSub1_2.class);
                    startActivity(intent2);
                }
            });
            b2.show();
        }
    }
}
