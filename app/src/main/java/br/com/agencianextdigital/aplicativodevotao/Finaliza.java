package br.com.agencianextdigital.aplicativodevotao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Finaliza extends AppCompatActivity {

    Intent i;
    TextView votoHomer, votoBart, votoBranco, votoNulo;
    int homer, bart, branco, nulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaliza);

        i = getIntent();
        homer = i.getIntExtra("homer", homer);
        bart = i.getIntExtra("bart", bart);
        nulo = i.getIntExtra("nulo", nulo);
        branco = i.getIntExtra("branco", branco);

        Inicia();

        votoHomer.setText(String.valueOf(homer));
        votoBart.setText(String.valueOf(bart));
        votoBranco.setText(String.valueOf(branco));
        votoNulo.setText(String.valueOf(nulo));
    }

    public void Inicia(){
        votoHomer = findViewById(R.id.votoHomer);
        votoBart = findViewById(R.id.votoBart);
        votoBranco = findViewById(R.id.votoBranco);
        votoNulo = findViewById(R.id.votoNulo);
    }
}