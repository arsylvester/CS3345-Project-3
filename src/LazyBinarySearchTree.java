
public class LazyBinarySearchTree 
{
	private TreeNode root;
	
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
	}
	
	 /**
     * Internal method to insert into a subtree.
     * @param key the item to insert.
     * @param node the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private Boolean insert( int key, TreeNode node )
    {
        if( node == null )
        {
             node = new TreeNode(key);
             return true;
        }
            
        if( node.key < key )
            return insert( key, node.leftChild );
        else if( node.key > key )
            return insert( key, node.rightChild );
        else // Duplicate
        	return false;
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
		return -1;
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
		return "";
	}
	
	public int height()
	{
		return -1;
	}
	
	public int size()
	{
		return -1;
	}
}
