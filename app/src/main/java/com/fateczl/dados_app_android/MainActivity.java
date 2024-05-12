package com.fateczl.dados_app_android;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton d4;
    private RadioButton d6;
    private RadioButton d8;
    private RadioButton d10;
    private RadioButton d12;
    private RadioButton d20;
    private RadioButton d100;
    private TextView escolha;
    private Spinner qtdDados;
    private Button gerar;
    private TextView saida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        d4=findViewById(R.id.rbD4);
        d4.setChecked(true);
        d6=findViewById(R.id.rbD6);
        d8=findViewById(R.id.rbD8);
        d10=findViewById(R.id.rbD10);
        d12=findViewById(R.id.rbD12);
        d20=findViewById(R.id.rbD20);
        d100=findViewById(R.id.rbD100);

        escolha=findViewById(R.id.tvEscolha);
        qtdDados=findViewById(R.id.sQtd);
        gerar=findViewById(R.id.btGearar);
        saida=findViewById(R.id.tvSaida);

        preencherTipoDadoSpinner();
        gerar.setOnClickListener(op -> gerar());
    }

    private void gerar() {
        Integer qtd = (Integer) qtdDados.getSelectedItem();
        jogarDados(qtd);
    }

    private void jogarDados(Integer qtd) {
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<qtd;i++){
            tipoDado(buffer);
            if(i!=qtd-1) buffer.append("   ");
        }
        saida.setText(buffer.toString());
    }

    private void tipoDado(StringBuffer buffer) {
        Random random = new Random();
        if (d4.isChecked()) {
            buffer.append(random.nextInt(4) + 1);
        }
        if (d6.isChecked()) {
            buffer.append(random.nextInt(6) + 1);
        }
        if (d8.isChecked()) {
            buffer.append(random.nextInt(8) + 1);
        }
        if (d10.isChecked()) {
            buffer.append(random.nextInt(10) + 1);
        }
        if (d12.isChecked()) {
            buffer.append(random.nextInt(12) + 1);
        }
        if (d20.isChecked()) {
            buffer.append(random.nextInt(20) + 1);
        }
        if (d100.isChecked()) {
            buffer.append(random.nextInt(100) + 1);
        }
    }

    private void preencherTipoDadoSpinner() {
        List<Integer> lista=new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qtdDados.setAdapter(adapter);

    }
}