package br.ulbra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editMetro, editPes, editCelcius, editFahrenheit, editQuilo, editLibra;
    Button btnConv1, btnConv2, btnConv3;
    double metro, pes, celcius, fahrenheit, quilo, libra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMetro = (EditText) findViewById(R.id.editMetro);
        editPes = (EditText) findViewById(R.id.editPes);
        btnConv1= (Button) findViewById(R.id.btnConv1);
        editCelcius = (EditText) findViewById(R.id.editCelcius);
        editFahrenheit = (EditText) findViewById(R.id.editFahrenheit);
        btnConv2 = (Button) findViewById(R.id.btnConv2);
        editQuilo = (EditText) findViewById(R.id.editQuilo);
        editLibra = (EditText) findViewById(R.id.editLibra);
        btnConv3 = (Button) findViewById(R.id.btnConv3);
        DecimalFormat f = new DecimalFormat("0.0");

        btnConv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editMetro.getText().toString().equals("") && editPes.getText().toString().equals("")) {

                    show("Erro.", "Preencha uma das métricas.");
                } else if (!(editMetro.getText().toString().equals("")) && !(editPes.getText().toString().equals(""))) {
                    show("Erro.", "Apague um dos campos para \n efetuar a conversão correta.");
                } else if (editMetro.getText().toString().equals("") && !(editPes.getText().toString().equals(""))) {
                    pes = Double.parseDouble(editPes.getText().toString());
                    metro = pes * 3.28084;
                    NumberFormat f = seuFormato();
                    editMetro.setText(f.format(metro));
                } else {
                    metro = Double.parseDouble(editMetro.getText().toString());
                    pes = metro / 3.28084;
                    NumberFormat f = seuFormato();
                    editPes.setText(f.format(pes));
                }
            }
        });
        btnConv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editCelcius.getText().toString().equals("") && editFahrenheit.getText().toString().equals("")){
                    show("Erro.", "Preencha uma das temperaturas.");
                } else if (!(editCelcius.getText().toString().equals("")) && !(editFahrenheit.getText().toString().equals(""))) {
                    show("Erro.", "Apague um dos campos para \n efetuar a conversão correta.");
                } else if (editCelcius.getText().toString().equals("") && !(editFahrenheit.getText().toString().equals(""))) {
                    fahrenheit = Double.parseDouble(editFahrenheit.getText().toString());
                    celcius = (fahrenheit - 32) * 5/9;
                    NumberFormat f = seuFormato();
                    editCelcius.setText(f.format(celcius));
                } else {
                    celcius = Double.parseDouble(editCelcius.getText().toString());
                    fahrenheit = (celcius *  9/5) + 32;
                    NumberFormat f = seuFormato();
                    editFahrenheit.setText(f.format(fahrenheit));
                }
            }
        });
        btnConv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editQuilo.getText().toString().equals("") && editLibra.getText().toString().equals("")){
                    show("Erro.", "Preencha um dos pesos.");
                } else if (!(editQuilo.getText().toString().equals("")) && !(editLibra.getText().toString().equals(""))) {
                    show("Erro.", "Apague um dos campos para \n efetuar a conversão correta.");
                } else if (editQuilo.getText().toString().equals("") && !(editLibra.getText().toString().equals(""))) {
                    libra = Double.parseDouble(editLibra.getText().toString());
                    quilo = libra / 2.64172;
                    NumberFormat f = seuFormato();
                    editQuilo.setText(f.format(quilo));
                } else {
                    quilo = Double.parseDouble(editQuilo.getText().toString());
                    libra = quilo * 2.02462;
                    NumberFormat f = seuFormato();
                    editLibra.setText(f.format(libra));
                }
            }
        });
    }

    public void show(String tit, String men) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(tit);
        b.setMessage(men);
        b.setNeutralButton("Fechar", null);
        b.show();
    }
    public static NumberFormat seuFormato() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ROOT);
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        return new DecimalFormat("#0.00", symbols);
    }
}

