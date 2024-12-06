
import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import java.io.File;

public class PrincipalInsertar 
{
    public static void main(String[] args) 
    {
        //Borramos la BBDD db4o cada vez
        File fichero = new File("BDJefeHijo");
        fichero.delete();

        // Crear conexión a la base de datos
        EmbeddedObjectContainer baseDatos=Db4oEmbedded.openFile("BDJefeHijo");
        
        try  {
            System.out.println("Conexión a la base de datos creada.");
            
            // Aquí se añaden los jefes y sus hijos
            baseDatos.store(new Jefe ("Angel", 5, 53, new Hijo("Gustavo", 7)));
            baseDatos.store(new Jefe ("Nieves", 3, 45, new Hijo("Ivan", 3)));
            baseDatos.store(new Jefe ("Jesus", 3, 5, new Hijo("Noelia", 3)));
            baseDatos.store(new Jefe ("Dolores", 5, 63, new Hijo("Sergio", 7)));
            baseDatos.store(new Jefe ("Vicki", 3, 5, null));
            baseDatos.store(new Jefe ("Fatima", 5, 63, new Hijo("Lidia", 27)));
            baseDatos.store(new Jefe ("Juan Luis", 3, 5, null));
            baseDatos.store(new Jefe ("Elena", 1, 42, new Hijo("David", 19)));
            baseDatos.store(new Jefe ("Miguel", 20, 45, new Hijo("Paula", 3)));
            baseDatos.store(new Jefe ("Jesus", 19, 44, new Hijo("Ruben", 12)));
           
            System.out.println("Registros insertados con éxito");
           
        } finally {
            baseDatos.close();// Asegúrate de cerrar la conexión
        }
    }
}
