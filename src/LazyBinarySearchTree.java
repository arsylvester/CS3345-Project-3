
public class LazyBinarySearchTree 
{
	private TreeNode root;
	private int treeSize;
	
	private static class TreeNode
	{
		public int key;
		public TreeNode leftChild;
		public TreeNode rightChild;
		public boolean deleted;
		
		public TreeNode(int key)
		{
			this.key = key;
			leftChild = null;
			rightChild = null;
			deleted = false;
		}
	}
	
	public LazyBinarySearchTree() 
	{
		root = null;
		treeSize = 0;
	}
	
	public boolean insert(int key) throws IllegalArgumentException
	{
		if(key < 1 || key > 99)
		{
			throw new IllegalArgumentException("Arguments out of bounds!");
		}
		
		if(root == null)
		{
			root = new TreeNode(key);
			return true;
		}
		
		TreeNode node = root;
		while(true)
		{
			if( key < node.key )
			{
				if(node.leftChild == null)
				{
					node.leftChild = new TreeNode(key);
					treeSize++;
					return true;
				}
				else
				{
					node = node.leftChild;
				}
			}
		    else if( key > node.key )
		    {
		    	if(node.rightChild == null)
				{
					node.rightChild = new TreeNode(key);
					treeSize++;
					return true;
				}
		    	else
		    	{
		    		node = node.rightChild;
		    	}
		    }
		    else // Duplicate
		    {
		    	if(node.deleted)
		    	{
		    		node.deleted = true;
		    		return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		    }
		}
	}

	public boolean delete(int key) throws IllegalArgumentException
	{
		if(key < 1 || key > 99)
		{
			throw new IllegalArgumentException("Arguments out of bounds!");
		}
		
		return delete(key, root);
	}
	
	private boolean delete(int key, TreeNode node)
	{
		if(node == null)
		{
			return false;
		}
		
		if(key < node.key)
		{
			return delete(key, node.leftChild);
		}
		else if(key > node.key)
		{
			return delete(key, node.rightChild);
		}
		else if(!node.deleted)
		{
			node.deleted = true;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int findMin()
	{
		return findMin(root, null);
	}	
	
	private int findMin(TreeNode node, TreeNode parent)
	{
		 if( node == null )
			 return -1;
	     else if( node.leftChild == null )
	     {
	    	 if(node.deleted)
	    	 {
	    		 if(node.rightChild != null)
	    		 {
	    			 return findMin(node.rightChild, node);
	    		 }
	    		 else
	    		 {
	    			 if(parent.deleted)
	    			 {
	    				 if(parent.rightChild == null)
	    				 {
	    					 return 1;
	    				 }
	    				 else
	    				 {
	    					 return findMin(parent.rightChild, parent);
	    				 }
	    			 }
	    			 else
	    			 {
	    				 return parent.key;
	    			 }
	    		 }
	    	 }
	    	 else
	    	 {
	    		 return node.key;
	    	 }
	     }
	     return findMin( node.leftChild, node);
	}
	
	public int findMax()
	{
		return -1;
	}
	
	public boolean contains(int key) throws IllegalArgumentException
	{
		if(key < 1 || key > 99)
		{
			throw new IllegalArgumentException("Arguments out of bounds!");
		}
		
		return contains(key, root);
	}
	
	private boolean contains(int key, TreeNode node)
	{
		if(node == null)
		{
			return false;
		}
		
		if(key < node.key)
		{
			return contains(key, node.leftChild);
		}
		else if(key > node.key)
		{
			return contains(key, node.rightChild);
		}
		else if(!node.deleted)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return toString(root, "");
	}
	
	private String toString(TreeNode node, String output)
	{
		if(node != null)
		{
			output = output + node.key + " " + toString(node.leftChild, output) + toString(node.rightChild, output);
			return output;
		}
		else
		{
			return "";
		}
	}
	
	public int height()
	{
		return height(root);
	}
	
	private int height(TreeNode node)
	{
		if(node == null)
		{
			return -1;
		}
		else
		{
			return 1 + Math.max(height(node.leftChild), height(node.rightChild));
		}
	}
	
	public int size()
	{
		return treeSize;
	}
}
