package br.com.agencianextdigital.aplicativodevotao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    Intent i;
    private EditText num1, num2, num3, num4, num5;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button btnConfirma, btnCorrige, btnBranco, btnResult;
    TextView nome, informationConfirma, informationCorrige, informationNulo, informationTecla;
    ImageView avatar;
    private int goku, naruto, nuloPre, brancoPre;
    private int votoBranco, votoNulo, votoHomer, votoBart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        i = getIntent();
        votoHomer = i.getIntExtra("homer", votoHomer);
        votoBart = i.getIntExtra("bart", votoBart);
        votoBranco = i.getIntExtra("branco", votoBranco);
        votoNulo = i.getIntExtra("nulo", votoNulo);
        naruto = i.getIntExtra("naruto", naruto);
        goku = i.getIntExtra("goku", goku);
        brancoPre = i.getIntExtra("brancoPre", brancoPre);
        nuloPre = i.getIntExtra("nuloPre", nuloPre);

        Inicio();

        btnConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this, Validacao.class);
                MediaPlayer audio = MediaPlayer.create(Principal.this, R.raw.som1);

                int result = Valida();
                if (result == 11111){
                    votoHomer = votoHomer + 1;
                }else if (result == 22222){
                    votoBart = votoBart + 1;
                }else if (result == 0){
                    Nulo();
                }

                i.putExtra("homer", votoHomer);
                i.putExtra("bart", votoBart);
                i.putExtra("branco", votoBranco);
                i.putExtra("nulo", votoNulo);
                i.putExtra("naruto", naruto);
                i.putExtra("goku", goku);
                i.putExtra("brancoPre", brancoPre);
                i.putExtra("nuloPre", nuloPre);
                audio.start();
                startActivity(i);
            }
        });

        btnCorrige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Corrige();
            }
        });

        btnBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Branco();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(9);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir(0);
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(Principal.this, Resultado.class);

                result.putExtra("homer", votoHomer);
                result.putExtra("bart", votoBart);
                result.putExtra("goku", goku);
                result.putExtra("naruto", naruto);
                result.putExtra("branco", votoBranco);
                result.putExtra("nulo", votoNulo);
                result.putExtra("brancoPre", brancoPre);
                result.putExtra("nuloPre", nuloPre);

                startActivity(result);
            }
        });

    }

    public void Inicio(){ // REFERÊNCIA OS ELEMENTOS A UMA VARIÁVEL
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        nome = findViewById(R.id.nome);
        informationConfirma = findViewById(R.id.informationConfirma);
        informationCorrige = findViewById(R.id.informationCorrige);
        informationNulo = findViewById(R.id.informationNulo);
        informationTecla = findViewById(R.id.informationTecla);

        btnConfirma = findViewById(R.id.btnConfirma);
        btnCorrige = findViewById(R.id.btnCorrige);
        btnBranco = findViewById(R.id.btnBranco);
        btnResult = findViewById(R.id.btnResult);

        avatar = findViewById(R.id.avatarPre);
        avatar.setImageResource(R.drawable.avatar);

//        Toast.makeText(Principal.this,"Um numero foi clicado", Toast.LENGTH_LONG).show();
    }

    public void Inserir(int value){
        if(num1.getText().toString().equals("")){
            num1.setText(String.valueOf(value));
        }else if (num2.getText().toString().equals("")){
            num2.setText(String.valueOf(value));
        }else if (num3.getText().toString().equals("")){
            num3.setText(String.valueOf(value));
        }else if (num4.getText().toString().equals("")){
            num4.setText(String.valueOf(value));
        }else if (num5.getText().toString().equals("")){
            num5.setText(String.valueOf(value));
            Valida();
        }
    }



    public int Valida(){
        String numero1 = num1.getText().toString();
        String numero2 = num2.getText().toString();
        String numero3 = num3.getText().toString();
        String numero4 = num4.getText().toString();
        String numero5 = num5.getText().toString();
        String numero = numero1 + numero2 + numero3 + numero4 + numero5;

        int numConvert = Integer.parseInt(numero);

        if(numConvert == 11111){
            avatar.setImageResource(R.drawable.avatar_homer);
            nome.setText(String.valueOf("Homer Simpson"));
            informationConfirma.setText(String.valueOf("CONFIRMA para CONFIRMAR este voto"));
            informationCorrige.setText(String.valueOf("CORRIGE para REINICIAR este voto"));
            informationTecla.setText(String.valueOf("Aperte a tecla para:"));

        }else if (numConvert == 22222){
            nome.setText(String.valueOf("Bart Simpson"));
            avatar.setImageResource(R.drawable.avatar_bart);
            informationConfirma.setText(String.valueOf("CONFIRMA para CONFIRMAR este voto"));
            informationCorrige.setText(String.valueOf("CORRIGE para REINICIAR este voto"));
            informationTecla.setText(String.valueOf("Aperte a tecla para:"));

        }else{
            nome.setText(String.valueOf("NÚMERO ERRADO!"));
            informationNulo.setText(String.valueOf("VOTO NULO"));
//            Toast.makeText(Principal.this,"Número inválido, por favor clique em CORRIGE e digite novemente.", Toast.LENGTH_LONG).show();
            numConvert = 0;
        }
        return numConvert;
    }

    public void Corrige(){
        num1.setText(String.valueOf(""));
        num2.setText(String.valueOf(""));
        num3.setText(String.valueOf(""));
        num4.setText(String.valueOf(""));
        num5.setText(String.valueOf(""));
        avatar.setImageResource(R.drawable.avatar);
        nome.setText(String.valueOf(""));
        informationConfirma.setText(String.valueOf(""));
        informationTecla.setText(String.valueOf(""));
        informationCorrige.setText(String.valueOf(""));
        informationNulo.setText(String.valueOf(""));
    }

    public void Branco(){
        votoBranco = votoBranco + 1;
        Intent b = new Intent(Principal.this, Validacao.class);
        MediaPlayer audio = MediaPlayer.create(Principal.this, R.raw.som1);
        b.putExtra("homer", votoHomer);
        b.putExtra("bart", votoBart);
        b.putExtra("branco", votoBranco);
        b.putExtra("nulo", votoNulo);
        b.putExtra("goku", goku);
        b.putExtra("naruto", naruto);
        b.putExtra("nuloPre", nuloPre);
        b.putExtra("brancoPre", brancoPre);
        audio.start();
        startActivity(b);
    }

    public void Nulo(){
        votoNulo = votoNulo + 1;
    }
}