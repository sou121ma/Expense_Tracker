package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import model.Expense;

public class ExpenseTrackerService {
	private static List<Expense> expenses;

	public ExpenseTrackerService() {
		expenses = new ArrayList<>();

		expenses.add(new Expense(125, "bill", LocalDate.parse("2020-12-12"), "Hello"));
		expenses.add(new Expense(120, "fee", LocalDate.parse("2020-11-12"), "Hello"));
		expenses.add(new Expense(205, "bill", LocalDate.parse("2020-02-12"), "Hello"));
		expenses.add(new Expense(145, "fee", LocalDate.parse("2020-09-14"), "Hello"));
	}

	public void addExpense(Expense expense) {
		expenses.add(expense);
		System.out.println("Your expenses added successfully");
	}

	public List<Expense> getAllExpenses() {
		return expenses;
	}

	public List<Expense> getByCategory(String category) {
		return expenses.stream()
				.filter(exp -> exp.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	public double getTotalExpense() {
		return expenses.stream().collect(Collectors.summingDouble(Expense::getAmount));

	}

	public void categoryWiseExpense() {
		Map<String, Double> collect = expenses.stream()
				.collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)));

		collect.forEach((category, total) -> {
			System.out.println("Category: " + category + ", Total Amount: " + total);
		});

	}

	public void deleteExpenseById(int id) {
	
		for (Expense e : expenses) {
			if (e.getId()==id) {				
				expenses.remove(e);
				System.out.println("Expense Successfully Removed");
				break;
			}
		}
		System.out.println("No such id found");

	}

}
