import java.util.Scanner;

interface bruh{ // I created an interface for gather under one roof all classes and force to use WhoAmI method for all classes.
	  public char WhoAmI();
}
class Cup implements bruh{
	public  char WhoAmI() {
		return 'C';
	}
}
class Ball implements bruh{
	public  char WhoAmI(){
		return 'B';
		
	}
}
class Hat implements bruh{
	public  char WhoAmI() {
		return 'H';
		}
}
class Pen implements bruh{
	public  char WhoAmI() {
		return 'P';
	}	
}
class Undefined implements bruh{
	public char WhoAmI(){
		return 'U';
	}
}
public class midtermFurkan {
	public static void M1(String letters,char arry[][]) { // this methods purpose is taking letters string to two dimensional array with using classes
		int a=0;
		int i=0;
		int j=0;
		Cup C=new Cup(); // here I created objects for every class for write letters to two dimensional array from string
		Ball B=new Ball();
		Hat H=new Hat();
		Pen P=new Pen();
		Undefined U= new Undefined();
		while(a<9) {
			if(letters.charAt(a)==C.WhoAmI()) { //in this while loop I'm checking all letters for which classes return is same with that letter
		        arry [i][j]=C.WhoAmI();
			}
			if(letters.charAt(a)==B.WhoAmI()) {
		        arry [i][j]=B.WhoAmI();
			}
			if(letters.charAt(a)==H.WhoAmI()) {
		        arry [i][j]=H.WhoAmI();
			}
			if(letters.charAt(a)==P.WhoAmI()) {
		        arry [i][j]=P.WhoAmI();
			}
			if(letters.charAt(a)==U.WhoAmI()) {
		        arry [i][j]=U.WhoAmI();
			}
			a++;
			j++;
			if(j==3) {
				j=0;
				i++;
			}
		}
		
}
	public static void PlayGame(char arry[][],char arry1[][],String letters) {
	// this methods purpose is making visible the locations that users entered and make them invisible again and start the memory game	
		int i=0;
		int j=0;
		int a=0;
		Scanner scn= new Scanner(System.in);
		while(a<9) {  // this while loop taking locations from user 9 time with scanner
		System.out.print("please enter location:");
		int line=scn.nextInt();
		int column=scn.nextInt();
		arry1 [line][column]= arry [line][column]; //here I'm changing the 'x' symbols to letters which are already given in my stirng
		while(j<3){ // this while loop printing the invisible two dimensional arrays visible form 
			System.out.print(arry1[i][j]);
			j++;
			if(j==3) {
				System.out.println();
				j=0;
				i++;
			}
			if(i==3) {
				break;
			}
		}
		i=0;
		j=0;
		a++;
		
	 }	
		Scanner asd=new Scanner(System.in); // this scanner taking the answer of Question from user
		System.out.println("do you want to cover them again?");
		String answer=asd.nextLine();
		if(answer.equals("yes")) { // this while loops purpose is if user write "yes" loop making invisible that two dimensional array which is visible and print it
			while(j<3){
				arry1[i][j]='X';
				System.out.print(arry1[i][j]);
				j++;
				if(j==3) {
					System.out.println();
					j=0;
					i++;
				}
				if(i==3) {
					break;
				}
			}
		}
		i=0;
		System.out.println("please enter letters you remember:");
		String remember= asd.nextLine(); // here I'm taking the users guess with scanner
          int count=0;
          while(i<9) { // this while loop compares the default form of two dimensional array with users guess if they are same for each  floor, loop increasing the count
			if(remember.charAt(i)==letters.charAt(i)) {
				count++;
			}
			i++;
		}
          if(count>=4) { // here if my count bigger or equal than 4 is printing that user won and users guess and then then the main form of array
        	  System.out.printf("you won with %d correct guess with %s \n",count,remember);
        	  System.out.printf("correct form should be like: %s \n",letters);
          }
          else {// here if my count smaller than 4 is printing that user lost and users guess and then then the main form of array
        	  System.out.printf("you lost with %d correct guess with %s \n",count,remember);
        	  System.out.printf("correct form should be like:%s \n",letters);
          }
          scn.close();// here closing the scanners
          asd.close();
	}
	public static void main(String[] args) {
		int column=3;
		int line=3;
		char [][] arry= new char [line][column]; // here I created two dimensional array for taking letter from string to here
		String letters="CHPUPBCBH";  // this is my string
     M1(letters,arry); // method calls(like functions)
     char [][]arry1=new char [line][column];// here I created 2nd array for invisible array 
        int i=0;
		int j=0;
		while(j<3){// this while loop makes every floor of array 'x' which means invisible character for us, and printing it.
			arry1[i][j]='X';
			System.out.print(arry1[i][j]);
			j++;
			if(j==3) {
				System.out.println();
				j=0;
				i++;
			}
			if(i==3) {
				break;
			}
		}
		PlayGame(arry,arry1,letters);// method call
		
	}
}

