package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String deptName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		String phone = sc.next();
		Address address = new Address(email, phone);
		Department dept = new Department(deptName, payDay, address);
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do funcionário: " + i);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(name, salary);
			
			dept.addEmployee(employee);
			System.out.println();
			
			showReport(dept);
		}
		
		
		
		
		sc.close();
	}
	
	private static void showReport(Department dept) {
		StringBuilder sb = new StringBuilder();
		sb.append("FOLHA DE PAGAMENTO:\n");
		sb.append("Departamento Vendas = R$ " + String.format("%.2f\n", dept.payroll()));
		sb.append("Pagamento realizado no dia " + dept.getPayDay() + "\n");
		sb.append("Funcionários:\n");
		for (Employee e : dept.getEmployee()) {
			sb.append(e + "\n");
			
		}
		sb.append("Para dúvidas favor entar em contato: " + dept.getAddress().getEmail());
		System.out.println(sb);
		
	}

}
