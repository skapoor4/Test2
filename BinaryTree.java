package Prac2;

import java.util.Stack;

public class BinaryTree<E extends Comparable<E>> {

	private TreeNode<E> root;
	
	public BinaryTree()
	{
		
		root = null;
		
		
	}

//Search item using recursive method	
	public void searchItem(E e)
	{
		 
		if(root==null)
			System.out.println("Tree is empty!");
		else
		{	
			TreeNode<E> current =  root;
			while(current!=null)
			{
				if(current.getElement().compareTo(e)>0)
					current = current.getLeft();
				else if(current.getElement().compareTo(e)<0)
					current = current.getRight();
				else 
					System.out.println("True");
					
				
			}
		}
		
	}
	
//Search item using recursive method
	
	public void searchItemRec(TreeNode<E> node,E e)
	{
		
		if(root==null)
			System.out.println("Tree is empty!");
		else
		{
			TreeNode<E> current =  node;
			if(current.getElement().compareTo(e)>0)
				searchItemRec(current.getLeft(),e);
			else if(current.getElement().compareTo(e)<0)
				searchItemRec(current.getRight(),e);
			else
				System.out.println(current.getElement());
				
			
			
		}
		
	}
	
//Inserting an element into Binary Search Tree
	
	public boolean addInsert(E e)
	{
		if(root==null)
			root = new TreeNode<E>(e);
		else
		{
			TreeNode<E> parent = root;
			TreeNode<E> current = root;
			
			while(current!=null)
			{
				if(current.getElement().compareTo(e)>0)			
					{
					parent = current;
					current = current.getLeft();
					}
				else if(current.getElement().compareTo(e)<0)
					
				{
					parent = current;
					current = current.getRight();
							
				}
				else
					return false;//duplicate element
				
			}
				
				TreeNode<E> newNode = new TreeNode<E>(e);
				if(parent.getElement().compareTo(e)>0)
					parent.setLeft(newNode);
				else if(parent.getElement().compareTo(e)<0)
					parent.setRight(newNode);
				
				
		}
		
		return true;
		
	}
	
//Insert into the tree using recursion

	public void addRec(E e)
	{
		root = addInsertRec(root,e);
		
		
	}
	public TreeNode<E> addInsertRec(TreeNode<E> node,E e)
	{
		if(node==null)
			node = new TreeNode<E>(e);
		else if(node.getElement().compareTo(e)>0)
					 node.setLeft(addInsertRec(node.getLeft(),e));
		else if(node.getElement().compareTo(e)<0)
			node.setRight(addInsertRec(node.getRight(),e));
		
		return node;
		
	}
	
//Delete the item using recursion
	
	public void deleteItem(E e)
	{
		root = deleteRec(root,e);
		
	}
	
	public TreeNode<E> deleteRec(TreeNode<E> node, E e )
	{
		if(node==null)
		{
			//do nothing
		}
		else if(node.getElement().compareTo(e)>0)
			node.setLeft(deleteRec(node.getLeft(),e));
		else if (node.getElement().compareTo(e)<0)
			node.setRight(deleteRec(node.getRight(),e));
		else
		{
			if(node.getRight()==null)
			{
				
				node = node.getLeft();
			}
			else 
			{
				
				E find = min(node.getRight());
				node.setElement(find);
				node.setRight(deleteRec(node.getRight(),find));
				
			}
			
		}
		return node;
		
		
	}
	
