/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.PreparedStatement;
import connection.ConnectionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Tweet;

/**
 *
 * @author vsawg
 */
public class TweetDAO {
    //Inserir os tweets (via streaming)
    public void create(Tweet t){

    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO `tweet`(`id_tweet`, `name`, `id_usuario`, `ProfileLocation`, `Text`, `Lat`, `Lng`) VALUES (?,?,?,?,?,?,?)");
            //stmt.setInt(1, t.getId());
            stmt.setString(1, t.getid_tweet());
            stmt.setString(2, t.getUser());
            stmt.setDouble(3, t.getid_usuario());
            stmt.setString(4, t.getProfileLocal());
            stmt.setString(5, t.getText());
            stmt.setDouble(6, t.getLat());
            stmt.setDouble(7, t.getLng());                   
            
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt);
        }
    
    }

    //Listar os tweets para o primeiro tratamento de stopword
    public List<Tweet> read(){
    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Tweet> listaTweet = new ArrayList<>();
   
    try {
            //stmt = con.prepareStatement("INSERT INTO `stoptweet`(`id_tweet`, `name`, `id_usuario`, `ProfileLocation`, `Text`, `Lat`, `Lng`) VALUES (?,?,?,?,?,?,?)");
//            stmt = con.prepareStatement("SELECT * FROM `tweet` where id < '1000");
            stmt = con.prepareStatement("SELECT * FROM `tweet`");
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Tweet tweet = new Tweet();
                
                tweet.setId(rs.getInt("id"));
                tweet.setid_tweet(rs.getString("id_tweet"));
                tweet.setUser(rs.getString("name"));
                tweet.setid_usuario(rs.getLong("id_usuario"));
                tweet.setProfileLocal(rs.getString("ProfileLocation"));
                tweet.setText(rs.getString("Text"));
                tweet.setLat(rs.getDouble("Lat"));
                tweet.setLng(rs.getDouble("Lng"));
                listaTweet.add(tweet);                
            }         
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt, rs);
        }
    
   // System.out.println("\n " + listaTweet);
        return listaTweet;
    }
    
     //Listar os tweets para o primeiro tratamento de stopword
    public List<Tweet> testeread(){
    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Tweet> listaTweet = new ArrayList<>();
   
    try {
            stmt = con.prepareStatement("SELECT * FROM `teste`");
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Tweet tweet = new Tweet();
                
                tweet.setId(rs.getInt("id"));
                tweet.setid_tweet(rs.getString("id_tweet"));
                tweet.setUser(rs.getString("name"));
                tweet.setid_usuario(rs.getLong("id_usuario"));
                tweet.setProfileLocal(rs.getString("ProfileLocation"));
                tweet.setText(rs.getString("Text"));
                tweet.setLat(rs.getDouble("Lat"));
                tweet.setLng(rs.getDouble("Lng"));
                listaTweet.add(tweet);                
            }         
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt, rs);
        }
    
   // System.out.println("\n " + listaTweet);
        return listaTweet;
    }
    
    //Deleta os antigos stoptweet
      public void deletstopword() {
       Connection con = ConnectionBD.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("DELETE FROM `stoptweet`");
            
             stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt);
        }
    }
      
      //Deleta os antigos stoptweet
      public void testedeletstopword() {
       Connection con = ConnectionBD.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("DELETE FROM `treinatweet`");
            
             stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt);
        }
    }
    
    //Novo banco de dados sem stopword
    public void stopword(Tweet t){

    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;
    
    try {
            stmt = con.prepareStatement("INSERT INTO `stoptweet`(`id`,`id_tweet`, `name`, `id_usuario`, `ProfileLocation`, `Text`, `Lat`, `Lng`) VALUES (?,?,?,?,?,?,?,?)");

            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getid_tweet());
            stmt.setString(3, t.getUser());
            stmt.setDouble(4, t.getid_usuario());
            stmt.setString(5, t.getProfileLocal());
            stmt.setString(6, t.getText());
            stmt.setDouble(7, t.getLat());
            stmt.setDouble(8, t.getLng());                   
            
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt);
        }
    }
    
    //Novo banco de dados sem stopword
    public void testestopword(Tweet t){

    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;
    
    try {
            stmt = con.prepareStatement("INSERT INTO `treinatweet`(`id`,`id_tweet`, `name`, `id_usuario`, `ProfileLocation`, `Text`, `Lat`, `Lng`) VALUES (?,?,?,?,?,?,?,?)");

            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getid_tweet());
            stmt.setString(3, t.getUser());
            stmt.setDouble(4, t.getid_usuario());
            stmt.setString(5, t.getProfileLocal());
            stmt.setString(6, t.getText());
            stmt.setDouble(7, t.getLat());
            stmt.setDouble(8, t.getLng());                   
            
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt);
        }
    }
    
    //Para criar o Documento para TDIDF
    public List<Tweet> DOCread(){
    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Tweet> listaTweet = new ArrayList<>();
   
    try {
            //stmt = con.prepareStatement("INSERT INTO `stoptweet`(`id_tweet`, `name`, `id_usuario`, `ProfileLocation`, `Text`, `Lat`, `Lng`) VALUES (?,?,?,?,?,?,?)");
//            stmt = con.prepareStatement("SELECT * FROM `treinatweet`");
            stmt = con.prepareStatement("SELECT * FROM `stoptweet`");
            rs = stmt.executeQuery();
            
            while (rs.next()){
            
                Tweet tweet = new Tweet();
                
                tweet.setId(rs.getInt("id")); //ACRESCENTEI PARA TENTAR USAR NO TFIDF
                tweet.setid_tweet(rs.getString("id_tweet"));
                tweet.setUser(rs.getString("name"));
                tweet.setid_usuario(rs.getLong("id_usuario"));
                tweet.setProfileLocal(rs.getString("ProfileLocation"));
                tweet.setText(rs.getString("Text"));
                tweet.setLat(rs.getDouble("Lat"));
                tweet.setLng(rs.getDouble("Lng"));
                listaTweet.add(tweet);                
            }         
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt, rs);
        }
    
   // System.out.println("\n " + listaTweet);
        return listaTweet;
    }
    
     //Para ler os tweets coletados por último (lê de um a um)
    public List<Tweet> TweetinTime(){
    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    //Para retornar tweet à tweet ( NÂO ESTA AUTOMATICO ATE ENTÃO)
    String num = "5";
    List<Tweet> listaTweet = new ArrayList<>();
   
    try {
            //stmt = con.prepareStatement("INSERT INTO `stoptweet`(`id_tweet`, `name`, `id_usuario`, `ProfileLocation`, `Text`, `Lat`, `Lng`) VALUES (?,?,?,?,?,?,?)");

            stmt = con.prepareStatement("SELECT * FROM `treinatweet`");
//            stmt = con.prepareStatement("SELECT * FROM `stoptweet` where `id` < " + num + " ORDER BY `id` ASC");

            rs = stmt.executeQuery();
            while (rs.next()){
            
                Tweet tweet = new Tweet();
                
                tweet.setId(rs.getInt("id")); //ACRESCENTEI PARA TENTAR USAR NO TFIDF
                tweet.setid_tweet(rs.getString("id_tweet"));
                tweet.setUser(rs.getString("name"));
                tweet.setid_usuario(rs.getLong("id_usuario"));
                tweet.setProfileLocal(rs.getString("ProfileLocation"));
                tweet.setText(rs.getString("Text"));
                tweet.setLat(rs.getDouble("Lat"));
                tweet.setLng(rs.getDouble("Lng"));
                listaTweet.add(tweet);
            }                 

            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt, rs);
        }
   // System.out.println("\n " + listaTweet);
        return listaTweet;
    }
    //Após os tweets coletados, registra para votação 
    //Novo banco de dados sem stopword
    //RESULTADO FINAL DO CRIME
    public void BancoVotaTweetSVM(Integer idregistro){

    Connection con = ConnectionBD.getConnection();
    PreparedStatement stmt = null;   
    
    try {
            stmt = con.prepareStatement("INSERT INTO crion.votacaotweetsvm(`id`, `id_tweet`, `name`, `id_usuario`, `Text`, `Lat`, `Lng`)\n" +
                                "select `id`, `id_tweet`, `name`, `id_usuario`, `Text`, `Lat`, `Lng` from crion.tweet WHERE id = " + idregistro + " and NOT EXISTS ( SELECT `id` FROM crion.votacaotweetsvm WHERE `id` = " + idregistro + " )");             

            stmt.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt);
        }
    }
    
    
     //Banco criado para ler o resultado da votação antes de fazer o teste, ou seja, seleciona as classes para o teste
     // Tweet 1 é crime ? Se sim, ele será atribuido como crime na fase de teste.
    public Integer LEITURAVOTACAO(Integer idregistro, int flag){

    Connection con = ConnectionBD.ConnectionMEDAULA();
    PreparedStatement stmt = null;   
    Integer rs = null;
    try {
            if(flag==0){
            stmt = con.prepareStatement("SELECT COUNT(*) FROM `votacao` WHERE id_tweet = " + idregistro + " AND crime = '1'");
            rs = stmt.executeUpdate();            
            }
            else{
            stmt = con.prepareStatement("SELECT COUNT(*) FROM `votacao` WHERE id_tweet = " + idregistro + " AND naocrime = '1'");
            rs = stmt.executeUpdate();            
            }
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex);
        }finally {
           ConnectionBD.closeConnection(con, stmt);
        }
     return rs;
    }

  
    
    
}


