package com.victoralejandro.pizzago;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Timer;

public class SolicitudActivity extends AppCompatActivity {
    private Spinner spinnerpizzas;
    private RadioGroup radiogrouptipomaza;
    private String tipopizza;
    private CheckBox checkBoxextra;
    private Timer timer;
    private PizzaObjetos e1 = new PizzaObjetos();
    private int extra1,extra2,total;
    //private Button btnordenar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);
        radiogrouptipomaza = (RadioGroup) findViewById(R.id.radiogrouptipomaza);
        spinnerpizzas = (Spinner) findViewById(R.id.spinner_pizza);
        checkBoxextra = (CheckBox) findViewById(R.id.chbquesomorzarella);
        //btnordenar = (Button) findViewById(R.id.btnordenar);


        spinnerpizzas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                tipopizza = parent.getItemAtPosition(pos).toString();
                switch (tipopizza){
                    case "Americana":
                        e1.setTipo("Americana");
                        e1.setPreciotipo(40);
                        Totalcuenta();
                        break;
                    case "Hawaina":
                        e1.setPreciotipo(45);
                        e1.setTipo("Hawaina");
                        Totalcuenta();
                        break;
                    case "Super Suprema":
                        e1.setPreciotipo(65);
                        e1.setTipo("Super Suprema");
                        Totalcuenta();
                        break;
                    case "Meat Lover":
                        e1.setPreciotipo(60);
                        e1.setTipo("Meat Lover");
                        Totalcuenta();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void radioButtonClicked(View view ){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radiomasagruesa:
                e1.setMaza("Maza gruesa");
                if(checked)
                break;
            case R.id.radiomasadelgada:
                e1.setMaza("Maza delgada");
                break;
            case R.id.radiomasaartezanal:
                e1.setMaza("Maza artezanal");
                break;
        }
    }
    public void checkboxClicked(View view ){
        CheckBox checkBox = (CheckBox) view;
        switch (view.getId()){
            case R.id.chbquesomorzarella:
                if(checkBox.isChecked())
                   extra1 = 8;
                Totalcuenta();
                break;
            case R.id.chbjamon:
                    extra2 = 12;
                Totalcuenta();
                break;
        }
    }
    public void Totalcuenta(){
        e1.setPrecioextra(extra1 + extra2);
        total = e1.getPreciotipo()+e1.getPrecioextra();
    }
    public void envarconfirmazcion(View view){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_layout_confirmacion);
        dialog.setTitle("DIalogo");

        TextView txtconfirmacion = (TextView) dialog.findViewById(R.id.textconfirmacion);
        Button btnaceptar = (Button) dialog.findViewById(R.id.btnaceptar);
        Button btncancelar = (Button) dialog.findViewById(R.id.btncancelar);


        txtconfirmacion.setText("Su pizza "+e1.getTipo()+" con "+e1.getMaza()+" a S/."+total+".00 + IGV esta en proceso de envio");
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(), "Cancel process!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                showNotification(view);
            }
        });

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Cancel process!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        dialog.show();
    }
    public void showNotification(View view){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SolicitudActivity.this, PrincipalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingIntent = PendingIntent.getActivity(SolicitudActivity.this, 100, intent, PendingIntent.FLAG_ONE_SHOT);

                // Notification
                Notification notification = new NotificationCompat.Builder(SolicitudActivity.this)
                        .setContentTitle("PIZZA GO")
                        .setContentText("Su pizza "+e1.getTipo()+" esta en proceso de envio")
                        .setSmallIcon(R.drawable.ic_local_pizza)
                        .setColor(ContextCompat.getColor(SolicitudActivity.this, R.color.primary))
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();

                // Notification manager
                NotificationManager notificationManager = (NotificationManager) SolicitudActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(100, notification);
            }
        },10000);
    }

}
