

public abstract class Mascota {
    private int id; 
    private String nombre;
    private int edad;

    public Mascota(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Edad: " + edad);
    }

    public abstract String hacerSonido(); 
}