import java.util.ArrayList;
import java.util.List;

public class GestionMascotas {
    
    private List<Mascota> listaMascotas;

    public GestionMascotas() {
        this.listaMascotas = new ArrayList<>();
    }

    
    public void agregarMascota(Mascota m) {
        listaMascotas.add(m);
        System.out.println("Mascota registrada con exito: " + m.getNombre());
    }

    
    public void mostrarTodas() {
        if (listaMascotas.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }
        System.out.println("*** LISTA TOTAL DE MASCOTAS ***");
        for (Mascota m : listaMascotas) {
            m.mostrarInfo(); 
            System.out.println("Sonido: " + m.hacerSonido());
            System.out.println("_________________________");
        }
    }

    public Mascota buscarPorId(int id) {
        for (Mascota m : listaMascotas) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null; 
    }


    public void buscarPorNombre(String nombre) {
        boolean encontrada = false;
        for (Mascota m : listaMascotas) {
        
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                m.mostrarInfo();
                System.out.println("Sonido: " + m.hacerSonido());
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontro ninguna mascota con el nombre: " + nombre);
        }
    }
}