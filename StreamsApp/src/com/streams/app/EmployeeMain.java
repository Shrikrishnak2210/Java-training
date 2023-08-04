package com.streams.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Cillian Murphy", "London", 101),
				new Employee("John Wick", "Manhattan", 439), 
				new Employee("Robert Downey", "California", 3000),
				new Employee("Oscaar Isaac", "London", 104));

		employees.forEach(System.out::println);
		System.out.println();

		System.out.println("Get employee bassed on city");
		List<Employee> employeeByCity = employees.stream()
				.filter(str -> str.getCity().equals("Manhattan"))
				.collect(Collectors.toList());
		employeeByCity.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Sorted employees according to name");
		employees.stream()
				.sorted((employee1, employee2) -> employee1.getName().compareTo(employee2.getName()))
				.forEach(employee -> System.out.println(employee));

		// employee name by employee id
		System.out.println();
		System.out.println("Employee by ID");
		String employeeById = employees.stream()
				.filter(emp -> emp.getEmployeeId() == (3000))
				.map(Employee::getName)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Employee doesn't exist with this ID"));
		System.out.println(employeeById);
		
		System.out.println();
		System.out.println("Employee name starts with");
		String employeeStartsWith = employees.stream()
				.filter(name -> name.getName().startsWith("K"))
				.map(Employee::getName)
				.findFirst()
				.orElse("not in first place");
		System.out.println(employeeStartsWith);
	}

}
