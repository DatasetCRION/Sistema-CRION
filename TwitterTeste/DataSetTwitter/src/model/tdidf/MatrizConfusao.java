/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tdidf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author vsawg
 */

/**
 * 
 * 
 * 
 * 
 */
public class MatrizConfusao {

    
    public void ResultadoMatrizConfusao() throws IOException{
        
            int PN=0 ,PP=0 ,NP=0 ,NN=0;
            String linha, linha2;
            FileReader arq = null, arqResultado = null;
            
            try {
                arq = new FileReader("RTeste20.txt");
                arqResultado = new FileReader("output8020.txt");
           
            
            } catch (FileNotFoundException s) {
                JOptionPane.showMessageDialog(null, "Arquivos não encontrados" + s);
            }

            BufferedReader lerArqResultado = new BufferedReader(arqResultado);
            BufferedReader lerArq = new BufferedReader(arq);
            // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            
            
            do{
                linha = lerArq.readLine(); 
                linha2 = lerArqResultado.readLine();
                
                if("1".equals(linha) && "1".equals(linha2))
                    PP++;
                else if("1".equals(linha) && "0".equals(linha2))
                    PN++;
                else if("0".equals(linha) && "1".equals(linha2))
                    NP++;
                else if("0".equals(linha) && "0".equals(linha2))
                    NN++;
                
                    System.out.println("\n-------------------------------------------");
                    System.out.println("\nLINHA1: " + linha);
                    System.out.println("\nLINHA2: " + linha2);
                    System.out.println("\n-------------------------------------------");
            }while(linha != null || linha2 != null ); 
                        
//            do{
//               linha = lerArq.readLine(); 
//               linha2 = lerArqResultado.readLine(); 
//                    System.out.println("\n-------------------------------------------");
//                    System.out.println("\nLINHA1: " + linha);
//                    System.out.println("\nLINHA2: " + linha2);
//                    System.out.println("\n-------------------------------------------");
//               }while(linha != null || linha2 != null ); 

            System.out.println("\n-------------------------------------------");
            System.out.println("\nVerdadeiro Positivo: " + PP);
            System.out.println("\nFalso Positivo: " + PN);
            System.out.println("\nVerdadeiro Negativo: " + NP);
            System.out.println("\nFalso Negativo: " + NN);
            System.out.println("\n-------------------------------------------");
            arq.close();
            arqResultado.close();
    }
}
