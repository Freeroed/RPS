/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Author;
import domain.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AuthorService;
import service.BookService;

/**
 *
 * @author Freeroed
 */
public class EditBook extends HttpServlet {
    
    @EJB
    AuthorService authorService;
    
    @EJB
    BookService bookService;
    Book book;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditBook at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        book = bookService.find(id);
        request.setAttribute("book", book);
        List<Author> authors = authorService.findAll();
        request.setAttribute("authors", authors);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/EditBook.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        book.setName(request.getParameter("name"));       
        book.setGenre(request.getParameter("genre"));  
        Author author = authorService.find(Integer.parseInt(request.getParameter("author")));
        book.setAuthorId(author);
        bookService.edit(book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
