import java.util.Scanner;

public class BudgetCalculator {
    private int age;
    private String maritalStatus;
    private String dependentStatus;
    private String carOwnership;
    private double monthlyIncome;
    private double suggestedExpenses;
    private double wants;
    private double needs;
    private double shortTermSavings;
    private double mediumTermSavings;
    private double longTermSavings;

    public BudgetCalculator() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setDependentStatus(String dependentStatus) {
        this.dependentStatus = dependentStatus;
    }

    public String getDependentStatus() {
        return dependentStatus;
    }

    public void setCarOwnership(String carOwnership) {
        this.carOwnership = carOwnership;
    }

    public String getCarOwnership() {
        return carOwnership;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void calculateSuggestedExpenses() {
        if (maritalStatus.equalsIgnoreCase("single")) {
            if (carOwnership.equalsIgnoreCase("public")) {
                suggestedExpenses = 1760;
            } else if (carOwnership.equalsIgnoreCase("owner")) {
                suggestedExpenses = 2290;
            }
        } else if (maritalStatus.equalsIgnoreCase("married")) {
            if (dependentStatus.equalsIgnoreCase("without")) {
                suggestedExpenses = 4110;
            } else if (dependentStatus.equalsIgnoreCase("with 1 child")) {
                suggestedExpenses = 5360;
            } else if (dependentStatus.equalsIgnoreCase("with 2 children")) {
                suggestedExpenses = 6110;
            }
        } else if (maritalStatus.equalsIgnoreCase("senior")) {
            if (dependentStatus.equalsIgnoreCase("single")) {
                suggestedExpenses = 2330;
            } else if (dependentStatus.equalsIgnoreCase("couple")) {
                suggestedExpenses = 3020;
            }
        } else if (maritalStatus.equalsIgnoreCase("single parent")) {
            if (dependentStatus.equalsIgnoreCase("with 1 child")) {
                suggestedExpenses = 4220;
            } else if (dependentStatus.equalsIgnoreCase("with 2 children")) {
                suggestedExpenses = 4940;
            }
        }
    }

    public void calculateBudgetAllocation() {
        // Allocate budget based on income
        shortTermSavings = monthlyIncome * 0.1;
        mediumTermSavings = monthlyIncome * 0.1;
        longTermSavings = monthlyIncome * 0.1;
        wants = monthlyIncome * 0.25;
        needs = monthlyIncome * 0.45;
    }

    public void compareBudgetWithExpenses() {
        double totalWantsAndNeeds = wants + needs;

        if (totalWantsAndNeeds > suggestedExpenses) {
            System.out.println("You have exceeded your budget.");
        } else {
            System.out.println("You are within your budget.");
        }
    }

    public static void main(String[] args) {
        BudgetCalculator budget = new BudgetCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Belanjawanku Reference Budget in Johor Bahru");
        System.out.println("Single P.T.U: RM1760");
        System.out.println("Single C.O: RM2290");
        System.out.println("Married w/o children: RM4110");
        System.out.println("Married (1 child): RM5360");
        System.out.println("Married (2 children): RM6100");
        System.out.println("Senior single: RM2330");
        System.out.println("Senior couple: RM3020");
        System.out.println("Single Parent (1 child) : RM4200");
        System.out.println("Single Parent (2 children): RM4940");

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        budget.setAge(age);

        System.out.print("Enter your marital status (single, married, senior, single parent): ");
        String maritalStatus = scanner.next();
        budget.setMaritalStatus(maritalStatus);

        System.out.print("Enter your dependent status (without, with 1 child, with 2 children, couple): ");
        String dependentStatus = scanner.next();
        budget.setDependentStatus(dependentStatus);

        System.out.print("Enter your car ownership status (public, owner): ");
        String carOwnership = scanner.next();
        budget.setCarOwnership(carOwnership);

        System.out.print("Enter your monthly income: RM");
        double monthlyIncome = scanner.nextDouble();
        budget.setMonthlyIncome(monthlyIncome);

        budget.calculateSuggestedExpenses();
        budget.calculateBudgetAllocation();
        budget.compareBudgetWithExpenses();

        scanner.close();
    }
}