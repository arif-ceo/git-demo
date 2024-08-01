package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class RetriveUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RetriveUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			out.println("<table border='1'>");
			out.println("<tr>");

			out.println("<th> ");
			out.println("<b>Id</b>");
			out.println("</th>");
			out.println("<th> ");
			out.println("<b>First Name</b>");
			out.println("</th>");
			out.println("<th> ");
			out.println("<b>Last Name</b>");
			out.println("</th>");
			out.println("<th> ");
			out.println("<b>Email</b>");
			out.println("</th>");
			out.println("<th> ");
			out.println("<b>Password</b>");
			out.println("</th>");
			out.println("</tr>");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan_db", "root", "test");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(3));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(4));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(5));
				out.println("</td>");
				out.println("</tr>");

			}
			
			out.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
