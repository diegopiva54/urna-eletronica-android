package br.com.agencianextdigital.aplicativodevotao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    Intent i;
    Button btnReiniciar;
    TextView resultHomer, resultBart, resultGoku, resultNaruto, brancoVereador, brancoPrefeito, nuloVereador, nuloPrefeito;
    private int goku, naruto, nuloPre, brancoPre;
    private int votoBranco, votoNulo, votoHomer, votoBart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        i = getIntent();
        Inicia();

        goku = i.getIntExtra("goku", goku);
        naruto = i.getIntExtra("naruto", naruto);
        votoHomer = i.getIntExtra("homer", votoHomer);
        votoBart = i.getIntExtra("bart", votoBart);
        votoBranco = i.getIntExtra("branco", votoBranco);
        votoNulo = i.getIntExtra("nulo", votoNulo);
        nuloPre = i.getIntExtra("nuloPre", nuloPre);
        brancoPre = i.getIntExtra("brancoPre", brancoPre);

        resultNaruto.setText(String.valueOf(naruto));
        resultGoku.setText(String.valueOf(goku));
        resultBart.setText(String.valueOf(votoBart));
        resultHomer.setText(String.valueOf(votoHomer));
        brancoVereador.setText(String.valueOf(votoBranco));
        brancoPrefeito.setText(String.valueOf(brancoPre));
        nuloVereador.setText(String.valueOf(votoNulo));
        nuloPrefeito.setText(String.valueOf(nuloPre));

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restart();
                Intent r = new Intent(Resultado.this, Principal.class);
                startActivity(r);
            }
        });

    }

    public void Inicia(){
        resultBart = findViewById(R.id.resultBart);
        resultHomer = findViewById(R.id.resultHomer);
        resultGoku = findViewById(R.id.resultGoku);
        resultNaruto = findViewById(R.id.resultNaruto);
        brancoPrefeito = findViewById(R.id.brancoPrefeito);
        brancoVereador = findViewById(R.id.brancoVereador);
        nuloPrefeito = findViewById(R.id.nuloPrefeito);
        nuloVereador = findViewById(R.id.nuloVereador);

        btnReiniciar = findViewById(R.id.btnReiniciar);
    }

    public void Restart(){
        goku = 0;
        naruto = 0;
        votoBart = 0;
        votoHomer = 0;
        nuloPre = 0;
        votoNulo = 0;
        brancoPre = 0;
        votoBranco = 0;
    }
}