/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tdidf;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.DAO.TweetDAO;
import model.bean.Tweet;

/**
 *
 * @author vsawg
 */
public class ContaVoto {
    Tweet t = new Tweet();
    TweetDAO dao = new TweetDAO();
    
     public void contarVotos() throws IOException {
        FileWriter arquivo = new FileWriter("ResultadoVoto.txt",true);
        PrintWriter gravarArquivo = new PrintWriter(arquivo);
        BufferedWriter conexao = new BufferedWriter(gravarArquivo);
        
        Integer idTweet;
        Integer resultadoParaLeitura;

        //FAZ A LEITURA DE CADA VOTO DO TREINAMENTO, ou seja, se é crime ou não
        for(Tweet twt: dao.DOCread()){   
            idTweet = twt.getId();
            int flagCrimeouNao = 0;

             //LISTA TABELAS -stoptweet- PARA DOC GERAL
             //Verifica se é crime, para isso resultado tem que ter 5 votos
             resultadoParaLeitura = dao.LEITURAVOTACAO(idTweet, flagCrimeouNao);
             if(resultadoParaLeitura==5)
             {conexao.write("1\n");}
             if(resultadoParaLeitura!=5){
                flagCrimeouNao = 1;
                 //Verifica se é NÃO crime, para isso resultado tem que ter 5 votos
                resultadoParaLeitura = dao.LEITURAVOTACAO(idTweet, flagCrimeouNao);
                if(resultadoParaLeitura==5)
                {conexao.write("0\n");}
             }             
        }
        
         conexao.flush(); //libera a gravaçao
         conexao.close(); //fecha o arquivo
     }
}
