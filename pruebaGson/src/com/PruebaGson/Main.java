package com.PruebaGson;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        Persona a = new Persona("Ariel", 27);
        Persona b = new Persona("Chino", 25);
        Persona c = new Persona("Juancito", 20);
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(a);
        personas.add(b);
        personas.add(c);

        Archivo archivo = new Archivo();
        archivo.cargarArchivo(personas);
        System.out.println("\nArchivo Json de Personas\n");
        archivo.leerArchivoJson();

        Persona m1 = new Persona ("Pato", 34);
        Persona m2 = new Persona ("Ruben",38);

        personas.add(m1);
        personas.add(m2);

        archivo.cargarArchivo(personas);
        System.out.println("\nArchivo Json de Personas Actualizado\n");
        archivo.leerArchivoJson();
        
    }
}
