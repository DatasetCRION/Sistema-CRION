package model.tdidf;


import java.io.*;
import java.util.Scanner;

public class CommandLine
{
     public String getBat(String command) throws IOException{
        String result = "";
        //Process exec = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+command);
        Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL");
        Process exec = Runtime.getRuntime().exec(command);
        
        Scanner leitor = new Scanner(exec.getInputStream());

        while(leitor.hasNext()){
            result = result + leitor.nextLine() + "\n";
        }
        
    return result;   
    }
}