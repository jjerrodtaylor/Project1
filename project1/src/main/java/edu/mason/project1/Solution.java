package edu.mason.project1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: jamaal.taylor
 * Date: 2/22/13
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {

    public Solution()
    {
        super();
    }

    public static void main(String [ ] args)
    {
        GList<InnerList> mainList = new GList<InnerList>();
        String addListAnswer = "n";
        String answer = "";
        boolean firstItem = true;

        do
        {
            String myInput;
            Scanner in = new Scanner(System.in);
            System.out.println("Add a list?:(y/n) ");
            addListAnswer = in.nextLine();

            if(addListAnswer.toString().equalsIgnoreCase("Y") || addListAnswer.toString().equalsIgnoreCase("y"))
            {
                System.out.println("Name of list?");
                String namedList = in.nextLine();
                //in.close();

                InnerList newList = new InnerList();
                GList<Integer> numberList = new GList<Integer>();
                newList.setName(namedList.toString());
                newList.setInner(numberList);

                try
                {

                    do
                    {
                        answer = "n";
                        Scanner scanner = new Scanner(System.in);

                        //ask them if they want to add a number
                        System.out.println("add a number?(y/n)");
                        answer = scanner.nextLine();
                        in.reset();
                        if(answer instanceof String && answer.equalsIgnoreCase("Y"))
                        {
                            System.out.println("value:");
                            Integer inputAnswer = in.nextInt();
                            in.reset();
                            if(inputAnswer instanceof Integer)
                            {
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
                    }while(!answer.equalsIgnoreCase("n"));

                }
                catch(InputMismatchException ex)
                {
                    ex.printStackTrace();
                }
                //newList.getInner().insertFirst(numberList);
                //newList.setInner(numberList);
                if(mainList.isEmpty() == true)
                {
                    mainList.insertFirst(newList);
                }
                else
                {
                    mainList.insertNext(newList);
                }

            }
            else if(addListAnswer.toString().equalsIgnoreCase("N"))
            {
                //display all of the lists created here.
                if(mainList.isEmpty() == true)
                {
                    break;
                }
                else
                {
                    if(mainList.hasNextItem() == true)
                    {
                        if(firstItem == true)
                        {
                            System.out.println(mainList.getFirstItem().getName());
                            while()
                        }
                        System.out.println(mainList.getNextItem().getName());
                        while(mainList.getNextItem().getInner().hasNextItem() == true)
                        {
                            System.out.println(mainList.getNextItem().getInner().getNextItem());
                        }
                    }
                }
            }
        }while(addListAnswer.equalsIgnoreCase("Y"));
    }
}
