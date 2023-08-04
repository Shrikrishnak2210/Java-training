package com.streams.app;

public class Employee implements Comparable<Employee> {
	private String name;
	private String city;
	private int employeeId;

	public Employee() {
		super();
	}

	public Employee(String name, String city, int employeeId) {
		super();
		this.name = name;
		this.city = city;
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", employeeId=" + employeeId + "]";
	}

	public Object length() {
		return null;
	}

	@Override
	public int compareTo(Employee o) {
		return 0;
	}
}
