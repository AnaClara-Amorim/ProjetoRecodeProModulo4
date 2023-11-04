package UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.Connectionn;
import model.Usuarios;

public class UsuariosDAO extends Usuarios{

	public UsuariosDAO(int idUsuario, String nome, String endereco, String email, String senha) {
		super(idUsuario, nome, endereco, email, senha);
		
	}
	
	public static void create (Usuarios usuario) {
		String sql = "INSERT INTO usuarios (nome, endereco, email, senha) "+" VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectionn.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEndereco());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			
			pstm.execute();			
			
			
		} 		catch (Exception e) {
			e.printStackTrace();			
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn!= null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void remove (int id) {

		String sql = "DELETE FROM usuarios WHERE idUsuario = ?";	
		Connection conn = null;		
		PreparedStatement pstm = null;

			try {
				conn = Connectionn.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);		
				pstm.setInt(1, id);		
				pstm.execute();				
				
			} catch (Exception e) {
				e.printStackTrace();

			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	
	public static void update (Usuarios usuario) {
		String sql = "UPDATE usuarios SET nome = ?, endereco = ?, email = ?, senha = ? WHERE idUsuario = ? ";
		Connection conn = null;

		PreparedStatement pstm = null;

			try {
				conn = Connectionn.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				

				 pstm.setString(1, usuario.getNome());
				 pstm.setString(2, usuario.getEndereco());
				 pstm.setString(3, usuario.getEmail());
				 pstm.setString(4, usuario.getSenha());
				 pstm.setInt(5, usuario.getIdUsuario());
				 pstm.execute();
			

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	
	public static List<Usuarios> getUsers(){		

		String sql = "SELECT * FROM usuarios";		

		List<Usuarios> usuarios = new ArrayList<Usuarios>();		

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; 

			try {
				conn = Connectionn.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				rset = pstm.executeQuery();				

				while (rset.next()) {
					Usuarios usuario = new Usuarios();			
					usuario.setIdUsuario(rset.getInt("idUsuario"));
					usuario.setNome(rset.getString("nome"));
					usuario.setEndereco(rset.getString("endereco"));
					usuario.setEmail(rset.getString("email"));	
					usuarios.add(usuario);				
				}					

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}			
					if(rset != null) {
						rset.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return usuarios;
	}
	
	public static Usuarios findById(int userId) {
	    
		String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;
	    Usuarios usuario = null;
 
	    try {
	    	conn = Connectionn.createConnectionToMySQL();
	        pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, userId);
	        rset = pstm.executeQuery();
 
	        if (rset.next()) {
	            usuario = new Usuarios();
	            usuario.setIdUsuario(rset.getInt("idUsuario"));
	            usuario.setNome(rset.getString("nome"));
	            usuario.setEndereco(rset.getString("endereco"));
	            usuario.setEmail(rset.getString("email"));
	            usuario.setSenha(rset.getString("senha"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstm != null) {
	                pstm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	            if (rset != null) {
	                rset.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return usuario;
	}

}
