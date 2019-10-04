/* Name: Andrew Sylvester
 * Class: CS 3345
 * Section: 001
 * Semester: Fall 2019
 * Project 3 
 * Class Description: This class P3Driver runs the project to test LazyBinarySearchTree
 * using data from an input file. The results are outputed to an output file.
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
        	//Open input and output files. Create Scanner.
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
				
				//Check for which operation to take
				switch (operation) 
				{	
				case "Insert":
					try 
					{
						//Should have a : before the int.
						if(in.findInLine(":") == null)
						{
							out.println("Error in Line: " + operation);
							break;
						}	
						String test = in.findInLine("[0-9]*");
						if(test != null)
						{
							out.println(lbst.insert(Integer.parseInt(test)) ? "True" :"False");
						}
						else
							throw new IllegalArgumentException("Arguments out of bounds!");
						
					} 
					catch (Exception e) 
					{
						out.println("Error in insert: IllegalArgumentException raised");
					}
					break;
				case "Delete":
					try 
					{
						//Should have a : before the int.
						if(in.findInLine(":") == null)
						{
							out.println("Error in Line: " + operation);
							break;
						}	
						String test = in.findInLine("[0-9]*");
						if(test != null)
						{
							out.println(lbst.delete(Integer.parseInt(test)) ? "True" :"False");
						}
						else
							throw new IllegalArgumentException("Arguments out of bounds!");
					} 
					catch (Exception e) 
					{
						out.println("Error in Delete: IllegalArgumentException raised");
					}
					break;
					
				case "FindMin":
					out.println(lbst.findMin());
					break;
					
				case "FindMax":
					out.println(lbst.findMax());
					break;
				case "Contains":
					try 
					{
						//Should have a : before the int.
						if(in.findInLine(":") == null)
						{
							out.println("Error in Line: " + operation);
							break;
						}	
						String test = in.findInLine("[0-9]*");
						if(test != null)
						{
							out.println(lbst.contains(Integer.parseInt(test)) ? "True" :"False");
						}
						else
							throw new IllegalArgumentException("Arguments out of bounds!");
					} 
					catch (Exception e) 
					{
						out.println("Error in Contains: IllegalArgumentException raised");
					}
					break;
				case "PrintTree":
					out.println(lbst.toString());
					break;
				case "Height":
					out.println(lbst.height());
					break;
				case "Size":
					out.println(lbst.size());
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