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
Para ver elconjunto de archivos y directorioscreados por elcomando mvn ejecute elcomando tree.
$ tree

imagen arbol 

### AJUSTAR ALGUNAS CONFIGURACIONES ENEL PROYECTO
Edite el archivo pom.xml y realize la siguiente actualización:
Hay que cambiar la version delcompilador de Java a la versión 8, para ello, agregue la sección properties antes de la sección de
dependencias: 

    <properties>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.source>1.8</maven.compiler.source>
    </properties>
    
### COMPILAR Y EJECUTAR

Para compilar ejecute elcomando:
$ mvn package

Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando mvn.
Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase App.java como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html

imagen

Realice elcambio en la clase App.java para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. Utilizar la primera posición del parámetro que llega al método "main" para realizar el saludo personalizado, en caso que no sea posible, se debe mantener el saludo como se
encuentra actualmente:

Buscarcómo enviar parámetros al plugin "exec".
Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!
Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!

Se comprueba la longitud, si esta vacia se retorna el mensaje por defecto "Hello world!" si no, se crea una variable donde se sumarizan todas las posiciones de la cadena de caracteres y se le añade al principio un hello y al final un signo de admitracion 

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
