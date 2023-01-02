import java.util.Scanner;

public class Crypticarithmetic {

    public static void main(String[] args) {
        System.out.println("\n\n\n                                                Crypiarithmetic Solver  \n\n\n");
        System.out.println("                                         Which operation to perform (+, - , / , * )");
        Scanner in = new Scanner(System.in);
        char ch = in.next().charAt(0);

        switch (ch) {

            case '+':
                cryptarithmetic_addition obj1 = new cryptarithmetic_addition();
                obj1.main(args);
                break;
            case '-':
                Cryptarithmetic_subs obj2 = new Cryptarithmetic_subs();
                obj2.main(args);
                break;
            case '*':
                Cryptarithmetic_multi obj3 = new Cryptarithmetic_multi();
                obj3.main(args);
                break;
            case '/':
                Cryptarithmetic_divison obj4 = new Cryptarithmetic_divison();
                obj4.main(args);
                break;

            default:
                System.out.println("Wrong Input");
        }

        in.close();
    }
}
