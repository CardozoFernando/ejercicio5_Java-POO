package ar.edu.utnfc.backend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    
    String nombre;
    int dni;
    short edad;
    String ocupacion;
    int cantidadPosteos;
    float horasEnPlataforma;
    boolean verificado;

    public boolean esMayorDeEdad(int edad) {
        if (this.getEdad() > edad ) {
            return true;
        }
        return false;
    }

}
