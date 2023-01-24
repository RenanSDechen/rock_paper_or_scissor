package com.app.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int pontvc = 0;
    int pontoandroid = 0;
    public void selecionadoPedra(View view){
        this.opSelecionado("pedra");
    }
    public void selecionadoPapel(View view){
        this.opSelecionado("papel");
    }
    public void selecionadoTesul(View view){
        this.opSelecionado("tesoura");
    }

    public void opSelecionado(String opSelecionado){
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoresultado = findViewById(R.id.ResulTexto);
        TextView Pvc = findViewById(R.id.Placarvc);
        TextView Pan = findViewById(R.id.placarAndroid);
        Random random = new Random();
        int numero = random.nextInt(3);
        String[] opcoes = {"pedra","papel","tesoura"};
        String opcaoApp = opcoes[numero];
        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            default:
                break;
        }
        if(
                        (opcaoApp == "tesoura" && opSelecionado == "papel")||
                        (opcaoApp == "papel" && opSelecionado == "pedra")||
                        (opcaoApp == "pedra" && opSelecionado == "tesoura")
        ){
            textoresultado.setText("Você perdeu!!");
            this.pontoandroid= this.pontoandroid +1;
            Pan.setText("  "+pontoandroid);

        }else if(
                        (opSelecionado == "tesoura" && opcaoApp == "papel")||
                        (opSelecionado == "papel" && opcaoApp == "pedra")||
                        (opSelecionado == "pedra" && opcaoApp =="tesoura")
        ){
            textoresultado.setText("Você ganhou!!");
            this.pontvc= this.pontvc +1;
            Pvc.setText("  "+pontvc);

        }else{
            textoresultado.setText("EMPATE DE DEUSES!!");
        }
    }
}