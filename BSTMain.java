/* wajp to create a binary tree or binary search tree and perform
   various operations on it */

import java.io.*;

// Assume that the data portion of each node consists of ONLY an integer.

class Node
{
  public int data;
  public Node left, right;

  public Node(int x)
  {
    data=x;
  }
}

class BST
{

private Node root;
private int lcount;  // will store no of leaf nodes in BST

public BST()
{
root=null;
}

// this fn will insert a new node as a leaf node in the BST
void insert(int x)
{
    Node p,follow;

    Node ptr=new Node(x);

    if(ptr==null)
    {
       System.out.println("Memory overflow. Unable to create.");
       return;
    }

    // a new node is always inserted as leaf node
    ptr.left=ptr.right=null;     // not required

    if(root==null)  // tree is empty
	 root=ptr;
     else		// tree is non empty
     {
	// searching the place of insertion.
	p=root;
	follow=null;

	while(p!=null)
	{
	  follow=p;
	  if(ptr.data<p.data)
	    p=p.left;
	  else
	    p=p.right;
	}

	// actual insertion
	if(ptr.data<follow.data)
	  follow.left=ptr;
	else
	  follow.right=ptr;
      }
    
}




// BT Traversal methods - ALMOST ALL PAPERS

void callpreorder()
{
  preorder(root);
}

void preorder(Node root)
{
  if(root!=null)
  {
    System.out.println(root.data);     // visit the root
    preorder(root.left);         // traverse the LST in preorder
    preorder(root.right);        // traverse the RST in preorder
  }
}

void callinorder()
{
inorder(root);
}

void inorder(Node root)
{
  if(root!=null)
  {
    inorder(root.left);
    System.out.println(root.data);
    inorder(root.right);
  }
}

void callpostorder()
{
  postorder(root);
}

void postorder(Node root)
{
  if(root!=null)
  {
    postorder(root.left);
    postorder(root.right);
    System.out.println(root.data);
  }
}

// this function will delete a node with value k from the SLL if it exists
public void deleteNode(int k)
{
  Node p,follow,t,f;

  // searching the node 
  p=root;  follow=null;
  while(p!=null)
  {
      if(p.data==k)
	break;

      follow=p;
      
      if(k<p.data)
	    p=p.left;
      else
	    p=p.right;  
  }

  if(p==null)
     System.out.println("REQUIRED NODE NOT FOUND");
  else // Actual Deletion
  {
    
    // EITHER A LEAF OR EMPTY LEFT SUB TREE

    if(p.left==null)
	if(p!=root)
	    if(follow.left==p)
		follow.left=p.right;
	    else
		follow.right=p.right;
	else
	    root=p.right;

    //  EMPTY RIGHT SUB TREE

    else if(p.right==null)
	    if(p!=root)
		if(follow.left==p)
		    follow.left=p.left;
		else
		    follow.right=p.left;
	    else
		root=p.left;

    // NON-EMPTY LEFT AND RIGHT SUB TREES
    else
    { 
      /* finding the inorder successor of p, that is,  
       finding the smallest node in right sub tree  of p*/

      t=p.right; f=p;
      while(t.left!=null)
      { 
        f=t; 
	t=t.left;
      }
      /* At this stage t is the inorder successor of p
         and f is the father of t */

      // put p's data in place of t
      p.data=t.data;
       
      if(f!=p)
	      f.left=t.right;
      else
	      f.right=t.right;
    }   
  }
}






// this fn will find the total no. of leaf nodes in the BST
// It will also print the data values of leaf nodes
void callleafcount()
{
lcount=0;		// not required
leafcount(root);
System.out.println("Total no. of leafs is "+lcount);
}

void leafcount(Node root)
{
  if(root!=null)
  {
    leafcount(root.left);
    if(root.left==null&&root.right==null)
    {    
	lcount++;
	System.out.println(root.data);
    }
    leafcount(root.right);
  }
}




}

class BSTMain
{
public static void main(String args[]) throws IOException
{

InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader stdin=new BufferedReader(isr);
int x,k,choice;

BST t=new BST();

do
{
      System.out.println("Menu:");
      System.out.println("1:Insert");
      System.out.println("2:Preorder");      
      System.out.println("3:Inorder");
      System.out.println("4:Postorder");
      System.out.println("5:Delete node");   
      System.out.println("9:Leaf Count"); 
      System.out.println("12:exit");
      System.out.println("Enter your choice: ");
      choice=Integer.parseInt(stdin.readLine());
      
      
      switch(choice)
      {
	case 1:
	System.out.println("Enter data value of new node: ");
	x=Integer.parseInt(stdin.readLine());
	t.insert(x);
	break;

	case 2:
	t.callpreorder();
	break;

	case 3:
	t.callinorder();
	break;
	
	case 4:
	t.callpostorder();
	break;

	case 5:
	System.out.println("Enter data value of the node to be deleted: ");
	k=Integer.parseInt(stdin.readLine());
	t.deleteNode(k);
	break;

	
	case 9:
	t.callleafcount();
	break;


	case 12:
	break;
       }

}while(choice!=12);

}
}

