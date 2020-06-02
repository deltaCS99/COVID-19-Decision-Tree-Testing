//Overall BinaryTree class: 25 marks *****************************************
import java.util.Iterator;

/**
 * A Binary Tree. There should be a reference to the root of the tree
 * and then all of the nodes contained in the tree are children of the root.
 *
 * @param <T> The type of the objects that will be contained in the tree
 */
public class BinaryTree<T> implements Iterable<T> {
	private BTNode<T> root;
	private int size;
	
	/**
	 * Create a new tree, with a null node in the root;
	 */
	public BinaryTree() {
		root = new BTNode<T>(null, null, null, null);
		size = 0;
	}
	
	public BinaryTree(T element) {
		root = new BTNode<T>(null, null, null, element);
		size = 1;
	}
	
	public BinaryTree(BTNode<T> root) {
		this.root = root;
	}
	
	/**
	 * Get the root of the tree
	 * @return return the root of the tree
	 */
	public BTPosition<T> root() {
		return root;
	}
	
	/**
	 * Get an iterator for the children of a node
	 * @param node a Position<T> which is a node in this tree;
	 * @return an Iterator over the children of a node
	 */
	public BTPosition<T> left(BTPosition<T> node) {
		BTNode<T> treeNode = checkPosition(node);
		
		if (hasLeft(treeNode)) {
			return treeNode.left();
		}
		return null;
	}
	
	/**
	 * Get an iterator for the children of a node
	 * @param node a Position<T> which is a node in this tree;
	 * @return an Iterator over the children of a node
	 */
	public BTPosition<T> right(BTPosition<T> node) {
		BTNode<T> treeNode = checkPosition(node);
		
		if (hasRight(treeNode)) {
			return treeNode.right();
		}
		return null;
	}
	
	public boolean hasLeft(BTPosition<T> node) {
		BTNode<T> treeNode = checkPosition(node);
		
		return treeNode.left() != null;
	}
	
	public boolean hasRight(BTPosition<T> node) {
		BTNode<T> treeNode = checkPosition(node);
		
		return treeNode.right() != null;
	}
	
	/**
	 * Get the parent of a node
	 * @param node a Position<T> which is a node in this tree
	 * @return a Position<T> which is the parent of this node
	 */
	public BTPosition<T> parent(BTPosition<T> node) {
		return node.parent();
	}
	
	/*
	 * Returns an iterator over all of the elements in this tree
	 * @return an Iterator<T> over all of the elements
	 * 5 marks ***********************************************************************************
	 */
	public Iterator<T> elements() {
		//TODO: Complete
		
		PositionList<T> list = new PositionList<T>(); 
		
		PreorderElementTraversal(list, root);
		
		return list.iterator();
		
	}
	
	/*
	 * Calculates the depth of a Binary tree node position in the overall binary tree
	 * 5 marks ***********************************************************************************
	 */
	public Integer nodeDepth(BTPosition<T> nodePos){
		//TODO: Complete
		if(nodePos.equals(root))
			
			return 0;
		
		return 1+nodeDepth(nodePos.parent());
	}
	
	/**
	 * Return an Iterator over all of the elements in this tree
	 */
	@Override
	public Iterator<T> iterator() {
		return elements();
	}
	
	/**
	 * The number of nodes in this tree
	 * @return the number of nodes in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Return true if the tree is empty
	 * @return true if the tree is empty, false if the tree is not empty;
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Perform a preorder traversal over all of the elements in the list. These elements should be
	 * added to the PositionList.
	 * @param elements a PositionList<T> that will hold all of the elements in this tree
	 * @param root The root of the subtree
	 * 5 marks ***********************************************************************************
	 */
	public void PreorderElementTraversal(PositionList<T> elements, BTPosition<T> root) {
		//TODO: Complete
		
		T item = root.element();
		
		elements.addLast(item);
		
		if(root.left() != null)
			PreorderElementTraversal(elements,root.left());
		
		if(root.right()!= null)
			PreorderElementTraversal(elements,root.right());
		
	}
	
	
	/**
	 * Perform a preorder traversal over all of the Positions in the list. These elements should be
	 * added to the PositionList.
	 * @param elements a PositionList<T> that will hold all of the elements in this tree
	 * @param root The root of the subtree
	 * 5 marks ***********************************************************************************
	 */
	public void PostOrderElementTraversal(PositionList<T> elements, BTPosition<T> root) {
		//TODO: Complete
		
		if(root.left() != null)
			PostOrderElementTraversal(elements,root.left());
		
		if(root.right() != null)
			PostOrderElementTraversal(elements,root.right());
		
		elements.addLast(root.element());
	}

	/**
	 * Perform an inorder traversal over all of the Positions in the list. These elements should be
	 * added to the PositionList.
	 * @param elements a PositionList<T> that will hold all of the elements in this tree
	 * @param root The root of the subtree
	 * 5 marks ***********************************************************************************
	 */
	public void InorderElementTraversal(PositionList<T> elements, BTPosition<T> root) {
		//TODO: Complete
		
		if(root.left()!= null) 
			InorderElementTraversal(elements,root.left());
			
		elements.addLast(root.element());
			
		if(root.right()!= null)
			InorderElementTraversal(elements,root.right());
		
	}

	/**
	 * Convert a Position<T> into a TreeNode<T>
	 * @param p a Position<T> to convert
	 * @return the corresponding TreeNode<T>
	 */
	private BTNode<T> checkPosition(BTPosition<T> p) {
		if (!(p instanceof BTNode<?>)) {
			throw new PositionException("Invalid Position");
		}
		
		return (BTNode<T>)p;
	}

}
