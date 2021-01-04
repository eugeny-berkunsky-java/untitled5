package containingObjects.hr;

public class HR {
	private Employee[] allEmployees;
	private int numOfEmployees;
	private Department[] allDepartments;
	private int numOfDepartments;

	public HR(int maxEmployees, int maxDepartments) {
		allEmployees = new Employee[maxEmployees];
		numOfEmployees = 0;

		allDepartments = new Department[maxDepartments];
		numOfDepartments = 0;
	}
	
	public Department getDepartmentByName(String name) {
		for (int i = 0; i < numOfDepartments; i++) {
			if (allDepartments[i].getName().equals(name))
				return allDepartments[i];
		}
		return null;
	}
	public Employee getEmployeeByName(String name) {
		for (int i = 0; i < numOfEmployees; i++) {
			if (allEmployees[i].getName().equals(name))
				return allEmployees[i];
		}
		return null;
	}

	public boolean addEmployee(Employee theEmployee, String departmentName) {
		if (numOfEmployees == allEmployees.length) 
			return false;

		Department theDepartment = getDepartmentByName(departmentName);
		if (theDepartment == null) { // не нашли
			return false;
		} else {
//			allEmployees[numOfEmployees] = new Employee(theEmployee);
//			theDepartment.addEmployee(allEmployees[numOfEmployees]);
			if (theDepartment.addEmployee(theEmployee)) {
				allEmployees[numOfEmployees] = theEmployee;
				numOfEmployees++;
				return true;
			}
			return false;
		}
	}

	public boolean addDepartment(String name, int maxEmployees) {
		if (numOfDepartments == allDepartments.length)
			return false;

		allDepartments[numOfDepartments++] = new Department(name, maxEmployees);
		return true;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("The company has ").append(numOfDepartments).append(" departments:\n");
		for (int i = 0; i < numOfDepartments; i++) {
			str.append(allDepartments[i].toString()).append("\n");
		}

		return str.toString();
	}
}
