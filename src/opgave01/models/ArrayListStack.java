package opgave01.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack<E> implements StackEaaa<E>{

    private ArrayList<E> list = new ArrayList<>();

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() {
        throwIfEmpty();
        return list.removeLast();
    }

    @Override
    public E peek() {
        throwIfEmpty();
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    private void throwIfEmpty() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    public void printStack() {
        for (E e : list) {
            System.out.print(e + "");
        }
    }
}
