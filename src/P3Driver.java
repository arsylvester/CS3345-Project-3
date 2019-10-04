/* Name: Andrew Sylvester
 * Class: CS 3345
 * Section: 001
 * Semester: Fall 2019
 * Project 3 
 * Class Description: This class P2Driver runs the project to test IDedLinkedList, IDedObject, and MyItem
 * using data from an input file. The results are outputed to an output file.
 * (Note: This file is pretty much untouched from what is given on eLearning as everything works as intended.)
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class P3Driver 
{
    public static void main(String[] args) 
    {
        Scanner in;
        if (args.length!=2) 
        {
            System.out.print("Error Incorrect Arguments:" + Arrays.toString(args));
            System.exit(0);    
        } 
        try 
		{
			File input_file = new File(args[0]);
			in = new Scanner(input_file).useDelimiter(":|\r\\n");
			File output_file = new File(args[1]);
			PrintWriter out;
			out = new PrintWriter(output_file);

			LazyBinarySearchTree lbst = new LazyBinarySearchTree();

			String operation = "";

			while (in.hasNext()) 
			{
				
				operation = in.next();
				
				switch (operation) 
				{	
				case "Insert":
					try 
					{
						if(in.findInLine(":") == null)
						{
							out.println("Error in Line: " + operation);
							break;
						}	
						out.println(lbst.insert(in.nextInt()) ? "True" :"False");
					} 
					catch (Exception e) 
					{
						out.println("Error in insert: IllegalArgumentException raised");
					}
					break;
				case "Delete":
					try 
					{
						out.println(lbst.delete(in.nextInt()) ? "True" :"False");
					} 
					catch (Exception e) 
					{
						out.println("Error in Delete: IllegalArgumentException raised");
					}
					break;
				case "FindMin":
					try 
					{
						out.println(lbst.findMin());
					} 
					catch (Exception e) 
					{
						out.println("ERROR");
					}
					break;
					
				case "FindMax":
					try 
					{
						out.println(lbst.findMax());
					} 
					catch (Exception e) 
					{
						out.println("ERROR");
					}
					break;
				case "Contains":
					try 
					{
						out.println(lbst.contains(in.nextInt()) ? "True" :"False");
					} 
					catch (Exception e) 
					{
						out.println("Error in Contains: IllegalArgumentException raised");
					}
					break;
				case "PrintTree":
					try 
					{
						out.println(lbst.toString());
					} 
					catch (Exception e) 
					{
						out.println("ERROR");
					}
					break;
				case "Height":
					try 
					{
						out.println(lbst.height());
					} 
					catch (Exception e) 
					{
						out.println("ERROR");
					}
					break;
				case "Size":
					try 
					{
						out.println(lbst.size());
					} 
					catch (Exception e) 
					{
						out.println("ERROR");
					}
					break;
				default:
					out.println("Error in Line: " + operation);
					//in.nextLine();
				}
				if(in.hasNext())
					in.nextLine();
			}
			in.close();
			out.close();
		} 
        catch (Exception e) 
        {
			System.out.println("Exception: " + e.getMessage());
		}
        
    }
    
    
}