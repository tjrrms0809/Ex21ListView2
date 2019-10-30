package com.ahnsafety.ex21listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;

    ArrayList<String> datas= new ArrayList<String>();

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 Data
        datas.add(new String("aaa"));
        datas.add(new String("bbb"));
        datas.add("ccc");

        et= findViewById(R.id.et);
        listView= findViewById(R.id.listview);

        //대량의 데이터(datas)들을 View객체로 만들어주는
        //작업을 수행하는 Adapter객체 생성
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);

        //리스트뷰의 항목이 비어있을때 보여지는 설정
        TextView tvEmptyList= findViewById(R.id.tv_empty_list);
        listView.setEmptyView(tvEmptyList);

        //리스트의 항목을 롱클릭하는 것을 듣는 리스너
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                datas.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    public void clickBtn(View view) {
        //EditText 에 있는 글씨를 얻어와서
        String str= et.getText().toString();

        //대량의 데이터에 추가하여
        datas.add(str);

        // ListView의 항목이 늘어나도록!!
        // Adapter에게 데이터가 변경되었다는 것을
        // 반드시 공지해야만 리스트뷰가 갱신됨
        adapter.notifyDataSetChanged();
        //리스트 뷰의 스크롤 위치 지정
        listView.setSelection(datas.size()-1);
        //EditText에 써있는
        et.setText("");
    }

}
