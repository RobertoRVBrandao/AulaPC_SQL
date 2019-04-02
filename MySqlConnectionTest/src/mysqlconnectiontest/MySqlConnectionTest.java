/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlconnectiontest;

import java.util.List;

/**
 *
 * @author Aluno
 */
public class MySqlConnectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        
        System.out.println(JdbcUtil.getConnection());
        AlunoDAO alunodao = new AlunoDAO(JdbcUtil.getConnection());
        alunodao.insere(new Aluno("Pionte"));
        List<Aluno> listar = alunodao.listar();
        for(Aluno a : listar){
            System.out.println(a.getNome());
        }
        
        
        
    }

 
    
}
