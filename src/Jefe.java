public class Jefe {
    
    String nombre;
    int antiguedad;
    int edad;
    //Solo tendrá un hijo!! si queremos que tenga varios esto debería convertirse en una lista
    //List<Hijo> hijos;
    Hijo inforUnHijo; 

    Jefe(String nombre, int antiguedad, int edad, Hijo h) {
        this.nombre=nombre;
        this.antiguedad=antiguedad;
        this.edad=edad;
        //this.hijos = new ArrayList<>(); // Inicializa la lista vacía para varios hijos
        this.inforUnHijo=h;
    }

    /*
    //Si permitieramos tener varios hijos
    // Método para añadir un hijo al jefe
    void agregarHijo(Hijo h) {
        this.hijos.add(h);
    }
    */
    
    /*
    // Visualizar datos del jefe y de todos sus hijos
    void visDatosEmpleados() {
        System.out.println("\n" + nombre + " tiene " + edad + " años, lleva " + antiguedad + " años en la empresa.");
        if (!hijos.isEmpty()) {
            System.out.println("Los datos de sus hijos son:");
            for (Hijo h : hijos) {
                h.visualHijo(); // Llama al método de visualización de cada hijo
            }
        } else {
            System.out.println("No tiene hijos registrados.");
        }
    } */
    void visDatosEmpleados() {
        System.out.println("\n"+nombre+ " tiene " +edad+ " años, lleva "+antiguedad+" años"
                + "\nen la empresa"); 
        if (inforUnHijo != null)
        {
            System.out.println("Los datos de su hijo son : ");
            inforUnHijo.visualHijo();
        }
        
    }
    
    void cumpleAños ()
    {
        edad++;
    }

   
    
}