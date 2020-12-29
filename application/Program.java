package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Order order = new Order ();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


		System.out.println("Enter client data: ");
		System.out.print("name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date: ");
		Date date = sdf.parse(sc.next());
		Client client = new Client(name, email, date);

		System.out.println("Enter Order Data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		System.out.print("How many items to this order: ");
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem items = new OrderItem(quantity, productPrice, product);
			order.addItem(items);
		}

		System.out.println(order);
		
		sc.close();
	}

}
