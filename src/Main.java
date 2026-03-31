import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        GestionMascotas gestion = new GestionMascotas();
        int opcion = 0;

        do {
            //hacemos el menu
            try {
                System.out.println("***** GESTIÓN DE MASCOTAS ****");
                System.out.println("1. Crear Mascota (Perro/Gato/Ave)");
                System.out.println("2. Mostrar Todas las Mascotas");
                System.out.println("3. Ejecutar sonido de una mascota (por ID)");
                System.out.println("4. Buscar mascota por nombre");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                
                opcion = Integer.parseInt(leer.nextLine());

                switch (opcion) {
                    case 1:
                        try {
                            System.out.print("ID: ");
                        int id = Integer.parseInt(leer.nextLine());
                            System.out.print("Nombre: ");
                        String nombre = leer.nextLine();
                            System.out.print("Edad: ");
                        int edad = Integer.parseInt(leer.nextLine());

                        if (id <= 0 || nombre.trim().isEmpty() || edad < 0) {
                            System.out.println("!ERROR!: Datos no válidos. ID debe ser > 0, nombre no vacío y edad >= 0.");
                        } 
                        else {
                            System.out.print("¿Es Perro (P), Gato (G), Ave (A)?: ");
                        String tipo = leer.nextLine(); 
                        if (tipo.equalsIgnoreCase("P")) {
                            gestion.agregarMascota(new Perro(id, nombre, edad));
                        } 
                        else if (tipo.equalsIgnoreCase("G")) {
                            gestion.agregarMascota(new Gato(id, nombre, edad));
                        } 
                        else if (tipo.equalsIgnoreCase("A")) {
                            gestion.agregarMascota(new Ave(id, nombre, edad));
                        } 
                        else {
                             System.out.println("Opción de mascota no válida. No se realizó el registro.");
                        }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("!ERROR!: Ingrese números válidos para ID y Edad.");
                        }
                        break;

                    case 2:
                        gestion.mostrarTodas();
                        break;

                    case 3:
                        System.out.print("Ingrese el ID de la mascota: ");
                        int idBuscar = Integer.parseInt(leer.nextLine());
                        Mascota m = gestion.buscarPorId(idBuscar);
                        if (m != null) {
                            System.out.println("La mascota con ID " + idBuscar + " hace: " + m.hacerSonido());
                        } else {
                            System.out.println("Mascota no encontrada.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el nombre a buscar: ");
                        String nomBuscar = leer.nextLine();
                        gestion.buscarPorNombre(nomBuscar);
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema de mascotas...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                //enn caso de que el suuario ingrese letras en el id 
                System.out.println("!ERROR!: Debe ingresar un número válido para ID, Edad u Opciones.");
            }
        } while (opcion != 5);

        leer.close();
    }
}