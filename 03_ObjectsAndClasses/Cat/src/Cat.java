import java.util.concurrent.ThreadLocalRandom;

public class Cat
{
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    public static int count = 0; // дз 3
    private double originWeight;
    private double weight;
    private double eat;
    private CatColours colour;
    private String name;
    private String breed;
    private boolean isLive = true;



    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count ++; //считаем кота
        colour = CatColours.values()[ThreadLocalRandom.current().nextInt(0, CatColours.values().length)];

    }

    //клонируем кота

    public void copyCat(Cat original)
    {
        originWeight = original.getWeight(); // вес задаем
        this.weight = original.getWeight();
        this.colour = original.getColour();
        this.name = original.getName() + "clone";

    }
    public Cat (Double weightKitten)
    {
        this();
        this.originWeight = weightKitten; // вес задаем
        this.weight = weightKitten;
    }

    public Cat (Double weightKitten,CatColours colour,String name)
    {
        this.name = name;
        this.colour = colour;
        this.weight = weightKitten;
        this.originWeight = weightKitten; // вес задаем
        count++; //считаем кота
    }

    public boolean isLive()
    { if (isLive)
        { if (weight<MIN_WEIGHT || weight>MAX_WEIGHT)
            { isLive = false;
            count--;}
        }
        return isLive;}


    public void setName( String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setCatColour(CatColours type)
    {
    colour = type;
    }

    public CatColours getColour() {
        return colour;
    }

    public void meow()
    {
        if (!isLive)
        {
            System.out.println("Кошка не может мяукать");

        }
        else {
            weight = weight - 10;
            if (weight < MIN_WEIGHT)
            {
                isLive = false;
                count--;
            }
            System.out.println("Meow");
        }
    }

    public void pee()
    {
        if (!isLive)
        {
            System.out.println("Кошка не может сходить в туалет");
        }
        else {
        weight = weight - weight*0.01;
            if (weight < MIN_WEIGHT)
            {
                isLive = false;
                count--;
            }
        System.out.println(" Котя сходил в туалет");
        }
    }

    public double eatAll()
    {
        return eat;
    }

    public void feed(Double amount)
    {
        if (!isLive)
        {
            System.out.println("Кошка не может кушать");
        }
        else {
            weight = weight + amount;
            if (weight > MAX_WEIGHT)
            {
                isLive = false;
                count--;
            }
            eat = eat + amount; //дз2
        }
    }

    public void drink(Double amount)
    {
        if (!isLive)
        {
            System.out.println("Кошка не может пить");
        }
        else {
            weight = weight + amount;
            if (weight > MAX_WEIGHT)
            {
                isLive = false;
                count--;
            }
            eat = eat + amount;//дз 2
        }
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
             return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}