package domain;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="NameOfOrder")
public class Order {
@Id


	private String ordernr;
	private String date;
	private String status;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String ordernr, String date, String status) {
		this.ordernr = ordernr;
		this.date = date;
		this.status = status;
	}

	public String getOrdernr() {
		return ordernr;
	}

	public void setOrdernr(String ordernr) {
		this.ordernr = ordernr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderLine> getOrderlines() {
		return Collections.unmodifiableCollection(orderlines);
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderlines.add(ol);
	}

}
