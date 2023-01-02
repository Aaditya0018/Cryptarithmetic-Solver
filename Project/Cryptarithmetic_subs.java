import java.util.*;

public class Cryptarithmetic_subs {
    public void main(String[] args) {

        System.out.println("OK! \n\n");

//  taking the input of 3 Strings
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first String: ");
        String s1 = sc.nextLine();
        System.out.println("Enter second String: ");
        String s2 = sc.nextLine();
        System.out.println("Enter third String: ");
        String s3 = sc.nextLine();


//      taking unique alphabets from the input strings
//      and putting it to Hashmap each having values = -1  
        HashMap<Character, Integer> charIntmap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntmap.containsKey(s1.charAt(i))) {
                charIntmap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntmap.containsKey(s2.charAt(i))) {
                charIntmap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntmap.containsKey(s3.charAt(i))) {
                charIntmap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }
        
            sc.close();


//        characters = SENDMORY
        
//      Main method where we use backtracking algorithm     


            System.out.println("\n\n\n All possible solutions \n");

        boolean[] usedNumbers = new boolean[10];
        answer(unique, 0, charIntmap, usedNumbers, s1, s2, s3);
    }

    //   this method provide num a unique number of a particular string
//   for the operation to be performed
    public static int getNumber(String s, HashMap<Character, Integer> charIntMap) {
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            num += charIntMap.get(s.charAt(i));
        }
        return Integer.parseInt(num);
    }

    //  using backtracking algorithm 
    public static void answer(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
            String s1, String s2, String s3) {

        //    	 base condition
        if (idx == unique.length()) {
            int num1 = getNumber(s1, charIntMap);
            int num2 = getNumber(s2, charIntMap);
            int num3 = getNumber(s3, charIntMap);

            if (num1 - num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('A' + i);
                    if (charIntMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }

                System.out.println();
            }
           
            return;
        }

        char ch = unique.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (usedNumbers[num] == false) {
                charIntMap.put(ch, num);
                usedNumbers[num] = true;
                answer(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                usedNumbers[num] = false;
            }
        }
    }

}
