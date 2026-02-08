//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {
    // Il programma parte con una chiamata a main().
    public static void main(String args[])
    {
        //Creo l'oggetto in per l'input da tastiera
        Scanner in = new Scanner( System.in );

        Lista<Integer> lista = new Lista<>();

        lista.aggiungiInTesta(6);
        lista.aggiungiInTesta(5);
        lista.aggiungiInTesta(4);
        
        lista.aggiungiInCoda(20);
        lista.aggiungiInCoda(21);
        lista.aggiungiInCoda(22);

        lista.aggiungiInPosizione(3, 0);
        lista.aggiungiInPosizione(10, 4);
        lista.aggiungiInPosizione(11, 5);
        lista.aggiungiInPosizione(30, 9);

        System.out.println("Lista:" +lista.toString() );
        System.out.println("Testa: "+lista.leggiTesta());
        System.out.println("Coda: "+lista.leggiCoda());
        System.out.println("Elemento "+3+": "+ lista.leggiInPosizione(3));
        System.out.println("Size: "+ lista.size());


    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md