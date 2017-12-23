package com.reallycool.harsha.buss;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Names extends Activity {
    EditText tv []; Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_names);
        LinearLayout linLayout = findViewById(R.id.lin);
        // set LinearLayout as a root element of the screen
        tv=new EditText[Dataclass.al.size()];
        Log.e(Dataclass.al.size() + "", " Yes");
        for(int i=0;i< Dataclass.al.size();i++ ) {
            tv [i]= new EditText(this);
            tv[i].setHint("Enter Name "+i);
        linLayout.addView(tv[i]);
    }
          button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (TextView t : tv) {
                    if (t.getText().equals("")) {
                        Toast.makeText(Names.this,"Enter All The Names",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Helper h=new Helper(Names.this, Dataclass.str);
                h.getWritableDatabase();
                for(int i=0;i<Dataclass.al.size();i++  ) {
                    String s []= Dataclass.al.get(i).split(" ");
                    int a=Integer.parseInt(s[0])*10+Integer.parseInt(s[1]);
                    h.addseat(new Seat(a,tv[i].getText().toString(),MainActivity.bdate));
                }
                Toast.makeText(Names.this, "Booked Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}