public class Encryption{
  static String caesarCipher(String cipher,String key){
    String encrypted = encrypt(cipher,key.charAt(0));
    for(int i=1;i<key.length();i++)
      encrypted = encrypt(encrypted,key.charAt(i));
    
    return encrypted;
  }
    
  /*Warning: scrambling the phrase will give the same end result, since you rotate it the same number of times
   "HelloWorld" is equal to 124 and pushes the alphabet 114 times
   "dHlerlolWo" is equal to 124 and pushes the alphabet 114 times
   instead, add extra or remove characters from the phrase to ensure a more secure encryption*/
  static String encrypt(String phrase, char cipher){
   String encrypt = "";
   
   for(int i=0;i<phrase.length();i++){
    encrypt += Character.isUpperCase(phrase.charAt(i)) ? 
        Character.toUpperCase( encrypt(cipher,toggle(phrase.charAt(i))) )+"" :
        encrypt(cipher,phrase.charAt(i));
   }
   
   return encrypt;
  }
  
  static char encrypt(char cipher,char letter){
   String original = "abcdefghijklmnopqrstuvwxyz";
   String encrypt = rotateAlphabet(cipher);
   
   for(int i=0;i<26;i++)
     if(letter == original.charAt(i))
      return encrypt.charAt(i);
   
   return letter;
  }
  
  static String rotateAlphabet(char letter){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String rearranged = "";
    
    for(int i=0;i<26;i++)
      if(letter == alphabet.charAt(i))
        rearranged += alphabet.substring(i) + alphabet.substring(0,i);
    
    return rearranged;
  }
  
  static String toggle(String sentence){
   String toggled = "";
   for(int i=0;i<sentence.length();i++)
     toggled += toggle(sentence.charAt(i)) + "";
   
   return toggled;
  }
  
  static char toggle(char letter){
    return Character.isLowerCase(letter) ? Character.toUpperCase(letter) : Character.toLowerCase(letter);
  }
}