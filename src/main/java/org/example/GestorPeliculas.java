package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorPeliculas {

    private static final String ARCHIVO = "peliculas.json";
    private final Gson gson;

    public GestorPeliculas() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Lee el fichero completo y devuelve la lista
    private List<Pelicula> leerPeliculas() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(file)) {
            Pelicula[] array = gson.fromJson(reader, Pelicula[].class);
            if (array == null) return new ArrayList<>();
            return new ArrayList<>(Arrays.asList(array));
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Escribe la lista completa en el fichero
    private void guardarPeliculas(List<Pelicula> peliculas) {
        try (Writer writer = new FileWriter(ARCHIVO)) {
            gson.toJson(peliculas, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero: " + e.getMessage());
        }
    }

    public void agregar(Pelicula pelicula) {
        List<Pelicula> lista = leerPeliculas();
        lista.add(pelicula);
        guardarPeliculas(lista);
        System.out.println("Película añadida correctamente.");
    }

    public void modificar(int id, Pelicula nueva) {
        List<Pelicula> lista = leerPeliculas();
        boolean encontrada = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                nueva.setId(id);
                lista.set(i, nueva);
                encontrada = true;
                break;
            }
        }
        if (encontrada) {
            guardarPeliculas(lista);
            System.out.println("Película modificada correctamente.");
        } else {
            System.out.println("No se encontró ninguna película con id " + id + ".");
        }
    }

    public void eliminar(int id) {
        List<Pelicula> lista = leerPeliculas();
        boolean eliminada = lista.removeIf(p -> p.getId() == id);
        if (eliminada) {
            guardarPeliculas(lista);
            System.out.println("Película eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna película con id " + id + ".");
        }
    }

    public Pelicula buscarPorId(int id) {
        List<Pelicula> lista = leerPeliculas();
        for (Pelicula p : lista) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public List<Pelicula> listarTodas() {
        return leerPeliculas();
    }
}
