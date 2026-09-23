import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }



    // write your codes here
    public void swap(){
        List<Node<E>> ls = new ArrayList<>();
        while(head != null) {
            ls.add(head);
            head = head.next;
        }
        Integer[] pos = new Integer[ls.size()];
        for(int i = 0; i < ls.size(); i++) pos[i] = i;
        Arrays.sort(pos, (a,b) -> ls.get(a).getElement().compareTo(ls.get(b).getElement()));

        int L = 0, R = ls.size() - 1;
        Node[] ans = new Node[ls.size()];
        while(L <= R) {
            ans[pos[L]] = ls.get(pos[R]);
            ans[pos[R]] = ls.get(pos[L]);
            L++;
            R--;
        }
        head = ans[0];
        tail = ans[ans.length - 1];
        for(int i = 0; i < ans.length - 1; i++) ans[i].setNext(ans[i + 1]);
        ans[ans.length - 1].setNext(null);
    }
   
}

