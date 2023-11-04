package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Usuarios;
import UserDAO.UsuariosDAO;


@WebServlet("/atualizar")
public class UserControllerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuarios usuario = UsuariosDAO.findById(id);
		
		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("atualizar.jsp");
		rd.forward(request, response);			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuarios user = UsuariosDAO.findById(id);
		
		user.setNome(nome);
		user.setEndereco(endereco);
		user.setEmail(email);
		user.setSenha(senha);
		
		try {
			UsuariosDAO.update(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		response.sendRedirect("/AgenciaHorizonteAberto/");
	}
	

}
