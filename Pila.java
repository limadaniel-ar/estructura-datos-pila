// Nombre: Lima, Daniel Alejandro
// Legajo: VINF013698

import java.util.Scanner;

/**
 * Esta es una clase que implementa una estructura de datos de pila con
 * operaciones básicas como apilar, desapilar, está vacío e imprimir la pila.
 */
public class Pila {
    // Estas líneas de código declaran e inicializan dos variables estáticas en la
    // clase Pila.
    static int nodo = -1;
    static int[] valores = new int[5];

    /**
     * Este es un programa de Java que implementa una pila controlada por menús
     */
    public static void main(String[] args) {
        boolean cerrarPrograma = false;
        int opcion = 0;
        int valorAAgregar = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            menuPrincipal();
            try {
                opcion = entrada.nextInt();
                entrada.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el número a apilar:");
                        try {
                            valorAAgregar = entrada.nextInt();
                            entrada.nextLine();
                            Pila.push(valorAAgregar);
                        } catch (Exception e) {
                            System.out.println("Sólo se pueden agregar números");
                            entrada.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("El elemento desapilado es: " + Pila.pop());
                        break;
                    case 3:
                        if (Pila.isEmpty()) {
                            System.out.println("La pila está vacía");
                        } else {
                            System.out.println("La pila no está vacía");
                        }
                        break;
                    case 4:
                        System.out.println("La pila se encuentra formada de la siguiente manera");
                        imprimirPila();
                        break;
                    case 5:
                        cerrarPrograma = true;
                        break;
                    default:
                        System.out.println("Error: Elija una opción correcta");
                        break;
                }
            } catch (Exception e) {
                System.out.println("La opción debe ser un número");
                entrada.nextLine();
            }
        } while (!cerrarPrograma);
    }

    /**
     * La función muestra un menú con opciones para una estructura de datos de pila.
     * 
     * @author Daniel Lima
     */
    public static void menuPrincipal() {
        System.out.println("Elija una opcion:");
        System.out.println("1. Apilar un número");
        System.out.println("2. Desapilar un número");
        System.out.println("3. Saber si la pila está vacía");
        System.out.println("4. Mostrar la pila completa");
        System.out.println("5. Salir del programa");
    }

    /**
     * Esta función imprime los valores de una pila en orden inverso.
     * 
     * @author Daniel Lima
     */
    public static void imprimirPila() {
        if (Pila.isEmpty()) {
            System.out.println("La pila está vacía");
        } else {
            for (int i = Pila.nodo; i >= 0; i--) {
                System.out.println(Pila.valores[i]);
            }
        }
    }

    /**
     * Esta función inserta un valor entero en una estructura de datos de pila, pero
     * imprime un mensaje de error si la pila ya está llena.
     * 
     * @param entrada un valor entero que representa el elemento que se colocará en
     *                la pila.
     * @author Daniel Lima
     */
    public static void push(int entrada) {
        if (nodo < valores.length - 1) {
            nodo++;
            valores[nodo] = entrada;
        } else {
            System.out.println("La pila está llena");
        }
    }

    /**
     * Esta función elimina y devuelve el elemento superior de una pila en Java, o
     * devuelve -1 si la pila está vacía.
     * 
     * @return El método devuelve un valor entero, que es el valor del elemento que
     *         se eliminó de la parte superior de la pila. Si la pila está vacía,
     *         devuelve -1.
     * @author Daniel Lima
     */
    public static int pop() {
        int valorEliminado;
        if (isEmpty()) {
            System.out.println("La pila está vacía, no se puede eliminar ningún elemento");
            valorEliminado = -1;
        } else {
            valorEliminado = valores[nodo];
            nodo--;
        }
        return valorEliminado;
    }

    /**
     * La función comprueba si una pila está vacía o no.
     * 
     * @return El método devuelve un valor booleano. Devuelve true si la variable
     *         `nodo` es igual a -1, indicando que no hay elementos en la estructura
     *         de datos, y false en caso contrario.
     */
    public static boolean isEmpty() {
        return nodo == -1;
    }
}