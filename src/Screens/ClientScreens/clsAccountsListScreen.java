package Screens.ClientScreens;

import CORE.Bank;
import CORE.clsAccount.enAccountState;
import CORE.clsAccount.enAccountType;
import Screens.MainScreens.Main_Screen;

public class clsAccountsListScreen extends Main_Screen {
    public static void Show() {
        DrawScreenHeader("\t     A c c o u n t s   L i s t   S c r e e n");
        Display_All_Accounts();
    }

    public static void Display_All_Accounts() {

        System.out.println("\n\t\t     -----------------------------------------------------------------------\n");
        System.out.println("\t\t\t\t     L i s t  o f  < " + Bank.TOTAL_ACCOUNTS + " >  A c c o u n t ( s )\n");
        System.out.println("\t\t     -----------------------------------------------------------------------");
        System.out.printf("\t\t     | %-10s | %-15s | %-10s | %-10s | %-10s |\n",
                "A_Number", "Full Name", "A_State", "A_Type", "A_Balance");
        System.out.println("\t\t     -----------------------------------------------------------------------");

        for (int i = 0; i < Bank.Client_List.size(); i++) {
            for (int j = 0; j < Bank.Client_List.get(i).Accounts.size(); j++) {
                String A_Number = Bank.Client_List.get(i).Accounts.get(j).GetAccount_Number();
                String Full_name = Bank.Client_List.get(i).GetFirstName() + " " + Bank.Client_List.get(i).GetLastName();
                enAccountState A_State = Bank.Client_List.get(i).Accounts.get(j).GetAccount_State();
                enAccountType A_Type = Bank.Client_List.get(i).Accounts.get(j).GetAccount_Type();
                double A_Balance = Bank.Client_List.get(i).Accounts.get(j).GetAccount_Balance();
                System.out.printf("\t\t     | %-10s | %-15s | %-10s | %-10s | %-10s |\n",
                        A_Number, Full_name, A_State, A_Type, A_Balance);
            }

        }
        System.out.println("\t\t     -----------------------------------------------------------------------");
    }
}