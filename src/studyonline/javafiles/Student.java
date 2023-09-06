package studyonline.javafiles;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String department;
	private String grade;
	private String reg_no;
	
	public Student(int id, String firstName, String lastName, int age, String email, String department, String grade,
			String reg_no) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.department = department;
		this.grade = grade;
		this.reg_no = reg_no;
	}
	
	

	public Student(String firstName, String lastName, int age, String email, String department, String grade,
			String reg_no) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.department = department;
		this.grade = grade;
		this.reg_no = reg_no;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", department=" + department + ", grade=" + grade + ", reg_no=" + reg_no + "]";
	}
}
