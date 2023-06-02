package com.example.calculadoravuelo;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.jakewharton.threetenabp.AndroidThreeTen;
import org.threeten.bp.LocalTime;
import java.util.Calendar;


public class CalculoActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        res = (TextView) findViewById(R.id.res);
        ha = (TextView) findViewById(R.id.h1);
        hb = (TextView) findViewById(R.id.h2);
        nuevoEtd = (TextView) findViewById(R.id.nuevoEtd);
        AndroidThreeTen.init(this);
    }


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
            diferencia();
            descanso();

        }, hora, minuto, true);
        recogerHora.show();

    }


    public void segundo(View v) {
        //Eta más 30 min
        final Calendar cal = Calendar.getInstance();
        final int hora = cal.get(Calendar.HOUR_OF_DAY);
        final int minuto = cal.get(Calendar.MINUTE);
        TimePickerDialog recogerHora = new TimePickerDialog(this, (view, horaDia, minutos) -> {
            h2 = horaDia;
            m2 = minutos;
            String horaF = (horaDia < 10) ? "0" + horaDia : String.valueOf(horaDia);
            String minutoF = (minutos < 10) ? "0" + minutos : String.valueOf(minutos);
            String AM_PM = (horaDia < 12) ? "a.m." : "p.m.";
            Toast.makeText(getApplication(), horaF + ":" + minutoF + " " + AM_PM, Toast.LENGTH_LONG).show();
            hb.setText(horaF + ":" + minutoF + AM_PM);
            diferencia();
            descanso();


        }, hora, minuto, true);
        recogerHora.show();

    }


    public void diferencia() {
        //Tiempo de servicio de vuelo
        if (h1 >= 0 && h2 >= 0) {
            if (h1 >= h2) {
                hora = (((h2 + 24) * 60) + m2) - ((h1 * 60) + m1);
            } else {
                hora = ((h2 * 60) + m2) - ((h1 * 60) + m1);
            }
            h = hora / 60;
            m = hora - (h * 60);

            descanso();
        }
        res.setText("Tiempo servicio de vuelo: " + h + " hrs " + m + " min ");


    }


     public void descanso() {
         LocalTime eta = LocalTime.of(h2, m2);

         LocalTime netd = LocalTime.ofSecondOfDay(0);
         //Sin tocar el nocturno
         if (h1 >= 6 && h2 >= 10) {
             if (hora <= 360) {

                 netd = eta.plusHours(8).plusMinutes(45);
             } else if (hora <= 480) {

                 netd = eta.plusHours(10).plusMinutes(45);
             } else if (hora <= 540) {

                 netd = eta.plusHours(11).plusMinutes(45);
             } else if (hora <= 600) {

                 netd = eta.plusHours(12).plusMinutes(45);
             } else if (hora <= 660) {

                 netd = eta.plusHours(13).plusMinutes(45);
             } else if (hora <= 720) {

                 netd = eta.plusHours(14).plusMinutes(45);
             } else if (hora <= 780) {

                 netd = eta.plusHours(15).plusMinutes(45);
             } else if (hora <= 840) {

                 netd = eta.plusHours(16).plusMinutes(45);
             } else if (hora <= 900) {

                 netd = eta.plusHours(17).plusMinutes(45);
             } else if (hora <= 960) {

                 netd = eta.plusHours(18).plusMinutes(45);
             }
             //Tocando nocturno
         } else if (h1 >= 3 && h2 < 3 || h2 >= 9) {
             if (hora <= 360) {

                 netd = eta.plusHours(10).plusMinutes(45);
             } else if (hora <= 480) {

                 netd =eta.plusHours(12).plusMinutes(45);
             } else if (hora <= 540) {

                 netd = eta.plusHours(13).plusMinutes(45);
             } else if (hora <= 600) {

                 netd =eta.plusHours(14).plusMinutes(45);
             } else if (hora <= 660) {

                 netd =eta.plusHours(15).plusMinutes(45);
             } else if (hora <= 720) {

                 netd =eta.plusHours(16).plusMinutes(45);
             } else if (hora <= 780) {

                 netd =eta.plusHours(16).plusMinutes(45);
             } else if (hora <= 840) {

                 netd =eta.plusHours(17).plusMinutes(45);
             } else if (hora <= 900) {

                 netd = eta.plusHours(17).plusMinutes(45);
             } else if (hora <= 960) {

                 netd = eta.plusHours(18).plusMinutes(45);
             }
             //Más de 50% del nocturno
         } else {
             if (hora <= 360) {

                 netd = eta.plusHours(12).plusMinutes(45);
             } else if (hora <= 480) {

                 netd =  eta.plusHours(14).plusMinutes(45);
             } else if (hora <= 540) {

                 netd =  eta.plusHours(15).plusMinutes(45);
             } else if (hora <= 600) {

                 netd =  eta.plusHours(16).plusMinutes(45);
             } else if (hora <= 660) {

                 netd =  eta.plusHours(17).plusMinutes(45);
             } else if (hora <= 720) {

                 netd =  eta.plusHours(18).plusMinutes(45);
             } else if (hora <= 780) {

                 netd =  eta.plusHours(18).plusMinutes(45);
             } else if (hora <= 840) {

                 netd =   eta.plusHours(19).plusMinutes(45);
             } else if (hora <= 900) {

                 netd =  eta.plusHours(19).plusMinutes(45);
             } else if (hora <= 960) {

                 netd =  eta.plusHours(20).plusMinutes(45);
             }
         }
            //Cumplido el descanso más 1 hora para nuevo ETD
         nuevoEtd.setText("Próximo ETD: " + netd.plusHours(1));
     }
 }











