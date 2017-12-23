package com.reallycool.harsha.buss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends Activity {
ListView lv;
static String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = (ListView) findViewById(R.id.listview);
        final ArrayList<String> arrayList = new ArrayList<String>();
        Helper h1 = new Helper(this, "busa");
        Helper h2 = new Helper(this, "busb");
        Helper h3 = new Helper(this, "busc");

        arrayList.add("BusA    -  "+(40-h1.getallseats(1).size())+"Seats left");
        arrayList.add("BusB    -  "+(40-h2.getallseats(1).size())+"Seats left");
        arrayList.add("BusC    -  "+(40-h3.getallseats(1).size())+"Seats left");
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listtext, arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dataclass.str=arrayList.get(i).toString().substring(0,4).toLowerCase();
                Intent intent=new Intent(Main2Activity.this,Dataclass.class);
                startActivity(intent);
            }
        });
    }

}
