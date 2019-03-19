# Utilidades de Programación 
## Dpto. Informática - I.E.S. Aguadulce

En este proyecto se incluye una serie de utilidades para programación. En 
este proyecto encontrarás:

* Código fuente del proyecto.
* Descargas de **los paquetes ".jar"** para incorporarlo en vuestro proyecto. Puedes encontrarlo [aquí](./downloads/). Los archivos .jar incluyen la documentación, por lo que solo tienes que incorporarlas a tu proyecto para que funcionen.
* [**Documentación**](./documentation/) para cada versión publicada.

### Ejemplos de utilización Versión 1.0.0.
        
        int numero;
        double nReal;
        String txt;
        Character c;

        /* Leer un número por teclado. */
        numero=ES.leeEntero("Introduce un número entero cualquiera:");
        ES.msg("El número 1 leído es:");
        ES.msgln(numero);
        
        /* Leer un número mayor o igual a 10. */        
        numero=ES.leeEntero("Introduce un número mayor o igual a 10:",10);
        ES.msg("El número 2 leído es:");
        ES.msgln(numero);

        /* Lee un número entre 10 y 20 ámbos incluidos. */        
        numero=ES.leeEntero("Introduce un número entre 10 y 20 ámbos incluidos:",10, 20);
        ES.msg("El número 3 leído es:");
        ES.msgln(numero);
        
        /* Lee un número opcional. Si no se introduce, se retorna "-100": */
        numero=ES.leeOptEntero("Introduce un número opcional (o pulsa enter):", -100);
        ES.msg("El número 4 leído es:");
        ES.msgln(numero);
        
        /* Lee un número opcional mayor o igual de 10. Si no se introduce
        se retorna -100. */
        numero=ES.leeOptEntero("Introduce un número opcional mayor o igual a 10 (o pulsa enter):", 10, -100);
        ES.msg("El número 5 leído es:");
        ES.msgln(numero);
        
        /* Lee un número opcional entre 10 y 20, ambos incluidos.
        Si no se introduce, retorna -100. */
        numero=ES.leeOptEntero("Introduce un número opcional entre 10 y 20 ambos incluidos (o pulsa enter):", 10, 20, -100);
        ES.msg("El número 6 leído es:");
        ES.msgln(numero);
                    
        /* Lee un número real cualquiera */
        nReal=ES.leeReal("Introduce un número real cualquiera:");
        ES.msg("El número real leído es:");
        ES.msgln(nReal);
        
        /* Lee un número real mayor de 10 */
        nReal=ES.leeReal("Introduce un número real mayor o igual que 10:", 10);
        ES.msg("El número real leído es:");
        ES.msgln(nReal);
        
        /* Lee un número real entre 10 y 20, ambos incluidos. */        
        nReal=ES.leeReal("Introduce un número real entre 10 y 20, ambos incluidos:", 10,20);
        ES.msg("El número real leído es:");
        ES.msgln(nReal);
        
        /* Lee un número real opcional. Si no se introduce retorna -1. */
        nReal=ES.leeOptReal("Introduce un número real opcional:",-1);
        ES.msg("El número real leído es:");
        ES.msgln(nReal);
        
        /* Lee un número real opcional mayor de 10. Si no se introduce retorna -1 */
        nReal=ES.leeOptReal("Introduce un número real opcional mayor de 10:",10,-1);
        ES.msg("El número real leído es:");
        ES.msgln(nReal);
        
        /* Lee un número real opcional entre 10 y 20, ambos incluidos. Si no 
        se introduce el número, retorna -1.*/
        nReal=ES.leeOptReal("Introduce un número real opcional entre 10 y 20, ambos incluidos:", 0,20,-1);
        ES.msg("El número real leído es:");
        ES.msgln(nReal);

        /* Lee un número real entre 10 y 20, ambos incluidos.
        Este método usa la versión "compleja" de leeReal, es mejor usar otras
        versiones más sencillas. */
        nReal=ES.leeReal("Introduce un número real entre 10 y 20 ambos incluidos:",(d)->d>=10 && d<=20, "El número no está entre 10 y 20", false);
        ES.msg("El número real leído es: ");
        ES.msgln(nReal);

        /* Lee si o no, retornando "S" o "N" */
        txt=ES.preguntarSiONo("Introduce si o no (S/N):");
        ES.msg("La opción leída ha sido: ");
        ES.msgln(txt);
        
        /* Lee una opción entre "a", "b" o "c" */
        txt=ES.preguntaOpcion("Introduce a,b o c:", true, false, "a","b","c");
        ES.msg("La opción leída ha sido: ");
        ES.msgln(txt);
        
        /* Lee una opción entre "a", "b" o "c", pudiendo no teclear nada (null) */
        txt=ES.preguntaOpcion("Introduce a,b o c (opcional):", true, true, "a","b","c");
        ES.msg("La opción leída ha sido: ");
        ES.msgln(txt);
        
        /* Lee una cadena obligatoria por teclado: */
        txt=ES.leeCadena("Introduce una cadena (obligatorio):");
        ES.msg("La cadena leída ha sido: ");
        ES.msgln(txt);
        
        /* Lee una cadena opcional por teclado: */
        txt=ES.leeCadena("Introduce una cadena (opcional):", true);
        ES.msg("La cadena leída ha sido: ");
        ES.msgln(txt);
        
        /* Lee un carácter obligatorio por teclado */
        c=ES.leeCaracter("Introduce un caracter:");
        ES.msg("El caracter leído ha sido: ");
        ES.msgln(c);

        /* Lee un carácter opcional por teclado */
        c=ES.leeCaracter("Introduce un caracter opcional:", true);
        ES.msg("El caracter leído ha sido: ");
        ES.msgln(c);

### Ejemplos de utilización del texto tabulado

        ES.msgln("***");
        ES.addTab();
        ES.msgln("***");
        ES.addTab();        
        ES.msg("*** ");
        ES.msg("*** ");
        ES.msgln("*** ");
        ES.msg("*** ");
        ES.msg("*** ");
        ES.msgln("*** ");
        ES.delTab();
        ES.msgln("***");
        ES.delTab();
        ES.msgln("***");
        ES.delTab();`

La salida del código anterior sería algo como lo siguiente:

	***
		***
			*** *** *** 
			*** *** *** 
		***
	***
