
/**
 * The Position interface
 *
 * @param <T> the type of the object for this position
 */
public interface BTPosition<T> {
	public T element();
	public BTPosition<T> left();
	public BTPosition<T> right();
	public BTPosition<T> parent();
}
