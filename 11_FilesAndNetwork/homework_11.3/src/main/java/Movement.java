
import com.opencsv.bean.CsvBindByPosition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movement {

    @CsvBindByPosition(position = 0)
    private String typeAccount;

    @CsvBindByPosition(position = 1)
    private String numberOfAccount;

    @CsvBindByPosition(position = 2)
    private String currency;

    @CsvBindByPosition(position = 3)
    private String dateOfTransaction;

    @CsvBindByPosition(position = 4)
    private String reference;

    @CsvBindByPosition(position = 5)
    private String description;

    @CsvBindByPosition(position = 6)
    private String income;

    @CsvBindByPosition(position = 7)
    private String outgo;

    private String company;

    public Movement() {

    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public void setNumberOfAccount(String numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public void setOutgo(String outgo) {
        this.outgo = outgo;
    }

    public double getIncome() {

        if (income.contains("\"") | income.contains(",")) {
            income = income.replaceAll("\"", "");
            income = income.replaceAll(",", ".");
        }
        return Double.parseDouble(income);
    }

    public double getOutgo() {

        if (outgo.contains("\"") | outgo.contains(",")) {
            outgo = outgo.replaceAll("\"", "");
            outgo = outgo.replaceAll(",", ".");
        }
        return Double.parseDouble(outgo);
    }

    public String getDescription() {
        return description;
    }

    public void setCompany() {
        String[] fragments = description.split("[\\p{Space}]{3,}");

        if (fragments.length < 3) {
            System.out.println("Wrong line: " + description);
        }

        Pattern pattern = Pattern.compile("[a-zA-Z]{1,}");
        Matcher matcher = pattern.matcher(fragments[1]);

        if (matcher.find()) {
            this.company = fragments[1].substring(matcher.start()).trim();
        } else {
            this.company = "";
        }
    }

    public String getCompanyName() {
        if(company== null){
            setCompany();
        }
        return company;
    }
}
