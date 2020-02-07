import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.Math.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TextGenerator
{
 public static String generateText()
 {
   try
   {
   FileReader file = new FileReader("alice_oz.txt");
   
   Scanner inFile = new Scanner(file);
   
   String startWord;
   char endChar;
   String text;
   
   
   double startNum = (int)(Math.random()*((335776-0)+1))+0;
   
   int numWords = (int)(startNum/5.);
   
   
   int x=0;
   while(x<numWords)
   {
     inFile.next();
     x=x+1;
   
   }
   
   StringBuffer s=new StringBuffer();
   
   int y=0;
   while(y<300)
   {
     s.append(inFile.next());
     s.append(" ");
     y=y+1;
     
   
   }
   return s.toString();
   }
   catch(Exception ex)
   {
    return null; 
   }
   
 }
 
}
