/*
 Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1
y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta clase debe
contener un método toString() que retorne el número de carta y el palo. La baraja estará
compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
luego se llama al método, este no mostrara esa primera carta.
 */
package Servicio;

import Entidad.Baraja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Mile
 */
public class ServicioBaraja {
    public ArrayList<Baraja> crearBaraja(){
        ArrayList<Baraja> baraja = new ArrayList<>();
        
        for (char i = 'a'; i < 'e'; i++) {            
            for (Integer j = 1; j < 13; j++) {
                if (j == 9 || j == 8){
                    continue;                    
                }
                Baraja carta = new Baraja();
                carta.setNumero(j);
                switch (i){
                    case 'a':
                        carta.setPalo("Copa(***)");
                        break;
                    case 'b':
                        carta.setPalo("Oro");
                        break;
                    case 'c':
                        carta.setPalo("Espada");
                        break;
                    case 'd':
                        carta.setPalo("Basto");
                        break;                       
                }                
                baraja.add(carta);
            }                
        }
        return baraja;                
        
    }
    
    public void barajar(ArrayList<Baraja> b){
        Collections.shuffle(b);
    }
    
    public Baraja siguienteCarta(ArrayList<Baraja> b){
        if (b.size() == 0){
            System.out.println("No hay mas cartas disponibles");
            return null;
        } else {
            System.out.println(b.get(0));
            return b.get(0);  
        }
        
    }
    
    public void cartasDisponibles(ArrayList<Baraja> b){
        if (b.size() > 0){
            System.out.println("Cartas disponibles: " + b.size());
        }
    }
    
    public void darCartas(ArrayList<Baraja> b, ArrayList<Baraja> m){
        Scanner leer = new Scanner(System.in);
        System.out.println("¿Cuantas cartas desea?");
        int cantidad = leer.nextInt();
        if (b.size() < cantidad){
            System.out.println("La cantidad de cartas disponibles es menor a la cantidad de cartas deseada");            
        } else {
            int contador = 0;           
            Iterator it = b.iterator();
            while (it.hasNext() && contador != cantidad){
                Baraja a = (Baraja) it.next();
                m.add(a);                
                System.out.println(a);
                contador++;
                b.remove(a);
            }
            
        }            
    }
    
    public void cartasMonton(ArrayList<Baraja> m){
        if (m.size() == 0){
            System.out.println("No hay cartas fuera de la baraja");
        } else {
            for (Baraja monton : m) {
                System.out.println(monton);
            }
        }
    }
    
    public void mostrarCartas(ArrayList<Baraja> b){
        for (Baraja baraja : b) {
            System.out.println(baraja);            
        }
    }
    
    
}
