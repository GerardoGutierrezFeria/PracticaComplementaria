package interfaces.ito.poo;
import excepciones.ito.poo.*;


public interface Interfaces<T> {
	
public boolean addItem(T item) throws ExisteCancion;
	
	public boolean existeItem(T item);
	public T getItem(int pos);
	public int getSize();
	public boolean clear(T item);
	public boolean isFree();
	public boolean isFull();
	
}