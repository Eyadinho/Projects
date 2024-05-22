
/**
 * Write a description of class hextodecimal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class hextodecimal
{ 
    public static void main(String args[])
    {
    Scanner in= new Scanner(System.in); // getting user input
    System.out.println("Enter a Hexadecimal number :   ");
    
    String hex = in.nextLine();// assign string to get hexadecimal
    int dec=0;//asign an integer variable to get the decimal number
    int size=hex.length();//length of hexa number
    int i=0;// assign the int so when it will be used for division by 16
    for(int i=size-1;i>=0;i--)// using the for loop as reverse for coming right to left 
{
    char c=hex.charAt(i);// getting the part where hexa is a letter not a number from a to f
    if(c=='A')
    { 
        dec+=10*Math.pow(16,i);
}
else if(c=='B')
{ 
    dec+=11*Math.pow(16,i);
} 

    else if(c=='C')
    {
     dec+=12*Math.pow(16,i);
}
else if (c=='D')
{
    dec+=13*Math.pow(16,i);
}
else if (c=='E')
{
    dec+=14*Math.pow(16,i);
}
else if (c=='F')
{
    dec+=15*Math.pow(16,i);
}
else
{
    dec+= Character.getNumericValue(c)*Math.pow(16,i);
}
i++;

}
System.out.println("Decimal number of this hexa is :  " +dec);

}}




    