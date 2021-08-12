
public class Loader

{
    private static Cat copy (Cat original)
    {
        return new Cat(original.getWeight(),original.getColour(),original.getName());
    }
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();

        //Проверяем котов на белый цвет )

        Cat[] list = {cat, cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9};

        for (int i = 0; i<list.length; i++){
            if (list[i].getColour() == CatColours.WHITE){
                System.out.println("Вес БЕЛОГО КОТА = " + list[i].getWeight() + " номер кота " + (i+1));
            }
            else {
                System.out.println("Кот номер " + (i+1) + " не белый");
            }


        }
        System.out.println("--------------------------------------------");
        System.out.println("Клонируем котов");
        System.out.println("--------------------------------------------");
        System.out.println(Cat.count + " ------10 cats-----");

        Cat cat10 = new Cat(1200.0); // задаю вес кота

        System.out.println(Cat.count + " -----11 cats-----");

        //клонируем кота

        Cat cat11 = new Cat();
        cat11.copyCat(cat10); //клонируем кота через метод класса
        cat11.setName("Клон Матроса");



        System.out.println(" -----12 cats----");

        Cat musa = copy(cat11); //клонируем кота через статик метод

        System.out.println("  Муся  " + musa.getName());
        System.out.println(Cat.count + "  ----13 cats----");


    }
}






