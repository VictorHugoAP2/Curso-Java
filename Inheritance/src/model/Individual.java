package model;

public class Individual extends TaxPayer{
    private Double healthExpenditures;

    public Individual(){
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }
    
    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        Double taxValue;
        if(super.getAnualIncome() < 20000){
            taxValue = super.getAnualIncome() * 0.15;
        }else{
            taxValue = super.getAnualIncome() * 0.25;
        }

        Double refundHealthExpenses = 0.0;
        if(healthExpenditures > 0){
            refundHealthExpenses = healthExpenditures * 0.5;
        }

        return taxValue - refundHealthExpenses;
    }
}
