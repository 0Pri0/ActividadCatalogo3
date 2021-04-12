package cl.duoc.actividadcatalogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Categorias> categoriasTodas = new ArrayList<>();
    //Se crea BD
    Conexion con = new Conexion(MainActivity.this,"Catalogo",null,1);

    public static boolean validadorProductos =false;
    public static boolean validadorCategorias =false;
    public static boolean validadorUsuarios =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se agrega a bd
        //Se inserta categoria defecto
        if(validadorCategorias ==false){
            validadorCategorias = true;

            //Se crean categorias
            Categorias c1 = new Categorias(1,"Bebestibles","Productos liquidos", R.drawable.icono_bebestible_01);
            Categorias c2 = new Categorias(2,"Sandwish","Comestible",R.drawable.icono_sandwich_01_01);
            Categorias c3 = new Categorias(3,"Pastelería","Tortas",R.drawable.icono_pastel_01);
            Categorias c4 = new Categorias(4,"Panadería","Pan",R.drawable.icono_pan_01);

            con.insertar(null,null,c1,"categorias",3);
            con.insertar(null,null,c2,"categorias",3);
            con.insertar(null,null,c3,"categorias",3);
            con.insertar(null,null,c4,"categorias",3);
        }

        //Se válida que el usuario ya no este creado en la BD
        /*if (getIntent().getBooleanExtra("login", false) != true){
            Usuarios u1 = new Usuarios(1,"admin","admin","admin@admin.cl",1,false,"admin");
            //Se inserta usuario defecto(administrador)
            con.insertar(null,u1,null,"usuarios",2);
            //Log.i("Usuario Admin: ", "se inserta usuario admin");
        }else{
            login = true;
        }*/

        if(validadorUsuarios = false){
            validadorUsuarios = true;
            Usuarios u1 = new Usuarios(1,"admin","admin","admin@admin.cl",1,false,"admin");
            //Se inserta usuario defecto(administrador)
            con.insertar(null,u1,null,"usuarios",2);
        }

        //Log.i("Usuario Admin: ","nose inserta Usuario admin");
        //Se crean productos
        if(validadorProductos == false) {
            validadorProductos =true;
            Catalogo p1 = new Catalogo(1, "Bebida Coca Cola tradicional", "bebida carbonatada conocida a nivel mundial por su sabor, tenemos en formato de 1 litro", 1300, R.drawable.coca);
            Catalogo p2 = new Catalogo(1, "Jugo Frutilla", "Jugo sabor Frutilla de  Andina del Valle, en formato de 2 litros", 1500, R.drawable.andina_del_valle_frutilla_);
            Catalogo p3 = new Catalogo(2, "Churrasco italiano", "Pan frica horneado en nuestras dependencias, con filetes de carne de Vacuno a la plancha, con rodajas de tomate y palta", 5500, R.drawable.churrasco_italiano1);
            Catalogo p4 = new Catalogo(2, "Chacarero", "Pan frica horneado en nuestras dependencias, con filetes de carne de vacuno a la plancha, rodajas de tomate, ají verde y porotos verdes cocidos", 6000, R.drawable.chacarero1);
            Catalogo p5 = new Catalogo(3, "Torta Mil Hojas", "Torta de capas de hojaldre, relleno con crema pastelera y manjar", 7500, R.drawable.mil_hojas);
            Catalogo p6 = new Catalogo(3, "Torta Tres Leches", "Torta de bizcocho bañado con leche evaporada, leche condensada y crema de leche", 8000, R.drawable.tres_leches);
            Catalogo p7 = new Catalogo(4, "Pan Marraqueta", "Pan blanco, elaborado en base a harina de trigo y levadura, de forma abultada y que puede dividirse en dos mitades", 1400, R.drawable.marraqueta);
            Catalogo p8 = new Catalogo(4, "Pan Hallulla", "Pan blanco, elaborado en base a harina de trigo y manteca, de forma redonda y aplanada", 1400, R.drawable.hallulla);
            Catalogo p9 = new Catalogo(1, "Agua", "Tenemos agua mineral Vital sin gas, en formato de 1,5 litros", 1200, R.drawable.vital_sin_gas_1_6_);
            Catalogo p10 = new Catalogo(1, "Mote con Huesillos", "El mejor mote con huesillos casero, bien frio, se vende en envase individual.", 1200, R.drawable.mote);
            Catalogo p11 = new Catalogo(2, "Papas fritas", "Papas cortadas en bastones, fritas en aceite vegetal.", 1600, R.drawable.papas_fritas);
            Catalogo p12 = new Catalogo(2, "Barros Luco", "Pan Frica horneado en nuestras dependencias, con filetes de carne de vacuno a la plancha y queso fundido.", 6000, R.drawable.barros_luco);
            Catalogo p13 = new Catalogo(3, "Torta Selva Negra", "Torta de bizcocho de Chocolate, relleno con capas de mermelada de Cerezas, con trozos de Cerezas, una experiencia para el paladar.", 7000, R.drawable.selva_negra);
            Catalogo p14 = new Catalogo(3, "Berlines", "Masa dulce redonda esponjosa, horneada, espolvoreada con azúcar flor y rellena con crema pastelera o manjar.", 600, R.drawable.berlines);
            Catalogo p15 = new Catalogo(4, "Dobladita", "Pan blanco, en base a harina de trigo y manteca, de forma triangular, semejante a un pañuelo doblado.", 1700, R.drawable.dobladita);
            Catalogo p16 = new Catalogo(4, "Empanadas de Queso", "Masa rellena de queso, en masa de hojaldre", 1300, R.drawable.empanada_queso);

            //Se insertan productos por defecto
            con.insertar(p1,null,null,"productos",1);
            con.insertar(p2,null,null,"productos",1);
            con.insertar(p3,null,null,"productos",1);
            con.insertar(p4,null,null,"productos",1);
            con.insertar(p5,null,null,"productos",1);
            con.insertar(p6,null,null,"productos",1);
            con.insertar(p7,null,null,"productos",1);
            con.insertar(p8,null,null,"productos",1);
            con.insertar(p9,null,null,"productos",1);
            con.insertar(p10,null,null,"productos",1);
            con.insertar(p11,null,null,"productos",1);
            con.insertar(p12,null,null,"productos",1);
            con.insertar(p13,null,null,"productos",1);
            con.insertar(p14,null,null,"productos",1);
            con.insertar(p15,null,null,"productos",1);
            con.insertar(p16,null,null,"productos",1);
        }

        /* Hasta aqui es el código defecto*/

        //se traen botones categorias
        ImageButton ibBebestibles = findViewById(R.id.ibBebestible);
        LinearLayout llBebestibles = findViewById(R.id.llBebestibles);
        TextView tvBebestible = findViewById(R.id.tvBebestible);
        ImageButton ibSandwish = findViewById(R.id.ibSandwich);
        LinearLayout llSandwich = findViewById(R.id.llSandwich);
        TextView tvSandwish = findViewById(R.id.tvSandwish);
        ImageButton ibPasteleria = findViewById(R.id.ibPasteleria);
        LinearLayout llPasteleria = findViewById(R.id.llPasteleria);
        TextView tvPasteleria = findViewById(R.id.tvPasteleria);
        ImageButton ibPanaderia = findViewById(R.id.ibPanaderia);
        LinearLayout llPanaderia = findViewById(R.id.llPanaderia);
        TextView tvPanaderia = findViewById(R.id.tvPanaderia);

        //se traen todas las categorias de la BD
        categoriasTodas = con.buscarCategoriasTodos();

        //se sobreescribe boton bebestibles
        String bebNombre= String.valueOf(categoriasTodas.get(0).getNombre()); // dato BD nombre
        int bebImagen= categoriasTodas.get(0).getImagen(); // dato BD Imagen

        ibBebestibles.setImageResource(bebImagen); //muestra imagen de BD
        tvBebestible.setText(bebNombre);    //Muestra nombre de BD

        //se sobreescribe boton Sandwish
        String sandNombre= String.valueOf(categoriasTodas.get(1).getNombre()); // dato BD nombre
        int sandImagen= categoriasTodas.get(1).getImagen(); // dato BD Imagen

        ibSandwish.setImageResource(sandImagen); //muestra imagen de BD
        tvSandwish.setText(sandNombre);    //Muestra nombre de BD

        //se sobreescribe boton Pasteleria
        String pastNombre= String.valueOf(categoriasTodas.get(2).getNombre()); // dato BD nombre
        int pastImagen= categoriasTodas.get(2).getImagen(); // dato BD Imagen

        ibPasteleria.setImageResource(pastImagen); //muestra imagen de BD
        tvPasteleria.setText(pastNombre);    //Muestra nombre de BD

        //se sobreescribe boton Panaderia
        String pandNombre= String.valueOf(categoriasTodas.get(3).getNombre()); // dato BD nombre
        int pandImagen= categoriasTodas.get(3).getImagen(); // dato BD Imagen

        ibPanaderia.setImageResource(pandImagen); //muestra imagen de BD
        tvPanaderia.setText(pandNombre);    //Muestra nombre de BD

        //Log.i("imagen BD",String.valueOf(bebImagen));

        //Categoria Bebestibles
        llBebestibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int bebCateg= categoriasTodas.get(0).getId();
                Intent intento = new Intent(MainActivity.this, Productos.class );
                intento.putExtra("categoria", bebCateg);
                startActivity(intento);
            }
        });

        //Categoria Sandwish
        llSandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sandCateg= categoriasTodas.get(1).getId();
                Intent intento = new Intent(MainActivity.this, Productos.class );
                intento.putExtra("categoria", sandCateg);
                startActivity(intento);
            }
        });

        //Categoria Pastelería
        llPasteleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pastCateg= categoriasTodas.get(2).getId();
                Intent intento = new Intent(MainActivity.this, Productos.class );
                intento.putExtra("categoria", pastCateg);
                startActivity(intento);
            }
        });

        //Categoría Panadería
        llPanaderia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int panaCateg= categoriasTodas.get(3).getId();
                Intent intento = new Intent(MainActivity.this, Productos.class );
                intento.putExtra("categoria", panaCateg);
                startActivity(intento);
            }
        });

        //Se llaman botones de administrador
        FloatingActionButton fab_agregarUsuario = findViewById(R.id.fab_AgregarUsuario);
        FloatingActionButton fab_modificarCategoria = findViewById(R.id.fab_modificarCategoria);
        FloatingActionButton fab_agregarProducto = findViewById(R.id.fab_agregarProducto);
        FloatingActionButton fab_acceso = findViewById(R.id.fab_acceso);
        FloatingActionButton fab_salir = findViewById(R.id.fab_salir);

        //Boton acceso
        fab_acceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, acceso.class );
                startActivity(intento);
            }
        });

        //Se esconde acceso si no esta autentificado el usuario

        boolean login = con.acceso(1);
        Log.i("login",String.valueOf(login));
        if(login == true){
            fab_acceso.hide();
            fab_agregarUsuario.show();
            fab_modificarCategoria.show();
            fab_agregarProducto.show();
            fab_salir.show();

        }else{
            fab_agregarUsuario.hide();
            fab_modificarCategoria.hide();
            fab_agregarProducto.hide();
            fab_salir.hide();
            fab_acceso.show();
        }


        //Se agrega evento a fab agregar usuario
        fab_agregarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, AgregarUsuario.class );
                startActivity(intento);
            }
        });

        //Se agrega evento a fab modificar categoria
        fab_modificarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, ModificarCategoria.class );
                startActivity(intento);
            }
        });

        //Se agrega evento a fab agregar producto
        fab_agregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, AgregarProductos.class );
                startActivity(intento);
            }
        });

        //Se agrega evento a fab salir
        fab_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                con.actualizarAcceso(1,false);
                //login = false;
                fab_agregarUsuario.hide();
                fab_modificarCategoria.hide();
                fab_agregarProducto.hide();
                fab_salir.hide();
                fab_acceso.show();

                //finish();
                //startActivity(getIntent());
            }
        });

    con.close();
    }
}