	public E min(TreeNode<E> node)
	{
		if(node.getLeft()==null)
			return node.getElement();
		else
			return min(node.getLeft());
		
	}
//Deleting an item from the BST using iterative method
	public void delete(E e)
	{
		if(root==null)
			System.out.println("Tree is emoty");
		else 
		{
			TreeNode<E> current = root;
			TreeNode<E> parent=null;
			while(current!=null)
			{
				if(current.getElement().compareTo(e)>0)
				{
					parent = current;
					current = current.getLeft();
					
				}
				else if(current.getElement().compareTo(e)<0)
				{
					parent = current;
					current = current.getRight();
					
				}
				else
					break;
				
			}	
			
			if(current==null) //not found
				System.out.println("Element not found");
			
			if(current.getLeft()==null)//Item with 0 child and 1 child.
			{
				if(parent==null)//If root is the element to delete
					root = current.getRight();
				else
				{
					if(parent.getElement().compareTo(e)>0)
						parent.setLeft(current.getRight());
					else
						parent.setRight(current.getRight());
						
					
					
				}
				
				
			}
			else
			{//Node with two children
				
				TreeNode<E> parentRightMost = current;
				TreeNode<E> rightMost = current.getLeft();
				
				while(rightMost.getRight()!=null)
				{
					parentRightMost = rightMost;
					rightMost = rightMost.getRight();
				}
				
				current.setElement(rightMost.getElement());
				if(parentRightMost.getRight()==rightMost)
					parentRightMost.setRight(rightMost.getLeft());
				else 
					parentRightMost.setLeft(rightMost.getLeft());//if there is no high rightmost element found
					
		
			
				
			}
			
			}
			
			
		}
		


//Tree Traversal using Iteration
	
	public void inOrderIter()
	{
		
		if(root==null)
			System.out.println("Tree is empty");
		else
		{
			TreeNode<E> current = root;
			Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
			while(!stack.isEmpty() || current!=null)
			{
				if(current!=null)
				{
					stack.push(current);
					current = current.getLeft();
					
					
				}
				else
				{
					TreeNode<E> temp = stack.pop();
					System.out.println(temp.getElement());
					current = temp.getRight();
					
					
				}
				
				
				
			}
			
			
			
		}
		
		
		
	}
	
//Inorder using recursion
	public void inOrderR()
	{
		inOrderRec(root);
		
		
	}
	public void inOrderRec(TreeNode<E> node)
	{
		if(node!=null)
		{
		 inOrderRec(node.getLeft());
		System.out.println(node.getElement());
		 inOrderRec(node.getRight());
		}
		
		
		
	}
	
//PostOrder using iteration
	
	public void postOrderIter()
	{
		if(root==null)
			System.out.println("Root is empty");
		else
		{
			TreeNode<E> current = root;
			Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
			
			while(!stack.isEmpty() || current!=null)
			{
				
				if(current!=null)
				{
					stack.push(current);
					current = current.getLeft();
					
				}
				else
				{
					TreeNode<E> temp = stack.peek().getRight();
					if(temp==null)
					{
						temp = stack.pop();
						System.out.println(temp.getElement());
						while(!stack.isEmpty()&& temp==stack.peek().getRight())
						{
							temp =stack.pop();
							System.out.println(temp.getElement());
							
							
						}
						
					}
					else
						current = temp;
					
					
					
				}
				
				
			}
			
		}
		
	}
	
//post order using recursion
	
	public void postOrderRec()
	{
		postOrderR(root);
		
		
	}
	
	public void postOrderR(TreeNode<E> node)
	{
		if(node!=null)
		{
		postOrderR(node.getLeft());
		postOrderR(node.getRight());
		System.out.println(node.getElement());
		}
		
		
	}
	
//preorder using iteration
	
	public void preOrderIter()
	{
		if(root==null)
			System.out.println("Tree is empty");
		else
		{
			Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
			stack.push(root);
			TreeNode<E> current = root;
			while(!stack.isEmpty())
			{
				current = stack.pop();
				System.out.println(current.getElement());
				if(current.getRight()!=null)
					stack.push(current.getRight());
				if(current.getLeft()!=null)
					stack.push(current.getLeft());
				
			}
			
		}
		
	}
	
//preorder using recursion
	
	public void preOrder()
	{
		
		preOrderRec(root);
	}
	public void preOrderRec(TreeNode<E> node)
	{
		if(node!=null)
		{
			System.out.println(node.getElement());
			preOrderRec(node.getLeft());
			preOrderRec(node.getRight());
		
		}

		
	}
	
}
