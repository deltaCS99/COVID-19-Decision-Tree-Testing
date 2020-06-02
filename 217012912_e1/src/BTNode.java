
/**
 * A Node in the tree
 *
 * @param <T> String the object type that will be stored in this node
 */
public class BTNode<T> implements BTPosition<T> {
	private T element = null;
	private BTNode<T> left  = null;
	private BTNode<T> right = null;
	private BTNode<T> parent = null;
	
	/**
	 * The constructor
	 * 
	 * @param parent - The parent of this node (null if the root)
	 * @param element the element that will be stored in the tree
	 */
	public BTNode(BTNode<T> parent, BTNode<T> left, BTNode<T> right, T element) {
		this.parent = parent;
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Set the element in this node
	 * @param element the element to set
	 */
	public void setElement(T element) {
		this.element = element;
	}
	
	@Override
	/**
	 * Get element from the TreeNode
	 */
	public T element() {
		return element;
	}

	/**
	 * Return the String representation of the Node.
	 */
	public String toString() {
		String ret = "(" + element.toString() + ")";
		return ret;
	}

	@Override
	public BTPosition<T> left() {
		return left;
	}

	@Override
	public BTPosition<T> right() {
		return right;
	}
	
	@Override
	public BTPosition<T> parent() {
		return parent;
	}
	
	public void setParent(BTNode<T> parent) {
		this.parent = parent;
	}
	
	public void setLeft(BTNode<T> left) {
		this.left = left;
	}
	
	public void setRight(BTNode<T> right) {
		this.right = right;
	}
}
