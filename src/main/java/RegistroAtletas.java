import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroAtletas {
    private List<Atleta> atletas;
    private Gson gson;

    public RegistroAtletas() {
        this.atletas = new ArrayList<>();
        // Configura Gson para manejar LocalDate correctamente
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void agregarAtleta(Atleta atleta) {
        atletas.add(atleta);
    }

    public Atleta buscarAtleta(String nombre) {
        for (Atleta atleta : atletas) {
            if (atleta.getNombre().equalsIgnoreCase(nombre)) {
                return atleta;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void guardarDatos(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            gson.toJson(atletas, writer);
            System.out.println("Datos guardados exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public void cargarDatos(String nombreArchivo) {
        try (FileReader reader = new FileReader(nombreArchivo)) {
            Type tipoListaAtletas = new TypeToken<ArrayList<Atleta>>(){}.getType();
            atletas = gson.fromJson(reader, tipoListaAtletas);
            if (atletas == null) {
                atletas = new ArrayList<>();
            }
            System.out.println("Datos cargados exitosamente desde " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("No se pudo encontrar el archivo de datos, se iniciará con una lista vacía.");
            atletas = new ArrayList<>();
        }
    }
}