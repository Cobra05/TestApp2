package com.example.protivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MethodsActivity extends AppCompatActivity {

    private String[] methods = new String[] {"Правила Трёх НЕ", "Метод EVOLUTION: Теория", "Метод EVOLUTION: Практика", "Метод ЭПРОМ: Часть 1", "Метод ЭПРОМ: Часть 2", "Метод ЭПРОМ: Часть 3", "Методика Красного Дракона", "Практика Красного Дракона"};

    private String[] tripleno = new String[] {"О методе", "Немного теории"};
    private String[] evolutiontheory = new String[] {"Введение", "Заблуждения", "...Часть II: Внутри головы...", "Амигдала", "Удушающая петля цивилизации", "Дофаминовые горки", "Автопилот на магистрали", "То из за чего ты никогда не бросишь ПиО", "Виденье общей картины", "Транстеоретическая модель изменения поведения"};
    private String[] evolutionpractic = new String[] {"Введение", "Постановка спринта", "Алгоритм срыва", "Работа с подсознанием", "Тренируем волю. Дыхательная практика", "Убеждение амигдалы", "Из Искры разжигаем пламя"};
    private String[] eprom1 = new String[] {"Введение", "5 химических элементов", "Цикл формирования зависимости", "Как работает человеческий мозг", "Раздражители, влияющие на «рептильный» мозг", "Эмоциональный мозг"};
    private String[] eprom2 = new String[] {"Простые способы вернуть мозг в сознательное состояние", "Составление личного плана", "Лучшее, что вы можете сделать для восстановления прямо сегодня", "Как правильно использовать ERP.", "A-B-C-D-E - модель, которая изменит вашу жизнь"};
    private String[] eprom3 = new String[] {"Важная стратегия, которая поможет вам освободиться", "7 убеждений, которые мешали мне избавиться от зависимости", "Как справиться с внешними возбудителями или техника \"мини-ERP\"", "О чем говорят триггеры?", "Что вы хотите от жизни? Очень важное упражнение"};
    private String[] methodicofreddragon = new String[] {"Введение", "Шаг 1.", "Шаг 2.", "Шаг 3.", "Шаг 4.", "Шаг 5.", "Послесловие"};
    private String[] practiceofreddragon = new String[] {"Введение", "Изоляция", "Лечение"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sPref = getSharedPreferences("Global", MODE_PRIVATE);
        int theme = sPref.getInt("theme", 0);
        if (theme == 0)
            setTheme(R.style.LightTheme);
        else if(theme == 1)
            setTheme(R.style.NightTheme);
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
        for (String punkt : eprom1){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String punkt : eprom2){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String punkt : eprom3){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);


        childDataItemList = new ArrayList<>();
        for (String punkt : methodicofreddragon){
            map = new HashMap<>();
            map.put("punkt", punkt);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String punkt : practiceofreddragon){
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
            }
            else if(groupPosition == 1){
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
            }
            else if(groupPosition == 2){
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
            else if(groupPosition == 3){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m30");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m31");
                        startActivity(webView);
                        break;
                    case 2:
                        webView.putExtra("method", "m32");
                        startActivity(webView);
                        break;
                    case 3:
                        webView.putExtra("method", "m33");
                        startActivity(webView);
                        break;
                    case 4:
                        webView.putExtra("method", "m34");
                        startActivity(webView);
                        break;
                    case 5:
                        webView.putExtra("method", "m35");
                        startActivity(webView);
                        break;

                }
            }
            else if(groupPosition == 4){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m40");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m41");
                        startActivity(webView);
                        break;
                    case 2:
                        webView.putExtra("method", "m42");
                        startActivity(webView);
                        break;
                    case 3:
                        webView.putExtra("method", "m43");
                        startActivity(webView);
                        break;
                    case 4:
                        webView.putExtra("method", "m44");
                        startActivity(webView);
                        break;
                }
            }
            else if(groupPosition == 5){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m50");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m51");
                        startActivity(webView);
                        break;
                    case 2:
                        webView.putExtra("method", "m52");
                        startActivity(webView);
                        break;
                    case 3:
                        webView.putExtra("method", "m53");
                        startActivity(webView);
                        break;
                    case 4:
                        webView.putExtra("method", "m54");
                        startActivity(webView);
                        break;

                }
            }
            else if(groupPosition == 6){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m60");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m61");
                        startActivity(webView);
                        break;
                    case 2:
                        webView.putExtra("method", "m62");
                        startActivity(webView);
                        break;
                    case 3:
                        webView.putExtra("method", "m63");
                        startActivity(webView);
                        break;
                    case 4:
                        webView.putExtra("method", "m64");
                        startActivity(webView);
                        break;
                    case 5:
                        webView.putExtra("method", "m65");
                        startActivity(webView);
                        break;
                    case 6:
                        webView.putExtra("method", "m66");
                        startActivity(webView);
                        break;

                }
            }
            else if(groupPosition == 7){
                switch (childPosition){
                    case 0:
                        webView.putExtra("method", "m70");
                        startActivity(webView);
                        break;
                    case 1:
                        webView.putExtra("method", "m71");
                        startActivity(webView);
                        break;
                    case 2:
                        webView.putExtra("method", "m72");
                        startActivity(webView);
                        break;
                }
            }
            return false;
        });

    }
}

