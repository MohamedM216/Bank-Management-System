package Screens.MainScreens;

import java.util.Scanner;

import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.Transactions.clsDepositScreen;
import Screens.Transactions.clsTransactionsHistoryScreen;
import Screens.Transactions.clsTransferScreen;
import Screens.Transactions.clsWithdrawScreen;

class Transactions_Main_Menu_Screen extends Main_Screen {

    private static Scanner scanner = new Scanner(System.in);

    private static enum enTransactionsChoice {
        Deposit, Withdraw, Transfer, Total_Balances, Transactions_History, Main_Menu
    };

    private static void _Go_To_Transactions_Menu() {
        System.out.print("\n\tPress Any Key to Go Back To Transactions Menu...");
        scanner.nextLine();
        clsUtil.Clear();
        Show();
    }

    private static enTransactionsChoice _Read_TransactionsMenu_Choice() {
        int Choice = clsInput.ReadInt("\t\t\tEnter Your Choice [1-5] : ", 1, 5);

        switch (Choice) {
            case 1:
                return enTransactionsChoice.Deposit;
            case 2:
                return enTransactionsChoice.Withdraw;
            case 3:
                return enTransactionsChoice.Transfer;
            case 4:
                return enTransactionsChoice.Transactions_History;
            default:
                return enTransactionsChoice.Main_Menu;

        }

    }

    private static void _Preform_Transactions_Choice(enTransactionsChoice Choice) {
        clsUtil.Clear();
        switch (Choice) {
            case Deposit: {
                clsDepositScreen.Show();
                _Go_To_Transactions_Menu();
            }
                break;
            case Withdraw: {

                clsWithdrawScreen.Show();
                _Go_To_Transactions_Menu();
            }
                break;
            case Transfer: {

                clsTransferScreen.Show();
                _Go_To_Transactions_Menu();
            }
                break;
            case Transactions_History: {
                clsTransactionsHistoryScreen.Show();
                _Go_To_Transactions_Menu();
            }
                break;
            default: {

            }

        }

    }

    public static void Show() {
        clsUtil.Clear();
        Admin_Main_Menu_Screen.DrawScreenHeader("\tT r a n s a c t i o n s  M e n u e  S c r e e n\n");

        System.out.println("\n\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\tT r a n s a c t i o n s  M e n u \n");
        System.out.println("\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t[1] Deposit.");
        System.out.println("\t\t\t[2] Withdraw.");
        System.out.println("\t\t\t[3] Transfer.");
        System.out.println("\t\t\t[4] Transactions History.");
        System.out.println("\t\t\t[5] Main Menu.");
        System.out.println("\t\t\t----------------------------------------------------------------");

        _Preform_Transactions_Choice(_Read_TransactionsMenu_Choice());

    }

}