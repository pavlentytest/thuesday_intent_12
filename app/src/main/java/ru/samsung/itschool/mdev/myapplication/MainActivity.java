package ru.samsung.itschool.mdev.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn, btn2;
    public static final String NAME = "name";

    private ActivityResultLauncher<Intent> result = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == MainActivity2.CODE) {
                    Toast.makeText(getApplicationContext(),
                                result.getData().getStringExtra(MainActivity2.FROM),
                                Toast.LENGTH_LONG
                        ).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn.setOnClickListener(view -> {
            // неявное намерение
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String url = "https://mirea.ru";
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
        btn2.setOnClickListener(view -> {
            // явное намерение
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra(NAME, "Hello from MainActivity!");
           // startActivity(intent);
            result.launch(intent);
        });


    }

}