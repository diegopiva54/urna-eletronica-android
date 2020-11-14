package br.com.agencianextdigital.aplicativodevotao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Validacao extends AppCompatActivity {

    Intent i;
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn00;
    private Button btnConfirmaPre, btnBrancoPre, btnCorrigePre;
    private EditText num01, num02;
    private TextView nomePre, informationNulo2, informationConfirma2, informationTecla2, informationCorrige2;
    ImageView avatarPre, avatarVice;
    private int votoBrancoPre, votoNuloPre, votoNaruto, votoGoku;
    private int votoBranco, votoNulo, votoBart, votoHomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacao);

        i = getIntent();
        votoBranco = i.getIntExtra("branco",votoBranco);
        votoNulo = i.getIntExtra("nulo", votoNulo);
        votoHomer = i.getIntExtra("homer", votoHomer);
        votoBart = i.getIntExtra("bart", votoBart);
        votoNaruto = i.getIntExtra("naruto", votoNaruto);
        votoGoku = i.getIntExtra("goku", votoGoku);
        votoBrancoPre = i.getIntExtra("brancoPre", votoBrancoPre);
        votoNuloPre = i.getIntExtra("nuloPre", votoNuloPre);


        Inicia();

        btnConfirmaPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Validacao.this,Finaliza.class);
                int result = Valida();
                if (result == 11){
                    votoGoku = votoGoku + 1;
                }else if (result == 22){
                    votoNaruto = votoNaruto + 1;
                }else if (result == 0){
                    votoNuloPre = votoNuloPre + 1;
                }

                i.putExtra("branco", votoBranco);
                i.putExtra("nulo", votoNulo);
                i.putExtra("bart", votoBart);
                i.putExtra("homer", votoHomer);
                i.putExtra("naruto", votoNaruto);
                i.putExtra("goku", votoGoku);
                i.putExtra("nuloPre", votoNuloPre);
                i.putExtra("brancoPre", votoBrancoPre);
                startActivity(i);
            }
        });

        btnCorrigePre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Corrige();
            }
        });

        btnBrancoPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Branco();
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(1);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(2);
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(3);
            }
        });

        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(4);
            }
        });

        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(5);
            }
        });

        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(6);
            }
        });

        btn07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(7);
            }
        });

        btn08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(8);
            }
        });

        btn09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(9);
            }
        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(0);
            }
        });
    }

    public void Inicia(){
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);
        btn05 = findViewById(R.id.btn05);
        btn06 = findViewById(R.id.btn06);
        btn07 = findViewById(R.id.btn07);
        btn08 = findViewById(R.id.btn08);
        btn09 = findViewById(R.id.btn09);
        btn00 = findViewById(R.id.btn00);

        num01 = findViewById(R.id.num01);
        num02 = findViewById(R.id.num02);

        btnConfirmaPre = findViewById(R.id.btnConfirmaPre);
        btnBrancoPre = findViewById(R.id.btnBrancoPre);
        btnCorrigePre = findViewById(R.id.btnCorrigePre);

        nomePre = findViewById(R.id.nomePre);
        informationNulo2 = findViewById(R.id.informationNulo2);
        informationConfirma2 = findViewById(R.id.informationConfirma2);
        informationTecla2 = findViewById(R.id.informationTecla2);
        informationCorrige2 = findViewById(R.id.informationCorrige2);

        avatarPre = findViewById(R.id.avatarPre);
        avatarPre.setImageResource(R.drawable.avatar);
        avatarVice = findViewById(R.id.avatarVice);
        avatarVice.setImageResource(R.drawable.avatar);
    }

    public void Corrige(){
        num01.setText(String.valueOf(""));
        num02.setText(String.valueOf(""));
        avatarPre.setImageResource(R.drawable.avatar);
        avatarVice.setImageResource(R.drawable.avatar);
        nomePre.setText(String.valueOf(""));
    }

    public void Inserir(int value){
        if(num01.getText().toString().equals("")){
            num01.setText(String.valueOf(value));
        }else if (num02.getText().toString().equals("")){
            num02.setText(String.valueOf(value));
            Valida();
        }
    }

    public int Valida(){
        String num1 = num01.getText().toString();
        String num2 = num02.getText().toString();
        String numero = num1 + num2;

        int numConverted = Integer.parseInt(numero);

        if(numConverted == 11){
            avatarPre.setImageResource(R.drawable.avatar_goku);
            nomePre.setText(String.valueOf("Son Goku"));
            avatarVice.setImageResource(R.drawable.avatar_vegeta);
            informationConfirma2.setText(String.valueOf("CONFIRMA para CONFIRMAR este voto"));
            informationCorrige2.setText(String.valueOf("CORRIGE para REINICIAR este voto"));
            informationTecla2.setText(String.valueOf("Aperte a tecla para:"));
        }else if (numConverted == 22){
            nomePre.setText(String.valueOf("Uzumaki Naruto"));
            avatarPre.setImageResource(R.drawable.avatar_naruto);
            avatarVice.setImageResource(R.drawable.avatar_sasuke);
            informationConfirma2.setText(String.valueOf("CONFIRMA para CONFIRMAR este voto"));
            informationCorrige2.setText(String.valueOf("CORRIGE para REINICIAR este voto"));
            informationTecla2.setText(String.valueOf("Aperte a tecla para:"));
        }else{
//            Toast.makeText(Validacao.this,"Número inválido, por favor clique em CORRIGE e digite novemente.", Toast.LENGTH_LONG).show();
            nomePre.setText(String.valueOf("NÚMERO ERRADO!"));
            informationNulo2.setText(String.valueOf("VOTO NULO"));
            numConverted = 0;
        }
        return numConverted;
    }

    public void Branco(){
        votoBrancoPre = votoBrancoPre + 1;
        Intent i = new Intent(Validacao.this,Finaliza.class);
        i.putExtra("branco", votoBranco);
        i.putExtra("nulo", votoNulo);
        i.putExtra("bart", votoBart);
        i.putExtra("homer", votoHomer);
        i.putExtra("naruto", votoNaruto);
        i.putExtra("goku", votoGoku);
        i.putExtra("nuloPre", votoNuloPre);
        i.putExtra("brancoPre", votoBrancoPre);

        startActivity(i);
    }
}