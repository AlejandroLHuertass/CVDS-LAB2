package edu.eci.cvds.patterns;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        if (args.length != 0) {
            String acumulador_string = "Hello ";
            for (int x = 0; x < args.length; x++) {
                acumulador_string += args[x]+" ";
            }
            System.out.println(acumulador_string+"!");
        } else {
            System.out.println( "Hello World!");
        }
    }
}
