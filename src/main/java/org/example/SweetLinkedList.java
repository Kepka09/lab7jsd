package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SweetLinkedList<T extends Sweet> implements List<T> {
    private Node<T> head;
    private int size;

    private class Node<T> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public SweetLinkedList() {
        head = null;
        size = 0;
    }

    public SweetLinkedList(T item) {
        this();
        add(item);
    }

    public SweetLinkedList(Collection<? extends T> c) {
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (current.item.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        Node<T> current = head;
        while (current != null) {
            array[i++] = current.item;
            current = current.next;
        }
        return array;
    }

    @Override
    public <U> U[] toArray(U[] a) {
        if (a.length < size) {
            a = (U[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        Node<T> current = head;

        while (current != null) {
            result[i++] = current.item;
            current = current.next;
        }

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T e) {
        Node<T> newNode = new Node<>(e, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null) {
            if (current.item.equals(o)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndex(index);
        boolean modified = false;
        for (T item : c) {
            add(index++, item);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            if (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<T> current = head;
        while (current != null) {
            if (!c.contains(current.item)) {
                remove(current.item);
                modified = true;
            }
            current = current.next;
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T oldElement = current.item;
        current.item = element;
        return oldElement;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        Node<T> current = head;
        Node<T> prev = null;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = new Node<>(element, head);
        } else {
            prev.next = new Node<>(element, current);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Node<T> current = head;
        Node<T> prev = null;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = current.next;
        } else {
            prev.next = current.next;
        }

        size--;
        return current.item;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<T> current = head;

        while (current != null) {
            if (current.item.equals(o)) {
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int lastIndex = -1;
        Node<T> current = head;

        while (current != null) {
            if (current.item.equals(o)) {
                lastIndex = index;
            }
            index++;
            current = current.next;
        }

        return lastIndex;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("ListIterator not supported");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("ListIterator not supported");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList not supported");
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
