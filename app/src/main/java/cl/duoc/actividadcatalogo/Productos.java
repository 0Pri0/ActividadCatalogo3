package cl.duoc.actividadcatalogo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Productos extends AppCompatActivity {
    //ArrayList<Catalogo> p = new ArrayList<>();
    Conexion con = new Conexion(Productos.this,"Catalogo",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        int catConver =0;
        //Se crea productos
        ArrayList<Catalogo> p = new ArrayList<>();
        //Se crea arrayList
        ListView lvListar = findViewById(R.id.lvProductos);

        int categoria = getIntent().getIntExtra("categoria", 0);
        p = con.buscarxCategoria(categoria);
        //Log.i("nombre: ", String.valueOf(producto));

        //List view personalizado
        CustomArrayAdapter adaptador = new CustomArrayAdapter(Productos.this,R.layout.plantilla_lv_productos,p);
        lvListar.setAdapter(adaptador);
    }
}


class CustomArrayAdapter extends ArrayAdapter<Catalogo>
{
    private Context miContexto;
    private int miRecurso;
    private ArrayList<Catalogo> miLista;

    public CustomArrayAdapter(Productos miContexto, int miRecurso, ArrayList<Catalogo> miLista) {
        super(miContexto, miRecurso, miLista);
        this.miContexto = miContexto;
        this.miRecurso = miRecurso;
        this.miLista = miLista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(miRecurso, null);
        ImageView lblImagen = view.findViewById(R.id.lblImagen);
        TextView lblNombre = view.findViewById(R.id.lblNombre);

        Catalogo p = miLista.get(position);

        lblImagen.setImageResource(p.getImagen());
        lblNombre.setText(String.valueOf(p.getNombre()));
        return view;


    }
}