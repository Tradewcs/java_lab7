package lab7;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBManagement.FilesystemDB;

public class DeleteFileEntryServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		FilesystemDB fsdb = new FilesystemDB("jdbc:mysql://localhost:3306/filesystem", "root", "1111");
		int id = Integer.parseInt(req.getParameter("FileID"));
		
		try {
			fsdb.deleteFileEntry(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, res);
	}
}
