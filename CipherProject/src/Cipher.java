import java.util.Scanner;
public class Cipher implements MasterCipher{


private String[] cribs= { "date","quip", "late", "scar", "pack", "tent", "cent", "lamp", "tree", "tick", "meet", "foot", "meat", "fear", "this", "ogre", "lair", "they", "take", "boat", "trip", "near", "lake", "text", "rant", "make", "that", "sick", "mike", "drop", "boom" };
private String encryptedMessage;
	public Cipher() {
		
		
	}
	
	@Override
	public String getMessage() {
		Scanner c = new Scanner(System.in);
		String message;
		while(true) {
		System.out.println("What do you want to encrypt?");
		message= c.nextLine();
		
		if(containsSpacesOrLowerCase(message)) {
			break;
		}
		}
		
		return message;
	}
	public boolean containsSpacesOrLowerCase(String myMessage){
		int counter=0;
		for(int i=0;i<myMessage.length();i++){
			if(myMessage.charAt(i)==' '){
			      counter++;
			 }
			if((int)myMessage.charAt(i)>96&&(int)myMessage.charAt(i)<123)
			    counter++;
		    }
		    if(myMessage.length()>0&&counter==myMessage.length()){
			    return true;
		  }
		  return false;

		  }
	
	@Override
	public int[] getShift() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please give me 4 numbers; one at a time");
		
		int[] numbers=new int[4];
		for(int i =0;i<4;i++) {
			try {
				String answer;
				answer=scan.nextLine();
				int integerVersion= Integer.parseInt(answer);
				numbers[i]=integerVersion;
			}
			catch(NumberFormatException e){
				System.out.println("That's no valid int buckaroo; try again");
			
			}
		}
		return numbers;
	}

	@Override
	public String performShift() {
		String message=getMessage();
		int[] shift=getShift();
		String str="";
		  int s=0;
		  for(int i=0;i<message.length();i++){
		    if(s>shift.length-1){
		      s=0;
		    }
		    if(message.charAt(i)==' '){
		      str+=message.charAt(i);
		    }
		    else{
		    int c=(int)message.charAt(i)+shift[s];
		    if(c>122){
		      c=c-97;
		      c=c%26;
		      c=c+97;
		    }
		    str+=(char)c;
		    }
		    if(message.charAt(i)!=' '){
		    s++;
		    }
		  }
		  return str;
	}
	@Override
	public String getFinalEncrypt() {
		encryptedMessage=performShift();
		return encryptedMessage;
	}
}
