import java.util.Scanner;
public class Magic8 
{

  public static void main(String[] args)
  {
    //Scanner object to read the user's input
    Scanner inputStr = new Scanner(System.in);
    
    //Welcome the user and ask for his input
    System.out.println("Welcome to Magic-8 Ball \n" );
    System.out.println("Are you ready to turn the magic ball? \n" );
    System.out.println("Ask your question and turn the ball \n" );
    
    //Read the user's input using Scanner object
    
    String str = inputStr.nextLine();
    //Print user's inout back to the user
    System.out.println("You entered"  +str );
    System.out.println("^^^^^^^^^^^^^^^");

    System.out.println("The Ball says -- \n");
    /* Generate Random number between 1-20 and generate different responses based on the number generated print different outputs using switch case */ 
    
    int choice = (int)(Math.random() * 20 + 1);
  
    switch(choice)
    {
      case 1:
      System.out.println("It is certain.");
      break;

      case 2:

      System.out.println("It is decidedly so.");
      break;

      case 3:

      System.out.println("Without a doubt.");
      break;
      
      case 4:
      
      System.out.println("Yes - definitely.");
      break;
      case 5:
      
      System.out.println("You may rely on it.");
      break;
      
      case 6:
      
      System.out.println("As I see it, yes.");
      break;
      
    case 7:

      System.out.println("Most likely.");
      break;
      
     case 8:
      
      System.out.println("Outlook good.");
      break;
      
     case 9:
      
      System.out.println("Yes.");
      break;
      
    case 10:
      
      System.out.println("Signs point to yes.");
      break;
      
    
    case 11:
      
      System.out.println("Reply hazy, try again.");
      break;
      
    case 12:

      System.out.println("Ask again later.");
      break;
      
    case 13:

      System.out.println("Better not tell you now.");
      break;
      
    case 14 :
      
      System.out.println("Cannot predict now.");
      break;

    case 15:

      System.out.println("Concentrate and ask again.");
      break;
      
    case 16:
      
      System.out.println("Don't count on it.");
      break;
      
    case 17:
      
      System.out.println("My reply is no.");
      break;

   case 18:

      System.out.println("My sources say no.");
      break;

    case 19: 

      System.out.println("Outlook not so good.");
      break;
  
      case 20 :
      System.out.println("Very doubtful.");
      break;

      default:
      System.out.println("OOpppsss, try again");
      break;

    }
    
  }

}