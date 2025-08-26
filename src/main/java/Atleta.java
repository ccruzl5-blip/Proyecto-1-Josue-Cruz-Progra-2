import java.util.ArrayList;
import java.util.List;

public class Atleta {
    private String nombre;
    private int edad;
    private String disciplina;
    private String departamento;
    private List<Entrenamiento> entrenamientos;

    // Constructor
    public Atleta(String nombre, int edad, String disciplina, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.disciplina = disciplina;
        this.departamento = departamento;
        this.entrenamientos = new ArrayList<>(); // Inicializa la lista de entrenamientos
    }

    // Método para agregar un entrenamiento
    public void agregarEntrenamiento(Entrenamiento entrenamiento) {
        this.entrenamientos.add(entrenamiento);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    @Override
    public String toString() {
        return "Atleta: " + nombre + " (" + edad + " años) - " + disciplina + " [" + departamento + "]";
    }
}