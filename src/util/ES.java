package util ;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Esta clase define algunos métodos para entrada y salida de datos auxiliares,
 * que mejoran la entrada y salida tradicional.
 * 
 * Estos métodos capturan los errores de entrada sin abortar, en caso de que el usuario 
 * introduzca datos no válidos.
 * 
 * También incluye métodos para simplificar la escritura de mensajes
 * en pantalla, como son los métodos msg y msgln. 
 * 
 * Se hace uso también de la sobrecarga de métodos. 
 * 
 * @author Profesorado programación I.E.S. Aguadulce.
 * @version 1.0.0
 */
public class ES {
    
    /**
     * Prefijo para lecturas de datos opcionales.
     */
    public final static String OPTIONAL_PREFIX = "(Op)";
    /**
     * Prefijo para lecturas de datos obligatorias.
     */
    public final static String COMPULSORY_PREFIX = "*";
    /**
     * Debe o no mostrarse el prefijo de opcionalidad u obligatoriedad.
     * Variable de control.
     */
    private static boolean showPromptPrefix=true;
    /**
     * Tabulaciones a añadir delante de cada línea.
     */
    private static String tabs="";
    /**
     * Constante separador de líneas (dependiente del sistema).
     */
    private final static String LINE_SEP=System.getProperty("line.separator");
    
    /**
     * Añadir tabulación a cada línea.
     * El texto se tabulará siempre que se usen los métodos "msg**"
     */
    public static void addTab()
    {
        tabs=tabs.concat("\t");
    }
    
    /**
     * Eliminar tabulacion.
     * El texto se tabulara siempre que se usen los métodos "msg**".
     */
    public static void delTab()
    {
        if (tabs.length()>0)
            tabs=tabs.substring(1);
    }
    
    /**
     * Permite comprobar si se mostrará el prefijo de obligatoriedad u 
     * opcionalidad de una entrada de datos.
     * @return true si se mostrará o false en caso contrario.
     */
    public static boolean isShowPromptPrefix() {
        return showPromptPrefix;
    }

    /**
     * Establece si se mostrará o no el prefijo de obligatoriedad u
     * opcionalidad de una entrada de datos.
     * @param showPromptPrefix true si se desea mostrar el prefijo
     * y false en caso contrario.
     */
    public static void setShowPromptPrefix(boolean showPromptPrefix) {
        ES.showPromptPrefix = showPromptPrefix;
    }
                   
    
    /**
     * Este método sirve para leer desde teclado cualquier número entero en el
     * rango de números del tipo int. La lectura se estará repitiendo hasta que
     * el valor suministrado esté en ese rango.
     *
     * @return El número entero leído.
     */
    @Deprecated
    public static int leeEntero() {
        return leeEntero(null);
    }

    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int, que será el
     * dato leído. La lectura se estará repitiendo hasta que el valor
     * suministrado esté en ese rango.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @return El número entero leído.
     */
    public static int leeEntero(String mensaje) {        
        return leeEntero(mensaje,null,null,null);
    }    
    
    /**
     * Este método sirve para leer desde teclado cualquier número entero en el
     * rango de números del tipo int que además sea mayor o igual que el valor
     * mínimo indicado como parámetro. La lectura se estará repitiendo hasta que
     * el valor suministrado esté en ese rango.
     *
     * @param minimo Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     */
    @Deprecated
    public static int leeEntero(int minimo) {        
        return leeEntero(null,minimo);
    }

    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int que además
     * sea mayor o igual que el valor mínimo indicado como parámetro. La lectura
     * se estará repitiendo hasta que el valor suministrado esté en ese rango.
     *
     * @param mensaje  Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param minimo  Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     */
    public static int leeEntero(String mensaje, final int minimo) {
        return leeEntero(mensaje,(t)->t>=minimo,
                String.format("El número debe ser mayor o igual a %d.",minimo),
                null);                      
    }

