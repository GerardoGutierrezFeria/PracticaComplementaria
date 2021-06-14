package app.ito.poo;

//Autor: Gutiérrez Feria Gerardo 20011238
import java.awt.HeadlessException;
import java.io.FileNotFoundException;


import Texto.ito.poo.Archivo1;
import Texto.ito.poo.Archivo2;
import clases.ito.poo.Cancion;
import excepciones.ito.poo.ConsultaCancion;
import excepciones.ito.poo.EliminaCancion;
import excepciones.ito.poo.EliminaInterprete;
import excepciones.ito.poo.ExisteCancion;
import excepciones.ito.poo.Solicitante;
import excepciones.ito.poo.Titulo;

public class MyApp {
	
	static Cancion e=new Cancion();
	static Archivo1 archivo;
	static Archivo2 archivo2;
	
	static void run() throws HeadlessException, ExisteCancion, EliminaCancion, FileNotFoundException, Titulo, Solicitante, ConsultaCancion, EliminaInterprete {
		
		Aplicación.menu();
		   
		
    }

		static void crearArchivo() throws FileNotFoundException {
			archivo = new Archivo1("guardaComposiciones");
		}
		public static void main(String[] args) throws HeadlessException, ExisteCancion, EliminaCancion, FileNotFoundException, Titulo, Solicitante, ConsultaCancion, EliminaInterprete {
			run();
		}

}
