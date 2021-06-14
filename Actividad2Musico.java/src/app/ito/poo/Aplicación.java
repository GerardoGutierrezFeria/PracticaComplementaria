package app.ito.poo;
import java.util.Scanner;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.time.LocalDate;

import excepciones.ito.poo.EliminaCancion;
import clases.ito.poo.Cancion;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import excepciones.ito.poo.*;
import clases.ito.poo.Composici�n;
import excepciones.ito.poo.ExisteCancion;
import Texto.ito.poo.*;
import excepciones.ito.poo.ConsultaCancion;

//Autor: Guti�rrez Feria Gerardo 20011238

public class Aplicaci�n<Interprete> {
	static Scanner lector= new Scanner(System.in);
	static Cancion Canci�n;
	static Composici�n compo;
	static Archivo1 archivo;
	static Archivo2 archivo2;
	static String interprete;
	
	
	
	static void menu() throws  HeadlessException, Titulo, Solicitante, ConsultaCancion, ExisteCancion, EliminaCancion, EliminaInterprete, FileNotFoundException {
		Comenzar();
		IniciarP();
		final JPanel 
		panel=new JPanel();
		boolean error=true;
		while(error) {
		try {
		boolean ciclo=true;
		int respuesta=0;
		while(ciclo) {
		String opciones="-Hola, soy Guti�rrez Feria Gerardo, el creador del c�digo, Seleccione la opci�n que m�s le favorezca:-\n 1.- A�adir composici�n \n 2.- Mostrar Composici�nes existentes \n 3.- Eliminar Composici�n (Dar de baja) \n 4.- AgregarInterprete \n 5.- EliminaInterprete \n 6.- No hacer nada m�s (Salir del programa) ";
		respuesta=Integer.parseInt(JOptionPane.showInputDialog(opciones));
		//metodo para a�adir genero
		/*System.out.print("
		 * 
		 * 
		 * 
		 * */
		switch(respuesta) {
		case 1:AgregaComposicion();break;
		case 2:muestraCancion();break;
		case 3:EliminaComposicion();break;
		case 4:AgregarInterprete();break;
		case 5:EliminaInterprete();break;
		case 6:guardaRegistro();ciclo=false;error=false;break;
		default:JOptionPane.showMessageDialog(null,"Ingresar opcion");
		  }
		}
		
		}catch(Titulo e){
			
			JOptionPane.showMessageDialog(panel,e.getMessage(),"���ERROR!!!", JOptionPane.ERROR_MESSAGE);
			
		}catch(Solicitante e ) {
			
			JOptionPane.showMessageDialog(panel,e.getMessage(),"���ERROR!!!", JOptionPane.ERROR_MESSAGE);
			
		}catch(	ExisteCancion e) {
			
			JOptionPane.showMessageDialog(panel,e.getMessage(),"���ERROR!!!", JOptionPane.ERROR_MESSAGE);
			
		}catch(EliminaInterprete e) {
			
			JOptionPane.showMessageDialog(panel,e.getMessage(),"���ERROR!!!", JOptionPane.ERROR_MESSAGE);
			
		}catch(EliminaCancion e) {
			
			JOptionPane.showMessageDialog(panel,e.getMessage(),"���ERROR!!!", JOptionPane.ERROR_MESSAGE);
			
		}catch(ConsultaCancion e) {
			
			JOptionPane.showMessageDialog(panel,e.getMessage(),"���ERROR!!!", JOptionPane.ERROR_MESSAGE);
			
		}
		}
	}
	
	static Composici�n capturarComposici�n()throws Titulo, Solicitante, ExisteCancion, EliminaInterprete,EliminaCancion, ConsultaCancion  {
	Composici�n n= new Composici�n(null, null, null, null, null, 0, 0);
	
	
			String titulos, solicitantes, generoMusical, fechaRegistro, fechaEstreno; int minutos, segundos;
			titulos=JOptionPane.showInputDialog("Inserte el titulo de la cancion");
			solicitantes=JOptionPane.showInputDialog("Inserte el nombre de interprete que lo solicita:");
			generoMusical=JOptionPane.showInputDialog("inserte el genero musical");
			fechaRegistro=JOptionPane.showInputDialog("Fecha en que se registro la canci�n??\nFavor de insertar:(a�o-mes-d�a):");
			fechaEstreno=JOptionPane.showInputDialog("Fecha que en se estreno la canci�n??\nFavor de insertar:(a�o-mes-d�a):");
			minutos=Integer.parseInt(JOptionPane.showInputDialog("Inserte duracion en minutos: "));
			segundos=Integer.parseInt(JOptionPane.showInputDialog("Inserte duracion en segundos: "));
			n.setTitulo(titulos);
			n.setSolicitantes(solicitantes);
			n.setGeneroMusical(generoMusical);
			n.setFechaRegistro(LocalDate.parse(fechaRegistro));
			n.setFechaEstreno(LocalDate.parse(fechaEstreno));
			n.setMinutos(minutos);
			n.setSegundos(segundos);
			
			return n;
				
			
		}
	
	static void Comenzar() {
		Canci�n=new Cancion();
	}
	