    /**
     * Este método sirve para leer desde teclado cualquier número entero en el
     * rango de números del tipo int que además sea mayor o igual que el valor
     * mínimo indicado como primer parámetro y menor o igual que el valor máximo
     * indicado como segundo parámetro. La lectura se estará repitiendo hasta
     * que el valor suministrado esté en ese rango.
     *
     * @param minimo Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @param maximo Es el valor más alto dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     * @throws IllegalArgumentException Lanza excepción si el parámetro mínimo
     *   es mayor que el máximo.
     */
    @Deprecated
    public static int leeEntero(int minimo, int maximo) throws IllegalArgumentException {       
        return leeEntero(null,minimo,maximo);
    }
    
    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int que además
     * sea mayor o igual que el valor mínimo indicado como primer parámetro y
     * menor o igual que el valor máximo indicado como segundo parámetro. La
     * lectura se estará repitiendo hasta que el valor suministrado esté en ese
     * rango.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param minimo Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @param maximo Es el valor más alto dentro del rango de los números.
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     * @throws IllegalArgumentException Lanza excepción si el parámetro mínimo
     *   es mayor que el máximo.
     */
    public static int leeEntero(String mensaje, int minimo, int maximo) throws IllegalArgumentException {
        int numero=0;
        if (minimo <= maximo) {
            numero=leeEntero(mensaje,(n)->n>=minimo && n<=maximo,
                    String.format("Error: Debe ser un número entero mayor o igual que %d y menor o igual que %d.",minimo,maximo),
                    null);            
        } else {
            // Si el valor mínimo es mayor que el máximo, lanzamos una excepción
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor máximo.");
        }
        return numero;
    }  
    
    /**
     * Lee entero opcional.
     * 
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int, que será el
     * dato leído. La lectura se estará repitiendo hasta que el valor
     * suministrado esté en ese rango. 
     * 
     * Si el usuario no introduce un número (directamente pulsa enter) 
     * el método retornará el valor por defecto indicado.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param valorPorDefecto Es el valor retornado en caso de que el usuario
     * no introduzca nada (directamente enter).
     * @return El número entero leído.
     */
    public static int leeOptEntero(String mensaje, int valorPorDefecto) {        
        Integer m=leeEntero(mensaje,null,null,true);
        return m!=null ? m : valorPorDefecto;
    }
    
    /**
     * Lee entero opcional mayor o igual a un mínimo.
     * 
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int, que será el
     * dato leído. La lectura se estará repitiendo hasta que el valor
     * suministrado esté por encima de un número mínimo. 
     * 
     * Si el usuario no introduce un número (directamente pulsa enter) 
     * el método retornará el valor por defecto indicado.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param minimo Valor mínimo a introducir por el usuario.     
     * @param valorPorDefecto Es el valor retornado en caso de que el usuario
     * no introduzca nada (directamente enter).
     * @return El número entero leído.
     */
    public static int leeOptEntero(String mensaje, int minimo, int valorPorDefecto) {        
        Integer m=leeEntero(mensaje,
                (t)->t>=minimo,
                String.format("El número debe ser mayor o igual a %d.",minimo)
                ,true);
        return m!=null ? m : valorPorDefecto;
    }
    
    /**
     * Lee entero opcional en un rango [mínimo, máximo], ambos incluidos.
     * 
     * Este escribe el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int, que será el
     * dato leído. La lectura se estará repitiendo hasta que el valor
     * suministrado sea superior o igual al número mínimo e inferior o igual
     * al número máximo.
     * 
     * Si el usuario no introduce un número (directamente pulsa enter) 
     * el método retornará el valor por defecto indicado.
     * 
     * Si el usuario no introduce un 
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param minimo Valor mínimo permitido.
     * @param maximo Valor máximo permitido.
     * @param valorPorDefecto Es el valor retornado en caso de que el usuario
     * no introduzca nada (directamente enter).
     * @return El número entero leído.
     */
     public static int leeOptEntero(String mensaje, int minimo, int maximo, int valorPorDefecto) {

        Integer m=null;
        if (minimo <= maximo) {
            m = leeEntero(mensaje,
                    (n) -> n >= minimo && n <= maximo,
                    String.format("El número debe ser mayor o igual a %d.", minimo),
                     true);
        } else {
            // Si el valor mínimo es mayor que el máximo, lanzamos una excepción
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor máximo.");
        }
        return m != null ? m : valorPorDefecto;
    }    
    
