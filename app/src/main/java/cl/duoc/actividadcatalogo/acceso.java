package cl.duoc.actividadcatalogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class acceso extends AppCompatActivity {
    //Se crea conexion
    Conexion con = new Conexion(acceso.this,"Catalogo",null,1);
    //Se revisa si hay logueo en la BD
    //boolean login = con.acceso(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        //Usuario BD
        ArrayList<Usuarios> u = new ArrayList<>();
        u = con.buscarUsuariosTodos();

        Log.i("lo que trae U", String.valueOf(con.buscarUsuariosTodos()));
        //String userBD = u.get(0).getNombre();
        //String passBD = u.get(0).getPassword();
        String userBD = "admin";
        String passBD = "admin";
        EditText etUser = findViewById(R.id.acc_etUsuario);
        EditText etPass = findViewById(R.id.acc_etPassword);
        ImageButton ibVolver = findViewById(R.id.acc_ibVolver);
        Button bAcceder = findViewById(R.id.bAcceder);



        //boton volver
        ibVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                //Intent intento = new Intent(acceso.this, MainActivity.class );
                //startActivity(intento);
            }
        });


        //Boton Acceder
        bAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Usuario BD
                //ArrayList<Conexion> c = new ArrayList<>();
                //c = con.buscarUsuariosTodos();

                if(etUser.getText().toString().equals(userBD) && etPass.getText().toString().equals(passBD)){
                    con.actualizarAcceso(1,true);
                   // Log.i("conexion:",String.valueOf(con.actualizarAcceso(1,true)));
                    //onBackPressed();

                    Intent intento = new Intent(acceso.this,MainActivity.class);
                    intento.putExtra("login", true);
                    startActivity(intento);
                }else{
                    Toast.makeText(acceso.this, "Credenciales Incorrectas!!", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(acceso.this, "Tranquilación!!, Estamos trabajando para usted!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}