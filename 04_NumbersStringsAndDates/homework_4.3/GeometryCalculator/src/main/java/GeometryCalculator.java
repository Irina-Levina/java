import net.sf.saxon.expr.Component;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {

        return Math.PI*Math.pow(Math.abs(radius),2.0);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (Math.PI*(Math.pow(Math.abs(radius),3.0)))/3*4;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return (!((a + b) < c)) && (!((a + c) < b)) && (!((c + b) < a)) && a != 0 && b != 0 && c != 0;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c))
        {
            double p = (a + b + c)/2;
            return Math.sqrt(p*(p-a)*(p-b)*(p-c));
            }
        else
        {return -1;}
    }
}
