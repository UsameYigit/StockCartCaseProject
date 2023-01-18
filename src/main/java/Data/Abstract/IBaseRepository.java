package Data.Abstract;

import java.util.ArrayList;

//Base repository for all entities that can be created
public interface IBaseRepository<T> {
	public ArrayList<T> getAll();
	public void create(T entity);
	public void delete(T entity);
	public void update(T entity);
}
