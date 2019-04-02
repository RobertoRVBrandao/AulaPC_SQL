/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlconnectiontest;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Aluno
 */
public class AlunoDAO {
    
    private Connection conn;
    public AlunoDAO(Connection c){
        this.conn = c;
    }
    
    public void insere(Aluno a) throws SQLException{
       
        String sql = "insert into insertupdate(Nome) values('"+a.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        
        ps.executeUpdate();
        ps.close();
        
    }
     public void update(String antigo,String novo) throws SQLException{
       
        String sql = "update insertupdate set nome='"+novo+"' where nome='"+antigo+"'";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        
        ps.executeUpdate();
        ps.close();
        
    }
    public List<Aluno> listar() throws SQLException{
		String sql = "select * from InsertUpdate";
        System.out.println(sql);		
        List alunos = new ArrayList();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
                            
                                
                                String nome=rs.getString("nome");
				alunos.add("\nID: "+id+"\nNOME: "+nome);
				System.out.println(alunos);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return null;
         
     
		
	}
}
