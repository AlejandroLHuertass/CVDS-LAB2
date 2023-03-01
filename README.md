# Laboratorio 2 - CVDS

##  EJERCICIO DE LAS FIGURAS
### CREAR UNPROYECTO CON MAVEN
Buscar cómo se crea un proyecto maven con ayuda de los arquetipos(archetypes).
Busque cómo ejecutar desde línea de comandos el objetivo "generate" del plugin "archetype",con lossiguientes
parámetros: Grupo: edu.eci.cvds
Id del Artefacto: Patterns
Paquete: edu.eci.cvds.patterns
archetypeArtifactId: maven-archetype-quickstart

    mvn -B archetype:generate 
    -DgroupId=edu.eci.cvds 
    -DartifactId=Patterns 
    -Dpackage=edu.eci.cvds.patterns 
    -DarchetypeArtifactId=maven-archetype-quickstart

Se debió haber creado en el directorio, un nuevo proyecto Patterns a partir de un modelo o arquetipo, que crea un conjunto de directorioscon un conjunto
de archivos básicos.

Cambie al directorio Patterns:
$ cd Patterns
Para ver elconjunto de archivos y directorios creados por el comando mvn ejecute el comando tree.
$ tree

![imagen1](https://github.com/AlejandroLHuertass/CVDS-LAB2/blob/d88fd0495a98ed788573df226557ba82df743037/img/imagen%20(1).png)

imagen arbol 

### AJUSTAR ALGUNAS CONFIGURACIONES ENEL PROYECTO
Edite el archivo pom.xml y realize la siguiente actualización:
Hay que cambiar la versión del compilador de Java a la versión 8, para ello, agregue la sección properties antes de la sección de dependencias: 

    <properties>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.source>1.8</maven.compiler.source>
    </properties>
    
### COMPILAR Y EJECUTAR

Para compilar ejecute el comando:
$ mvn package

Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando mvn.
Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase App.java como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html

imagen

Realice el cambio en la clase App.java para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. Utilizar la primera posición del parámetro que llega al método "main" para realizar el saludo personalizado, en caso que no sea posible, se debe mantener el saludo como se
encuentra actualmente:

Buscar cómo enviar parámetros al plugin "exec".
Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!
Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!

Se comprueba la longitud, si esta vacia se retorna el mensaje por defecto "Hello world!" si no, se crea una variable donde se sumarizan todas las posiciones de la cadena de caracteres y se le añade al principio un hello y al final un signo de admiración 

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
### HACER EL ESQUELETO DE LA APLICACION

Creacion de paquetes:

#### Paquete Shapes

RegularShapeType:

    package edu.eci.cvds.patterns.shapes;
    public enum RegularShapeType {
	    Triangle, Quadrilateral, Pentagon, Hexagon
	    }
Shape

    package edu.eci.cvds.patterns.shapes;
    public interface Shape {
	    public int getNumberOfEdges();
	    }

ShapeMain

    edu.eci.cvds.patterns.shapes;
    public class ShapeMain {
        public static void main(String[] args) {
            if (args == null || args.length != 1) {
                System.err.println("Parameter of type RegularShapeType is required.");
                return;
            }
            try {
                RegularShapeType type = RegularShapeType.valueOf(args[0]);
                Shape shape = ShapeFactory.create(type);
                System.out.println(String.format("Successfully created a %s with %s sides.", type, shape.getNumberOfEdges()));
            } catch (IllegalArgumentException ex) {
                System.err.println("Parameter '" + args[0] + "' is not a valid RegularShapeType"); 
                return;
            }
        }
    }

#### Paquete Concrete

Hexagon

    package edu.eci.cvds.patterns.shapes.concrete;
    import edu.eci.cvds.patterns.shapes.Shape;
    
    public class Hexagon implements Shape {
        public int getNumberOfEdges() {
            return 6;
        }
    }

Pentagon

    package edu.eci.cvds.patterns.shapes.concrete;
    import edu.eci.cvds.patterns.shapes.Shape;
    
    public class Pentagon implements Shape {
        public int getNumberOfEdges() {
            return 5;
        }
    }

Quadrilateral

    package edu.eci.cvds.patterns.shapes.concrete;
    import edu.eci.cvds.patterns.shapes.Shape;
    
    public class Quadrilateral implements Shape {
        public int getNumberOfEdges() {
            return 4;
        }
    }

Triangle

    package edu.eci.cvds.patterns.shapes.concrete;
    import edu.eci.cvds.patterns.shapes.Shape;
    
    public class Triangle implements Shape {
        public int getNumberOfEdges() {
            return 3;
        }
    }

#### Finalmente el Factory 

ShapeFactory

    package edu.eci.cvds.patterns.shapes;
    import edu.eci.cvds.patterns.shapes.concrete.Triangle;
    import edu.eci.cvds.patterns.shapes.concrete.Quadrilateral;
    import edu.eci.cvds.patterns.shapes.concrete.Pentagon;
    import edu.eci.cvds.patterns.shapes.concrete.Hexagon;
    import javax.management.PersistentMBean;
    
    public class ShapeFactory {
        public static Shape create (RegularShapeType type) {
            switch (type) {
                case Hexagon:
                    return new Hexagon();
                case Pentagon:
                    return new Pentagon();
                case Quadrilateral:
                    return new Quadrilateral();
                case Triangle:
                    return new Triangle();
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

ejecución  
 
Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:
Sin parámetros
Parámetro: qwerty
Parámetro: pentagon
Parámetro: Hexagon
