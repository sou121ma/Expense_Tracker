package model;

import java.time.LocalDate;

public class Expense {
	private int id;
	private double amount;
	private String category;
	private LocalDate date;
	private String description;

	private static int initialid = 0;

	public Expense(double amount, String category, LocalDate date, String description) {

		initialid +=1;
		
		this.id = initialid;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.description = description;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "id=" + id + ", amount=" + amount + ", category=" + category + ", date=" + date
				+ ", description=" + description + "";
	}
	
	
	

}
