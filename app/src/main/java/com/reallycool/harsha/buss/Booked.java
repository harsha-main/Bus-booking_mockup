package com.reallycool.harsha.buss;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Booked extends Activity {
ArrayList<String> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        al = new ArrayList<String>();
        ListView lv = findViewById(R.id.lv);
        Helper h1 = new Helper(this, "busa");
        Helper h2 = new Helper(this, "busb");
        Helper h3 = new Helper(this, "busc");

        List<Seat> l= h1.getallseats(0);
        if(l.size()>0){
            al.add("BusA");
            for (Seat s : l) {al.add(s.name+", Seat:"+s.id+", Date"+s.date);}
            al.add(" ");
        }
        l= h2.getallseats(0);
        if(l.size()>0){
            al.add("BusB");
            for (Seat s : l) {al.add(s.name+", Seat:"+s.id+", Date"+s.date);}
            al.add(" ");
        }
        l= h3.getallseats(0);
        if(l.size()>0){
            al.add("BusC");
            for (Seat s : l) {al.add(s.name+", Seat:"+s.id+", Date"+s.date);}
        }

        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listtext, al);
        lv.setAdapter(adapter);
    }

}
