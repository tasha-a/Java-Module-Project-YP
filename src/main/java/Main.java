import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean start = true;

        while(start) {
            System.out.println("На сколько человек делим счет?");
            int numberPeople = scanner.nextInt();

            if ( numberPeople > 1 ) {
                Calculator calculator = new Calculator();
                calculator.calculator( numberPeople );
                start = false;
            }
            else {
                System.out.println("Некорректное число. Попробуйте ввести количество людей снова");
            }
        }
    }
}

   class Calculator {

       public static void calculator(int numberPeople) {

           boolean goodsNext = true ;
           String finish = "Завершить" ;
           double sum = 00.00 ;
           String list = "" ;
           String endingRub = "";
           String endingSum = "";
           Double sumEach ;

           DecimalFormat decimalFormat = new DecimalFormat( "#.##" );


           while (goodsNext) {

               System.out.println("Введите название товара");
               Scanner scanner = new Scanner(System.in);
               String nameGoods = scanner.nextLine();

               if (nameGoods.equalsIgnoreCase(finish)) {
                   //System.out.println(sum/numberPeople + "\n");
                   break;
               }

               System.out.println("Введите стоимость в формате 00,00");

               if ( scanner.hasNextDouble() ) {

                   double price = scanner.nextDouble();

                   if (price > 0 ) {

                       sum = sum + price;
                      // Calculator goods = new Calculator();
                     endingRub = ending(price) ;

                     decimalFormat.format(price);

                       list = list + " \n" + nameGoods + " – " + price + " рубл"  + endingRub  ;
                   }
                   else {
                       System.out.println("Ошибка! Неверный формат цены. Попробуйте ввести данные о товаре снова");
                   }
               }
               else {
                   System.out.println("Ошибка! Неверный формат цены. Попробуйте ввести данные о товаре снова");
               }
           }

           endingSum = ending(sum/numberPeople) ;

           System.out.println(list + "\n" + "С каждого: " + decimalFormat.format(sum/numberPeople)  + " рубл" + endingSum );


       }


    public static String ending( double price) {

          String endingOne = "ь" ;
          String endingTwo = "я" ;
          String endingThree = "ей" ;

          String ending ;
          String list = "" ;

          int priceInt = (int)price;

          if (priceInt == 11) {
              ending = endingThree;
          }
          else {
              priceInt %= 10;

              switch (priceInt){
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



