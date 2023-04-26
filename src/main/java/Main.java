import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("На сколько человек делим счет?");

            if (scanner.hasNextInt()) {
                int numberPeople = scanner.nextInt();

                if (numberPeople > 1) {
                    Calculator.calculator(numberPeople);
                    break;
                } else {
                    System.out.println("Некорректное число. Попробуйте ввести количество людей снова");
                }
            } else {
                System.out.println("Некорректное число. Попробуйте ввести количество людей снова");
            }
        }
    }
}




