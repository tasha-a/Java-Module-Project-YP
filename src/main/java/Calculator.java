import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    public static void calculator(int numberPeople) {

        String finish = "Завершить";
        double sum = 00.00;
        StringBuilder list = new StringBuilder();
        String endingRub = "";
        String endingSum = "";

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        while (true) {

            System.out.println("Введите название товара или слово 'Завершить', чтобы получить результат");
            Scanner scanner = new Scanner(System.in);
            String nameGoods = scanner.nextLine();

            if (nameGoods.equalsIgnoreCase(finish)) {
                break;
            }

            System.out.println("Введите стоимость в формате 00,00");

            if (scanner.hasNextDouble()) {

                double price = scanner.nextDouble();

                if (price > 0) {
                    sum = sum + price;
                    endingRub = ending(price);
                    decimalFormat.format(price);

                    list.append(" \n" + nameGoods + " – " + price + " рубл" + endingRub);

                } else {
                    System.out.println("Ошибка! Неверный формат цены. Попробуйте ввести данные о товаре снова");
                }
            } else {
                System.out.println("Ошибка! Неверный формат цены. Попробуйте ввести данные о товаре снова");
            }
        }

        endingSum = ending(sum / numberPeople);
        System.out.println(list + "\n" + "С каждого: " + decimalFormat.format(sum / numberPeople) + " рубл" + endingSum);
    }

    public static String ending(double price) {

        String endingOne = "ь";
        String endingTwo = "я";
        String endingThree = "ей";
        String ending;

        int priceInt = (int) price;

        if (price > 10) {
            price %= 100;

            if (price == 11 || price == 12 || price == 13 || price == 14) {
                ending = endingThree;

            } else {
                priceInt %= 10;

                switch (priceInt) {
                    case 1:
                        ending = endingOne;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        ending = endingTwo;
                        break;
                    default:
                        ending = endingThree;
                        break;
                }
            }
        } else {
            priceInt %= 10;

            switch (priceInt) {
                case 1:
                    ending = endingOne;
                    break;
                case 2:
                case 3:
                case 4:
                    ending = endingTwo;
                    break;
                default:
                    ending = endingThree;
                    break;
            }
        }
        return ending;
    }
}
