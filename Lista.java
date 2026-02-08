import java.util.NoSuchElementException;

public class Lista<T> {
    private Nodo<T> head;

    public Lista() {
        this.head = null;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public void aggiungiInTesta(T dato) {
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        nuovoNodo.next = this.head;
        this.head = nuovoNodo;
    }

    public void aggiungiInCoda(T dato) {
        Nodo<T> nuovoNodo = new Nodo<>(dato);

        if (this.head == null) {
            this.head = nuovoNodo;
        } else {
            Nodo<T> corr = this.head;
            while ( corr.next != null ) {
                corr = corr.next;
            }
            corr.next = nuovoNodo;
        }
    }

    public void aggiungiInPosizione(T dato, int posizione) {
        if (posizione < 0) {
            throw new IndexOutOfBoundsException("Posizione negativa");
        }
        if (posizione == 0) {
            aggiungiInTesta(dato);
            return;
        }
        
        Nodo<T> corrente = head;
        int i = 0;
        while (corrente != null && i < posizione - 1) {
            corrente = corrente.next;
            i++;
        }
        if (corrente == null) {
            throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
        }
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        nuovoNodo.next = corrente.next;
        corrente.next = nuovoNodo;
    }

    public void aggiungiInPosizione_alt(T dato, int pos) {
        if (pos == 0) {
            this.aggiungiInTesta(dato);
        } else {
            Nodo<T> corr = this.head;
            int posCorr = 0;
            while ( corr.next != null && posCorr < pos-1) {
                corr = corr.next;
                ++posCorr;
            }
            if (posCorr < pos) {
                Nodo<T> nuovoNodo = new Nodo<>(dato);
                nuovoNodo.next = corr.next;
                corr.next = nuovoNodo;
            } else {
                throw new IndexOutOfBoundsException("Parametro poszione "+pos+" va oltre la fine della lista.");
            }

        }
    }

    public T leggiTesta() {
        if (this.head == null) {
            throw new NoSuchElementException("Lista vuota");
        } else {
            return this.head.dato;
        }
    }

    public T leggiCoda() {
        if ( this.head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        Nodo<T> curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.dato;
    }

    public T leggiInPosizione(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Posizione negativa");
        }

        Nodo<T> curr = this.head;
        int pos = 0;
        while ( curr != null && pos < i ) {
            curr = curr.next;
            ++pos;
        }
        if ( curr != null ) {
            return curr.dato;
        } else {
            throw new IndexOutOfBoundsException( i+" va oltre l'ultimo elemento");
        }
    }

    public int size() {
        int cont = 0;
        Nodo<T> curr = this.head;
        while (curr != null) {
            ++cont;
            curr = curr.next;
        }
        return cont;
    }

    public String toString() {  
        String str = "";
        Nodo<T> current = this.head;

        while ( current != null ) {
            str += "["+current.dato+"| -]->";
            current = current.next;
        }
        str += " NULL";
        return str;
    }



}
