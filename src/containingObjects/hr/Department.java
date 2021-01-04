package containingObjects.hr;

public class Department {
	private String name;
	private Employee[] allEmployees;
	private int numOfEmployees;

	public Department(String name, int maxEmployees) {
		this.name = name;
		allEmployees = new Employee[maxEmployees];
		numOfEmployees = 0;
	}
	
	public String getName() {
		return name;
	}

	public boolean addEmployee(Employee theEmployee) {
		if (numOfEmployees < allEmployees.length) {
			allEmployees[numOfEmployees++] = theEmployee;
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder("Department '" + name + "' has "
				+ numOfEmployees + " employee"
				+ (numOfEmployees > 1 ? "s" : "") + ":\n");
		for (int i = 0; i < numOfEmployees; i++) {
			str.append(i + 1).append("- ").append(allEmployees[i]).append("\n");
		}
		return str.toString();
	}
}


