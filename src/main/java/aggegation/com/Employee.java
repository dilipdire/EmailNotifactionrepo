package aggegation.com;

public class Employee {

	int empId;
	String name;
	String department;
	Address address;
	public Employee(int empId, String name, String department, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.department = department;
		this.address = address;
	}
	
	public void display()
	{
		System.out.println(empId +" "+ name+" "+ department);
		System.out.println(address.state+ " "+address.dist+ " "+address.city);
	}
	public static void main(String[] args) {
		
		Address addrs =new Address("Karanatak","Bangalore","Blr");
		Address addrs1 =new Address("Utter Pradesh","Varanasi","VNS");
		
		Employee emp = new Employee(101,"Dilip","QA Automtaion",addrs);
		Employee emp1 = new Employee(102,"Amrita","QA Automtaion",addrs1);
		emp.display();
		emp1.display();
		
	}
}
