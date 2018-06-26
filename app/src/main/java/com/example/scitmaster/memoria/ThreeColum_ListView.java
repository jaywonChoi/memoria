package com.example.scitmaster.memoria;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class ThreeColumn_ListAdapter extends ArrayAdapter<Memo> {
    private LayoutInflater mInflater;
    private ArrayList<Memo> memo;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<Memo> memo) {
        super(context, textViewResourceId, memo);
        this.memo = memo;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Memo memos = memo.get(position);

        if (memos != null) {
            TextView title = (TextView) convertView.findViewById(R.id.text_title);
            TextView context = (TextView) convertView.findViewById(R.id.text_context);
            TextView id = (TextView)convertView.findViewById(R.id.text_id);

            if( id != null){
                id.setText(memos.getId());
            }

            if (title != null) {
                title.setText(memos.getTitle());
            }
            if (context != null) {
                context.setText((memos.getContext()));
            }
        }

        return convertView;
    }
}
