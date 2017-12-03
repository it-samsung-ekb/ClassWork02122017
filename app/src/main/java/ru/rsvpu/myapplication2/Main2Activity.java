package ru.rsvpu.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Second Activity :)");

        //проверяем наличие значения в интенте по ключу
        if(getIntent().hasExtra("second")){

            //показываем тост в случае если открывали со второй кнопки
            Toast.makeText(getApplicationContext(),getIntent().getStringExtra("second"),Toast.LENGTH_SHORT).show();
        }

        //проверяем наличие значения в интенте по ключу
        if(getIntent().hasExtra("third")){

            //создаём интент для передачи результата на открывшую активити
            Intent intent = new Intent();
            intent.putExtra("result",getIntent().getStringExtra("third")+" YES");
            setResult(RESULT_OK,intent);
            finish(); //закрываем текущую активити
        }
    }
}
