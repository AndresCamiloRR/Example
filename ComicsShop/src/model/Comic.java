package model;

/**
 * Clase que representa un comic.
 * Desarrollada para el proyecto comicsShop.
 * @author angievig
 * @version 1.0
 * @since April 2022
 */

public class Comic {
	private String name;
	private int numCopiesForSale;
	private int numCopiesSold;
	private double price;
	private double iva;
	
	public Comic(String name, int numItems, double price) {
		this.name = name;
		this.numCopiesForSale = numItems;
		this.price = price;
		numCopiesSold = 0;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumCopiesForSale() {
		return numCopiesForSale;
	}

	public int getNumCopiesSold() {
		return numCopiesSold;
	}
		
	public void setNumCopiesForSale(int numCopiesForSale) {
		this.numCopiesForSale=numCopiesForSale;
	}

	public void setNumCopiesSold(int numCopiesSold) {
		this.numCopiesSold=numCopiesSold;
	}

	
	/**
	* Method that calculate the iva from each comic based
	* on the price
	* @return iva, double that contains the value of the iva from the comic
	*/
	
	public double CalculateIva(){
		iva=price*0.19;
		return iva;
	}

	public String toString() {
		return "**** Datos del Comic ****\n" + 
	"nombre: " + name + "\n" +
	"cantidad de copias del comic en el inventario: " + numCopiesForSale + "\n" +
	"precio del comic sin iva: " + price + "\n" +
	"precio del comic con iva: " + (price + CalculateIva()) + "\n" +
	"cantidad de copias del comic vendidos: " + numCopiesSold + "\n" ;		
	}

}
