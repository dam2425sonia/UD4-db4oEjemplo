import com.db4o.*;
import com.db4o.query.Query;

public class PrincipalModificar {

    public static void main(String[] args) {
        Jefe j;
        ObjectSet res;

        // Crear conexión a la base de datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
        try {
            // Query: Es la interfaz utilizada para construir consultas en DB4O.
            // Crea una nueva consulta vacía.
            Query cons = baseDatos.query();

            // Restringe la consulta a objetos de la clase Jefe. Solo los objetos de este
            // tipo serán considerados en los resultados.
            cons.constrain(Jefe.class);

            // Especifica que se está consultando el campo nombre de los objetos de tipo
            // Jefe. Filtra los resultados para que solo incluyan objetos cuyo campo nombre
            // tenga
            // el valor "Miguel".
            cons.descend("nombre").constrain("Miguel");

            // Ejecuta la consulta y devuelve una lista de resultados (un objeto ObjectSet).
            res = cons.execute();

            // res.hasNext(): Verifica si hay más resultados en el conjunto.
            while (res.hasNext()) {
                j = (Jefe) res.next(); // Obtiene el siguiente objeto de los resultados.
                j.cumpleAños(); // Llama al método `cumpleAños()` del objeto `Jefe` para incrementar la edad
                baseDatos.store(j); // Actualiza el objeto en la base de datos.
            }

            System.out.println("Información de los jefes");
            cons = baseDatos.query(); // Crea una nueva consulta vacía.
            cons.constrain(Jefe.class); // Restringe la consulta a objetos de la clase Jefe. Solo los objetos de este
                                        // tipo serán considerados en los resultados.
            // Ejecuta la consulta y devuelve una lista de resultados (un objeto ObjectSet).
            res = cons.execute();
            while (res.hasNext()) {
                j = (Jefe) res.next(); // Obtiene el siguiente objeto de los resultados.
                j.visDatosEmpleados(); // Llama al método `visDatosEmpleados()` del objeto `Jefe` para mostrar la info
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            baseDatos.close();
        }

    }
}
