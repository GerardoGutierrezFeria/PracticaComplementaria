package Texto.ito.poo;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Archivo1 {

	private Formatter almac�n;
	
	public Archivo1(String archivo) throws FileNotFoundException{
		this.almac�n= new Formatter(archivo);
	}
	
	public  void writeByte(byte item) {
		this.almac�n.format("%d ", item);
	}
	
	public void writeByteLn(byte item) {
		this.almac�n.format("%d\n", item);
	}
	
	public void writeShort(short item) {
		this.almac�n.format("%d ", item);
	}
	
	public void writeShortLn(short item) {
		this.almac�n.format("%d\n", item);
	}
	
	public void writeInt(int item) {
		this.almac�n.format("%d ",item);
	}
	
	public void writeIntLn(int item) {
		this.almac�n.format("%d\n", item);
	}
	
	public void writeLong(long item) {
		this.almac�n.format("%d ",item);
	}
	
	public void writeLongLn(long item) {
		this.almac�n.format("%d\n", item);
	}
	
	public void writeString(String item) {
		this.almac�n.format("%s ", item);
	}
	
	public void writeStringLn(String item) {
		this.almac�n.format("%s\n", item);
	}
	
	public void writeFloat(float item) {
		this.almac�n.format("%.2f ", item);
	}
	
	public void writeFloatLn(float item) {
		this.almac�n.format("%f\n", item);
	}
	
	public void writeDouble(double item) {
		this.almac�n.format("%f ", item);
	}
	
	public void writeDoubleLn(double item) {
		this.almac�n.format("%f\n", item);
	}
	
	public void writeBoolean(boolean item) {
		this.almac�n.format("%b ", item);
	}
	
	public void writeBooleanLn(boolean item) {
		this.almac�n.format("%b\n", item);
	}
	
	
	
	public void close() {
		this.almac�n.close();
	}
}