    /**
     * Método genérico para leer un número entero, permitiendo su comprobación
     * a través de un predicado. Todos los parámetros pueden ser null.
     * 
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número. Si es null, no se mostrará el mensaje.
     * @param t Función lambda que implementa un predicado con el que se comprobará
     * si el número introducido coincide o no con el valor esperado. Si es
     * null no se realizará ninguna comprobación.
     * @param errorMessage Es el mensaje que se muestra en caso de que el número
     * no cumpla con el predicado. Si es null no se mostrará el mensaje de error.
     * @param canBeEmpty Si este flag es true, se admitirá que el usuario no 
     * introduzca nada, situación en la que el método retornará NULL. Si
     * canBeEmpty, a su vez, es null, se considerará como false (no debe
     * admitir un valor vacío)
     * @return  El número entero leído o null (en caso de que canBeEmpty sea true y
     * el usuario no introduzca una cadena).
     */
    public static Integer leeEntero(String mensaje, Predicate<Integer> t, String errorMessage, Boolean canBeEmpty) {
        Integer numero = null;
        boolean leido = false;
        Scanner teclado = new Scanner(System.in);
        do {
            if (mensaje != null && mensaje.length() > 0) {
                prompt(mensaje, canBeEmpty);
            }

            String tmp = teclado.nextLine();
            if (!tmp.isEmpty()) {
                try {
                    numero = Integer.parseInt(tmp);
                    if (t == null || t.test(numero)) {
                        leido = true;
                    } else {
                        if (errorMessage != null && errorMessage.length() > 0) {
                            error(errorMessage);
                        }
                    }
                } catch (NumberFormatException e) {
                    error(String.format("\"%s\" no es un número entero válido. ", tmp.trim()));
                }            
            } else if (canBeEmpty==null || canBeEmpty==false) {
                error("Debe introducirse un número entero válido.");
            } 
            else
            {
                numero=null;
                leido=true;
            }
        } while (!leido);
        return numero;
    }        
    
    /**
     * Lee un número real desde teclado.
     * 
     * Este método escribe el mensaje indicado (prompt) para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número real en el rango de números del tipo double, que será el
     * dato leído. 
     * 
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @return El número double leído.
     */
    public static double leeReal (String mensaje)
    {
        return leeReal(mensaje,null,null,null);
    }
    
    /**
     * Lee un número real desde teclado mayor o igual a uno dado.
     * 
     * Este método escribe el mensaje indicado (prompt) para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * de un número real mayor que el número mínimo indicado.
     * 
     * @param msg Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param min Mínimo valor aceptado.
     * @return El número double leído.
     */
    public static double leeReal (String msg, double min)
    {
        return leeReal(msg,(d)->d>=min,
                String.format("El número debe ser mayor o igual a %f.",min)
                ,null);
    }
    
    /**
     * Lee un número real desde teclado entre un mínimo y un máximo,
     * ambos incluidos.
     * 
     * Este método escribe el mensaje indicado (prompt) para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * de un número real entre el mínimo y máximo indicado, ambos incluidos.
     * 
     * @param msg Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param min Mínimo valor aceptado.
     * @param max Máximo valor aceptado.
     * @return El número double leído.
     * @throws IllegalArgumentException Lanza esta excepción si el mínimo es superior al máximo.
     */
    public static double leeReal (String msg, double min, double max)
            throws IllegalArgumentException
    {
        if (min>max)
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor máximo.");   
        return leeReal(msg,(d)->d>=min && d<=max,
                String.format("El número debe estar entre %f y %f (ambos incluidos).",min,max)
                ,null);
    }
    
    /**
     * Lee real opcional en un rango.
     * 
     * Este escribe el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número real. La lectura se estará repitiendo hasta que el valor
     * suministrado sea superior o igual al número mínimo e inferior o igual
     * al número máximo.
     * 
     * Si el usuario no introduce un número (directamente pulsa enter) 
     * el método retornará el valor por defecto indicado.
     * 
     * @param msg Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param valorPorDefecto Es el valor retornado en caso de que el usuario
     * no introduzca nada (directamente enter).
     * @return El número entero real leído.
     */    
    public static double leeOptReal (String msg, double valorPorDefecto)
    {
        Double d=leeReal(msg,null,null,true);
        if (d==null) d=valorPorDefecto;
        return d;
    }
    
