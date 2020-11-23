import java.util.*;

public class ATM {
    private final ArrayList<Integer> availableBills = new ArrayList<>(Arrays.asList(100, 50, 20, 10));
    private TreeMap<Integer, Integer> billsQty;
    private TreeMap<Integer, Integer> billsQtyCopy;

    public ATM(ArrayList<Integer> availableBills) {
        this.billsQty = new TreeMap<>();

        for (int i = 0; i < availableBills.size(); i++) {
            this.billsQty.put(this.availableBills.get(i), availableBills.get(i));
        }
    }

    public void calculateAmount(TreeMap<Integer, Integer> withdrawList, Integer value, Integer billIndex) {
        if (value == 0)
            return;

        if (billIndex > 3) {
            this.billsQty = this.billsQtyCopy;
            withdrawList.clear();

            return;
        }

        Integer billValue = this.availableBills.get(billIndex);
        Integer billQty = this.billsQty.get(billValue);
        Integer amountOfBillsToWithdraw = value / billValue;
        int newValue = value % billValue;

        if (billQty != -1) {
            if (amountOfBillsToWithdraw > billQty) {
                amountOfBillsToWithdraw = billQty;
                newValue = value - (amountOfBillsToWithdraw * billValue);
            }

            this.billsQty.put(billValue, billQty - amountOfBillsToWithdraw);
        }

        if (amountOfBillsToWithdraw > 0)
            withdrawList.put(billValue, amountOfBillsToWithdraw);

        this.calculateAmount(withdrawList, newValue, billIndex + 1);
    }

    public String withdrawBills(Integer value) {
        if (value % 10 != 0)
            return "Withdraw failed. Available bills are 10, 20, 50, 100.\n";

        StringBuilder formattedBills;
        TreeMap<Integer, Integer> withdrawList = new TreeMap<>();

        this.billsQtyCopy = new TreeMap<>(this.billsQty);

        this.calculateAmount(withdrawList, value, 0);

        if (withdrawList.size() == 0) {
            formattedBills = new StringBuilder("Sorry, there are not enough bills in the ATM at the moment!\n");
        } else {
            formattedBills = new StringBuilder("Returning...\n");

            for (Map.Entry<Integer, Integer> bill : withdrawList.entrySet()) {
                formattedBills.append(bill.getValue()).append(" x $").append(bill.getKey()).append("\n");
            }
        }

        return formattedBills.toString();
    }
}
