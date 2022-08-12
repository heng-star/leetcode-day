package src.java.test.Interfacetets;

import com.sun.corba.se.spi.orb.ParserImplBase;
import junit.runner.StandardTestSuiteLoader;

public class Extendx {
    public static void main(String[] args) {
        // 给一个有普通收入、工资收入和享受国务院特殊津贴的小伙伴算税:
        Income[] incomes = new Income[] {
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };

        Income i1=new Income(3000);
//        i1.
        Income i2=new Salary(6000);
//        i2.
        Income i3=new StateCouncilSpecialAllowance(60000);

        System.out.println(totalTax(i1,i2,i3));
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income: incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

class Income {
    final int base=18;
    int year;
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }

    void init(){
        year=2020;
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    public void add(int v){
        this.income+=v;
    }

    @Override
    public double getTax() {
        return 0;
    }
}
