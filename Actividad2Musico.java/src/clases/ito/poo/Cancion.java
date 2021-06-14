package clases.ito.poo;
//autor: Gutiérrez Feria Gerardo 20011238
import interfaces.ito.poo.*;
import excepciones.ito.poo.EliminaCancion;
import excepciones.ito.poo.ExisteCancion;



public class Cancion implements Interfaces<Composición>{

	static Composición c;
	

	private Composición composiciones[]=null;
	private int ultimo=0;
	private final int INC=5;
	
	 
	public Cancion() {
		super();
		this.composiciones=new Composición[INC];
		this.ultimo=-1;
	}
	
	public void ExisteCancion(Composición item) throws ExisteCancion{
		if(this.existeItem(item)) {
			throw new ExisteCancion("¡¡¡ERROR!!!La composicion que intenta registrar ya existe \n Intente de nuevo");
		}
	}
	
	
	
	public void EliminaCancion(Composición item) throws EliminaCancion{
		if(item.getSolicitantes()=="") {
			throw new EliminaCancion("¡¡¡ERROR!!!No se puede dar de baja una composicion con interpretes que ya la solicitaron!");
		}
	}
	
	public void incrementaArreglo() {
		Composición aumenta[]=new Composición[this.composiciones.length+INC];
		for(int i=0;i<composiciones.length;i++)
			aumenta[i]=this.composiciones[i];
		composiciones= aumenta;
	}
	
	@Override
	public boolean addItem(Composición item) throws ExisteCancion {
		boolean add=false;
		
		if(this.isFull()) 
			incrementaArreglo();
		int j=0;
		for(;j<=this.ultimo;j++)
			if(item.compareTo(this.composiciones[j])<0) {
				break;
				}
				
				for(int i=this.ultimo;i>=j;i--)
					composiciones[i+1]=composiciones[i];
				this.composiciones[j]=item;
				this.ultimo++;
				add=true;
			
		return add;
	}
	
	public boolean existeItem(Composición item) {
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(item.compareTo(this.composiciones[i])==0) {
				existe=true;
				break;
			}
					
		return existe;
	}
	
	@Override
	public Composición getItem(int pos) {
		Composición cb=null;
		if(pos<=this.ultimo&&!this.isFree())
			cb=this.composiciones[pos];
		return cb;
	}
	
	@Override
	public int getSize() {
		return this.ultimo+1;
	}
	
	@Override
	public boolean clear(Composición item) {
		boolean elimina=false;
		if(this.existeItem(item)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(this.composiciones[i])==0)
					break;
			for(;i<=this.ultimo;i++)
				composiciones[i]=composiciones[i+1];
			this.ultimo--;
			elimina=true;
		}
		return elimina;
	}
	
	@Override
	public boolean isFree() {
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		
		return this.ultimo+1==this.composiciones.length;
	}
	
	
}
	
