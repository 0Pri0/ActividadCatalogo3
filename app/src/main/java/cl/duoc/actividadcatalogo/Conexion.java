package cl.duoc.actividadcatalogo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Conexion extends SQLiteOpenHelper {

    private Context miContexto;
    private String nombre;
    private int version;
    private SQLiteDatabase.CursorFactory factory;

    //Constructor
    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.miContexto = context;
        this.nombre = name;
        this.version = version;
        this.factory = factory;
    }

    //crea la DB la primera vez.
    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryProductos = "create table productos(id integer primary key autoincrement, " +
                "                          codigo_categoria integer," +
                "                          nombre text, " +
                "                          descripcion text, " +
                "                          precio integer, " +
                "                          imagen integer)";

        String queryUsuarios = "create table usuarios(id integer primary key autoincrement, " +
                "                      nombre text, " +
                "                      apellido text, " +
                "                      email text," +
                "                      perfil integer, " +
                "                      cuentaActiva boolean," +
                "                      password text)";

        String queryCategorias = "create table categorias(id integer primary key autoincrement, " +
                "                      nombre text, " +
                "                      descripcion text, " +
                "                      imagen integer)";

        db.execSQL(queryProductos);
        db.execSQL(queryUsuarios);
        db.execSQL(queryCategorias);

    }


    //Insertar productos
    public boolean insertar(Catalogo producto, Usuarios usuario, Categorias categoria, String tabla, int modo) {
        /*
         * Modo 1: para insertar en tabla de productos
         * Modo 2: para insertar en tabla de usuarios
         * Modo 3: para insertar en tabla de categorías
         * */

        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        //productos a insertar
        ContentValues cv = new ContentValues();

        if (modo == 1) {
            cv.put("codigo_categoria", producto.getCategoria());
            cv.put("nombre", producto.getNombre());
            cv.put("descripcion", producto.getDescripcion());
            cv.put("precio", producto.getPrecio());
            cv.put("imagen", producto.getImagen());
        } else if (modo == 2) {
            cv.put("nombre", usuario.getNombre());
            cv.put("apellido", usuario.getApellido());
            cv.put("email", usuario.getEmail());
            cv.put("perfil", usuario.getPerfil());
            cv.put("cuentaActiva", usuario.isCuentaActiva());
            cv.put("password", usuario.getPassword());

        } else if (modo == 3) {
            cv.put("id", categoria.getId());
            cv.put("nombre", categoria.getNombre());
            cv.put("descripcion", categoria.getDescripcion());
            cv.put("imagen", categoria.getImagen());

        }

        long respuesta = escritor.insert(tabla, null, cv);
        escritor.close();

        return respuesta != -1;
    }

    //Trae todos los productos
    public ArrayList<Catalogo> buscarProductosTodos() {
        ArrayList<Catalogo> productosTodos = new ArrayList<>();
        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        Cursor cursor = null;
        cursor = escritor.rawQuery("select * from productos", null);
        //pregunto si hay algo al comienzo
        if (cursor.moveToFirst()) {
            //recorro tupla por tupla
            do {
                int categoria = cursor.getInt(1);
                String nombre = cursor.getString(2);
                String descripcion = cursor.getString(3);
                int precio = cursor.getInt(4);
                int imagen = cursor.getInt(5);

                Catalogo p = new Catalogo(categoria, nombre, descripcion, precio, imagen);
                productosTodos.add(p);

                //avanzo a la siguiente tupla
            } while (cursor.moveToNext());
        }
        escritor.close();
        return productosTodos;
    }

    //Trae todos los Usuarios
    public ArrayList<Usuarios> buscarUsuariosTodos() {
        ArrayList<Usuarios> usuariosTodos = new ArrayList<>();
        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        Cursor cursor = null;
        cursor = escritor.rawQuery("select * from usuarios", null);
        //pregunto si hay algo al comienzo
        if (cursor.moveToFirst()) {
            //recorro tupla por tupla
            do {
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String apellido = cursor.getString(2);
                String email = cursor.getString(3);
                int perfil = cursor.getInt(4);
                boolean cuentaActiva = new Boolean(cursor.getString(5));
                String password = cursor.getString(6);

                Usuarios u = new Usuarios(id, nombre, apellido, email, perfil, cuentaActiva, password);
                usuariosTodos.add(u);

                //avanzo a la siguiente tupla
            } while (cursor.moveToNext());
        }
        escritor.close();
        return usuariosTodos;
    }

    //Trae todas las categorías
    public ArrayList<Categorias> buscarCategoriasTodos() {
        ArrayList<Categorias> categoriasTodos = new ArrayList<>();
        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        Cursor cursor = null;
        cursor = escritor.rawQuery("select * from categorias", null);
        //pregunto si hay algo al comienzo
        if (cursor.moveToFirst()) {
            //recorro tupla por tupla
            do {
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String descripcion = cursor.getString(2);
                int imagen = cursor.getInt(3);


                Categorias c = new Categorias(id, nombre, descripcion, imagen);
                categoriasTodos.add(c);

                //avanzo a la siguiente tupla
            } while (cursor.moveToNext());
        }
        escritor.close();
        return categoriasTodos;
    }

    //busca productos por categoria
    public ArrayList<Catalogo> buscarxCategoria(int categoria) {
        String[] args = new String[]{String.valueOf(categoria)};
        ArrayList<Catalogo> producto = new ArrayList<>();
        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        Cursor cursor = null;
        cursor = escritor.rawQuery("select * from productos where codigo_categoria = ?", args, null);
        //pregunto si hay algo al comienzo
        if (cursor.moveToFirst()) {
            //recorro tupla por tupla
            do {
                int id = cursor.getInt(0);
                int cod_cat = cursor.getInt(1);
                String nombre = cursor.getString(2);
                String descripcion = cursor.getString(3);
                int precio = cursor.getInt(4);
                int imagen = cursor.getInt(5);


                Catalogo c = new Catalogo(cod_cat, nombre, null, precio, imagen);
                producto.add(c);

                //avanzo a la siguiente tupla
            } while (cursor.moveToNext());
        }
        escritor.close();
        return producto;
    }

    //revisa si hay logueo en bd
    public boolean acceso(int idUser) {

        boolean logueo = true;
        SQLiteDatabase escritor = this.getWritableDatabase();
        Cursor cursor = null;
        //String[] args = new String[]{String.valueOf(idUser)};

        cursor = escritor.rawQuery("select * from usuarios where id = "+idUser+"", null);
        if (cursor.moveToFirst()) {
            do {//campos que devolvera
                logueo = new Boolean(new Boolean(cursor.getString(5)));
            } while (cursor.moveToNext());
        }
        return logueo;
    }

    //Buscar productos por categoría
    public Catalogo buscar(int categ, String tabla) {
        Catalogo p = null;
        SQLiteDatabase escritor = this.getWritableDatabase();
        Cursor cursor = null;
        String[] args = new String[]{String.valueOf(categ)};
        //cursor = escritor.rawQuery("select id,mensaje from lista where id  = ?",new String[] {String.valueOf(id)});
        cursor = escritor.rawQuery("select * from tabla where categoria  = ?", args);
        if (cursor.moveToFirst()) {
            do {//campos que devolvera
                int categoria = cursor.getInt(1);
                String nombre = cursor.getString(2);
                String descripcion = cursor.getString(3);
                int precio = cursor.getInt(4);
                int imagen = cursor.getInt(5);
                p = new Catalogo(categoria, nombre, descripcion, precio, imagen);

            } while (cursor.moveToNext());
        }
        return p;
    }

    //Eliminar
    public boolean eliminar(int id, String tabla) {
        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        //los paramentros, lo que quiero insertar
        String[] args = new String[]{String.valueOf(id)};

        int respuesta = escritor.delete(tabla, "id=?", args);
        escritor.close();

        return respuesta != 0;
    }

    //Actualizar acceso usuario
    public void actualizarAcceso(int idUser, boolean acceso) {
        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        String[] args = {String.valueOf(idUser)};
        ContentValues cv = new ContentValues();
        cv.put("cuentaActiva", String.valueOf(acceso));
        //args = new String[]{String.valueOf(idUser)};
        escritor.update("usuarios", cv, "id=?", args);

        Log.i("Acceso", String.valueOf(escritor.update("usuarios", cv, "id=?", args)));
        Toast.makeText(miContexto, "Acceso Modificado.!", Toast.LENGTH_SHORT).show();
        escritor.close();

        //Log.i("actualizarAcceso: ", String.valueOf(respuesta));

    }

    //Actualizar datos
    public boolean actualizar(Catalogo p, Usuarios u, Categorias c, String tabla, int modo) {
        /*
         * modo 1: actualiza tabla productos
         * modo 2: actualiza tabla usuarios
         * modo 3: actualiza tabla categorias
         * */

        //escribir
        SQLiteDatabase escritor = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String[] args = new String[]{};

        if (modo == 1) {
            cv.put("categoria", p.getCategoria());
            cv.put("nombre", p.getNombre());
            cv.put("descripcion", p.getDescripcion());
            cv.put("precio", p.getPrecio());
            cv.put("imagen", p.getImagen());

            args = new String[]{String.valueOf(p.getId())};

        } else if (modo == 2) {
            cv.put("nombre", u.getNombre());
            cv.put("apellido", u.getApellido());
            cv.put("email", u.getEmail());
            cv.put("perfil", u.getPerfil());
            cv.put("cuentaActiva", u.isCuentaActiva());
            cv.put("password", u.getPassword());

            args = new String[]{String.valueOf(u.getId())};

        } else if (modo == 3) {
            cv.put("nombre", c.getNombre());
            cv.put("descripcion", c.getDescripcion());
            cv.put("imagen", c.getImagen());

            args = new String[]{String.valueOf(c.getId())};
        }

        int respuesta = escritor.update(tabla, cv, "id=?", args);
        escritor.close();

        return respuesta != 0;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int vOld, int vNew) {

    }
}
