package com.example.scitmaster.memoria;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by SCITMASTER on 2018-03-06.
 */

public class GameSub2 extends Activity {
    ImageView bear;
    ImageView elephant;
    ImageView lion;
    ImageView grape;
    ImageView strawberry;
    ImageView guitar;
    EditText answer;
    Button check;
    int change = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamesub2_activity);//그림카드게임

        bear = (ImageView) findViewById(R.id.bear);
        elephant = (ImageView) findViewById(R.id.elephant);
        lion = (ImageView) findViewById(R.id.lion);
        grape = (ImageView) findViewById(R.id.grape);
        strawberry = (ImageView) findViewById(R.id.strawberry);
        guitar =(ImageView) findViewById(R.id.guitar);
        answer = (EditText) findViewById(R.id.answer);
        check = (Button)findViewById(R.id.check);


    }
    public void Check(View v){
        changeImage();
    }
    private void changeImage(){
        String test = answer.getText().toString();
        if (change == 0 && test.equals("곰")){
            Toast.makeText(GameSub2.this,"정답입니다.",Toast.LENGTH_SHORT).show();
            bear.setVisibility(View.INVISIBLE);
            answer.setText("");
            elephant.setVisibility(View.VISIBLE);

            change++;
        }
        else if(change == 1 && test.equals("코끼리")){
            Toast.makeText(GameSub2.this,"정답입니다.",Toast.LENGTH_SHORT).show();
            elephant.setVisibility(View.INVISIBLE);
            answer.setText("");
            lion.setVisibility(View.VISIBLE);

            change++;
        }
        else if(change == 2 && test.equals("사자")){
            Toast.makeText(GameSub2.this,"정답입니다.",Toast.LENGTH_SHORT).show();
            lion.setVisibility(View.INVISIBLE);
            answer.setText("");
            grape.setVisibility(View.VISIBLE);

            change++;
        }
        else if(change == 3 && test.equals("포도")){
            Toast.makeText(GameSub2.this,"정답입니다.",Toast.LENGTH_SHORT).show();
            grape.setVisibility(View.INVISIBLE);
            answer.setText("");
            strawberry.setVisibility(View.VISIBLE);

            change++;
        }
        else if(change == 4 && test.equals("딸기")){
            Toast.makeText(GameSub2.this,"정답입니다.",Toast.LENGTH_SHORT).show();
            strawberry.setVisibility(View.INVISIBLE);
            answer.setText("");
            guitar.setVisibility(View.VISIBLE);

            change++;
        }
        else if(change == 5 && test.equals("기타")){
            Toast.makeText(GameSub2.this,"정답입니다.",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder b3 = new AlertDialog.Builder(GameSub2.this);
            b3.setTitle("수고하셨습니다.");
            b3.setMessage("메인메뉴로 돌아가시겠습니까?");
            b3.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent4 = new Intent(GameSub2.this,MainActivity.class);
                    startActivity(intent4);
                }
            });
            b3.setNegativeButton("재시작", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent5 = new Intent(GameSub2.this,GameSub2.class);
                    startActivity(intent5);
                }
            });
            b3.show();
        }
        else {
            Toast.makeText(GameSub2.this,"다시적어주세요.",Toast.LENGTH_SHORT).show();
        }
    }

}
