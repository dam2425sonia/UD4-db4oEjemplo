/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {
    
    static String pedirCadena()
    {
        String cadena="";
        BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));
        try
        {
            cadena = teclado.readLine();
        }catch(IOException e)
        {
            System.out.println("\nSe ha procducido un error en la entrada de datos");
        }
        return cadena;
    }
    
    static int pedirEntero()
    {
        String cadena;
        int num=0;
        boolean correcto;
        do
        {
            correcto = true;
            cadena = pedirCadena();
            try
            {
                num = Integer.parseInt(cadena);
            }catch(NumberFormatException e)
            {
                    System.out.println("Error, ha insertado letras");
                    correcto = false;
            }
        }while(correcto == false);
        return num;
    }
    
    

}
