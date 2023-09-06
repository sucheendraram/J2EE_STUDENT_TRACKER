package studyonline.javafiles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action = "LIST";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			action = request.getParameter("action");
			if(action == null) {
				action = "LIST";
			}
			System.out.println("ACtion "+action);
			if(action.equals("LIST")) {
				listAllStudents(request, response);
			} else if(action.equals("ADD")) {
				addStudent(request,response);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) {
		try {
			//All the logic for adding the students to be added here
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String department = request.getParameter("department");
			String regNo = request.getParameter("regNo");
			String grade = request.getParameter("grade");
			String email = request.getParameter("email");
			int age = Integer.parseInt(request.getParameter("age"));
			
			Student s1 = new Student(firstName, lastName, age, email, department, grade, regNo);
			StudentDBUtil.addStudent(s1);
			listAllStudents(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listAllStudents(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Student> allStudents = StudentDBUtil.getAllStudents();
			System.out.println("ALL STUDENTS" + allStudents);
			request.setAttribute("STUDENTS_LIST", allStudents);
			request.getRequestDispatcher("/list-students.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
