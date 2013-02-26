
INFS 519
Program 1
due February 28, 2013
The program

This program is an exercise in generic (singly) linked lists. You will write a parameterized list class with just a few operations.
Then you will create lists from this class using two different classes for the type parameter creating a "list of lists".
You will write a driver program which will create and display a list of lists. Each (inner) list will have a name and contain integers.
Running the program may look like:


    add a list (y/n)?  y
    name of list?  first_list
    add a number (y/n)?  y
    value:  10
    add a number (y/n)?  y
    value:  11
    add a number (y/n)?  y
    value:  12
    add a number (y/n)?  n
    add a list (y/n)?  y
    name of list?  another_list
    add a number (y/n)?  n
    add a list (y/n)?  y
    name of list?  the_last_one
    add a number (y/n)?  y
    value:  -1
    add a number (y/n)?  y
    value:  -2
    add a number (y/n)?  y
    value:  -3
    add a number (y/n)?  y
    value:  -4
    add a number (y/n)?  n
    add a list (y/n)?  n

    list name: first_list
    10
    11
    12

    list name: another_list

    list name: the_last_one
    -1
    -2
    -3
    -4

Internals

Your program will have three classes: GList<T>, InnerList, and a main class. The InnerList class is used to store a String
 (as a name for an inner list) and an instance of GList<Integer> for an inner list of integers. In your main class then
 you will create an (outer) list of InnerList.
Class GList<T>

This class will have a private inner GNode<T> class with a data field of type T and a next field for linking, and a
constructor (taking a T parameter to initialize the data field). You may use the GNode<T> class which we wrote in class for this.

GList<T> will have two (private, of course) fields, both of type GNode<T>: head and cursor. The head field will simply
be a head pointer for the linked list. The cursor field will be used to point to nodes in the list. The (only) public methods in this class are:

    public boolean isEmpty() { return head == null; }
    public void insertFirst(T t): puts a new node containing t as a new first element of the list and makes cursor point to this node.
    public void insertNext(T t): puts a new node containing t into the list after the node pointed to by cursor and makes cursor point to this node.
    public T getFirstItem(): points cursor to the first node and returns the value stored in that node.
    public T getNextItem(): advances cursor one place in the list and returns the value stored at that node.
    public boolean hasNextItem(): returns whether or not the node pointed to by cursor is followed by another node.

A list can then be traversed by methods outside of the GNode<T> class by first calling getFirstItem() once and then calling getNextItem() while hasNextItem() returns true. A linked list can be built in a similar manner using insertFirst(T t) and insertNext(T t)

Class InnerList

This class is:


    public class InnerList
    {
       private String name;
       private GList<Integer> inner = new GList<Integer>();
       // get and set methods for both fields are here
    }

Notice that the type passed for the type parameter is Integer. Integer is the wrapper class for int. It must be used to store integers since int is a primary type and we can only store classes in a parameterized class. Because of "auto-boxing" and "auto-unboxing" you can assign int values to Integer and read Integer values as if they were ints.

You can now make lists of (inner) lists where each inner list has a name by creating a list of type GList<InnerList>.
The main class

In your main you will create GList<InnerList> list; In a loop you will ask the user if he or she wishes to create a list. As long as the user answers yes you will create new inner lists by adding nodes to list. To create an inner list you will first ask the user for a name for this inner list (to be stored in the name field of InnerList) and you will then ask the user, in another loop, if he or she wishes to add a number. As long as the user wishes to add numbers to the list the program will accept and append them. Your program should generate output similar to the example shown above.

Whenever accepting integer input you must read the integer in a try catch block. The catch block must catch an InputMismatchException. Your program will then give a reasonable error message and continue to ask for an integer until an int is successfully read.
To turn in

You will turn in a (well commented) copy of your source code and a hardcopy of a sample terminal session using operations which will be posted later. ========