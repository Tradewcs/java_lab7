<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="DBManagement.FilesystemDB" %>
<%@ page import="entries.FileEntry" %>
<%@ page import="entries.DirectoryEntry" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
    border-collapse: collapse;
    margin-bottom: 20px;
    margin-right: 300px;
    display: inline;
}

tr {
	height: 10px;
}

th {
    background-color: #f2f2f2;
    padding: 8px;
    text-align: left;
}

td {
    padding: 8px;
    border: 1px solid #ddd;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f1f1f1;
}

a {
  background-color: #199319;
  color: white;
  padding: 10px 15px;
  border-radius:10px;
}

</style>
<style>form{max-width:400px;margin:0 auto;padding:20px;border:1px solid #ccc;border-radius:5px;background-color:#f9f9f9}span{display:block;margin-bottom:5px;font-weight:700}input{width:100%;padding:8px;margin-bottom:10px;box-sizing:border-box}input[type=date]{width:calc(100% - 18px)}input[type=submit]{background-color:#4caf50;color:#fff;padding:10px 15px;border:none;border-radius:4px;cursor:pointer}input[type=submit]:hover{background-color:#45a049}</style>
</head>
<body>

	<div class="tables">
	<%
        FilesystemDB fsdb = new FilesystemDB("jdbc:mysql://localhost:3306/filesystem", "root", "1111");
        List<FileEntry> files = fsdb.getAllFiles();
        List<DirectoryEntry> dirs = fsdb.getAllDirectories();
        
        out.println("<table>");
        out.println("<tr><th>Files</th></tr>");
        out.println("<tr> <th>ID</th> <th>Name</th> <th>Size</th> <th>Created</th> </tr>");
        
        for (int i = 0; i < files.size(); i++) {
            out.println("<tr> <td>" + files.get(i).getID() + "</td> <td>" + files.get(i).getName() + "</td> <td>" + files.get(i).getSize() +"</td> <td>" + files.get(i).getCreated() + "</td> </tr>");
        }

        out.println("</table>");
        
        out.println("<table>");
        out.println("<tr><th>Directories</th></tr>");
        out.println("<tr> <th>ID</th> <th>Name</th></tr>");
        
        for (int i = 0; i < dirs.size(); i++) {
            out.println("<tr> <td>" + dirs.get(i).getID() + "</td> <td>" + dirs.get(i).getName() + "</td> </tr>");
        }

        out.println("</table>");
    %>
    
     <table>
        <tr>
            <th>Delete File | Directory</th>
        </tr>
    	<tr>
            <td>
                <form action="deleteFileEntry">
                    <span>File ID</span>
                    <br>
                    <input type="number" name="FileID">
                    <input type="submit" value="Delete FileEntry">
                </form>
            </td>
        </tr>
        
        <tr>
            <td>
                <form action="deleteDirectoryEntry">
                    <span>Directory ID</span>
                    <br>
                    <input type="number" name="DirectoryID">
                    <input type="submit" value="Delete DirectoryEntry">
                </form>
            </td>
        </tr>
        

    </table>
    
    
    
    </div>
    
    <br>
    
    
    <a href="http://localhost:8080/lab7/index.html">Add FileEntry | DirectoryEntry</a>
    
</body>
</html>