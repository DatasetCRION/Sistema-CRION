/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tdidf;

/*         MATRIZ TD IDF [Qtd Tweet][palavraN +2]
 *  [0]                   |   1     |  Palavras | ... | Palavras N 
 *  [1] Flag Crime        |  Id BD  |  Valores                     <=
 *  [2] Flag Crime        |  Id BD  |  Valores
 *  [Count BD] Flag Crime |  Id BD  |  Valores 
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.DAO.TweetDAO;
import model.bean.Tweet;
import java.io.*;

/*public class classeRetorno {

    Integer id;
    Bool flag;
    ArrayList<Double> valores;

//get set
}*/

/**
 *
 * @author vsawg
 */
public class TFIDFCalculator {

    Tweet t = new Tweet();
    TweetDAO dao = new TweetDAO();
    List<String> DocTotal = new ArrayList<String>();
    //List<String> DocTotal = Arrays.asList("*flag*","*id*");
    List<String> PalavraNaoIgual = new ArrayList<String>();
    //List<String> Teste = Arrays.asList("*flag*","*id*");
    //ArrayList<ArrayList<String>> MatrizIF = new ArrayList<ArrayList<String>>();
    //String[][] MatrizIF = new String[200][];
    
    
    
//List<classeRetorno> lista = new ArrayList();

    /**
     * @param doc list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    public Double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word)) {
                result++;
            }
        }
        return result / doc.size();
    }
    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    public Double idf(List<String> docs, String term) {
        double n = 0;        
        /*for (String doc : docs) {
            if (term.equalsIgnoreCase(doc)) {
                n++;
                break;
            }
        }*/
        for (int a = 0; a < docs.size(); a++)
        {
            if(term.equals(docs.get(a)))
                n++;
        }
        return Math.log(docs.size() / n);
    }
    
    public Double binario(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word)) {
                result=1;
            }
        }
        return result;
    }
    /**
     * @param docTweet a text document
     * @param docTotal all documents
     * @param term term
     * @return the TF-IDF of term
     */
    public Double tfIdf(List<String> docTweet, List<String> docTotal, String term) {
        return tf(docTweet, term) * idf(docTotal, term);
//        return tf(docTweet, term);
        //return binario(docTweet, term);
    }

    public void CreateDoc() throws IOException {
        String palavra;
        Integer idTweet;
        PalavraNaoIgual.add("*Flag*");
        PalavraNaoIgual.add("*ID*"); 

        //LISTA TABELAS -stoptweet- PARA DOC GERAL
        for (Tweet twt : dao.DOCread()) {
            idTweet = twt.getId();
            //DocTotal.add(Integer.toString(idTweet));
            palavra = twt.getText();
            montaDoc(palavra); 
        }

        //CRIA TD IDF DAS PALAVRAS
        for(Tweet twt: dao.DOCread()){                     
            idTweet = twt.getId();    
            palavra = twt.getText();
           
            montaMatrizVector(idTweet, palavra);
        }
        
       /*  
 // IMPRIME DOC TOTAL
        for(String s : this.DocTotal){
            System.out.print(s + " | ");
        }
        System.out.println(" ");
        for(String s : this.PalavraNaoIgual){
            System.out.print(s + " | ");
        }*/
        
        
 /*/ IMPRIME MATRIZ
        for (int i = 0; i < MatrizIF.length; i++) {
            for (int j = 0; j < 123; j++) {
                System.out.println(MatrizIF[i][j] + "   |   " );
            }
            System.out.println();
        }
         */
    }

    //Monta todo o documento com as palavras do stop
    public String montaDoc(String texto) {
        
        // cria um array com todos as palavras do texto
        String[] textoSplit = texto.trim().split(" ");
        for (int a = 0; a < textoSplit.length; a++) {
            DocTotal.add(textoSplit[a]);
            if (PalavraNaoIgual.contains(textoSplit[a])){} 
            else {
               PalavraNaoIgual.add(textoSplit[a]);
            }
        }
        return "";
    }

      //Cria a estrutura da matriz FlagCrime - ID Tweet -Palavras [VETOR]
    private void montaMatrizVector(Integer ID, String texto) throws IOException {
        //Array para Matriz
        //List<String> ListaTweet = new ArrayList<String>();
        String[] ListaTweet = new String[PalavraNaoIgual.size()];
        //ListaTweet.clear();
        String[] textoSplit = texto.trim().split(" ");
        TFIDFCalculator calculator = new TFIDFCalculator();

        ListaTweet[0] = "1";
        ListaTweet[1] = Integer.toString(ID);

        //Verifica se há alguma palavra em comum na Matriz
        for (int a = 0; a < textoSplit.length; a++) {
           //Para calcular tfidf
            Double tfidf = calculator.tfIdf(listaTweet(texto), DocTotal, textoSplit[a] );
            //System.out.print("\n" + textoSplit[a]);
           //System.out.println("\n" + textoSplit[a] + "   |   " + tfidf + " - " + DocTotal.size() + " - " + PalavraNaoIgual.size());
             
           for (int b = 2; b < PalavraNaoIgual.size(); b++) { 
                if (textoSplit[a].equals(PalavraNaoIgual.get(b))){
                    ListaTweet[b] = Double.toString(tfidf);
                }
                else{
                    if (ListaTweet[b] == "0" || ListaTweet[b] == null){
                        ListaTweet[b] = "0";
                    }
                }                        
            }
           
        }
        //TXT PARA TREINAMENTO DO SVM
        FileWriter arquivo = new FileWriter("Treino20.txt",true);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            BufferedWriter conexao = new BufferedWriter(gravarArquivo);
            conexao.write(ListaTweet[0]+ " ");
             for (int b = 2; b < ListaTweet.length; b++) { 
                    conexao.write(b-1+":"+ListaTweet[b]+" ");
//                    conexao.write(ListaTweet[b]);
             }
            conexao.write("\n");
            conexao.flush(); //libera a gravaçao
            conexao.close(); //fecha o arquivo
        
        
        
        /*System.out.print("\n"+ ListaTweet[0]+ " " + ListaTweet[1]+ " => ");
        for (int b = 2; b < ListaTweet.length; b++) { 
                System.out.print(b-1+":"+ListaTweet[b]+" ");
        }*/
    }
    
    
    //Cria a lista do tweet para o calculo do tfidf
    private List<String> listaTweet(String texto) {
        List<String> localTweet = new ArrayList<String>();
        localTweet.clear();
        String[] textoSplit = texto.trim().split(" ");
        for (int a = 0; a < textoSplit.length; a++) {
               localTweet.add(textoSplit[a]);
        }
        return localTweet;
    }

