package lab7;

import entries.*;

import DBManagement.FilesystemDB;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDirectoryEntryServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String name = req.getParameter("name");
		
		DirectoryEntry de = new DirectoryEntry(name, 0);
		
		FilesystemDB fsdb = new FilesystemDB("jdbc:mysql://localhost:3306/filesystem", "root", "1111");
	
		try {
			fsdb.addDirectoryEntry(de);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, res);
        
        
	}
}