package opgave03.models;

import opgave01.models.LinkedStack;
import opgave01.models.StackEaaa;

import java.security.cert.PKIXRevocationChecker;
import java.util.NoSuchElementException;

public class DropOutStack<E> implements StackEaaa<E> {

//    En drop-out stak er en stak der har samme funktionalitet som en almindelig stak,
//    bortset fra, at stakken maksimalt kan indeholde n elementer. Når det (n+1)’te
//    element indsættes, så droppes det første element, så størrelsen af drop-out
//    stakken aldrig bliver større end n.
//    Færdiggør DropOutStack klassen ved brug af dobbeltrettet noder.

    private Node<E> top;
    private Node<E> bottom;
    private int size = 0;
    private int maxSize;

    public DropOutStack(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void push(E element) {
        if (size == maxSize) {
            bottom = bottom.next;
            if (bottom != null) {
                bottom.previous = null;
            }
        }
        Node<E> newNode = new Node<>(element, null, top);
        if (isEmpty()) {
            bottom = newNode;
        }
        if (top != null) {
            top.next = newNode;
        }
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        throwIfEmpty();
        E element = top.element;
        top = top.next;
        if (top != null) {
            top.previous = null;
        } else {
            bottom = null;
        }
        size--;
        return element;
    }


    @Override
    public E peek() {
        throwIfEmpty();
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node<T> {
        T element;
        Node<T> next;
        Node<T> previous;

        public Node(T element, Node<T> next, Node<T> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private void throwIfEmpty() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    public void printStack() {
        Node<E> current = bottom;

        while (current.next != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
