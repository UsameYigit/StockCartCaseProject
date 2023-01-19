package Data.Abstract;

public interface INavigators<T,Y> {
	public T getNextItem(Y position);
	public T getPreviousItem(Y position);
	public T getLastItem();
	public T getFirstItem();
}
