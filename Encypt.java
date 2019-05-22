import java.util.*;
import java.nio.file.*;
import java.lang.*; 
import java.io.*; 

class  Main {
  public static void main(String[] args)throws Exception {
    String file = Input.readFile("encryptedFile.txt");
    String build2 = "";
    int ascii2 = 0;
    
    //String array of all 52 cards
    ArrayList<String>  mylist = new ArrayList<String>(); 
    mylist.add("\uD83C\uDCA1"); mylist.add("\uD83C\uDCB1"); mylist.add("\uD83C\uDCC1"); mylist.add("\uD83C\uDCD1");
    mylist.add("\uD83C\uDCA2"); mylist.add("\uD83C\uDCB2"); mylist.add("\uD83C\uDCC2"); mylist.add("\uD83C\uDCD2");
    mylist.add("\uD83C\uDCA3"); mylist.add("\uD83C\uDCB3"); mylist.add("\uD83C\uDCC3"); mylist.add("\uD83C\uDCD3");
    mylist.add("\uD83C\uDCA4"); mylist.add("\uD83C\uDCB4"); mylist.add("\uD83C\uDCC4"); mylist.add("\uD83C\uDCD4");
    mylist.add("\uD83C\uDCA5"); mylist.add("\uD83C\uDCB5"); mylist.add("\uD83C\uDCC5"); mylist.add("\uD83C\uDCD5");
    mylist.add("\uD83C\uDCA6"); mylist.add("\uD83C\uDCB6"); mylist.add("\uD83C\uDCC6"); mylist.add("\uD83C\uDCD6");
    mylist.add("\uD83C\uDCA7"); mylist.add("\uD83C\uDCB7"); mylist.add("\uD83C\uDCC7"); mylist.add("\uD83C\uDCD7");
    mylist.add("\uD83C\uDCA8"); mylist.add("\uD83C\uDCB8"); mylist.add("\uD83C\uDCC8"); mylist.add("\uD83C\uDCD8");
    mylist.add("\uD83C\uDCA9"); mylist.add("\uD83C\uDCB9"); mylist.add("\uD83C\uDCC9"); mylist.add("\uD83C\uDCD9");
    mylist.add("\uD83C\uDCAA"); mylist.add("\uD83C\uDCBA"); mylist.add("\uD83C\uDCCA"); mylist.add("\uD83C\uDCDA");
    mylist.add("\uD83C\uDCAB"); mylist.add("\uD83C\uDCBB"); mylist.add("\uD83C\uDCCB"); mylist.add("\uD83C\uDCDB");
    mylist.add("\uD83C\uDCAD"); mylist.add("\uD83C\uDCBD"); mylist.add
    ("\uD83C\uDCCD"); mylist.add("\uD83C\uDCDD");
    mylist.add("\uD83C\uDCAE"); mylist.add("\uD83C\uDCBE"); mylist.add("\uD83C\uDCCE"); mylist.add("\uD83C\uDCDE"); 

      build2 = "";

      //Add all characters to an array
      String[] source = file.split(" ");

      //Going backwards
      for(int i = source.length-1; i > -1; i--){
        int offset = mylist.indexOf(source[i]);
        
        //Isolating numbers and subtracting 4, or 2
        if(mylist.indexOf(source[i]) == -1 && source[i].length() > 0){
          int ascii = Integer.parseInt(source[i]);

          if(ascii % 2 == 0){
            build2 += (char)(ascii - 4);
          }else{
            build2 += (char)(ascii - 2);
          }
        }else{
          //Making ascii chars to display on screen
          if(offset <= 25){
            ascii2 = (65 + offset);
          }else if(offset >= 26){
            int number = offset - 26;
            ascii2 = (97 + number);
          }

          if( ascii2 >= (int)'A' && ascii2 <= (int)'Z') { 
            build2 += (char)ascii2;
          }else{
            build2 += (char)ascii2;
          }
        }
      }

      System.out.println("\nYour decrypted message is: \n" + build2);

  try{
       Files.write(Paths.get("dencryptedFile.txt"), build2.getBytes());
     }catch(Exception e){
       System.out.println("Oh NO!");
     }
    //End Decypt
  }
}