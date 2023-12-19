package Screens.MainScreens;

import java.util.Scanner;

import CORE.Bank;
import CORE.Client;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;

public class Client_Main_Menu_Screen extends Main_Screen {

    private static Scanner scanner = new Scanner(System.in);

    private static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tU p d a t e  C l i e n t  S c r e e n");
    }

    private static enum enChoice {
        _Display_Account, _Update_Account, _Transactions, _Logout
    };

    public static Client ReadClient(Client Client_To_Read) {

        Reset();
        Client_To_Read.SetFirstName(clsInput.ReadText("Enter First Name : "));
        Reset();
        Client_To_Read.SetLastName(clsInput.ReadText("Enter Last Name : "));
        Reset();
        Client_To_Read.SetPhone(clsInput.ReadText("\nEnter Phone Number : "));
        Reset();
        Client_To_Read.SetUsername(clsInput.ReadText("Enter Username : "));
        Reset();
        Client_To_Read.SetPassword(clsInput.ReadText("Enter Password : "));
        Reset();
        // ========================

        return Client_To_Read;
    }

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

    private static void _Go_To_Main_Menu() {
        System.out.print("\n\tPress Any Key to Go Back To Main Menu...");
        scanner.nextLine();
        clsUtil.Clear();
        Show();
    }

    private static enChoice _Read_Main_Menu_Choice() {
        int Choice = clsInput.ReadInt("\t\t\tEnter Your Choice [1-4] : ", 1, 4);

        switch (Choice) {
            case 1:
                return enChoice._Display_Account;
            case 2:
                return enChoice._Update_Account;
            case 3:
                return enChoice._Transactions;
            default:
                return enChoice._Logout;
        }

    }

    private static void _Preform_Main_Menu_Choice(enChoice Choice) {
        clsUtil.Clear();
        switch (Choice) {
            case _Display_Account: {
                for (int i = 0; i < Bank.CurrentClient.Accounts.size(); i++) {
                    if (Bank.CurrentClient.Accounts.get(i).GetAccount_Number().equals(Bank.CurrentAccountNumber)) {
                        _Print(Bank.CurrentClient, i);
                    }
                }

                _Go_To_Main_Menu();
            }
                break;
            case _Update_Account: {
                Bank.CurrentClient = ReadClient(Bank.CurrentClient);
                Bank.CurrentClient.Save();
                _Print(Bank.CurrentClient, Bank.CurrentAccountNumber_Index);
                _Go_To_Main_Menu();
            }
                break;
            case _Transactions: {
                Transactions_Main_Menu_Screen.Show();
                Show();
            }
                break;
            case _Logout: {

            }
        }
    }

    public static void Show() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tM a i n  M e n u  S c r e e n \n");

        System.out.println("\n\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\t  ----> M a i n  M e n u  <----    << Client >>\n");
        System.out.println("\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t[1]  Display Account.");
        System.out.println("\t\t\t[2]  Update Account.");
        System.out.println("\t\t\t[3]  Transactions.");
        System.out.println("\t\t\t[4]  Logout.");
        System.out.println("\n\t\t\t----------------------------------------------------------------\n");

        _Preform_Main_Menu_Choice(_Read_Main_Menu_Choice());
    }
}
