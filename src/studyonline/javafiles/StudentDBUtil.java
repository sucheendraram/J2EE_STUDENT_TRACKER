package studyonline.javafiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilities.DatabaseConnect;

public class StudentDBUtil {
	public static List<Student> getAllStudents() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		List<Student> students = null;
		try {
			// Establish a connection
			conn = DatabaseConnect.createConnection();
			// Create a Statment
			stmt = conn.createStatement();
			// Execute the query
			String query = "select * from student_tracker";
			res = stmt.executeQuery(query);
			// Process the result set
			students = new ArrayList<Student>();
			while (res.next()) {
				int id = res.getInt("id");
				int age = res.getInt("age");
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");
				String department = res.getString("department");
				String grade = res.getString("grade");
				String regNo = res.getString("reg_no");
				Student s1 = new Student(id, firstName, lastName, age, email, department, grade, regNo);
				students.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (res != null) {
				res.close();
			}

		}
		return students;
	}

	public static void addStudent(Student student) throws Exception {
		// Create a conn
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DatabaseConnect.createConnection();
			String query = "insert into student_tracker (first_name, last_name,age,email,department,grade,reg_no) values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getEmail());
			pstmt.setString(5, student.getDepartment());
			pstmt.setString(6, student.getGrade());
			pstmt.setString(7, student.getReg_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public static Student getStudentDetailsUsingId(int studentId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Student student = null;
		try {
			conn = DatabaseConnect.createConnection();
			String query = "select * from student_tracker where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, studentId);
			res = pstmt.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				int age = res.getInt("age");
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");
				String department = res.getString("department");
				String grade = res.getString("grade");
				String regNo = res.getString("reg_no");
				student = new Student(id, firstName, lastName, age, email, department, grade, regNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (res != null) {
				res.close();
			}
		}
		return student;
	}

	public static void updateStudent(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DatabaseConnect.createConnection();
			String query = "update student_tracker set first_name=?,last_name=?, age=?, email=?, department=?,grade=?,reg_no=? where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getEmail());
			pstmt.setString(5, student.getDepartment());
			pstmt.setString(6, student.getGrade());
			pstmt.setString(7, student.getReg_no());
			pstmt.setInt(8, student.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public static void deleteStudent(int id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DatabaseConnect.createConnection();
			String query = "delete from student_tracker where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
}
