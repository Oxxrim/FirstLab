package ua.kpi.firstlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String[] authors = {"Пушкін", "Шевченко", "Булгаков", "Украинка"};
    String item = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = findViewById(R.id.authors);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, authors);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                item = (String) parent.getItemAtPosition(position);
            }


            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }




    public void sendMessage(View view) {
        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        String year = editText.getText().toString();
        textView.setText(item + " " + year);
    }
}
