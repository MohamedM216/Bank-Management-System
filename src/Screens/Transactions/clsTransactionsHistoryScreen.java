package Screens.Transactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import CORE.clsAccount;
import CORE.Bank;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;

public class clsTransactionsHistoryScreen extends Main_Screen {
    public static ArrayList<String> Records = new ArrayList<>();

    public static ArrayList<String> Get_Records() {
        String Line;
        try (BufferedReader BR = new BufferedReader(new FileReader(Bank.TRANSACTIONS_FILE))) {
            while ((Line = BR.readLine()) != null) {
                Records.add(Line);
            }
        } catch (IOException e) {
            System.out.println("Transactions File Not Found");
        }
        return Records;
    }

    public static void Draw_Transactions_Table() {
        // Type&&&&Amount&&&&Time&&&&Date&&&&From_AccountNumber[&&&&To_AccountNumber]
        System.out.println("\n\t\t     --------------------------------------------------------------");
        System.out.println("\t\t\t\t D e p o s i t  &  W i t h d r a w  T a b l e    ");
        System.out.println("\t\t     --------------------------------------------------------------");
        System.out.printf("\t\t     | %-10s| %-10s | %-7s | %-10s | %-10s |\n", "A_Number", "Type", "Amount", "Time",
                "Date");
        System.out.println("\t\t     --------------------------------------------------------------");
        for (int i = 0; i < Records.size(); i++) {
            String[] Data = Records.get(i).split(Bank.TRANSACTION_DELIMITER);
            if (Data[4].equals(Bank.CurrentAccountNumber)
                    && !(Data[0].equals(clsUtil.enTransactionType.TRANSFER.toString()))) {

                System.out.printf("\t\t     | %-10s| %-10s | %-7s | %-10s | %-10s |\n", Data[4], Data[0], Data[1],
                        Data[3], Data[2]);
                System.out.println("\t\t     --------------------------------------------------------------");
            }
        }
    }

    public static void Draw_Transfer_Table() {
        // Type&&&&Amount&&&&Time&&&&Date&&&&From_AccountNumber[&&&&To_AccountNumber]
        System.out.println("\n\n ------------------------------------------------------");
        System.out.println("\t\tT r a n s f e r    T a b l e    ");
        System.out.println(" ------------------------------------------------------");
        System.out.printf(" | %-6s| %-6s | %-7s | %-10s | %-10s |\n", "Form ", "To", "Amount", "Time", "Date");
        System.out.println(" ------------------------------------------------------");
        for (int i = 0; i < Records.size(); i++) {
            String[] Data = Records.get(i).split(Bank.TRANSACTION_DELIMITER);
            if (Data[4].equals(Bank.CurrentAccountNumber)
                    && Data[0].equals(clsUtil.enTransactionType.TRANSFER.toString())) {
                System.out.printf(" | %-6s| %-6s | %-7s | %-10s | %-10s |\n", Data[4], Data[5], Data[1], Data[3],
                        Data[2]);
                System.out.println(" ------------------------------------------------------");
            }
        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\tT r a n s f e r  H i s t o r y  S c r e e n");
        if (Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index)
                .GetAccount_State() == clsAccount.enAccountState.ACTIVE) {
            Records = Get_Records();
            Draw_Transactions_Table();
            Draw_Transfer_Table();
            Records.clear();
        } else {
            System.out.println("Your Account Is Closed");
        }

    }
}
