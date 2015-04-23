/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.JOptionPane;
import model.UsuarioDAO;
import model.UsuarioDAOHibernate;

/**
 *
 * @author a132067x
 */
public class TelaNewUserController {
    UsuarioDAO usuarioDAO;
    Usuario  usuario;
    UsuarioDAOHibernate usuarioDAOHibernate;
    
    public TelaNewUserController() {
        usuarioDAO = new UsuarioDAO();
        usuario=new Usuario();
        usuarioDAOHibernate = new UsuarioDAOHibernate();
        
    }
    
    public boolean cadastrarNovoUsuario(String login, String senha){ 
        usuario.setLogin(login);
        usuario.setSenha(senha);
       
        
        try{
           usuarioDAOHibernate.InserirUsuario(usuario);
           JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso!","Usuario cadastrado",1);
           return true;
        }catch(Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Usuario ja cadastrado, Tente outro","Erro",0); 
                    return false;
        }
        
            
    }
}
