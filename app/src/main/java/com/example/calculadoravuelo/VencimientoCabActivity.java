package com.example.calculadoravuelo;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class VencimientoCabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vencimiento_cab);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.menu_home){
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
        }
        if(id==R.id.menu_des){
            Intent myIntent = new Intent(this, CalculoActivity.class);
            startActivity(myIntent);
        }
        if(id==R.id.menu_cab){
            Toast.makeText(this, "¡Próximamente!", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.menu_int){
            Toast.makeText(this, "¡Próximamente!", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.decreto){
            String _url = "https://www.argentina.gob.ar/sites/default/files/infoleg/dto877-1.pdf";
            Uri _link  = Uri.parse(_url);
            Intent intent = new Intent(Intent.ACTION_VIEW, _link);
            startActivity(intent);
        }
        if(id==R.id.help){
            Intent myIntent = new Intent(this, Help.class);
            startActivity(myIntent);
        }

        return super.onOptionsItemSelected(item);
    }

        int h1 = 0, h2 = 0, m1 = 0, m2 = 0;
        int hora = 0, h = 0, m = 0;
        TextView res, ha, hb, nuevoEtd;


        public void primero(View v) {
        //Inicio del tiempo de servicio de vuelo (1 hora antes del ETD)
        final Calendar cal = Calendar.getInstance();
        final int hora = cal.get(Calendar.HOUR_OF_DAY);
        final int minuto = cal.get(Calendar.MINUTE);
        TimePickerDialog recogerHora = new TimePickerDialog(this, (view, horaDia, minutos) -> {
            h1 = horaDia;
            m1 = minutos;
            String horaF = (horaDia < 10) ? "0" + horaDia : String.valueOf(horaDia);
            String minutoF = (minutos < 10) ? "0" + minutos : String.valueOf(minutos);
            String AM_PM = (horaDia < 12) ? "a.m." : "p.m.";
            Toast.makeText(getApplication(), horaF + ":" + minutoF + " " + AM_PM, Toast.LENGTH_LONG).show();
            ha.setText(horaF + ":" + minutoF + AM_PM);
            //diferencia();
           // descanso();

        }, hora, minuto, true);
        recogerHora.show();

    }
}