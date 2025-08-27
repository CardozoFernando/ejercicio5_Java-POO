package ar.edu.utnfc.backend;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String ruta = "src/clientes.csv"; // ruta relativa
        Cliente[] clientes = new Cliente[200]; 
        int count = 0;

        try (Scanner scanner = new Scanner(new File(ruta))) {
            scanner.nextLine(); // saltar encabezado

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");

                // Crear objeto Cliente a partir de los campos
                Cliente c = new Cliente(
                        campos[0],                     // nombre
                        Integer.parseInt(campos[1]),   // dni
                        Short.parseShort(campos[2]),   // edad
                        campos[3],                     // ocupacion
                        Integer.parseInt(campos[4]),   // cantidadPosteos
                        Float.parseFloat(campos[5]),   // horasEnPlataforma
                        Boolean.parseBoolean(campos[6])// verificado
                );

                clientes[count++] = c;
            }


            /*
            // Mostrar los primeros 10
            System.out.println("Primeros 10 clientes cargados:");
            for (int i = 0; i < Math.min(10, count); i++) {
                System.out.println(clientes[i]);
            } 
            */

        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }

        //Punto 1
        int mayoresDe25 = contarMayoresDe(25, clientes);
        System.out.println("Cantidad de clientes mayores de 25 años: " + mayoresDe25);

        //Punto 2
        int totalPosteos = totalPosteos(clientes);
        System.out.println("Cantidad total de posteos entre todos los clientes: " + totalPosteos);
    
        //Punto 3
        Object[][] puntuaciones = calcularPuntuacion(clientes, clientes.length);
        mostrarPuntuaciones(puntuaciones, clientes.length);
    }

    /*
     * Calcular la cantidad de clientes mayores de 25 años.
        Implementar un método contarMayoresDe(int edad) que 
        devuelva este valor (hacer el método genérico para poder ser reutilizado).
     */
    public static int contarMayoresDe(int edad, Cliente[] clientes){
        int cantidad = 0;
        for (Cliente cliente : clientes){
            if (cliente != null && ((Cliente) cliente).esMayorDeEdad(edad)){
                cantidad ++;
            }
        }
        return cantidad;
    }

    /*
     * Calcular la cantidad total de posteos entre todos los clientes.
Implementar un método totalPosteos() que sume los posteos de todos.
     */
    public static int totalPosteos(Cliente[] clientes){
        int cantidad = 0;
        for (Cliente cliente : clientes){
            if (cliente != null){
                cantidad += ((Cliente) cliente).getCantidadPosteos();
            }
        }

        return cantidad;
    }
    
    /*
     * Calcular la “puntuación de los clientes”.
        La puntuación se define como:

        (horasEnPlataforma * 2) si el cliente tiene más de 25 años.

        (horasEnPlataforma * 3) si el cliente tiene 25 años o menos.

        +20 puntos extra si el cliente está verificado

        Implementar un método calcularPuntuacion() que devuelva la puntuación 
        de un cliente, y otro método que muestre la puntuación de todos los clientes cargados.
     */
    public static Object[][] calcularPuntuacion(Cliente[] clientes, int longitud){
        Object[][] puntuaciones = new Object[longitud][2]; // count = cantidad de clientes cargados
        int i=0;
        for (Cliente cliente : clientes){
            if (cliente != null){
                float puntuacion = 0;
                if (cliente.esMayorDeEdad(25)){
                    puntuacion = cliente.getHorasEnPlataforma() * 2;
                } else {
                    puntuacion = cliente.getHorasEnPlataforma() * 3;
                }

                if (cliente.isVerificado()){
                    puntuacion += 20f;
                }
                puntuaciones[i][0] = cliente.getNombre(); // nombre
                puntuaciones[i][1] = puntuacion;          // puntuación
                i++;
                
            }
        }

        return puntuaciones;
        
    }

    public static void mostrarPuntuaciones(Object[][] puntuaciones, int longitud){
        System.out.println("Puntuaciones de los clientes:");
        for (int i = 0; i < longitud; i++){
            if (puntuaciones[i][0] != null){
                System.out.println("Cliente: " + puntuaciones[i][0] + " - Puntuación: " + puntuaciones[i][1]);
            }
        }
    }

}
