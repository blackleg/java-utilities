/*
 * Copyright 2015 Blackleg blackleg@openaliasbox.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.blackleg.java.utilities;

/**
 *
 * @author Blackleg blackleg@openaliasbox.org
 */
public class Calculator {
    
    /**
     * Devuelve si un numero entero es Capicua. 
     * @param numero A number
     * @return boolean true es capicua, false no es capicua.
     */
    public static boolean isCapicua(int numero) {
        //Si numero es menor que 10 devolver falso
        if (numero < 10) {
            return false; 
        }
        int aux = 0;
        int contador = numero;
        //Da la vuelta al numero introducido;
        while (contador > 0) { 
            int digito = contador%10;
            aux = aux * 10 + digito;
            contador = contador/10;
        }
       return numero==aux; 
    }
    
    
    /**
     * Devuelve el maximo comun divisor entre dos numeros.
     * @param min First number
     * @param max Second number
     * @return int MCD
     */
        
    public static int maximoComunDivisor(int min, int max) {
        min = Math.abs(min);
        max = Math.abs(max);
        if (min > max) { //Ordenar
            int aux = min;  
            min = max;   
            max = aux;  
        }
        int contador = max;
        int mcd = max;
        while (min%mcd != 0) {
            if (max%contador == 0) {
                mcd = contador;
            }
            contador --;
        }
        if (mcd > max) {  
            mcd = 1;
        }
        return mcd;
    }
    
    /**
     * Retorna el factorial de un número.
     * @param num a double
     * @return double
     */
    public static double factorial(double num) {
        double fac = 1;
        while (num > 1) {
            fac = fac * num ;
            num--;
        }
        return fac;     
    }
    
    /**
     * Comprueba si un numero es primo.
     * @param number a long number
     * @return boolean
     */
    public static boolean isPrimo(long number) {
        long contador = 2;   
        while(contador <= (number/2 + 1))
            {
               if (number%contador == 0 && number != contador)
               {
                   return false;
               }
               contador++;
            }
        return true;
    }
    
    /**
     * Muestra en pantalla los primos entre dos numeros.
     * @param min a long number
     * @param max a long number
     */
    public static void primosEntre(long min, long max) {
        if (min > max) { //Ordenar
            long aux = min;
            min = max; 
            max = aux;
        }

        boolean estado;       
        while(min <= max)
        {
            estado = isPrimo(min); //Comprueba si es primo;
            if ( estado )
            {
                System.out.println(min);
            }
            min++;
        }   
    }
    

    /**
     * Resuelve una ecuacion de segundo grado
     * a*x²+b*x+c=0
     * @param valora EL valor de a
     * @param valorb El valor de b
     * @param valorc El valor de c
     * @param resultado Variable donde se asigna el resultado
     * @param esimaginario Variable donde se asigna si el resultado es un numero imaginario o no.
     * @return Devuelve true si se puede resolver la ecuacion y el resultado es util.
     */
    public static boolean ecuacionSegundoGrado(double valora, double valorb, double valorc, double[] resultado, boolean esimaginario) {
        double d = (valorb * valorb) - (4 * valora * valorc);
        esimaginario = false;
        
        if ( valora == 0 && valorb == 0 && valorc == 0) {
            return false;
        } else if ( valora == 0 && valorb == 0 && valorc != 0) {
            return false;
        } else if ( valora == 0 && valorb != 0) { 
            resultado = new double[1];  
            resultado[0] = -valorc/valorb;
            
        } else if ( valora != 0 && d == 0) {   
            resultado = new double[1];
            resultado[0] = -valorb/(2 * valora);
        } else if ( valora != 0 && d > 0) {
            resultado = new double[2];
            resultado[0] = (-valorb + Math.sqrt((valorb * valorb) -4*valora*valorc)) / (2 * valora);
            resultado[1] = (-valorb - Math.sqrt((valorb * valorb) -4*valora*valorc)) / (2 * valora); 
        } else if ( valora != 0 && d < 0) {
            double prei, posti;
            prei = -valorb/(2 * valora);
            posti = Math.sqrt(-(Math.pow(valorb, 2) - (4 * valora * valorc))) / (2 * valora);
            resultado = new double[2];
            esimaginario = true;
            resultado[0] = prei;
            resultado[1] = posti;   
        } else {
            return false;
        }
        return true; 
    }
    
    /**
     * Devuelve una matriz con la serie de fibonacci
     * @param elementos El numero de elementos que componen la serie
     * @return long[] 
     */
    public static long[] fibonacci (int elementos) {
        long[] matriz = new long[elementos];
        long primero = 1;
        long segundo = 1;
        matriz[0] = primero;
        matriz[1] = segundo;
        for (int i = 2; i < elementos; i++) {
            long siguiente = segundo + primero;
            matriz[i] = siguiente;
            primero = segundo;
            segundo = siguiente; 
        }
  return matriz;
    }
    
    /**
     * Redondea un double a un numero de decimales
     * @param numero El numero a redondear
     * @param decimales El numero de decimales
     * @return double redondeado
     */
    public static double redondear(double numero, int decimales) { 
        int enteros = Numbers.contarEnteros(numero);
        String s_numero = String.valueOf(numero);
        char[] temporal = new char[enteros + decimales + 1];
        char[] numeros = s_numero.toCharArray();
        int tamaño = temporal.length;
        int tamaño_numero = numeros.length;
        for (int i = 0; i < tamaño ; i++) {
            if (i < enteros) {
                temporal[i] = numeros[i];
            }
            if (i == enteros) {
                temporal[i] = ".".charAt(0);
            }
            if (i > enteros && i < tamaño -1 && i < tamaño_numero) {
              temporal[i] = numeros[i];  
            }
            if (i > enteros && i == tamaño -1 && i < tamaño_numero) {
                int n_siguiente = 0;
                if (i + 1 < tamaño_numero) {
                    n_siguiente = Integer.parseInt(String.valueOf(numeros[i +1]));
                }
                if (n_siguiente > 5) {
                    String s_suma = String.valueOf(numeros[i]);
                    int n_suma = Integer.parseInt(s_suma);
                    s_suma = String.valueOf(n_suma + 1);
                    temporal[i] = s_suma.charAt(0);
                } else {
                    temporal[i] = numeros[i];
                }
            }
            if (i > enteros && i >= tamaño_numero) {
                temporal[i] = "0".charAt(0);
            }
        } 
        s_numero = Arrays.toText(temporal);
        return Double.valueOf(s_numero);
    }
    
    
    
    /**
     * Calcula el area de un circulo.
     * @param radio
     * @return
     */
    public static double areaCirculo (double radio) {
        return Math.PI * radio * radio;
    }
    
    /**
     * Calcula el perimetro de un circulo.
     * @param radio
     * @return
     */
    public static double perimetroCirculo (double radio) {
        return 2 * Math.PI * radio;
    }
    
    
    public static double areaCuadrado (double lado) {
        return Math.pow(lado, 2);
    }
    
    public static double perimetroCuadrado (double lado) {
        return 4 * lado;
    }
    
}
