package com.example.calculadoravuelo;



import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CalculoActivity extends AppCompatActivity {

    long h1 = 0, h2 = 0, m1 = 0, m2 = 0;
    long hora = 0, h = 0, m = 0;
    TextView res, ha, hb, nuevoEtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        res=(TextView) findViewById(R.id.res);
        ha=(TextView) findViewById(R.id.h1);
        hb=(TextView) findViewById(R.id.h2);
        nuevoEtd=(TextView) findViewById(R.id.nuevoEtd);
    }
    public void primero (View v) {
        final Calendar cal = Calendar.getInstance();
        final int hora = cal.get(Calendar.HOUR_OF_DAY);
        final int minuto = cal.get(Calendar.MINUTE);
        TimePickerDialog recogerHora = new TimePickerDialog(this, (view, horaDia, minutos) -> {
            h1 = horaDia;
            m1 = minutos;
            String horaF = (horaDia < 10) ? String.valueOf("0" + horaDia) : String.valueOf(horaDia);
            String minutoF = (minutos < 10) ? String.valueOf("0" + minutos) : String.valueOf(minutos);
            String AM_PM = (horaDia < 12) ? "a.m." : "p.m.";
            Toast.makeText(getApplication(), horaF + ":" + minutoF + " " + AM_PM, Toast.LENGTH_LONG).show();
            ha.setText(horaF + ":" + minutoF + AM_PM);
            diferencia();
            descanso();

        }, hora, minuto, true);
        recogerHora.show();

    }
    public void segundo (View v){
        final Calendar cal = Calendar.getInstance();
        final int hora = cal.get(Calendar.HOUR_OF_DAY);
        final int minuto = cal.get(Calendar.MINUTE);
        TimePickerDialog recogerHora = new TimePickerDialog(this, (view, horaDia, minutos) -> {
            h2 = horaDia;
            m2 = minutos;
            String horaF = (horaDia < 10) ? String.valueOf("0" + horaDia) : String.valueOf(horaDia);
            String minutoF = (minutos < 10) ? String.valueOf("0" + minutos) : String.valueOf(minutos);
            String AM_PM = (horaDia < 12) ? "a.m." : "p.m.";
            Toast.makeText(getApplication(), horaF + ":" + minutoF + " " + AM_PM, Toast.LENGTH_LONG).show();
            hb.setText(horaF + ":" + minutoF + AM_PM);
            diferencia();
            descanso();


        }, hora, minuto, true);
        recogerHora.show();

    }
    public void diferencia(){

        if (h1>=0 && h2 >=0) {
            if(h1 >= h2){
                hora = (((h2+24) * 60) + m2) - ((h1 * 60) + m1);
            } else {
                hora = ((h2 * 60) + m2) - ((h1 * 60) + m1);
            }
            h = hora / 60;
            m = hora - (h*60);
            descanso();
        }
        res.setText("Tiempo servicio de vuelo: " + h + " hrs " + m + " min ");


    }
    public void descanso() {
        long etd = 0, hetd = 0, metd = 0;
        final Calendar cal = Calendar.getInstance();
        final int hora = cal.get(Calendar.HOUR_OF_DAY);
        final int minuto = cal.get(Calendar.MINUTE);
        if (h1 >= 6  && h2 >= 6) {
            if (h == 6) {
                etd = ((h2 + 8) * 60) + m2 + 45;
            } else if (h == 7 || h == 8) {
                etd = ((h2 + 10) * 60) + m2 + 45;
            } else if (h == 9) {
                etd = ((h2 + 11) * 60) + m2 + 45;
            } else if (h == 10) {
                etd = ((h2 + 12) * 60) + m2 + 45;
            } else if (h == 11) {
                etd = ((h2 + 13) * 60) + m2 + 45;
            } else if (h == 12) {
                etd = ((h2 + 14) * 60) + m2 + 45;
            } else if (h == 13) {
                etd = ((h2 + 15) * 60) + m2 + 45;
            } else if (h == 14) {
                etd = ((h2 + 16) * 60) + m2 + 45;
            } else if (h == 15) {
                etd = ((h2 + 17) * 60) + m2 + 45;
            } else if (h == 16) {
                etd = ((h2 + 18) * 60) + m2 + 45;
            }
        }else if (h1 >= 3 || h2 <=3){
            if (h == 6) {
                etd = ((h2 + 10) * 60) + m2 + 45;
            } else if (h == 8) {
                etd = ((h2 + 12) * 60) + m2 + 45;
            } else if (h == 9) {
                etd = ((h2 + 13) * 60) + m2 + 45;
            } else if (h == 10) {
                etd = ((h2 + 14) * 60) + m2 + 45;
            } else if (h == 11) {
                etd = ((h2 + 15) * 60) + m2 + 45;
            } else if (h == 12) {
                etd = ((h2 + 16) * 60) + m2 + 45;
            } else if (h == 13) {
                etd = ((h2 + 16) * 60) + m2 + 45;
            } else if (h == 14) {
                etd = ((h2 + 17) * 60) + m2 + 45;
            } else if (h == 15) {
                etd = ((h2 + 17) * 60) + m2 + 45;
            } else if (h == 16) {
                etd = ((h2 + 18) * 60) + m2 + 45;
            }
        }else {
            if (h == 6) {
            etd = ((h2 + 12) * 60) + m2 + 45;
        } else if (h == 8) {
            etd = ((h2 + 14) * 60) + m2 + 45;
        } else if (h == 9) {
            etd = ((h2 + 15) * 60) + m2 + 45;
        } else if (h == 10) {
            etd = ((h2 + 16) * 60) + m2 + 45;
        } else if (h == 11) {
            etd = ((h2 + 17) * 60) + m2 + 45;
        } else if (h == 12) {
            etd = ((h2 + 18) * 60) + m2 + 45;
        } else if (h == 13) {
            etd = ((h2 + 18) * 60) + m2 + 45;
        } else if (h == 14) {
            etd = ((h2 + 19) * 60) + m2 + 45;
        } else if (h == 15) {
            etd = ((h2 + 19) * 60) + m2 + 45;
        } else if (h == 16) {
            etd = ((h2 + 20) * 60) + m2 + 45;
        }

                }
        hetd = etd  / 60;
        metd = etd  - (hetd*60);
        nuevoEtd.setText("Próximo ETD: " + hetd + "hrs" + metd + "min");
            }

        }








