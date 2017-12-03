package ru.rsvpu.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /**
     * обявляем view-элементы в качестве свойств класса
     * */
    Button btn1,btn2,btn3;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btn1.setOnClickListener(v -> {
            //создаём интент для зпуска Activity
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            //кладём в интент значения с EditText с ключём "second"
            intent.putExtra("second",getTextFromEdit());
            startActivity(intent);

        });

        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("third", getTextFromEdit());

            //запускаем активити для получения с неё результата
            startActivityForResult(intent,1);
        });


    }

    /**
     * Переопределили метод для получения результата с активити,
     * вызванной с помощью метода startActivityForResult()
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            editText.setText("");
            editText.setText(data.getStringExtra("result"));
        }
    }

    /**
     * метод для инициализации view-элементов
     * */
    void initView(){
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        editText = findViewById(R.id.editText);
    }

    //метод для полчения текстовой переенной с EditText
    String getTextFromEdit(){
        return editText.getEditableText().toString();
    }
}
