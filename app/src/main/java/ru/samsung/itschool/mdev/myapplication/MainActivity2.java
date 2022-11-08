package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    private Button btn;
    public static final String FROM = "from";
    public static final int CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String str = bundle.getString(MainActivity.NAME);
            Snackbar.make(findViewById(R.id.root2),str,Snackbar.LENGTH_LONG).show();
        }
        btn = findViewById(R.id.button3);
        btn.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(FROM, "Data from MainAcitivity2!");
            setResult(CODE, intent);
            finish();
        });

    }
}