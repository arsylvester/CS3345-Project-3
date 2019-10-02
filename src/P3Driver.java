
public class P3Driver 
{
	public static void main(String[] args) 
	{
		try
		{
		LazyBinarySearchTree lbst = new LazyBinarySearchTree();
		lbst.insert(10);
		lbst.insert(5);
		lbst.insert(12);
		lbst.insert(6);
		lbst.insert(14);
		lbst.insert(102);
		lbst.insert(13);
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