     /**
     * Lee real opcional mayor que mínimo.
     * 
     * Este escribe el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número real. La lectura se estará repitiendo hasta que el valor
     * suministrado sea superior o igual al número mínimo indicado.
     * 
     * Si el usuario no introduce un número (directamente pulsa enter) 
     * el método retornará el valor por defecto indicado.
     * 
     * @param msg Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param min Valor mínimo permitido.
     * @param valorPorDefecto Es el valor retornado en caso de que el usuario
     * no introduzca nada (directamente enter).
     * @return El número entero real leído.
     */
    public static double leeOptReal (String msg, double min, double valorPorDefecto)
    {
        Double numReal=leeReal(msg,(doubleValue)->doubleValue>=min,
                String.format("El número debe ser mayor o igual a %f.",min)
                ,true);
        if (numReal==null) numReal=valorPorDefecto;
        return numReal;
    }
    
    /**
     * Lee real opcional en un rango [mínimo, máximo], ambos incluidos.
     * 
     * Este escribe el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número real. La lectura se estará repitiendo hasta que el valor
     * suministrado sea superior o igual al número mínimo e inferior o igual
     * al número máximo.
     * 
     * Si el usuario no introduce un número (directamente pulsa enter) 
     * el método retornará el valor por defecto indicado.
     * 
     * @param msg Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param min Valor mínimo permitido.
     * @param max Valor máximo permitido.
     * @param valorPorDefecto Es el valor retornado en caso de que el usuario
     * no introduzca nada (directamente enter).
     * @return El número entero real leído.
     */
    public static double leeOptReal (String msg, double min, double max, double valorPorDefecto)
    {
        if (min>max)
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor máximo.");   
        
        Double numReal=leeReal(msg,(d)->d>=min && d<=max,
                String.format("El número debe estar entre %f y %f (ambos incluidos).",min,max)
                ,true); 
        
        if (numReal==null) numReal=valorPorDefecto;
        
        return numReal;
    }
    
    
    /**
     * Método genérico para leer un número real (double), permitiendo su comprobación
     * a través de un predicado. Todos los parámetros pueden ser null.
     * 
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número. Si es null, no se mostrará el mensaje.
     * @param t Función lambda que implementa un predicado con el que se comprobará
     * si el número introducido coincide o no con el valor esperado. Si es
     * null no se realizará ninguna comprobación.
     * @param errorMessage Es el mensaje que se muestra en caso de que el número
     * no cumpla con el predicado. Si es null no se mostrará el mensaje de error.
     * @param canBeEmpty Si este flag es true, se admitirá que el usuario no 
     * introduzca nada, situación en la que el método retornará NULL. Si
     * canBeEmpty, a su vez, es null, se considerará como false (no debe
     * admitir un valor vacío)
     * @return  El número real (Double) leído o null (en caso de que canBeEmpty sea true y
     * el usuario no introduzca una cadena).
     */
    public static Double leeReal(String mensaje, Predicate<Double> t, String errorMessage, Boolean canBeEmpty) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);
        Double numero = null;
        boolean leido = false;
        if (nf == null) {
            throw new IllegalArgumentException("Formato de número no puede ser null.");
        }
        Scanner teclado = new Scanner(System.in);
        do {
            if (mensaje != null && mensaje.length() > 0) {
                prompt(mensaje, canBeEmpty);
            }
            String tmp = teclado.nextLine().trim();
            if (!tmp.isEmpty()) {
                ParsePosition p = new ParsePosition(0);
                Number numInst = nf.parse(tmp, p);
                if (p.getIndex() > 0 && p.getIndex() == tmp.length()) {
                    numero = numInst.doubleValue();
                    if (t == null || t.test(numero)) {
                        leido = true;
                    } else {
                        if (errorMessage != null && errorMessage.length() > 0) {
                            error(errorMessage);
                        }
                    }
                } else {
                    error(String.format("\"%s\" no es un número real válido (Ejemplo: %.2f)", tmp.trim(),9999.99));
                }
            } else if (canBeEmpty == null || canBeEmpty == false) {
                error(String.format("Debe introducirse un número real válido (Ejemplo: %.2f)",9999.99));
            } else {
                numero=null;
                leido = true;
            }
        } while (!leido);
        return numero;
    }
    
    /**
     * Lee desde teclado una respuesta para una pregunta de tipo Si o No,
     * mostrando por pantalla la pregunta en cuestión. Sólo se admiten como
     * respuestas S, s, N o n.
     *
     * @param mensaje  Es el mensaje que se envía con la pregunta cuya
     * respuesta se espera que sea S o N.
     * @return la cadena "S" si se ha respondido "S" o "s" y la cadena "N" si se
     * ha respondido "N" o "n".
     */
    public static String preguntarSiONo(String mensaje) {        
        return preguntaOpcion(mensaje,true,false,"S","N");
    }
    
    /**
     * Lee desde teclado una respuesta para una pregunta de tipo Si o No,
     * mostrando por pantalla la pregunta en cuestión. Sólo se admiten como
     * respuestas S, s, N o bien n.
     *
     * @param mensaje  Es el mensaje que se envía con la pregunta cuya
     * respuesta se espera que sea S o N.
     * @return la cadena "S" si se ha respondido "S" o "s" y la cadena "N" si se
     * ha respondido "N" o "n".
     */
    @Deprecated
    public static String leeRespuesta (String mensaje)
    {
        return preguntarSiONo(mensaje);
    }
    