//Verifica se o Tweet COLETADO é crime ou não
     public void CalculaTweet() throws IOException {
         
        for (Tweet twt : dao.TweetinTime()) {
            Integer idTweet = twt.getId();
            //DocTotal.add(Integer.toString(idTweet));
            String texto = twt.getText();
            // cria um array com todos as palavras do texto
            String[] ListaTweet = new String[PalavraNaoIgual.size()];

            String[] textoSplit = texto.trim().split(" ");
            TFIDFCalculator calculator = new TFIDFCalculator();
            ListaTweet[0] = "1";
            ListaTweet[1] = "";

              //Verifica se há alguma palavra em comum na Matriz
            for (int a = 0; a < textoSplit.length; a++) {
                //Para calcular tfidf
                 Double tfidf = calculator.tfIdf(listaTweet(texto), DocTotal, textoSplit[a] );
                 //System.out.print("\n" + textoSplit[a]);
                //System.out.println("\n" + textoSplit[a] + "   |   " + tfidf + " - " + DocTotal.size() + " - " + PalavraNaoIgual.size());
                for (int b = 2; b < PalavraNaoIgual.size(); b++) { 
                     if (textoSplit[a].equals(PalavraNaoIgual.get(b))){
                         ListaTweet[b] = Double.toString(tfidf);
                     }
                     else{
                         if (ListaTweet[b] == "0" || ListaTweet[b] == null){
                             ListaTweet[b] = "0";
                         }
                     }                        
                 }  
             }
            
//            //Imprime arquivo verifica
//            System.out.print("\n"+ ListaTweet[0]+ " " + ListaTweet[1]+ " => ");
//             for (int b = 2; b < ListaTweet.length; b++) { 
//                     System.out.print(b-1+":"+ListaTweet[b]+" ");
//             }
            
            //Grava o arquivo para predição
            FileWriter arquivo = new FileWriter("Teste80.txt",true);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            BufferedWriter conexao = new BufferedWriter(gravarArquivo);
            gravarArquivo.print(ListaTweet[0]+ " ");
             for (int b = 2; b < ListaTweet.length; b++) { 
                     conexao.write(b-1+":"+ListaTweet[b]+" ");
             }
            conexao.write("\n");
            conexao.flush(); //libera a gravaçao
            conexao.close(); //fecha o arquivo
           

            
//            CommandLine avalia = new CommandLine();
//            
//            String resultadoAvalicao;
//            resultadoAvalicao = avalia.getBat(".\\svm-predict.exe teste.txt treinamentoSVM.txt.model output.txt");
            
            
//            String teste1 = "Accuracy = 49% (50/100) (classification";
//            String teste2 = "Accuracy = 9% (94/100) (classification)";
//            String teste3 = "Accuracy = 68.8525% (42/61) (classification)";
//            VaiVotarTweet(idTweet,teste1);
            
            //System.out.print("\n" + idTweet + " " + resultadoAvalicao);
            //VaiVotarTweet(idTweet,resultadoAvalicao);
            
            
        }
    }
    //Metedo para levar o tweet para o banco de votação
     public void VaiVotarTweet(Integer idTweet, String resultado){
         String[] textoSplit = resultado.trim().split(" ");
         String porcentagem;       

        //System.out.print(textoSplit[2].substring(2) + " " + textoSplit[2].length() );
         //textoSplit[2] = porcentagem
         int aux = textoSplit[2].length() -1 ;     
        
            porcentagem = textoSplit[2].substring(0, aux);
            //valorPorcentagem = Integer.parseInt(porcentagem);
            Double valorPorcentagem = Double.valueOf(porcentagem);

         if(valorPorcentagem < 50)
             System.out.print("\n NÃO É CRIME - TWEET DESCARTADO " + valorPorcentagem + "%");
         else
            {  
                System.out.print("\n TWEET ADICIONADO: "  + idTweet + " PORCENTAGEM: " + valorPorcentagem + "%");
                dao.BancoVotaTweetSVM(idTweet);
            }
     }
}