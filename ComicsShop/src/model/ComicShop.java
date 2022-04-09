package model;
/**
 * Clase controladora del proyecto comicsShop.
 * @author angievig
 * @version 1.0
 * @since April 2022
 */

public class ComicShop {
	private String nit;
	private double totalSales;
	private double totalTaxes;
	private final int MAX_COMICS = 10;
	private Comic[] comics = new Comic[MAX_COMICS];
	private int solds = 0;
	
	public ComicShop(String nit) {
		this.nit = nit;
		this.totalSales = 0;
		this.totalTaxes = 0;
	}

	/*
	* The method will create an object of Comic type and save it into an 
	* empty position of the array called comics
	* @param name, String that contains the name of the comic
	* @param numCopiesForSale, int that contains the number of copies of the comic that are available
	* @param price, double that contains the price of the comic
	*/
	
	public void RegisterComic(String name, int numCopiesForSale, double price){
		
		Comic aComic = new Comic(name, numCopiesForSale, price);
		
		comics[EmptyPosition()]=aComic;
		
	}
	
	/*
	* The method will search for a position in the array comics and
	* check if it's empty or not
	* @return index, int with the value of an empty position or a value of -1 if the array is full
	*/
	
	public int EmptyPosition(){
		
		int index=-1;
		
		for (int counter=0; counter<MAX_COMICS && index==-1; counter++){
			
			if(comics[counter]==null){
				
				index = counter;
				
			}
			
		}
		
		return index;
		
	}
	
	/*
	* The method will search if there's a comic that has a name equal to the parameter
	* @param name, String with the name of the comic
	* @return out, boolean true if the comic exist, false if it doesn't
	*/
	
	
	public boolean nameExists(String name){
		
		boolean out=false;
		
		for(int counter = 0; counter<MAX_COMICS&&out==false; counter++){
			
			if(comics[counter]!=null && comics[counter].getName().equals(name)){
				
				out=true;
				
			}
			
		}
		
		return out;
	}
	
	/*
	* The method will search for the index of the comic that it's name is
	* equals to the parameter
	* @param name, String with the name of the comic
	* @return index, int with the position were the comic is located
	*/
	
	public int NameSearch(String name){
		
		int index=-1;
		
		for (int counter=0; counter<MAX_COMICS && index==-1; counter++){
			
			if(comics[counter].getName().equals(name)){
				
				index = counter;
				
			}
			
		}
		
		return index;
		
	}
	
	/*
	* The method will search for the num of copies from the comic we selected
	* @param name, String with the name of the comic
	* @return copies, int with the number or copies from the comic that are available
	*/
	
	public int numOfCopies(String name){
		
		int copies=0;
		
		int index=NameSearch(name);
		
		if(comics[index].getNumCopiesForSale()>0){
			
			copies=comics[index].getNumCopiesForSale();
			
		}
		return copies;
		
	}
	
	
	/*
	* The method will subtract the purchases from the num of copies for 
	* sale and add the purchases to the num of copies sold
	* @param name, String with the name of the comic
	* @param quantity, int with the number of copies the client wants to buy
	* @return cost, double with the total cost of the purchase with iva
	*/
	
	public double BuyComic(String name, int quantity){
		
		double cost=0;
		
		int index=NameSearch(name);
		
		comics[index].setNumCopiesForSale(comics[index].getNumCopiesForSale()-quantity);
		
		comics[index].setNumCopiesSold(comics[index].getNumCopiesSold()+quantity);
		
		cost=(comics[index].getPrice()+comics[index].CalculateIva())*quantity;

		
		return cost;
	} 
	
	/*
	* The method will create a message with the info from a comic if it's registered in the store
	* @param index, int that contains the index of the comic that we want to check
	* @return String with the info of the comic
	*/
	
	public String ComicInfo(int index){
		
		return comics[index].toString();
		
	}
	
	/*
	* The method will create a message with the store info and the info from
	* all the comics registered in the store
	* @return info, String with the info of the store and each comic
	*/
	
	public String toString() {
		
		
		String info = "**** Datos de la tienda ****\n" + 
		"nit: " + nit + "\n" +
		"cantidad de dinero en caja: " + TotalSales() + "\n" +
		"cantidad de productos vendidos: " + CopiesSold() + "\n" ;
		
		for(int counter=0; counter<MAX_COMICS; counter++){
			
			if(comics[counter]!=null){
				info+= "\n" + comics[counter].toString();
			}
		};
		
		return info;
	}
	
	/*
	* The method will calculate the total sales from the store
	* @return totalSales, double with the gains from the store
	*/
	
	public double TotalSales(){
		
		for(int counter=0; counter<MAX_COMICS; counter++){
			
			if(comics[counter]!=null){
				this.totalSales=(comics[counter].getPrice()+comics[counter].CalculateIva())*comics[counter].getNumCopiesSold();
			}
			
		}
		
		return totalSales;
		
	}
	
	
	/*
	* The method will calculate the total taxes from the store
	* @return totalTaxes, double with the taxes gains from the store
	*/
	
	public double TotalTaxes(){
		
		for(int counter=0; counter<MAX_COMICS; counter++){
			
			if(comics[counter]!=null){
				this.totalTaxes=comics[counter].CalculateIva()*comics[counter].getNumCopiesSold();
			}
			
		}
		
		return totalTaxes;
		
	}
	
	/*
	* The method will calculate the total copies that have been sold from the store
	* @return copiesSold, int with the number of copies sold from the store
	*/
	
	public int CopiesSold(){
		
		int copiesSold=0;
		
		for(int counter=0; counter<MAX_COMICS; counter++){
			
			if(comics[counter]!=null){
				copiesSold+=comics[counter].getNumCopiesSold();
			}
			
		}
		
		return copiesSold;
		
	}
}
