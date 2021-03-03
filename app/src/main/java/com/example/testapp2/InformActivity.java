package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InformActivity extends AppCompatActivity {

    private String[] methods = new String[] {"Правила Трёх НЕ", "Метод EVOLUTION: Теория", "Метод EVOLUTION: Практика", "Метод ЭПРОМ", "Метод Красного Дракона"};

    private String[] tripleno = new String[] {"О методе", "Немного теории"};
    private String[] evolutiontheory = new String[] {"Введение", "Заблуждения", "...Часть II: Внутри головы...", "Амигдала", "Удушающая петля цивилизации", "Дофаминовые горки", "Автопилот на магистрали", "То из за чего ты никогда не бросишь ПиО", "Виденье общей картины", "Транстеоретическая модель изменения поведения"};
    private String[] evolutionpractic = new String[] {"Введение", "Постановка спринта", "Алгоритм срыва", "Работа с подсознанием", "Тренируем волю. Дыхательная практика", "Убеждение амигдалы", "Из Искры разжигаем пламя"};
    private String[] eprom = new String[] {
            "1",
            "2",
            "3",
            "4",
            "5"};
    private String[] reddragon = new String[] {"1", "2", "3", "4", "5"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inform_activity);

        Map<String, String> map;

        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();

        for (String group : methods){
            map = new HashMap<>();
            map.put("groupName", group);
            groupDataList.add(map);
        }

        String groupFrom[]= new String[] {"groupName"};

        int groupTo[] = new int[]{android.R.id.text1};

        ArrayList<ArrayList<Map<String, String>>> childDataList = new ArrayList<>();

        ArrayList<Map<String, String>> childDataItemList = new ArrayList<>();

        for (String punkt : tripleno){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String punkt : evolutiontheory){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String punkt : evolutionpractic){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String punkt : eprom){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);


        childDataItemList = new ArrayList<>();
        for (String punkt : reddragon){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        String childFrom[] = new String[] {"punkt"};
        int childTo[] = new int[] {android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupDataList, android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo,
                childDataList, android.R.layout.simple_expandable_list_item_1, childFrom, childTo);
        ExpandableListView elv = findViewById(R.id.expand);
        elv.setAdapter(adapter);
        Intent webView = new Intent(this, WebView.class);
        elv.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Toast.makeText(v.getContext(), "Нажато " + groupPosition + id, Toast.LENGTH_SHORT).show();
            if (groupPosition == 0){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m00");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m01");
                        startActivity(webView);
                        break;

                }
            }else if(groupPosition == 1){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m10");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m11");
                        startActivity(webView);
                        break;
                    case 2:
                        webView.putExtra("method", "m12");
                        startActivity(webView);
                        break;
                    case 3:
                        webView.putExtra("method", "m13");
                        startActivity(webView);
                        break;
                    case 4:
                        webView.putExtra("method", "m14");
                        startActivity(webView);
                        break;
                    case 5:
                        webView.putExtra("method", "m15");
                        startActivity(webView);
                        break;
                    case 6:
                        webView.putExtra("method", "m16");
                        startActivity(webView);
                        break;
                    case 7:
                        webView.putExtra("method", "m17");
                        startActivity(webView);
                        break;
                    case 8:
                        webView.putExtra("method", "m18");
                        startActivity(webView);
                        break;
                    case 9:
                        webView.putExtra("method", "m19");
                        startActivity(webView);
                        break;
                }
            }else if(groupPosition == 2){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m20");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m21");
                        startActivity(webView);
                        break;
                    case 2:
                        webView.putExtra("method", "m22");
                        startActivity(webView);
                        break;
                    case 3:
                        webView.putExtra("method", "m23");
                        startActivity(webView);
                        break;
                    case 4:
                        webView.putExtra("method", "m24");
                        startActivity(webView);
                        break;
                    case 5:
                        webView.putExtra("method", "m25");
                        startActivity(webView);
                        break;
                    case 6:
                        webView.putExtra("method", "m26");
                        startActivity(webView);
                        break;
                }
            }
            return false;
        });

    }
}

