package com.example;

public class Employee {

	private String id;
	private double salary;
	private boolean paid;
	private boolean added;

	public Employee(String id, double salary) {
		this.id = id;
		this.salary = salary;
	}

	public void setAdded(boolean added) { this.added = added; }

	public boolean wasAdded() { return added; }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + "]";
	}

}
