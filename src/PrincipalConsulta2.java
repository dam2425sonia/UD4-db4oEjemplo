import com.db4o.*;
import com.db4o.query.Query;

public class PrincipalConsulta2 {

    public static void main(String[] args) {
        Query cons;
        ObjectSet res;
        Jefe j;

        // Crear conexión a la base de datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
        try {

            System.out.println("\n\nVamos a visualizar los datos de todos los jefes + de 55 años con la informacion de los hijos");
            cons = baseDatos.query();
            cons.constrain(Jefe.class);
            cons.descend("edad").constrain(55).greater();

            res = cons.execute();
            while (res.hasNext()) {
                j = (Jefe) res.next();
                j.visDatosEmpleados();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            baseDatos.close();
        }
    }
}
