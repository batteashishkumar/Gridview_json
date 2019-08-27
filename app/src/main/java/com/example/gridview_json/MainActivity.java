package com.example.gridview_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String json;
    ArrayList<String> mylist;
    List<Obj> mylist_obj;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = new ArrayList<String>();
        mylist_obj = new ArrayList<Obj>();
        t=findViewById(R.id.empty);
        json = "{\n" +
                "        \"0\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"title\": \"you\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "        \"id\": \"1\",\n" +
                "        \"title\": \"Baseball\"\n" +
                "        },\n" +
                "        \"2\": {\n" +
                "        \"id\": \"2\",\n" +
                "        \"title\": \"Two\"\n" +
                "        },\n" +
                "        \"3\": {\n" +
                "        \"id\": \"3\",\n" +
                "        \"title\": \"ashish\"\n" +
                "        },\n" +
                "        \"4\": {\n" +
                "        \"id\": \"4\",\n" +
                "        \"title\": \"raju \"\n" +
                "        },\n" +
                "        \"5\": {\n" +
                "        \"id\": \"5\",\n" +
                "        \"title\": \"rajsheaker \"\n" +
                "        },\n" +
                "        \"6\": {\n" +
                "        \"id\": \"6\",\n" +
                "        \"title\": \"srikanth \"\n" +
                "        },\n" +
                "        \"7\": {\n" +
                "        \"id\": \"7\",\n" +
                "        \"title\": \"prem \"\n" +
                "        },\n" +
                "        \"8\": {\n" +
                "        \"id\": \"8\",\n" +
                "        \"title\": \"again\"\n" +
                "        }\n" +
                "\n" +
                "        }";
        t.setText(json);
        t.setMovementMethod(new ScrollingMovementMethod());
        list_update();

    }


    @Override
    public void onStart() {
        super.onStart();
        try {
            JSONObject mainObject = new JSONObject(json);
            for (int i = 0; i < 9; i++) {
                JSONObject Object = mainObject.getJSONObject(String.valueOf(i));
                String name = Object.getString("id");
                String url = Object.getString("title");
                Obj x = new Obj(name, url);
                mylist_obj.add(x);
            }
        } catch (Exception e) {
        }
    }

    public void list_update() {
        List_adapter adapter=new List_adapter(this,mylist_obj);

        GridView listView =  findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

    }


}