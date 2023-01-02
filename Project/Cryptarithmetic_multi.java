import java.util.HashMap;
import java.util.Scanner;

public class Cryptarithmetic_multi {

    int count = 0;
    public void main(String[] args) {
        Cryptarithmetic_multi C = new Cryptarithmetic_multi();
        System.out.println("OK! \n");

        HashMap<Character,Integer> maps = new HashMap<Character,Integer>(); 

        //  taking the input of 3 Strings    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first String: ");
        String a = sc.nextLine();
        System.out.println("Enter second String: ");
        String b = sc.nextLine();
        System.out.println("Enter third String: ");
        String c = sc.nextLine();
        
        String string = a + b + c;

        boolean numbers[] = new boolean[10];

        String characters = "";

//      taking unique alphabets from the input strings
//      and putting it to Hashmap each having values = -1  

        for(int i=0;i<string.length();i++){
            char s = string.charAt(i);
            if(characters.indexOf(s)==-1){
                maps.put(s, -1);
                characters += s;
                
            }
        }
            sc.close();
//      characters = SENDMORY

//  Main method where we use backtracking algorithm     
        System.out.println("\n\n\n All possible solutions \n");
        C.SolveCryptarithmetic(characters,0,maps,numbers,a,b,c);
        System.out.println("\nTotal no. of solutions :" +C.count);
 }

//  using backtracking algorithm 
     void SolveCryptarithmetic(String characters,int k,HashMap<Character,Integer> maps,boolean[] numbers,String a,String b,String c){
         
//     	base condition
        if(k==characters.length()){
            int num1 = getnum(a,maps);
            int num2 = getnum(b,maps);
            int num3 = getnum(c,maps);
            if(num1 * num2 == num3){
                count++;
                for(int i=0;i<characters.length();i++)
                System.out.print(characters.charAt(i)+"-"+maps.get(characters.charAt(i))+"   ");
                System.out.println();
            }
    
            return;
        }
         
        char ch = characters.charAt(k);
        for(int i=0;i<10;i++){
            if(numbers[i]==false){
                maps.replace(ch, i);
                numbers[i] = true;
                SolveCryptarithmetic(characters, k+1, maps, numbers, a, b, c);
                numbers[i]=false;
                maps.replace(ch, -1);
            }
        }
     }

     //   this method provide num a unique number of a particular string
//   for the operation to be performed
     int getnum(String str,HashMap<Character,Integer> maps ){
        String num = "";
        
        for(int i=0;i<str.length();i++){
                num += maps.get(str.charAt(i));
            }
    
        return Integer.parseInt(num);

     }
    
}
