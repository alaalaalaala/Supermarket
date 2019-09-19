/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Supermarket {
    
    private List listProduct;
    public static final String APPLE ="apple";
    public static final String WATERMELON ="watermelon";
    public static final String ORANGE ="orange";


    public Supermarket() {
        createListeProduct();
    }
    public List<Product> createListeProduct(){
        listProduct= new ArrayList();
        Product apple= new Product(APPLE,0.20);
        Product orange= new Product(ORANGE,0.50);
        Product watermelon= new Product(WATERMELON,0.80);
        listProduct.add(apple);
        listProduct.add(orange);
        listProduct.add(watermelon);
        return listProduct;
    }
    /**
     * verify if a quantity valid 
     * @param quantite
     * @return boolean
     */
    public boolean isValidNumber(String quantite){
        try{
            Integer.parseInt (quantite);
            return true;
        } catch(NumberFormatException e) {
            System.out.println(e.getMessage()+"Merci d'entrer un nombre valide !!");
            return false;
        }
    }
    /**
     * get price of apple after discount
     * @param appleQuantity
     * @param applePrice
     * @return double 
     */
    public double getApplePrice(String appleQuantity,double applePrice){
        	Scanner sc = new Scanner(System.in);
                do{
                   System.out.println("Quantité des Pommes");
                   appleQuantity=sc.next();
                }
                while(! isValidNumber(appleQuantity));
		return  applePrice * (Integer.parseInt(appleQuantity) - (Integer.parseInt(appleQuantity) / 2));
    }
    /**
     * get orange price
     * @param orangeQuantity
     * @param price
     * @return double
     */
     public double getOrangePrice(String orangeQuantity,double price){
        	Scanner sc = new Scanner(System.in);
                do{
                   System.out.println("Quantité des Oranges");
                   orangeQuantity=sc.next();
                }
                while(! isValidNumber(orangeQuantity));
		return  price * (Integer.parseInt(orangeQuantity) );
    }
     /**
      * get price watermelon after discount
      * @param watermelonQuantity
      * @param price
      * @return 
      */
     public double getWatermelonPrice(String watermelonQuantity,double price){
        	Scanner sc = new Scanner(System.in);
                do{
                   System.out.println("Quantité des Watermelon");
                   watermelonQuantity=sc.next();
                }
                while(! isValidNumber(watermelonQuantity));
		return  price * (Integer.parseInt(watermelonQuantity) - (Integer.parseInt(watermelonQuantity) / 3));
    }
    
    
    /**
     * calculate price command
     * @param quantite
     * @return double
     */
    public Double calculateCommandPrice(){
        double price=0.0;
        double priceCommand=0.0;
	Scanner sc = new Scanner(System.in);
        for(Product product :createListeProduct()){
				if (APPLE.equals(product.getType())) {
					price =getApplePrice(new String(), product.getPrice());
				} else if (WATERMELON.equals(product.getType())) {
                                         price = getWatermelonPrice(new String(), product.getPrice());
				} else {
                                        price =getOrangePrice(new String(), product.getPrice());
				}
                System.out.println("Prix des\t"+product.type+":"+price);
                priceCommand = priceCommand+ price;
        }
        System.out.println("Prix de la commande\t" + priceCommand);
        return priceCommand;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Supermarket supermarket= new Supermarket();
     supermarket.calculateCommandPrice();
    }
    
}
