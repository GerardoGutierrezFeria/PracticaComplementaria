package excepciones.ito.poo;

@SuppressWarnings("serial")
public class ExisteCancion extends Exception {

	public ExisteCancion(String message) {
		super(message);
	}
}
