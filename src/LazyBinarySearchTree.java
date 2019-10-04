/* Name: Andrew Sylvester
 * Class: CS 3345
 * Section: 001
 * Semester: Fall 2019
 * Project 3 
 * Class Description: This class LazyBinarySearchTreee is an implementation of a Binary Search Tree with lazy deletion.
 */
public class LazyBinarySearchTree 
{
	private TreeNode root;
	private int treeSize;
	
	/**
	 * Node class to be used to hold data for the Binary tree.
	 *
	 */
	private static class TreeNode
	{
		public int key;
		public TreeNode leftChild;
		public TreeNode rightChild;
		public boolean deleted;
		
		/**
		 * Constructor
		 * @param key The value for the node to hold.
		 */
		public TreeNode(int key)
		{
			this.key = key;
			leftChild = null;
			rightChild = null;
			deleted = false;
		}
	}
	
	/**
	 * Constructor
	 */
	public LazyBinarySearchTree() 
	{
		root = null;
		treeSize = 0;
	}
	
	/**
	 * Inserts a node with key into the tree. If already exists will return false, or if 
	 * deleted will undelete the node.
	 * @param key Value to be inserted into the tree.
	 * @return Whether or not the key was logically inserted.
	 * @throws IllegalArgumentException
	 */
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
	
	/**
	 * Helper method for insert.
	 * @param key Value to Insert.
	 * @param node Current node in traversal.
	 * @param parent Last node in the traversal.
	 * @return If inserted or not logically.
	 */
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

	/**
	 * If key is in the tree then this method marks it as deleted if not already.
	 * @param key The value to delete.
	 * @return Whether or not the key was logically deleted.
	 * @throws IllegalArgumentException
	 */
	public boolean delete(int key) throws IllegalArgumentException
	{
		if(key < 1 || key > 99)
		{
			throw new IllegalArgumentException("Arguments out of bounds!");
		}
		
		return delete(key, root);
	}
	
	/**
	 * Helper method for delete.
	 * @param key The value to be deleted
	 * @param node Current node in the recursive traversal.
	 * @return Whether or not the node was deleted logically.
	 */
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
	
	/**
	 * Finds the minimum non-deleted key.
	 * @return the minimum non-deleted value in the tree.
	 */
	public int findMin()
	{
		return findMin(root);
	}	
	
	/**
	 * Helper method for findMin that traverses the tree by infix.
	 * @param node The current node in the traversal.
	 * @return The value of the minimum non-deleted node.
	 */
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
	
	/**
	 * Finds the maximum non-deleted key.
	 * @return the maximum non-deleted value in the tree.
	 */
	public int findMax()
	{
		return findMax(root);
	}
	
	/**
	 * Helper method for findMax that traverses the tree by in-order.
	 * @param node The current node in the traversal.
	 * @return The value of the maximum non-deleted node.
	 */
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
	
	/**
	 * Checks if the key is in the binary tree and not deleted.
	 * @param key Value to find in tree.
	 * @return Whether or not the value was found undeleted in the tree.
	 * @throws IllegalArgumentException
	 */
	public boolean contains(int key) throws IllegalArgumentException
	{
		if(key < 1 || key > 99)
		{
			throw new IllegalArgumentException("Arguments out of bounds!");
		}
		
		return contains(key, root);
	}
	
	/**
	 * Helper method for contains.
	 * @param key Value to find in tree.
	 * @param node Current node in the recursive traversal of the tree.
	 * @return Whether or not the key was found undeleted in the tree.
	 */
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
	
	/**
	 * Gets a string with the values of the tree in pre-order and marked with * if deleted.
	 * @return 
	 */
	public String toString()
	{
		return toString(root, "");
	}
	
	/**
	 * Helper method for toString.
	 * @param node Current node in the recursive pre-order traversal.
	 * @param output Current string of values in the tree.
	 * @return A string with values of the tree.
	 */
	private String toString(TreeNode node, String output)
	{
		if(node != null)
		{
			if(node.deleted)
			{
				output = output + "*" + node.key + " " + toString(node.leftChild, output) + toString(node.rightChild, output);;
			}
			else
			{
				output = output + node.key + " " + toString(node.leftChild, output) + toString(node.rightChild, output);
			}
			return output;
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * Gets the height of the tree.
	 * @return Height of tree.
	 */
	public int height()
	{
		return height(root);
	}
	
	/**
	 * Helper method of height. Traverses tree recursively to find the height.
	 * @param node Current node in the traversal.
	 * @return Height of the tree.
	 */
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
	
	/**
	 * Gets the number of nodes in the tree (deleted or not.)
	 * @return The size of the tree.
	 */
	public int size()
	{
		return treeSize;
	}
}
