package org.example;

public class Pelicula {

    private int id;
    private String titulo;
    private String director;
    private int anio;
    private boolean ganadora;
    private String categoria;

    public Pelicula() {}

    public Pelicula(int id, String titulo, String director, int anio, boolean ganadora, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.ganadora = ganadora;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public boolean isGanadora() { return ganadora; }
    public void setGanadora(boolean ganadora) { this.ganadora = ganadora; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return id + " | " + titulo + " | " + director + " | " + anio +
                " | " + (ganadora ? "GANADORA" : "NOMINADA") +
                " | " + categoria;
    }
}