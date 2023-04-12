package org.example;
/*Hay muchas actividades agradables en este divertido y pequeño planeta Tierra, pero probablemente la más feliz, simple y satisfactoria sea ir al cine. Ir con amigos, ir con seres queridos, experimentar una nueva aventura desde la seguridad de un asiento de cine, rodeado de compañeros de viaje afines.
Como desarrollador principiante, puedes contribuir a crear esta maravillosa experiencia cinematográfica. Tus buenos amigos te pidieron que les ayudes a crear una aplicación para un cine donde las personas puedan obtener boletos, reservar asientos y disfrutar de su noche de cine.
No hay mucho espacio en nuestro nuevo cine, así que debes tener en cuenta las restricciones en el número de asientos. Tus amigos dijeron que la sala cabría 7 filas de 8 asientos. Tu tarea es ayudarlos a visualizar la disposición de los asientos imprimiendo el esquema en la consola.

Tu salida debería ser como en el ejemplo a continuación y debería contener 9 líneas.
Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
*/

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {//inicializo i en 0, mientras i sea menor a 9, incremento i en 1
            if (i == 0) {
                System.out.println("Cinema:");
            } else if (i == 1) {
                System.out.println("  1 2 3 4 5 6 7 8");
            } else {
                System.out.println(i - 1 + " S S S S S S S S");
            }
        }

    }
}