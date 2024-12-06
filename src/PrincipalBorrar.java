import com.db4o.*;
import com.db4o.query.Query;

public class PrincipalBorrar {
    public static void main(String[] args) {
        Jefe j;
        Hijo h;

        // Crear conexión a la base de datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");

        try {
            System.out.println("\n\nVamos a eliminar los datos de todos los jefes con antiguedad de menos de 6 años");
            
            Query cons = baseDatos.query();
            cons.constrain(Jefe.class);
            cons.descend("antiguedad").constrain(6).smaller();
            
            // Ejecuta la consulta y devuelve una lista de resultados (un objeto ObjectSet).
            ObjectSet res = cons.execute();
            while (res.hasNext()) {
                j = (Jefe) res.next();
                // Si tiene un hijo asociado, eliminarlo
                if (j.inforUnHijo != null) {
                    baseDatos.delete(j.inforUnHijo); // Elimina el hijo asociado
                }
                baseDatos.delete(j);
            }

            System.out.println("informacion de los jefes después de eliminar");
            cons = baseDatos.query();
            cons.constrain(Jefe.class);

            res = cons.execute();
            while (res.hasNext()) {
                j = (Jefe) res.next();
                j.visDatosEmpleados();
            }

            // Obtener todos los hijos
            System.out.println("\n\nVisualizacion de los hijos de los jefes");
            
            // Query: Es la interfaz utilizada para construir consultas en DB4O.
            // Crea una nueva consulta vacía.
            cons = baseDatos.query();

            // Restringe la consulta a objetos de la clase Hijo. Solo los objetos de este
            // tipo serán considerados en los resultados.
            cons.constrain(Hijo.class);

            // Ejecuta la consulta y devuelve una lista de resultados (un objeto ObjectSet).
            res = cons.execute();
            while (res.hasNext()) {
                h = (Hijo) res.next();
                h.visualHijo();
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            baseDatos.close();
        }

    }
}