/**
 * 
 * Lee desde teclado una respuesta para una pregunta donde se aceptan una serie
 * de opciones (a, b, c, etc) mostrando por pantalla la pregunta en cuestión. 
 * 
 * @param mensaje Mensaje a mostrar para realizar la pregunta.
 * @param ignoreCase Ignora mayúsculas y minúsculas.
 * @param canBeEmpty Si la repuesta puede ser vacía o no (retornará null cuando
 * sea vacía).
 * @param a Lista separada por comas de opciones, o un array de string con las mismas.
 * @return La opción elegida por el usuario. Si canBeEmpty es true y el
 * usuario no introduce ninguna opción, se retornará null.
 */
    public static String preguntaOpcion (String mensaje, boolean ignoreCase, boolean canBeEmpty, String ...a)
    {
        Scanner in=new Scanner(System.in);
        List<String> l=Arrays.asList(a);
        if( ignoreCase )
            l=l.stream().map(s->s.toUpperCase()).distinct().collect(Collectors.toList());
        String listOfOptions=l.stream().collect(Collectors.joining(", "));
        boolean leido=false;
        String cad;
        do
        {        
            if (mensaje!=null) prompt(mensaje,canBeEmpty);
            cad=in.nextLine().trim();
            cad=ignoreCase?cad.toUpperCase():cad;            
            if (!cad.isEmpty() && l.contains(cad))                
                leido=true;
            else if (cad.isEmpty() && canBeEmpty)
            {
                cad=null;
                leido=true;
            }
            else
                error(String.format("Debe introducir una de las siguientes opciones: %s",listOfOptions));
        } while (!leido);
        return cad;
    }
    
     /**
     * Este método lee una cadena de caracteres desde teclado, y comprueba que
     * efectivamente la lectura se ha producido correctamente, mandando un
     * mensaje de error en caso de que haya fallado. 
     *
     * @param mensaje Mensaje a mostrar para indicar que el usuario debe
     * introducir un texto.
     * @param canBeEmpty Si el usuario puede no introducir el dato (true),
     * o si debe introducir el dato (false). Si el usuario no introduce nada,
     * retornará null cuando canBeEmpty sea true.
     * @return La cadena de caracteres leído desde el teclado, o null, en caso
     * de que el usuario no introduzca nada y pulse enter.
     */
    public static String leeCadena(String mensaje, boolean canBeEmpty) {
        Scanner in=new Scanner(System.in);    
        boolean leido=false;
        String cad;
        do
        {        
            if (mensaje!=null) prompt(mensaje,canBeEmpty);
            cad=in.nextLine().trim();
            
            if (!cad.isEmpty())                
                leido=true;
            else if (cad.isEmpty() && canBeEmpty)
            {
                cad=null;
                leido=true;
            }
            else
                error("Debe introducir una cadena no vacía.");
        } while (!leido);
        return cad;       
    }
    
   /**
     * Este método lee una cadena de caracteres desde teclado, y comprueba que
     * efectivamente la lectura se ha producido correctamente, mandando un
     * mensaje de error en caso de que haya fallado. No se admite una cadena 
     * vacía.
     *
     * @param mensaje Mensaje a mostrar para indicar que el usuario debe
     * introducir un texto.
     * @return La cadena de caracteres leído desde el teclado.
     */
    public static String leeCadena(String mensaje) {       
        return leeCadena(mensaje,false);
    }
    
    /**
     * Este método lee una cadena de caracteres desde teclado, y comprueba que
     * efectivamente la lectura se ha producido correctamente, mandando un
     * mensaje de error en caso de que haya fallado. No se admite una cadena 
     * vacía.
     * @return La cadena de caracteres leído desde el teclado.
     */
    @Deprecated
    public static String leeCadena() {       
        return leeCadena(null,false);
    }
    
     /**
     * Lee un carácter de teclado.
     * @param mensaje Mensaje a mostrar por pantalla
     * @return El carácter leído por teclado.
     */
    public static char leeCaracter(String mensaje) {
      
        return leeCaracter(mensaje, false);
    }
    
    /**
     * Lee un carácter de teclado.
     * 
     * @param mensaje Mensaje de texto a mostrar por pantalla para leer el carácter.
     * @param canBeEmpty True si puede ser vacío. Si es true y el usuario 
     * pulsa enter, retornará null.
     * @return el carácter o null si canBeEmpty es true y el usuario no teclea nada (solo pulsa enter).
     */
    public static Character leeCaracter(String mensaje, boolean canBeEmpty) {
      
        Scanner in=new Scanner(System.in);    
        boolean leido=false;
        Character car=null;
        do
        {        
            if (mensaje!=null) prompt(mensaje,canBeEmpty);
            String cad=in.nextLine().trim();
            
            if (!cad.isEmpty() && cad.length()==1)
            { 
                car=cad.charAt(0);
                leido=true;
            }
            else if (cad.isEmpty() && canBeEmpty)
            {
                car=null;
                leido=true;
            }
            else
                error("Debe introducir solo un carácter.");
        } while (!leido);
        return car;     
    }
    
    /**
     * Método interno para mostrar el prompt al usuario.
     * @param msg Texto de prompt
     */
    private static void prompt(String msg, Boolean canBeEmpty)
    {
        establecerColorTexto(ColorTexto.AZUL);
        
        if (isShowPromptPrefix())
            msg=( canBeEmpty==null || canBeEmpty==false ? COMPULSORY_PREFIX : OPTIONAL_PREFIX ).concat(msg);
        ES.msg(msg.length()>0 && msg.charAt(msg.length()-1)!=' ' ? msg.concat(" ") : msg);
        
        resetearColores();
    }       
    
    /**
     * Método interno para mostrar un mensaje de error al usuario.
     * @param msg Texto de error.
     */
    private static void error(String msg)
    {
        establecerColorTexto(ColorTexto.ROJO);
        ES.msgln(msg.startsWith("ERROR:")?msg:msg);        
        resetearColores();
    }        
                
    /**
     * Mostrar un número por pantalla.     
     * @param entero  Es es el valor entero de tipo int a imprimir como texto.
     */
    public static void msg(int entero) {
        msg(String.format("%d",entero));
    }
    
    /**
     * Mostrar un carácter por pantalla.
     * @param c  El carácter a imprimir como texto por pantalla.
     */
    public static void msg(Character c) {
        if (c!=null)
            msg(String.format("%c",c));
        else
            msg("[null value]");
    }

    /**
     * Mostrar un número entero largo por pantalla.     
     * 
     * @param enteroLargo Es es el valor entero de tipo long a imprimir como
     * texto.
     */
    public static void msg(long enteroLargo) {
        msg(String.format("%d",enteroLargo));
    }
    
    /**
     * Mostrar un número número real por pantalla.     
     *
     * @param real  Es es el valor real de tipo float a imprimir como texto.
     */
    public static void msg(float real) {
        msg(String.format("%f",real));
    }
    
     /**
     * Mostrar un número número double por pantalla.      
     * 
     * @param realLargo Es es el valor entero de tipo double a imprimir como
     * texto.
     */
    public static void msg(double realLargo) {
        msg(String.format("%f",realLargo));
    }

    /**
     * Variable que contiene si en el último mensaje se imprimio un salto
     * de línea. Usado para saber si tiene o no que añadirse tabulaciones.
     */
    private static boolean newLineControl=true;
    
    /**
     * Mostrar una cadena por pantalla.
     *      
     * @param cadenaAImprimir Es la cadena de texto que hay que escribir en
     * el dispositivo de salida estándar.
     */
    public static void msg(String cadenaAImprimir) {
                
        if (cadenaAImprimir==null) cadenaAImprimir="[null value]";
        System.out.print(newLineControl?tabs.concat(cadenaAImprimir):cadenaAImprimir);                        
        if (newLineControl) newLineControl=false;
        if (cadenaAImprimir.endsWith("\n") || cadenaAImprimir.endsWith(LINE_SEP))
            newLineControl=true;
        
    }    
    
    /**
     * Muestra un salto de línea por pantalla.
     */
    public static void msgln() {
        msg(LINE_SEP);
    }
    
    /**
     * Muestra una cadena por pantalla seguida de un salto de línea.
     * 
     * @param cadenaAImprimir Es la cadena de texto que hay que escribir en
     * el dispositivo de salida estándar.
     */
    public static void msgln(String cadenaAImprimir) {
        if (cadenaAImprimir==null) cadenaAImprimir="[null value]";
        msg(cadenaAImprimir.concat(LINE_SEP));
    }

    /**
     * Muestra un entero largo por pantalla seguido de un salto de línea.
     * 
     * @param entero Es es el valor entero de tipo int a imprimir como texto.
     */
    public static void msgln(int entero) {
        msg(entero);
        msgln();
    }
     
    /**
     * Muestra un carácter por pantalla seguido de un salto de línea.
     * 
     * @param caracter Es el carácter de tipo char a imprimir como texto.
     */
    public static void msgln(Character caracter) {
        msg(caracter);       
        msgln();
    }
    
     /**
     * Muestra un entero largo por pantalla seguido de un salto de línea.
     *
     * @param enteroLargo Es es el valor entero de tipo long a imprimir como
     * texto.
     */
    public static void msgln(long enteroLargo) {
        msg(enteroLargo);
        msgln();
    }

    /**
     * Muestra un real por pantalla seguido de un salto de línea.
     *
     * @param real Es es el valor real de tipo float a imprimir como texto.
     */
    public static void msgln(float real) {
        msg(real);
        msgln();
    }              
    
    /**
     * 
     * Muestra un real largo por pantalla seguido de un salto de línea.
     * 
     * @param realLargo Es es el valor entero de tipo double a imprimir como
     * texto.
     */
    public static void msgln(double realLargo) {
        msg(realLargo);
        msgln();
    }       
    
     /**
     * Códigos de color para ser usados a la hora de mostrar texto por pantalla
     * o como colores de fondo.     
     */
    public enum ColorTexto {  
        RESET(0),
        NEGRO(30),
        ROJO(31),
        VERDE(32),
        AMARILLO(33),
        AZUL(34),
        MAGENTA(35),
        CYAN(36),
        BLANCO(37);

        private final int colorCode;

        ColorTexto(int colorCode) {
            this.colorCode = colorCode;
        }
        
        /**
         * Obtiene la secuencia de escape ANSI asociada al color de texto.
         * @return Cadena con la secuencia de escape.
         */
        public final String codigoColorTexto() {
            return "\33[".concat(String.valueOf(this.colorCode)).concat("m");
        }
        /**
         * Obtiene la secuencia de escape ANSI asociada al color de fondo.
         * @return Cadena con la secuencia de escape.
         */
        public final String codigoColorFondo ()
        {
            return "\33[".concat(String.valueOf(this.colorCode+10)).concat("m");
        }        
    }
    
    /**
     * Método que permite establecer el color de texto mostrado por pantalla.
     * @param c Uno de los valores del enumerado ColorTexto.
     * @see ES.ColorTexto
     * @see ES#resetearColores
     */
    public static void establecerColorTexto (ColorTexto c)
    {
        System.out.print(c.codigoColorTexto());
    }
    
    /**
     * Método que permite establecer el color de fondo para el texto mostrado por pantalla.
     * @param c Uno de los valores del enumerado ColorTexto.
     * @see ES.ColorTexto
     * @see ES#resetearColores
     */
    public static void establecerColorFondo (ColorTexto c)
    {
        System.out.print(c.codigoColorFondo());
    }
    
    /**
     * Método que permite reestablecer a los valores por defecto el color del 
     * texto y el color de fondo.     
     */
    public static void resetearColores ()
    {
        System.out.print("\33[0m");
    }
    
}//class ES