public class Decryption extends Encryption{
    static String decryptCaesarCipher(String cipher,String key){
    String decrypted = decrypt(cipher,key.charAt(key.length()-1));
    for(int i=key.length()-2;i>-1;i--)
      decrypted = decrypt(decrypted,key.charAt(i));
    
    return decrypted;
  }
  
  static String decrypt(String phrase, char cipher){
   String decrypt = "";
   for(int i=0;i<phrase.length();i++){
    decrypt += Character.isUpperCase(phrase.charAt(i)) 
      ? Character.toUpperCase(decrypt(cipher,toggle(phrase.charAt(i)))) : decrypt(cipher,phrase.charAt(i));
   }
   
   return decrypt;
  }
  
  static char decrypt(char cipher,char letter){
   String original = rotateAlphabet(cipher);
   String decrypt = decryptAlphabet(letter);

   for(int i=0;i<26;i++)
     if(letter == original.charAt(i))
      return decrypt.charAt(i);

   return letter;
  }
  
  static String decryptAlphabet(char key){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String rearranged = rotateAlphabet(key);
    
    for(int i=0;i<26;i++)
      if(key == alphabet.charAt(i))
        return rearranged.substring(26-i,26) + rearranged.substring(0,26-i);
    
    return "null";
  }
}