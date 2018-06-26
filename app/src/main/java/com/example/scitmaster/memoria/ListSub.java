package com.example.scitmaster.memoria;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ListSub extends Activity {
    DatabaseHelper databaseHelper;
    static ArrayList<Memo> memolist;
    Memo memo;
    ListView listView;
    TextView id;
    Button back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        databaseHelper = new DatabaseHelper(this);
        id = (TextView) findViewById(R.id.text_id);
        back = (Button)findViewById(R.id.back);

        memolist = new ArrayList<>();
        Cursor data = databaseHelper.getListContents();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(ListSub.this,"데이터가 없습니다.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                memo = new Memo(data.getString(0),data.getString(1),data.getString(2));
                memolist.add(i,memo);
                i++;

            }

            ThreeColumn_ListAdapter adapter =  new ThreeColumn_ListAdapter(this,R.layout.list_adapter, memolist);
            listView = (ListView) findViewById(R.id.listview);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                    //String title = adapterView.getItemAtPosition(i).toString();
                    String title = memolist.get(i).getTitle().toString();
                    String context = memolist.get(i).getContext().toString();
                    Cursor data = databaseHelper.getItemID(title);
                   // Intent intent = new Intent(ListSub.this,EditSub.class);

                    //memo객체
                    int itemid = -1;
                    while (data.moveToNext()){
                        itemid = data.getInt(0);
                    }
                    if (itemid > -1){
                       Log.d(TAG,"id ="+itemid);
                        Log.d(TAG,"title ="+title);
                        Log.d(TAG,"context ="+context);

                        //수정으로 값보내기
                       Intent intent = new Intent(ListSub.this,EditSub.class);
                       intent.putExtra("id",itemid);
                       intent.putExtra("title",title);
                       intent.putExtra("context",context);
                       startActivity(intent);
                    }
                    //startActivity(intent);

                    //Toast.makeText(ListSub.this,title,Toast.LENGTH_SHORT).show();

                }
            });
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(ListSub.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(ListSub.this,"메뉴화면으로 돌아갑니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
