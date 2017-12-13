/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tdidf;

import java.util.Arrays;
import java.util.List;
import model.DAO.TweetDAO;
import model.bean.Tweet;
import java.sql.PreparedStatement;
import connection.ConnectionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author vsawg
 */
public class TweetFrequencia {
    Tweet t = new Tweet();
    TweetDAO dao = new TweetDAO();
    List<String> palavras;
    
    public void readTweet(){
    
        //Deleta antigos dados de stopword
        dao.deletstopword();
        dao.testedeletstopword();
        String tratavel;
        
        //Listar Tweet lido na tabela tweet
        for(Tweet twt: dao.read()){
    
                //twt.getId();
                tratavel = twt.getText(); 
                //removerstopword(tratavel);
                twt.getId();
                twt.getid_tweet();
                twt.getUser();
                twt.getid_usuario();
                twt.getProfileLocal();
                twt.setText(removerstopword(tratavel));
                twt.getLat();
                twt.getLng();
                
                dao.stopword(twt);
        }
        
        //Listar Tweet lido na tabela teste
        for(Tweet twt: dao.testeread()){
    
                //twt.getId();
                tratavel = twt.getText(); 
                //removerstopword(tratavel);
                twt.getId();
                twt.getid_tweet();
                twt.getUser();
                twt.getid_usuario();
                twt.getProfileLocal();
                twt.setText(removerstopword(tratavel));
                twt.getLat();
                twt.getLng();
                
                dao.testestopword(twt);
        }
        
        
    }
    
    private String removerstopword (String tratar){
    
         //array com as pontuações, caracteres e numeros a serem eliminadas
            String[] pontuacoes = { "\n", ".", ",", ":", ";", "-", "'", "<", ">", "!", "?", "(", ")", "[", "]", "{", "}", "/", "*", "#", "$", "%", "¨", "&", "_", "|", "=", "+", "°", "ª", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };            
            // cria um array com todos as palavras do texto
            String[] textoSplit = tratar.trim().split(" ");
            //array com as acentuações a serem eliminadas
            String[] comPalavras = { "RT", "ä", "á", "â", "à", "ã", "ê", "ë", "è", "í", "î", "ï", "ì", "ö", "ó", "ô", "ò", "õ", "ü", "ú", "û", "ù", "ç", "~", "-","—", "·" };
            //array com os elementos sem os acentos
            String[] semPalavras = { "", "a", "a", "a", "a", "a", "e", "e", "e", "i", "i", "i", "i", "o", "o", "o", "o", "o", "u", "u", "u", "u", "c", "", "","", "" };
            
            String[] stopANDgirias = {"qe","q","vc","soh","sdds","brinks","ctz","ctza","sdd","lol","xoxo","pq","omg","wtf","btf","LMFAO","tbt","fb","de", "a", "o", "que", "e", "do", "em", "da", "um", 
            "para", "é", "com", "não", "uma", "os", "no","se", "por", "na", "mais", "as", "dos", "como", "mas", "foi", "ao", "ele", "das", "tem", "à", "seu", "sua", "ou", 
            "ser", "quando", "muito", "há", "nos", "já", "está", "eu", "também", "só", "pelo", "pela", "até", "isso", "ela", "entre", "era", "depois", "sem", "mesmo", "aos", 
            "ter", "seus", "quem", "nas", "me", "esse", "eles", "estão", "você", "tinha", "foram", "essa", "num", "nem", "suas", "meu", "às", "minha", "têm", "numa", "pelos", 
            "elas", "havia", "seja", "qual", "será", "nós", "tenho", "lhe", "deles", "essas", "esses", "pelas", "este", "fosse", "dele", "tu", "te", "vocês", "vos", "lhes", "meus", 
            "minhas", "teu", "tua", "teus", "tuas", "nosso", "nossa", "nossos", "nossas", "dela", "delas", "esta", "estes", "estas", "aquele", "aquela", "aqueles", "aquelas", 
            "isto", "aquilo", "estou", "está", "estamos", "estão", "estive", "esteve", "estivemos", "estiveram", "estava", "estávamos", "estavam", "estivera", "estivéramos", 
            "esteja", "estejamos", "estejam", "estivesse", "estivéssemos", "estivessem", "estiver", "estivermos", "estiverem", "hei", "há", "havemos", "hão", "houve", "houvemos", 
            "houveram", "houvera", "houvéramos", "haja", "hajamos", "hajam", "houvesse", "houvéssemos", "houvessem", "houver", "houvermos", "houverem", "houverei", "houverá", 
            "houveremos", "houverão", "houveria", "houveríamos", "houveriam", "sou", "somos", "são", "era", "éramos", "eram", "fui", "foi", "fomos", "foram", "fora", "fôramos", 
            "seja", "sejamos", "sejam", "fosse", "fôssemos", "fossem", "for", "formos", "forem", "serei", "será", "seremos", "serão", "seria", "seríamos", "seriam", "tenho", "tem", 
            "temos", "tém", "tinha", "tínhamos", "tinham", "tive", "teve", "tivemos", "tiveram", "tivera", "tivéramos", "tenha", "tenhamos", "tenham", "tivesse", "tivéssemos", 
            "tivessem", "tiver", "tivermos", "tiverem", "terei", "terá", "teremos", "terão", "teria", "teríamos", "tão", "teriam"};
            
            String textoSemPontuacao = "";

            //percorre todos os elemntos do texto
            for (int a = 0; a < textoSplit.length; a++)
            {
                //Remove toda associação @nome
                if(textoSplit[a].startsWith("@") == true){
                        textoSplit[a] = "";   
                }
                //Remove toda #
                if(textoSplit[a].startsWith("#") == true){
                        textoSplit[a] = "";   
                }
                
                //Remove toda #
                if(textoSplit[a].startsWith("http") == true){
                        textoSplit[a] = "";   
                }
                   
                //remove os stop e algumas girias - verifica iniciais maiusculas 
                for (int i = 0; i < stopANDgirias.length; i++)
                {
                    if(textoSplit[a].equals(stopANDgirias[i]) || textoSplit[a].equals(stopANDgirias[i].substring(0, 1).toUpperCase() + stopANDgirias[i].substring(1)))
                         textoSplit[a] = "";
                }
                      
                //percorre array de pontuação, caso alguma dessas pontuações esteja no elemento do texto ela é substituita po um "" ou seja, elemento vazio
                for (int i = 0; i < pontuacoes.length; i++)
                {
                    textoSplit[a] = textoSplit[a].replace(pontuacoes[i], "");
                }

                //percorre array de palavras caso alguma desses acentos esteja no elemento do texto ela é substituita pela letra sem o acento
                for (int i = 0; i < comPalavras.length; i++)
                {
                    textoSplit[a] = textoSplit[a].replace(comPalavras[i], semPalavras[i]);
                }
                   
                List<String> palavras = Arrays.asList(textoSplit[a]); 

                // coloca elemento em caixa baixa e o concatena na string a ser retornada
                textoSemPontuacao = textoSemPontuacao + textoSplit[a].toLowerCase() + " ";

            }

            
            textoSemPontuacao = textoSemPontuacao.replaceAll("( )+", " ");
            return textoSemPontuacao;
    }
    
    
    
    
    
}
