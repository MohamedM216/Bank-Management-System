package Screens.ClientScreens;

import CORE.Client;
import FK_Lib.clsInput;
import Screens.MainScreens.Main_Screen;

public class clsFindClientScreen extends Main_Screen {
    private static void _Print(Client Object, int Account_Index) {
        // No GUI Inside Core Class
        System.out.println("\n\n\n\t\t\t--------------------->> Client Card <<---------------------");
        System.out.println("\t\t\t   ID               : " + Object.GetID());
        System.out.println("\t\t\t   Full Name        : " + Object.GetFirstName() + " " + Object.GetLastName());
        System.out.println("\t\t\t   Phone            : " + Object.GetPhone());
        System.out.println("\t\t\t   Username         : " + Object.GetUsername());
        System.out.println("\t\t\t   Password         : " + Object.GetPassword());
        System.out.println("\t\t\t   Account Number   : " + Object.Accounts.get(Account_Index).GetAccount_Number());
        System.out.println(
                "\t\t\t   State Of Account : " + Object.Accounts.get(Account_Index).GetAccount_State().toString());
        System.out.println(
                "\t\t\t   Type Of Account  : " + Object.Accounts.get(Account_Index).GetAccount_Type().toString());
        System.out.println("\t\t\t   Balance          : "
                + Double.toString(Object.Accounts.get(Account_Index).GetAccount_Balance()));
        System.out.println("\t\t\t-----------------------------------------------------------");
    }

    public static void Find_By_Account_Number(String AccountNumber) {
        // If User Entered Account Number

        Client client = (Client) Client.Find_By_Account_Number(AccountNumber);

        if (client.Accounts.size() == 0) {
            _Print(client, 0);
        } else {
            for (int i = 0; i < client.Accounts.size(); i++) {
                if (client.Accounts.get(i).GetAccount_Number().equals(AccountNumber)) {
                    _Print(client, i);
                }
            }

        }
    }

    public static void Find_By_Full_Name(String FullName) {
        Client client = (Client) Client.Find_By_Full_Name(FullName);
        if (client.Accounts.size() == 1) {
            _Print(client, 0);
        } else {
            System.out.println("\nThis Person Has [" + client.Accounts.size() + "] Accounts");
            System.out.println("\n\t\t\t\t--------------");
            for (int i = 1; i <= client.Accounts.size(); i++) {
                System.out.printf("\t\t\t\t  [%d] %s\n", i, client.Accounts.get(i - 1).GetAccount_Number());
            }
            System.out.println("\t\t\t\t--------------\n");
            String AccountNumber = clsInput.ReadText("\nEnter Account Number : ");

            if (Client.IsExist_By_Account_Number(AccountNumber)) {

                for (int i = 0; i < client.Accounts.size(); i++) {
                    if (client.Accounts.get(i).GetAccount_Number().equals(AccountNumber)) {

                        _Print(client, i);
                    }
                }
            } else {
                System.out.println("\n\tInvalid Account Number !");
            }

        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tF i n d  C l i e n t  S c r e e n");
        String Full_Name_Or_Account_Number = clsInput.ReadText("\nEnter Full Name Or Account Number : ");

        // If User Entered Full Name
        if (Client.IsExist_By_Account_Number(Full_Name_Or_Account_Number)) {

            Find_By_Account_Number(Full_Name_Or_Account_Number);
        } else if (Client.IsExist_By_Full_Name(Full_Name_Or_Account_Number)) {

            Find_By_Full_Name(Full_Name_Or_Account_Number);
        } else {
            System.out.println("\n\tClient Not Found!!");
        }

    }
}
