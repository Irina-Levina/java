public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] dimensionalArray = new char[size][size];

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        for (int lineCount = 0; lineCount < dimensionalArray.length; lineCount++)
        {
            for (int element = 0; element < dimensionalArray[lineCount].length; element++)
            {
                if((element == lineCount) | (element == dimensionalArray[lineCount].length - lineCount - 1) ) {
                    dimensionalArray[lineCount][element] = symbol;
                } else {
                    dimensionalArray[lineCount][element] = ' ';
                }
            }
        }
        return dimensionalArray;
    }
}
