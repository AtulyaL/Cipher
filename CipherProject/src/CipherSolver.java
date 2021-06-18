import java.util.Arrays;
public class CipherSolver {
private Cipher c;
private String[] cribs= { "date","quip", "late", "scar", "pack", "tent", "cent", "lamp", "tree", "tick", "meet", "foot", "meat", "fear", "this", "ogre", "lair", "they", "take", "boat", "trip", "near", "lake", "text", "rant", "make", "that", "sick", "mike", "drop", "boom" };
public int[] shifts;

public CipherSolver() {
shifts=new int[4];
c= new Cipher();
}
public int[] shiftsCIPHER(String fourLetterWord, String crib){
	int i= ((int)crib.charAt(0))-((int)fourLetterWord.charAt(0));
	int a=((int)crib.charAt(1))-((int)fourLetterWord.charAt(1));
	int x=((int)crib.charAt(2))-((int)fourLetterWord.charAt(2));
	int z=((int)crib.charAt(3))-((int)fourLetterWord.charAt(3));
	int[] differences={i,a,x,z};
	return differences;
}
public String[] findFourLetterWordsCipher(String message){
	  String[] words=message.split(" ");
	  String forLater="";
	  for(String word:words){
	    if(word.length()==4){
	      forLater+=word+" ";
	    }
	  }
	  if(!(forLater.length()==0)){
	  return forLater.split(" ");
	  }
	  String[] empty={};
	  return empty;

	}

public int findStartIndexCIPHER(String encryptedMessage, String fourLetterWord){
	  String str="";
	  
	  for(int i=0;i<encryptedMessage.length();i++){
	    if(encryptedMessage.charAt(i)!=' '){
	      str+=encryptedMessage.charAt(i);
	    }
	    
	    }
	    if(!(str.contains(fourLetterWord))){
	    return -1;
	  }
	  int index=str.indexOf(fourLetterWord);
	    if(index>3){
	      index=index%4;
	}
	  return index;
	}


public void decrypt() {
	String encryptedMessage=c.getFinalEncrypt();
	System.out.println(encryptedMessage);
	String[] fourLetterEncryptedWords=findFourLetterWordsCipher(encryptedMessage);
	for(String word:fourLetterEncryptedWords) {
		for(String crib: cribs) {
			shifts=shiftsCIPHER(word,crib);
			int s=findStartIndexCIPHER(encryptedMessage,word);
			for(int i=0;i<encryptedMessage.length();i++) {				
				String decrypted="";
				if(s>shifts.length-1){
				      s=0;
				    }
				    if(encryptedMessage.charAt(i)==' '){
				      decrypted+=encryptedMessage.charAt(i);
				    }
				    else{
				    int c=(int)encryptedMessage.charAt(i)+shifts[s];
				    if(c>122){
				      c=c-97;
				      c=c%26;
				      c=c+97;
				    }
				    if(c<97) {
				    	 c=c-97;
					     c=c+26;
					     c=c+97;    
				    }
				    decrypted+=(char)c;
				    }
				    if(encryptedMessage.charAt(i)!=' '){
				    s++;
				    }
				    System.out.print(decrypted);
				    
			}
			
		}
		
	}
	
}

}