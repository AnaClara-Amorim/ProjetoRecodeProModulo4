package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserDAO.UsuariosDAO;
import model.Usuarios;

@WebServlet("/cadastro")
public class UserControllerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuarios usuario = new Usuarios();
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		try {
			UsuariosDAO.create(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/AgenciaHorizonteAberto/");
	}

}
