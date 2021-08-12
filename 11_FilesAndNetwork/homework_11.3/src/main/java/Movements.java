import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;


public class Movements {

    List<Movement> movementList;


    public Movements(String pathMovementsCsv) {
        try {
            movementList = beanBuilder(Paths.get(pathMovementsCsv), Movement.class);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public List<Movement> beanBuilder(Path path, Class clazz) throws Exception {

        ColumnPositionMappingStrategy ms = new ColumnPositionMappingStrategy();
        ms.setType(clazz);

        Reader reader = Files.newBufferedReader(path);
        CsvToBean cb = new CsvToBeanBuilder(reader)
                .withType(clazz)
                .withSkipLines(1)
                .withMappingStrategy(ms)
                .build();

        setMovementList(cb.parse());
        reader.close();
        return getMovementList();
    }

    public void setMovementList(List<Movement> csvList) {
        this.movementList = csvList;    }

    public List<Movement> getMovementList() {

        if (movementList != null) return movementList;
        return new ArrayList<Movement>();
    }

    public double getExpenseSum() {

        return movementList.stream().mapToDouble(Movement::getOutgo).sum();
    }

    public double getIncomeSum() {
        return movementList.stream().mapToDouble(Movement::getIncome).sum();
    }


}
