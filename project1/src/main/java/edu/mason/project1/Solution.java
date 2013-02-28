package edu.mason.project1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Jamaal J. Taylor
 * Date: 2/28/13
 * Time: 11:26 PM
 * For class project 1
 */
public class Solution {

    public Solution()
    {
        super();
    }
    //A utility function that displays the contents of a GList<InnerList>
    public static void displayInnerList(String name, GList<Integer> numberList)
    {
        System.out.println(name);
        if(numberList.getFirstItem() != null)
        {
            System.out.println(numberList.getFirstItem());
        }
        while(numberList.hasNextItem() == true)
        {
            System.out.println(numberList.getNextItem());
        }
    }

    public static void main(String [ ] args)
    {
        //declare variable that are used through out the program
        GList<InnerList> mainList = new GList<InnerList>();
        String addListAnswer = "n";
        String answer = "";
        boolean finished = false;

        //enter main loop that asks user if they want to add a list
        do
        {
            //declare and instantiate scanner to read in data
            //Use text to prompt the user for input
            Scanner in = new Scanner(System.in);
            System.out.println("Add a list?:(y/n) ");
            addListAnswer = in.nextLine();

            //condition that determines if user entered a yes
            if(addListAnswer.toString().equalsIgnoreCase("Y") || addListAnswer.toString().equalsIgnoreCase("y"))
            {
                System.out.println("Name of list?");
                String namedList = in.nextLine();
                //in.close();

                InnerList newList = new InnerList();
                GList<Integer> numberList = new GList<Integer>();
                newList.setName(namedList.toString());
                newList.setInner(numberList);


                do
                {
                    try
                    {
                        answer = "n";
                        Scanner scanner = new Scanner(System.in);

                        //ask them if they want to add a number
                        System.out.println("add a number?(y/n)");
                        answer = scanner.nextLine();

                        //make sure to reset the scanner each time or things won't work
                        in.reset();

                        //check to make sure that the input is a string and either y or n.
                        if(answer instanceof String && answer.equalsIgnoreCase("Y"))
                        {
                            System.out.println("value:");
                            Integer inputAnswer = in.nextInt();
                            in.reset();
                            if(inputAnswer instanceof Integer)
                            {
                                //we decide whether we are inserting the first node or some node after first
                                if(newList.getInner().isEmpty())
                                {
                                    newList.getInner().insertFirst(inputAnswer);
                                }
                                else
                                {
                                    newList.getInner().insertNext(inputAnswer);
                                }
                            }
                            else
                            {
                                //you should only enter here if a valid integer wasn't entered
                                throw new InputMismatchException("You must enter a valid integer");
                            }
                        }
                        else if(answer instanceof String && answer.equalsIgnoreCase("N"))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Please type y or n.");
                        }
                    }
                    catch (InputMismatchException ex)
                    {
                        //ex.printStackTrace();
                        System.out.println("You must enter a valid number");
                    }
                }while(!answer.equalsIgnoreCase("n"));

                if(mainList.isEmpty() == true)
                {
                    mainList.insertFirst(newList);
                }
                else
                {
                    mainList.insertNext(newList);
                }
            }
            else if(addListAnswer.toString().equalsIgnoreCase("N"))//enter here when they don't want to add another list
            {
                do
                {
                    //if the main list is empty you can exit the loop
                    if(mainList.isEmpty() == true)
                    {
                        break;
                    }
                    else
                    {
                        //display the first node
                        Solution.displayInnerList(mainList.getFirstItem().getName(), mainList.getFirstItem().getInner());

                        //display the rest of the nodes
                        while(mainList.hasNextItem() == true)
                        {
                            Solution.displayInnerList(mainList.getNextItem().getName(), mainList.getNextItem().getInner());
                        }

                        //signal that you are finished going through all of the nodes of mainlist
                        finished = true;
                    }
                }while (finished==false);
            }
            else
            {
                System.out.println("Please type y or n.");
            }
        }while(addListAnswer.equalsIgnoreCase("Y"));
    }
}
