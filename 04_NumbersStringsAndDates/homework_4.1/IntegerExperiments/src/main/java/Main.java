public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count = 898989;
    System.out.println(container.count);

    int sum = sumDigits(5555);


    System.out.println("Сумма чисел " + sum);
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  public static int sumDigits(Integer number) {

    if (number != null)
    {String ss = number.toString();
      int i = ss.length();
      int sum = 0;

      for (int n = 0; n != i;)
      {
        sum = sum + Character.getNumericValue(ss.charAt(n));
        n++;
      }
      return sum;
    }
    else {
      return -1;
    }


  }
}
