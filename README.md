5. Clientes de App - CSV
📝 Enunciado del Ejercicio
Se desea implementar un programa en Java que permita gestionar información de clientes de una red social.

Crear una clase llamada Cliente que contenga los siguientes atributos privados:

nombre (String)

dni

edad (short)

ocupacion (String)

cantidadPosteos (int)

horasEnPlataforma (float)

verificado (boolean)

Implementar:

Constructor con parámetros.

Métodos getters y setters para cada atributo.

Un método toString() que devuelva la información completa del cliente.

En la clase App, se requiere:

Importe los datos de un archivo CSV llamado clientes.csv.

Genere un vector (Cliente[]) con todos los registros cargados desde el archivo.

Muestre por consola los primeros 10 clientes cargados.

Maneje posibles excepciones (por ejemplo, FileNotFoundException) usando try-catch.

👉 El CSV tendrá 200 registros de clientes ficticios, con los campos separados por comas en este orden:
nombre,dni,edad,ocupacion,cantidadPosteos,horasEnPlataforma,verificado

Ejemplo de línea del CSV:

 
JuanPerez,12345678,25,Estudiante,57,12.5,true
📝 Enunciado Ampliado
Además de importar y mostrar los datos de los clientes, el programa debe:

Calcular la cantidad de clientes mayores de 25 años.
Implementar un método contarMayoresDe(int edad) que devuelva este valor (hacer el método genérico para poder ser reutilizado).

Calcular la cantidad total de posteos entre todos los clientes.
Implementar un método totalPosteos() que sume los posteos de todos.

Calcular la “puntuación de los clientes”.
La puntuación se define como:

(horasEnPlataforma * 2) si el cliente tiene más de 25 años.

(horasEnPlataforma * 3) si el cliente tiene 25 años o menos.

+20 puntos extra si el cliente está verificado

Implementar un método calcularPuntuacion() que devuelva la puntuación de un cliente, y otro método que muestre la puntuación de todos los clientes cargados.
