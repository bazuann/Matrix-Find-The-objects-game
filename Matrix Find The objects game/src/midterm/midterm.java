package midterm;
import java.util.Scanner;

interface whoami{
    public char whoAmI(); 
} 

class Cup implements whoami{	
		public  char whoAmI() {
			return 'C';//if you call whoAmI method with cup it is gona return letter 'c'
		}
   }

	class Ball implements  whoami{
		public  char whoAmI() {
			return 'B';//if you call whoAmI method with ball it is gona return letter 'b'
		}
   }

	class Hat implements whoami{
		public  char whoAmI() {
			return 'H';//if you call whoAmI method with hat it is gona return letter 'h'
		}
   }

	class Pen implements whoami {
		public  char whoAmI() {
			return 'P';               //if you call whoAmI method with pen it is gona return letter 'p'
		}
   }

public class midterm {
	
	public static void clear() {
	    for (int i = 0; i<30; i++){       //clear function for better looking 
	       System.out.print('\n');
	    }
	}
	
	public static void Placement(String items, char [][] num){      
                      //this is gona place the items in the grid
			int i = 0;
			int z = 0;
			int c = 0;
			Cup cup = new Cup();
			Ball ball = new Ball();                     //creating the objects 
			Hat hat = new Hat();
			Pen pen = new Pen();
			
			while(i< 3) {
				while(z < 3) {
					if(items.charAt(c)== 'C') {
						num[i][z] = cup.whoAmI();
					}
					if(items.charAt(c)== 'B') {
						num[i][z] = ball.whoAmI();             
                                                                        //that area create object and place at the matrix
					}                                                   //i take 'i' as a x axis and 'z' as a y axis
					if(items.charAt(c)== 'H') {                  
                                                                     //it is gona check every x and y cordinate for placing 
						num[i][z] = hat.whoAmI();
					}
					if(items.charAt(c)== 'P') {
						num[i][z] = pen.whoAmI();
					}
					if(items.charAt(c)== 'U') {
						num[i][z] = 'U';
					}
					c++;
					z++;
				}
				z = 0;
				i++;
			}			
		}
	public static void PlayGame(char[][] x,char[][] full) {
		Scanner sc = new Scanner(System.in);
		int s = 0;
		int y = 0;
		int ı = 0;
		int ş = 0;        
		int k = 0;
		int u = 0;
		char[][] num = new char[3][3];
		for(int b=0; b<3;b++) {
			for(int g=0; g<3;g++) {                //new array for hided matrix
				num[b][g] = 'X';                   //it is gona place every column and row a 'x'
			}
		}
		
		while(ı <9) {
		System.out.println("Please enter row-col location: ");
		s = sc.nextInt();
		y = sc.nextInt();		
		x[s][y] = full[s][y];                       //replace the x matrix with user entered locations 
		for(int i = 0; i<3; i++) {
	    	for(int j = 0; j<3; j++) {
	    		System.out.print(x[i][j]+" ");     
                    //prints the replaced matrix with the user entered location
	    	}
	    	System.out.println();
	    }
		ı++;
		}
		
		System.out.println("if you want to cover them again ?");
        String YesNo =  sc.next(); 

		 
		clear();       // code to clear screen 
	
		if(YesNo.equals("no")) {
	System.out.println("Okay ım waiting to you say yes ...");    
 //if user says ım not ready the program wait until user ready 
			while(YesNo.equals("no")) {
		            YesNo =  sc.next(); 
		}
		}
		
		if(YesNo.equals("yes")) {
			                                                  //thats gona hapeen when user ready 
			for(int i = 0; i<3; i++) {
		    	for(int j = 0; j<3; j++) {
		    		System.out.print(num[i][j]+" ");
		    	}
		    	System.out.println();
		    }
		}
		
		System.out.println("your turn try to remember :) enter what you remember : ");
		String answer = sc.next();             //Takes the answer from user
		int count = 0;
		
		while(ş < 3) {
			while(k < 3) {
			if(answer.charAt(u) == full[ş][k]) {
			count++;    //checks if the user entered correct if it is increase the count
			}
			u++; //for string to get 0 1 2 so for
			k++;
		 }
			k = 0;  //resets the y cordinate 
			ş++;
		}
		
		if(count > 3) {
			System.out.printf("You won with %d correct answer :)  \n",count);
			System.out.println("The Correct one is was like that: ");
			for(int i = 0; i<3; i++) {
		    	for(int j = 0; j<3; j++) {
		    		System.out.print(full[i][j]+" ");    
               //that shows the correct matrix (that we hard coded)
		    	}
		    	System.out.println();
		    }
		}
		
		else {
			System.out.printf("You lose with %d correct answer :( \n ",count);
			System.out.println("The Correct one is was like that: ");
			for(int i = 0; i<3; i++) {
		    	for(int j = 0; j<3; j++) {       
                                //that shows the correct matrix (that we hard coded)
		    		System.out.print(full[i][j]+" ");       
		    	}
		    	System.out.println();
		    }
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		char[][] fınal=new char[3][3];       //crates the 2 dim arrays
		char[][] num = new char[3][3];      //crates the 2 dim arrays 
	
		for(int b=0; b<3;b++) {
			for(int g=0; g<3;g++) {                //this code gona place x every colomn and row
				num[b][g] = 'X';
			}
		}
		String st = "CPCHPBUBH";       //the items that gona place in the matrix	
		 Placement(st,fınal);        //these two codes calls the functions 
		  PlayGame(num,fınal);       //actual things gona happen at these function
	}
}
