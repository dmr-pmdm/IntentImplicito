package com.example.intentimplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnContactos, btnLlamar, btnDial, btnNavegador, btnMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.btnContactos:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                } else {
                    Toast.makeText(this, "IRRESOLUBLE", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnDial:
                i = new Intent(Intent.ACTION_DIAL);
                startActivity(i);
                break;
            case R.id.btnLlamar:
                i = new Intent(Intent.ACTION_CALL, Uri.parse("tel: (+34) 986112233"));
                startActivity(i);
                break;
            case R.id.btnNavegador:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.edu.xunta.gal/portal"));
                startActivity(i);
                break;
            case R.id.btnMapa:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 42.25,-8.68"));
                startActivity(i);
                break;
        }
    }
}
