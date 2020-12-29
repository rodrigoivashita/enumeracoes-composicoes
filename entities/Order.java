package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment = new Date();
	private OrderStatus status;

	private Client client = new Client();
	private List<OrderItem> items = new ArrayList<>();

	public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		double sum = 0.0;
		for (OrderItem item : items)
			sum = +item.subTotal();
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY: " + "\n");
		sb.append("Order moment: ");
		sb.append(sdf1.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append( status + "\n");
		sb.append("Client: ");
		sb.append(getClient());
		sb.append("Order items: " + " \n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total Price: ");
		sb.append(String.format("%,2f", total()));
		return sb.toString();
	}

}
