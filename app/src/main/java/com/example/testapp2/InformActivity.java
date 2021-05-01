package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class InformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sPref = getSharedPreferences("Global", MODE_PRIVATE);
        int theme = sPref.getInt("theme", 0);
        if (theme == 0)
            setTheme(R.style.LightTheme);
        else if(theme == 1)
            setTheme(R.style.NightTheme);
        setContentView(R.layout.activity_inform);


        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("category");

        String[] list;
        String[] vred = {"Вред онанизма. Научные исследования", "Вред онанизма по пунктам.", "Беседа с урологом на тему онанизма.", "Вреден ли онанизм?", "Вред онанизма - от первого лица", "Среда современного онанизма. Культ онанизма.", "Вред онанизма: потеря семени и ее последствия", "Коротко о вреде онанизма", "Вред онанизма."};
        String[] polza = {"Половое Воздержание", "Онанизм и время", "Что произойдёт с вашим телом и сознанием, если прекратить мастурбировать?", "Половые излишества", "О физиологической пользе воздержания", "Неосновной инстинкт", "Воздержание"};
        String[] soveti = {"1", "2", "3", "4"};
        if(type.equals("vred")){ list = vred; }
        else if(type.equals("polza")){ list = polza; }
        else{list = soveti;}


        ListView lv = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_expandable_list_item_1, list);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), WebView.class);
            int pos = position;
            if(type.equals("vred")){
                intent.putExtra("type", "vred");
                intent.putExtra("id", pos);
                startActivity(intent);
            }
            else if(type.equals("polza")){
                intent.putExtra("type", "polza");
                intent.putExtra("id", pos);
                startActivity(intent);
            }
            else{
                intent.putExtra("type", "sovet");
                intent.putExtra("id", pos);
                startActivity(intent);
            }


        });
    }
}