	static void AgregaComposicion() throws Titulo, Solicitante, HeadlessException , ExisteCancion, ConsultaCancion, EliminaCancion, EliminaInterprete, FileNotFoundException {
		Composici�n nueva;
		nueva= capturarComposici�n();
		Canci�n.ExisteCancion(nueva);
		Canci�n.addItem(nueva);
	    JOptionPane.showMessageDialog(null, "**Su composicion se agrego exitosamente**");
			if(Canci�n.isFull())
				Canci�n.incrementaArreglo();
		
	}
	static Composici�n Composicionaleatorio(String aleatorio) {
		compo = null;int i=0;
		for(;i<Canci�n.getSize();i++) {
			compo=Canci�n.getItem(i);
			System.out.println(Canci�n.getItem(i)+"\nEs la composici�n?"+aleatorio);lector.nextLine();
			if(lector.nextLine().equalsIgnoreCase("si"))
				break;
			compo=null;
		}
		return compo;	
	}
	
	static void AgregarInterprete() {
		
		if(!Canci�n.isFree()) {
			compo=Composicionaleatorio ("Ingresando...");
			System.out.println("Introduce el nombre del Interprete");
			compo.AgregarInterpret(lector.nextLine());
		}else
			System.out.println("No hay composiciones existentes");
	}
	
	
	static void EliminaInterprete() {
		
		if(!Canci�n.isFree()){
			compo=Composicionaleatorio ("Eliminando...");
			System.out.println("Introduce el nombre del Interprete para eliminarlo");
			compo.EliminarInterpret(lector.nextLine());
		}else
			System.out.println("No hay composiciones existentes");
	}

    static void muestraCancion() {
		
		
		if(Canci�n.isFree())
			JOptionPane.showMessageDialog(null,"���No se encontro ninguna composicion!!!");
		else {
			
		String cuentas="";
		for(int i=0;i<Canci�n.getSize();i++)
			cuentas=cuentas+"\n"+(Canci�n.getItem(i));
		JOptionPane.showMessageDialog(null,cuentas);
		
		  }
        }
    	
		
		
    static void EliminaComposicion() throws EliminaCancion {
		int pos=0;
		if(Canci�n.isFree())
			JOptionPane.showMessageDialog(null,"Aun no hay canciones");
		else {
			boolean CUENTA=true;
			while(CUENTA) {
		    String cuentas="";
		    
		    for(int i=0;i<Canci�n.getSize();i++)
			    cuentas=cuentas+"\n"+(i+1)+")"+(Canci�n.getItem(i));
		    pos=Integer.parseInt(JOptionPane.showInputDialog("Seleccione la cancion a borrarr\n"+cuentas));
		    if((Canci�n.getSize())>=pos&&pos>0) {
		    	Canci�n.EliminaCancion(Canci�n.getItem(pos-1));
		    	Canci�n.clear(Canci�n.getItem(pos-1));
		    	
		    	JOptionPane.showMessageDialog(null,"Cancion borrada con exito");
		    	CUENTA=false;
		    }	
		    else
		    	
		    	JOptionPane.showMessageDialog(null,"Aun no hay canciones!!, no se pueden borrar");
		    }
		}
	}
		
	static void guardaRegistro() throws FileNotFoundException , ExisteCancion , EliminaInterprete, ConsultaCancion {
			if (Canci�n.isFree()) {
				
			}
			else {
				archivo=new Archivo1("Guarda Canciones");
				for(int i=0;i<Canci�n.getSize();i++) {
					archivo.writeString(Canci�n.getItem(i).getGeneroMusical());
					archivo.writeString(Canci�n.getItem(i).getTitulo());
					archivo.writeString(Canci�n.getItem(i).getSolicitantes());
					if(Canci�n.getItem(i).getFechaRegistro()==null) {
						archivo.writeString(Canci�n.getItem(i).getFechaEstreno().toString());
						archivo.writeStringLn("null");	
					}
					else {
						archivo.writeString(Canci�n.getItem(i).getFechaRegistro().toString());
						archivo.writeStringLn(Canci�n.getItem(i).getFechaEstreno().toString());	
					}
					
				}
				archivo.close();
			}
						
		}
		static void IniciarP() throws FileNotFoundException, Titulo ,ExisteCancion {
			boolean existe=false;
			try {
				archivo2= new Archivo2("Guardando composiciones");
				existe=true;
			}catch(FileNotFoundException e) {
				System.err.println("Creando composiciones...");
			}
			if(existe)
				LTexto();
			
		}
		
		static void LTexto() throws Titulo ,ExisteCancion {
			
			while(!archivo2.isEOF()) {
				Composici�n error=null;
				error.setTitulo(archivo2.readString());
				error.setMinutos(archivo2.readInt());
				error.setSegundos(archivo2.readInt());
				error.setGeneroMusical(archivo2.readString());
				error.setSolicitantes(archivo2.readString());
				error.setFechaRegistro(LocalDate.parse(archivo2.readString()));
				error.setFechaEstreno(LocalDate.parse(archivo2.readString()));
				String fechaAct;
				fechaAct=archivo2.readString();
				if(fechaAct.equals("null")) 
					error.setFechaEstreno(null);
				else
					error.setFechaEstreno(LocalDate.parse(fechaAct));
				Canci�n.addItem(compo);
				archivo2.isFinLinea();
			
				
			}
		}
		
		
		  
}
