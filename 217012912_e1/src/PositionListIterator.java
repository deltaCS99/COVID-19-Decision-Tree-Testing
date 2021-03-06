import java.util.Iterator;

/**
 * An iterator over a Position List. This will return the Item that is
 * contained in the list
 *
 * @param <T> The object type that will be returned by the Iterator
 */
public class PositionListIterator<T> implements Iterator<T> {
	IList<T> list;
	Position<T> cursor;
	
	/**
	 * The constructor
	 * @param list the list to iterate over
	 */
	public PositionListIterator(PositionList<T> list) {
		this.list = list;
		if (!list.isEmpty()) {
			this.cursor = list.first();
		}
	}
	
	@Override
	/**
	 * Returns true if there next() will return an element
	 */
	public boolean hasNext() {
		return !list.isEmpty() && list.next(cursor) != null;
	}

	@Override
	/**
	 * Return the "next" item in the list and then advance the cursor.
	 */
	public T next() {
		T element = cursor.element();
		cursor = list.next(cursor);
		return element;
	}

	@Override
	/**
	 * Should be used to remove the item from the list, but for now
	 * we do not include an implementation.
	 */
	public void remove() {
		//do nothing - keep java happy
	}

}
