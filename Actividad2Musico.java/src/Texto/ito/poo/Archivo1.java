package Texto.ito.poo;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Archivo1 {

	private Formatter almacén;
	
	public Archivo1(String archivo) throws FileNotFoundException{
		this.almacén= new Formatter(archivo);
	}
	
	public  void writeByte(byte item) {
		this.almacén.format("%d ", item);
	}
	
	public void writeByteLn(byte item) {
		this.almacén.format("%d\n", item);
	}
	
	public void writeShort(short item) {
		this.almacén.format("%d ", item);
	}
	
	public void writeShortLn(short item) {
		this.almacén.format("%d\n", item);
	}
	
	public void writeInt(int item) {
		this.almacén.format("%d ",item);
	}
	
	public void writeIntLn(int item) {
		this.almacén.format("%d\n", item);
	}
	
	public void writeLong(long item) {
		this.almacén.format("%d ",item);
	}
	
	public void writeLongLn(long item) {
		this.almacén.format("%d\n", item);
	}
	
	public void writeString(String item) {
		this.almacén.format("%s ", item);
	}
	
	public void writeStringLn(String item) {
		this.almacén.format("%s\n", item);
	}
	
	public void writeFloat(float item) {
		this.almacén.format("%.2f ", item);
	}
	
	public void writeFloatLn(float item) {
		this.almacén.format("%f\n", item);
	}
	
	public void writeDouble(double item) {
		this.almacén.format("%f ", item);
	}
	
	public void writeDoubleLn(double item) {
		this.almacén.format("%f\n", item);
	}
	
	public void writeBoolean(boolean item) {
		this.almacén.format("%b ", item);
	}
	
	public void writeBooleanLn(boolean item) {
		this.almacén.format("%b\n", item);
	}
	
	
	
	public void close() {
		this.almacén.close();
	}
}