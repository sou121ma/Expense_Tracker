package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import model.Expense;
import service.ExpenseTrackerService;

public class ExpenseTracker {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ExpenseTrackerService expenseService = new ExpenseTrackerService();

		while (true) {
			System.out.println("**************************************************");
			System.out.println("Welcome to Expense Tracker");
			System.out.println("1.Add Expense");
			System.out.println("2.View All Expense");
			System.out.println("3.View by Category");
			System.out.println("4.View Total Expenses");
			System.out.println("5.View Total Expenses by Category");
			System.out.println("6.Exit");
			System.out.print("Choose an Option: ");

			int choice = sc.nextInt();
			sc.nextLine(); // Ignored a new line character

			switch (choice) {

				case 1:
					System.out.print("Enter Expense Category: ");
					String category = sc.nextLine();

					LocalDate date = null;
					while (date == null) {
						System.out.print("Enter Date in YYYY-MM-DD: ");
						String dateString = sc.nextLine();

						// checking the valid date format
						try {
							date = LocalDate.parse(dateString);
							System.out.println(date);

						} catch (DateTimeParseException e) {
							System.out.print("Wrong format! Please ");
						}
					}

					System.out.print("Enter amount: ");
					double amount;
					while (!sc.hasNextDouble()) {
						System.out.print("Wrong input! Please a valid amount: ");
						sc.nextLine(); // ignored new line character (consume new line)
					}
					amount = sc.nextDouble();

					sc.nextLine(); // ignored new line character (consume new line)

					System.out.print("Enter Description: ");
					String description = sc.nextLine();

					Expense expense = new Expense(amount, category, date, description);
					expenseService.addExpense(expense);

					break;

				case 2:
					List<Expense> list = expenseService.getAllExpenses();

					if (list.isEmpty()) {
						System.out.println("------ Sorry Expense List is empty --------");
						System.out.println();
					} else {
						System.out.println("----List ----");

						list.forEach(e -> System.out.println(e));
						System.out.println();
					}

					break;

				case 3:
					System.out.print("Enter the category: ");
					String searchCategory = sc.nextLine();
					List<Expense> byCategory = expenseService.getByCategory(searchCategory);
					if (byCategory.isEmpty()) {
						System.out.println("------ Sorry No Result Found --------");
						System.out.println();
					} else {
						System.out.println("----List ----");

						byCategory.forEach(e -> System.out.println(e));
						System.out.println();
					}

					break;

				case 4:
					System.out.println("Total Expenses: " + expenseService.getTotalExpense());
					break;

				case 5:
					expenseService.categoryWiseExpense();

					break;

				case 6:
					System.out.println("Exiting.......");
					sc.close();
					System.exit(0);
					break;

				case 7:
					System.out.print("Enter id: ");
					int id = sc.nextInt();
					expenseService.deleteExpenseById(id);
					break;

				default:
					System.out.println("Invalid input! please try again");

					break;
			}

		}

	}

}
