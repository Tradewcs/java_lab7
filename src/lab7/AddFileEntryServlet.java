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

public class AddFileEntryServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String name = req.getParameter("name");
		int size = Integer.parseInt(req.getParameter("size"));
		LocalDate created = LocalDate.parse(req.getParameter("created"));
		String parent_name = req.getParameter("parent");
		
		FileEntry fe = new FileEntry(name, size, 0);
		fe.setCreated(created);
		
		FilesystemDB fsdb = new FilesystemDB("jdbc:mysql://localhost:3306/filesystem", "root", "1111");
	
		try {
			
			fsdb.addFileEntry(fe, new DirectoryEntry(parent_name, 0));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, res);
	}
}