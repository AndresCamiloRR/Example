package ui;

import java.util.Scanner;
import model.ComicShop;


/**
 * Clase principal el proyecto comicsShop.
 * Desarrollada para el 
 * @author angievig
 * @version 1.0
 * @since April 2022
 */
public class MainShop {
	
	/**
	 * store es la conexiOn con la clase Shop en el paquete model
	 */
	private ComicShop store;
	/**
	 * sc es el objeto que permite leer informaciOn digitada por el usuario
	 */
	private Scanner sc;
	
	/**
	 * Constructor de la clase, no recibe prametros.  
	 * El mEtodo inicializa el objeto lector 
	 */
	public MainShop() {
		sc= new Scanner(System.in);
	}
	

	public static void main (String[] a){
		// creando un objeto de la clase principal
		MainShop obPpal = new MainShop();
		
		//Llamando el método que inicializa la tienda pidiendo datos al usuario
		obPpal.initShop();
		
		// variable para leer la entrada
		int option= 0;
		
		//ciclo para ejecutar el menu mientras que el usuario no
		// elija la opciOn para salir (0)
		do {
		    option =obPpal.showMenu();
		    obPpal.answerOption(option);
		}while (option !=0);


	}


	/**
	 * Metodo que se encarga de llamar a los mEtodos que resuelven cada uno de los 
	 * requerimientos de la aplicaciOn 
	 * @param userOption, int es el nUmero ingresado por el usuario (no ha sido validado) 
	 */
	public void answerOption(int userOption) {
		switch(userOption) {
		case 0: 
			System.out.println("cerrando la aplicaciOn, bye");
			break;
		case 1:
			BuyComic();
			break;
		case 2:
			store.Money();
			break;
		case 3: 
			ComicAvailable();
			break;
		case 4: 
			newComic();
			break;
		case 5: 
		System.out.println("La informaciOn de la tienda es la siguiente:");
		System.out.println(store.toString());
			break;
		
		case 6:
			System.out.print(store.SapasYAsociados());
		}
		
		
	}
	
	/**
	* The method will read the inputs inserted by the user, save them in variables, call Register Comic 
	* method from store and insert the variables as parameters
	*/
	public void newComic(){
		
		
		if(store.EmptyPosition()!=-1){
			
			String name;
			int numCopiesForSale;
			double price;
			
			do{
				System.out.println("Ingrese el nombre del comic");
				name=sc.next();
			}while(store.nameExists(name));
			sc.nextLine();
		
			System.out.println("Ingrese el numero de copias a la venta");
			
			numCopiesForSale=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Ingrese el precio del comic");
			price=sc.nextDouble();
			sc.nextLine();
			
			store.RegisterComic(name, numCopiesForSale, price);
			
			System.out.println("El comic ha sido registrado, si desea ver sus datos, puede elegir la opcion 3 o 5 ;D");
			
		}else{
			
			System.out.println("Sorry but there's no space for more comics :c");
		}
	}


	/**
	 * Metodo que permite crear instancias de los objetos con informaciOn ingresada
	 * por el usuario
	 */
	public void initShop() {
		System.out.println("Bienvenido a la tienda de Comics de Stuart, digite el nit");
		String nit= sc.nextLine();
		store = new ComicShop(nit);
		
		
		
	}
	/**
	 * Metodo que muestra el menu de la aplicaciOn, a este metod hace falta implementar la validaciOn
	 * del valor ingresado por el usuario
	 * @return input, int es la opciOn elegida por el usuario
	 */
	public int showMenu() {
		int input;
		System.out.println("\n\nMenu de la Tienda, digite una opciOn\n"+ 
		                    "(1) Vender un comic\n" +
		                    "(2) Mostrar la cantidad de dinero en caja\n" +
		                    "(3) Consultar la disponibilidad de un comic\n"+
		                    "(4) Registrar un comic para la venta\n"+
		                    "(5) Mostrar los datos de la tienda\n"+
		                    "(0) Para salir"
	
		);
		input = sc.nextInt();
		sc.nextLine();
		return input;
	}
	
	/**
	*Method that will read the inputs made by the user and use them as parameteres for the method BuyComic from
	*an objetc of ComicShop type and print the price the client will have to pay
	*/
	
	public void BuyComic(){
		
		String name;
		
		int quantity;
		
		System.out.println("Ingrese el nombre del comic");
		
		name=sc.nextLine();
		
		if(store.nameExists(name)){
		
			if(store.numOfCopies(name)>0){
				
				do{
					System.out.println("hay disponibles " + store.numOfCopies(name) + " copias, cuantas desea comprar?");
					
					quantity=sc.nextInt();
					
				}while(quantity<0&&quantity>store.numOfCopies(name));
				
				System.out.print("El costo total a pagar es de: " + store.BuyComic(name,quantity));
				
			}else{
				
				System.out.println("Lo sentimos, pero no quedan mas copias del comic");
				
			}
		}else{
			
			System.out.println("Lo sentimos, pero el comic que buscas no forma parte de los registros de la tienda");
			
		}
	}
	
	/**
	*Method that will read the inputs made by the user and use them as parameteres for the method nameExists and call ComicInfo method
	*from an objetc of ComicShop type to check if the comic that user is looking for exist in the store and print his info
	*/
	
	public void ComicAvailable(){
		
		String name;
		
		int index=-1;
		
			
			System.out.println("Ingrese el nombre del comic");
			
			name=sc.nextLine();
			
		if(store.nameExists(name)){	
		
			index = store.NameSearch(name);
			
			System.out.println(store.ComicInfo(index));
			
		}else{
			
			System.out.println("Lo sentimos, pero el comic que buscas no forma parte de los registros de la tienda");
			
		}
	}
	
	/**
	*Method that will print the profits made by the store from solds and taxes
	*/
	

	
}
