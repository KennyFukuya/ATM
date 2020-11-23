import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    @Test
    void withdrawBills() {
        // unlimited amount of bills
        ATM unlimitedAtm = new ATM(new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1)));
        assertEquals("Returning...\n1 x $10\n", unlimitedAtm.withdrawBills(10), "Should return a single $10 bill");
        assertEquals("Returning...\n2 x $20\n", unlimitedAtm.withdrawBills(40), "Should return two $20 bills");
        assertEquals("Returning...\n1 x $50\n", unlimitedAtm.withdrawBills(50), "Should return a single $50 bill");
        assertEquals("Returning...\n1 x $100\n", unlimitedAtm.withdrawBills(100), "Should return a single $100 bill");
        assertEquals("Returning...\n2 x $20\n1 x $50\n1 x $100\n", unlimitedAtm.withdrawBills(190), "Should return a single $100, one $50 and two $20");
        assertEquals("Withdraw failed. Available bills are 10, 20, 50, 100.\n", unlimitedAtm.withdrawBills(15), "Invalid value to withdraw");

        //limited amount of bills
        ATM limitedAtm = new ATM(new ArrayList<Integer>(Arrays.asList(2, 4, 1, 0)));
        assertEquals("Returning...\n3 x $50\n2 x $100\n", limitedAtm.withdrawBills(350), "Should return two $100 and three 50 bills");
        assertEquals("Sorry, there are not enough bills in the ATM at the moment!\n", limitedAtm.withdrawBills(350), "Should abort operation when there are not enough money in the ATM");
        assertEquals("Returning...\n1 x $20\n1 x $50\n", limitedAtm.withdrawBills(70), "Should return a one $50 and one $20 bill");
        assertEquals("Sorry, there are not enough bills in the ATM at the moment!\n", limitedAtm.withdrawBills(110), "The ATM is out of money");
    }
}