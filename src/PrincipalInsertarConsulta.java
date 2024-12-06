import com.db4o.*;
import com.db4o.query.Query;

public class PrincipalInsertarConsulta {
    public static void main(String[] args) {
        Query con;
        Hijo h;
        ObjectSet cons;

        // Crear conexión a la base de datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
        try {
            // Obtener todos los jefes
            System.out.println("\n\nVamos a visualizar los datos de todos los jefes(con la informacion de los hijos");
            
            /* 
            -> queryByExample(Object template):Es un método para realizar consultas en DB4O mediante un "ejemplo".
            Se pasa un objeto de ejemplo (en este caso, un objeto de la clase Jefe) con ciertos valores nulos o predeterminados.
            DB4O devolverá todos los objetos que coincidan con este ejemplo.
            */
            
            ObjectSet res = baseDatos.queryByExample(new Jefe(null, 0, 0, null)); 
            //Se crea un objeto de ejemplo de la clase Jefe donde todos los atributos están vacíos o inicializados al valor predeterminado.
            //Esto significa que se recuperarán todos los objetos de la clase Jefe almacenados en la base de datos.
            while (res.hasNext()) {
                Jefe j = (Jefe) res.next(); // Recupera el siguiente objeto del conjunto.
                j.visDatosEmpleados();      // Llama a un método para mostrar información.
            }

            // Obtener todos los hijos
            System.out.println("\n\nVisualizacion de los hijos de los jefes");
            
            // Query: Es la interfaz utilizada para construir consultas en DB4O.
            // Crea una nueva consulta vacía.
            con = baseDatos.query();

            // Restringe la consulta a objetos de la clase Hijo. Solo los objetos de este
            // tipo serán considerados en los resultados.
            con.constrain(Hijo.class);

            // Ejecuta la consulta y devuelve una lista de resultados (un objeto ObjectSet).
            cons = con.execute();
            while (cons.hasNext()) {
                h = (Hijo) cons.next();
                h.visualHijo();
            }

        } finally {
            baseDatos.close();// Asegúrate de cerrar la conexión
        }
    }
}
