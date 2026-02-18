import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaContactos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<String>> agenda = new HashMap<>();

        int opcion;

        do {
            System.out.println("\n--- AGENDA ---");
            System.out.println("1. Añadir teléfono a contacto");
            System.out.println("2. Mostrar teléfonos de un contacto");
            System.out.println("3. Mostrar agenda completa");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del contacto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    if (agenda.containsKey(nombre)) {
                        agenda.get(nombre).add(telefono);
                    } else {
                        ArrayList<String> listaTelefonos = new ArrayList<>();
                        listaTelefonos.add(telefono);
                        agenda.put(nombre, listaTelefonos);
                    }

                    System.out.println("Teléfono añadido correctamente.");
                    break;

                case 2:
                    System.out.print("Nombre del contacto: ");
                    String buscar = scanner.nextLine();

                    if (agenda.containsKey(buscar)) {
                        System.out.println("Teléfonos de " + buscar + ":");
                        for (String t : agenda.get(buscar)) {
                            System.out.println("- " + t);
                        }
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    break;

                case 3:
                    System.out.println("\nAgenda completa:");
                    for (Map.Entry<String, ArrayList<String>> entrada : agenda.entrySet()) {
                        System.out.println(entrada.getKey() + ":");
                        for (String t : entrada.getValue()) {
                            System.out.println("  - " + t);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}