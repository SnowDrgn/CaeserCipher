//This class contains the display methods
public class CaesarCipher extends Decryption{
  public static void main(String[]args){
    show("cRX+pT#A9!j?H","computer");
    System.out.println("\n------------->\n");
    show("cRX+pT#A9!j?J","r");
  }
  
  static void show(String cipher,String key){
    showCaesarCiphers(cipher,key);
    System.out.println();
    
    String caesar = caesarCipher(cipher,key);
    showCaesarCiphersDecrypted(caesar,key);
    System.out.println("\nencrypted = " + caesar + "\noriginal = " + decryptCaesarCipher(caesar,key));
  }
  
  static void showCaesarCiphers(String cipher,String key){
    String encrypted = encrypt(cipher,key.charAt(0));
    System.out.println(cipher + "  original\n" + encrypted + "  " + key.charAt(0));
    
    for(int i=1;i<key.length();i++){
      encrypted = encrypt(encrypted,key.charAt(i));
      System.out.println(encrypted + "  " + key.charAt(i));
    }
  }
  
  static void showCaesarCiphersDecrypted(String cipher,String key){
    String decrypted = decrypt(cipher, key.charAt(key.length()-1) );
    System.out.println(cipher + "  final encrypted\n" + decrypted + "  " + key.charAt(key.length()-1));
    
    for(int i=key.length()-2;i>-1;i--){
      decrypted = decrypt(decrypted,key.charAt(i));
      System.out.println(decrypted + "  " + key.charAt(i));
    }
  }
}