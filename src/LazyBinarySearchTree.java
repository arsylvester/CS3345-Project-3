
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
			treeSize++;
			return true;
		}
		
		return insert(key, root, root);
	}
	
	private boolean insert(int key, TreeNode node, TreeNode parent)
	{
		if(node == null)
		{
			if(key < parent.key)
				parent.leftChild = new TreeNode(key);
			else
				parent.rightChild = new TreeNode(key);
			treeSize++;
			return true;
		}
		
		if(key < node.key)
		{
			return insert(key, node.leftChild, node);
		}
		else if(key > node.key)
		{
			return insert(key, node.rightChild, node);
		}
		else if(node.deleted)
		{
			node.deleted = false;
			return true;
		}
		else
		{
			return false;
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
		return findMin(root);
	}	
	
	//infix
	private int findMin(TreeNode node)
	{
		if(node != null)
		{
			int leftMin = findMin(node.leftChild);
			if(leftMin > -1)
				return leftMin;
			
			if(!node.deleted)
				return node.key;
			
			int rightMin = findMin(node.rightChild);
			if(rightMin > -1)
				return rightMin;
		}
		return -1;
	}
	
	
	public int findMax()
	{
		return findMax(root);
	}
	
	private int findMax(TreeNode node)
	{
		if(node != null)
		{
			int rightMin = findMax(node.rightChild);
			if(rightMin > -1)
				return rightMin;
			
			if(!node.deleted)
				return node.key;
			
			int leftMin = findMax(node.leftChild);
			if(leftMin > -1)
				return leftMin;
		}
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
			if(node.deleted)
			{
				output = output + "*";
			}
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
