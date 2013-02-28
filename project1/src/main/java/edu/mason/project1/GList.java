package edu.mason.project1;
/**
 * Created by IntelliJ IDEA.
 * User: jamaal.taylor
 * Date: 2/22/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class GList<T> {

    /*
    * Private node class that makes the linked list.
    * The class contains a field to hold data and a field that
    * holds a link to the next node.
    * */
    private class GNode<T>
    {
        private T data;
        private GNode<T> next;

        public GNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private GNode<T> head = new GNode<T>(null);
    private GNode<T> cursor = new GNode<T>(null);

    public GList()
    {
        super();
    }

    public boolean isEmpty()
    {
        if(head.next == null)
        {
            return true;
        }
        return false;
    }

    //puts a new node containing t as a new first element of the list and makes cursor point to this node.
    public void insertFirst(T t)
    {
        GNode<T> element = new GNode<T>(t);
        if(head.next == null)
        {
            head.next = element;
        }
        else
        {
            element.next = head.next;
            head.next = element;
        }
        cursor.next = element;
    }

    //puts a new node containing t into the list after the node pointed to by cursor and makes cursor point to this node.
    public void insertNext(T t)
    {
        GNode<T> element = new GNode<T>(t);
        cursor.next.next = element;
        cursor.next = element;
    }

    //points cursor to the first node and returns the value stored in that node.
    public T getFirstItem()
    {
        //make the cursor point to the element that is pointed
        //to by head
        cursor.next = head.next;
        return cursor.next.data;
    }

    //advances cursor one place in the list and returns the value stored at that node.
    public T getNextItem()
    {
        cursor.next = cursor.next.next;
        return cursor.next.data;
    }

    //returns whether or not the node pointed to by cursor is followed by another node.
    public boolean hasNextItem()
    {
        if(cursor.next.next == null)
        {
            return false;
        }
        return true;
    }

}
