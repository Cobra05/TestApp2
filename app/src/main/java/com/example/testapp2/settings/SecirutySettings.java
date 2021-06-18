package com.example.testapp2.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp2.R;

import org.jetbrains.annotations.NotNull;

import java.util.zip.Inflater;

import io.ghyeok.stickyswitch.widget.StickySwitch;

public class SecirutySettings extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sPref = getSharedPreferences("Global" ,MODE_PRIVATE);
        int theme = sPref.getInt("theme", 0);
        if (theme == 0)
            setTheme(R.style.LightTheme);
        else if(theme == 1)
            setTheme(R.style.NightTheme);
        setContentView(R.layout.seciruty_settings_layout);
        SharedPreferences sprf = getSharedPreferences("Global", MODE_PRIVATE);
        String directionn = sprf.getString("Pin", "OFF");

        StickySwitch stck = findViewById(R.id.pin_switch);
        // set switch state
        if(directionn.equals("OFF")){
            stck.setDirection(StickySwitch.Direction.LEFT);
        }else {
            stck.setDirection(StickySwitch.Direction.RIGHT);
        }
        // on/off pin lock
        stck.setOnSelectedChangeListener((direction, s) -> {
            if (direction == StickySwitch.Direction.LEFT){
                sprf.edit().putString("Pin", "OFF").apply();
            }else if (direction == StickySwitch.Direction.RIGHT){
                sprf.edit().putString("Pin", "ON").apply();
                pin_change(stck, sprf, 1);

            }
        });

        // set/change password
        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(v -> {
            if (directionn.equals("OFF")) {
                Toast.makeText(this, "Сначала включите блокировку PIN", Toast.LENGTH_SHORT).show();
            } else if (directionn.equals("ON")){
                pin_change(stck, sprf, 0);
            }
        });
    }

    public void pin_change(StickySwitch stck, SharedPreferences sprf, int code){

        AlertDialog.Builder alrt = new AlertDialog.Builder(this, R.style.Dialog);
        alrt.setTitle("Установить PIN-код");
        View vi = LayoutInflater.from(this).inflate(R.layout.pin_dialog_view, null);
        alrt.setView(vi);
        EditText edit = vi.findViewById(R.id.pin_dialog);

        alrt.setPositiveButton("ОК", (dialog, which) -> {
            String pin = String.valueOf(edit.getText());
            if (pin.length() < 4){
                Toast.makeText(this, "Должен состоять из 4 чисел", Toast.LENGTH_SHORT).show();
                stck.setDirection(StickySwitch.Direction.LEFT);

            }else {
                sprf.edit().putString("Pin-code", pin).apply();
                sprf.edit().putString("Pin", "ON").apply();
            }
        })
                .setNegativeButton("Отмена", (dialog, which) -> {
                    if (code == 0){
                        Toast.makeText(this, "PIN-код не изменён", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "Отменено", Toast.LENGTH_SHORT).show();
                        stck.setDirection(StickySwitch.Direction.LEFT);
                    }
                });
        alrt.create().show();

    }


}