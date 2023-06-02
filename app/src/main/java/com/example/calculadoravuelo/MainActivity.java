package com.example.calculadoravuelo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

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



}