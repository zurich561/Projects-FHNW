package woche7_Art_Webshop;

import java.util.ArrayList;
import java.util.Scanner;

import woche7_Art_Webshop.Painting.Paint;
import woche7_Art_Webshop.Sculpture.Material;
import woche7_Art_Webshop.Transaction.PaymentMethod;

public class ArtWorkshopMain {
    public static ArrayList<Artwork> productList = new ArrayList<>();
    public static ArrayList<Transaction> transactionList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static Customer customer1;
    public static void main(String[] args) {
        
        //Kundeninformationen abfragen
        System.out.println(abschnitt() + "LOGIN:" + '\n' + '\n' +  "Vor- und Nachname eingeben:");
        String name = scanner.nextLine();

        System.out.println("E-Mail Adresse:");
        String eMail = scanner.nextLine();

        System.out.println("Telefonnummer:");
        String phone = scanner.nextLine();

        //Kunden erstellen
       customer1 = new Customer(name, eMail, phone);
        System.out.println('\n' + "Deine Daten wurden erfolgreich erfasst!");


        //Schleife für Benutzereingaben
        while (true) {
            System.out.println(abschnitt() + "HAUPTMENÜ" + '\n' + '\n' + "Aktion auswählen:");
            System.out.println("1. Neues Produkt erfassen");
            System.out.println("2. Produkt kaufen");
            System.out.println("3. Meine Bestellungen auflisten");
            System.out.println("4. Shop beenden");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    newProduct();
                    break;
                case "2":
                    buyProduct();
                    break;
                case "3":
                    getMyOrders();
                    break;
                case "4":
                    System.out.println("Shop beendet.");
                    return; // Die Schleife verlassen und das Programm beenden
                default:
                    System.out.println("Ungültige Eingabe. Bitte wählen Sie eine gültige Aktion.");
                    break;
            }
        }
    }
    
    //Methode um neues Produkt zu erstellen
    public static void newProduct() {
        do {
            System.out.print(abschnitt() + "PRODUKT ERFASSEN" + '\n' + '\n' +  "Welche Art von Kunstwerk möchten Sie erfassen?" + '\n' + "1. Skulptur" + '\n' + "2. Gemälde");
            String in = scanner.nextLine();

            System.out.println('\n' + "Verkaufspreis in CHF eingeben: ");
            Number price = scanner.nextDouble();
            scanner.nextLine();

            switch (in) {
                case "1":
                    System.out.println('\n' +  "Welches Material hat die Skulptur?" + '\n' + "1. Bronze" + '\n' + "2. Holz"
                            + '\n' + "3. Ton");
                    String input = scanner.nextLine();

                    if (input.equals("1")) {
                        Sculpture sculpture1 = new Sculpture(price, Material.BRONZE);
                        productList.add(sculpture1);
                    } else if (input.equals("2")) {
                        Sculpture sculpture1 = new Sculpture(price, Material.WOOD);
                        productList.add(sculpture1);
                    } else {
                        Sculpture sculpture1 = new Sculpture(price, Material.CLAY);
                        productList.add(sculpture1);
                    }

                    System.out.println('\n' + "Produkt erfolgreich erfasst.");

                    break;

                case "2":
                    System.out.println('\n' +  "Um welche Farbe handelt es sich?" + '\n' + "1. Wasserfarbe" + '\n' + "2. Ölfarbe");
                    input = scanner.nextLine();

                    System.out.println('\n' +  "Handelt es sich um ein Original?" + '\n' + "1. Ja" + '\n' + "2. Nein");
                    String inOriginal = scanner.nextLine();
                    Boolean isOriginal = inOriginal.equals("1");

                    if (input.equals("1")) {
                        Painting painting1 = new Painting(price, Paint.WATERCOLOR, isOriginal);
                        productList.add(painting1);
                    } else {
                        Painting painting1 = new Painting(price, Paint.OIL, isOriginal);
                        productList.add(painting1);
                    }

                    System.out.println('\n' +  "Produkt erfolgreich erfasst.");

                    break;

                default:
                    System.out.println("Ungültige Eingabe!");
                    break;
            }

            System.out.println('\n' +  "Möchten Sie ein weiteres Produkt erfassen?" +'\n' + "1. Ja" + '\n' + "2. Nein" );
        } while (scanner.nextLine().equalsIgnoreCase("1"));
        
    }
    
    //Methode um ein bestehendes Produkt zu kaufen
    public static void buyProduct() {
    	
    	if (productList.isEmpty()) System.out.println(abschnitt() + "PRODUKT KAUFEN" + '\n' + '\n' + "Keine Produkte vorhanden, bitte erst ein Produkt hinzufügen");
    	else {
    		System.out.println(abschnitt() + "PRODUKT KAUFEN" + '\n' + '\n' + "Folgende Produkte sind an Lager: " + '\n' );
    		
    		for (int i = 0; i < productList.size(); i++) {
                System.out.println("Index: " + i  + productList.get(i).toString());
            }
	    	
	    	System.out.println('\n' + "Welches Produkt möchten Sie kaufen?" + '\n' + "(Index angeben)" + '\n');
	    	Integer index = scanner.nextInt();
	    	Artwork b = productList.get(index);
	    	scanner.nextLine();
	    	
	    	System.out.println("Zahlungsmethode auswählen: " + '\n' + Transaction.getAllPaymentMethods() + '\n');
	    	String paymentInput = scanner.nextLine();
	    	
	    	PaymentMethod pay = null;
	    	
	    	if (paymentInput.equals("1")) pay = PaymentMethod.CASH; 
	    	else if (paymentInput.equals("2")) pay = PaymentMethod.PAYPAL;
	    	else if (paymentInput.equals("3")) pay = PaymentMethod.VISA;
	    	else if (paymentInput.equals("4")) pay = PaymentMethod.MASTERCARD;
	    	else if (paymentInput.equals("5")) pay = PaymentMethod.BANKTRANSFER;
	    	
	    	System.out.println('\n' + "Warenkorb:" + '\n' + b.toString() + '\n' + '\n' + "Kauf bestätigen: " + '\n' + "1. Bestätigen" + '\n' + "2. Abbrechen") ;
	    	String in = scanner.nextLine();
	    	
	    	if (in.equals("1")) {
	    		productList.remove(b);
	    		Transaction transaction1 = new Transaction(pay, b, customer1.getCustomerID());
	    		transactionList.add(transaction1);
	    		
	    		System.out.println('\n' + "Erfolg, hier Ihre Bestellübersicht: " + '\n' + transaction1.toString());
	    	}
	    	
	    	else System.out.println('\n' + "Bestellung abgebrochen");
	    	
    	}
    }
    
    public static void getMyOrders () {
    	System.out.println(abschnitt() + "MEINE BESTELLUNGEN: " + '\n' + '\n');
    	for ( int i = 0; i > transactionList.size(); i++) {
    		transactionList.get(i).toString();
    	}
    	
    }
    
    public static String abschnitt () {
    	return '\n' + "________________________________________________________________________________________________________________" + '\n'; 
    }
    
}
