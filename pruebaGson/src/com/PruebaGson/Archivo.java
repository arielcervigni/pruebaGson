package com.PruebaGson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Properties;

public class Archivo {

    public static final String path = "C:\\Users\\Taller.MAKER\\Desktop\\pruebaGson\\archivo.json";
    public File archivo = new File (path);

    void cargarArchivo (ArrayList<Persona> personas) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        Gson gson = new Gson();
        String paraGrabar = "";

        try {
             paraGrabar+= gson.toJson(personas);

            bw.write(paraGrabar);
            bw.close();
            //System.out.println("Archivo:" + paraGrabar);

        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

/* // No se que es esa linea Type..
    public ArrayList<Persona> leerArchivo () throws IOException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String rta;

        Type personasTipo = new TypeToken<ArrayList<Persona>>(){}.getType();

        rta = br.readLine();
        ArrayList<Persona> personas = null;

        while (rta!= null) {
            personas = gson.fromJson(rta, personasTipo);
            rta = br.readLine();
        }
            br.close();

        return personas;
    }
*/

    public void leerArchivoJson () throws FileNotFoundException {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader(archivo)); /// Iniciamos el buffer
        JsonParser parser = new JsonParser(); // iniciamos el parser

        JsonElement element = parser.parse(br); // parceando el buffer

        JsonArray a = element.getAsJsonArray(); // Tengo un arreglo de Elementos Json

        for (JsonElement e : a){
            Persona p = gson.fromJson(e.getAsJsonObject(),Persona.class); // Obtengo una persona de un elemento json
            System.out.println(p.toString());
        }

    }
}
