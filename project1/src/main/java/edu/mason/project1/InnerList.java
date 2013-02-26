package edu.mason.project1;

/**
 * Created by IntelliJ IDEA.
 * User: jamaal.taylor
 * Date: 2/22/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class InnerList
{

     private String name;
     private GList<Integer> inner = new GList<Integer>();
       // get and set methods for both fields are here
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public GList<Integer> getInner()
    {
        return inner;
    }

    public void setInner(GList<Integer> inner)
    {
        this.inner = inner;
    }
}
