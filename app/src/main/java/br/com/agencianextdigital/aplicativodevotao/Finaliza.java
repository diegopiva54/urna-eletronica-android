package br.com.agencianextdigital.aplicativodevotao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Finaliza extends AppCompatActivity {

    Intent i;
    int homer, bart, goku, naruto, branco, nulo, nuloPre, brancoPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaliza);

        i = getIntent();
        homer = i.getIntExtra("homer", homer);
        bart = i.getIntExtra("bart", bart);
        goku = i.getIntExtra("goku", goku);
        naruto = i.getIntExtra("naruto", naruto);
        nulo = i.getIntExtra("nulo", nulo);
        branco = i.getIntExtra("branco", branco);
        nuloPre = i.getIntExtra("nuloPre", nuloPre);
        brancoPre = i.getIntExtra("brancoPre", brancoPre);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Finaliza.this, Principal.class);
                i.putExtra("homer", homer);
                i.putExtra("bart", bart);
                i.putExtra("branco", branco);
                i.putExtra("nulo", nulo);
                i.putExtra("naruto", naruto);
                i.putExtra("goku", goku);
                i.putExtra("nuloPre", nuloPre);
                i.putExtra("brancoPre", brancoPre);
                startActivity(i);
            }
        }, 5000);
    }
}