package Screens.MainScreens;

import java.util.Scanner;

import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.ClientScreens.clsAccountsListScreen;
import Screens.ClientScreens.clsAddClientScreen;
import Screens.ClientScreens.clsClientsListScreen;
import Screens.ClientScreens.clsDeleteClientScreen;
import Screens.ClientScreens.clsFindClientScreen;
import Screens.ClientScreens.clsUpdateClientScreen;
import Screens.EmployeeScreens.clsEmployeeAccountScreen;

public class Employee_Main_Menu_Screen extends Main_Screen {

    private static Scanner scanner = new Scanner(System.in);

    private static enum enMainMenuChoice {
        _Client_List, _Accounts_List, _NewClintScreen, _UpdateClintScreen, _FindClintScreen, _DeleteClintScreen,
        _My_Account, _Logout
    };

    private static void GoToMainMenu() {

        System.out.print("\n\tPress Any Key to Go Back To Main Menu...");
        scanner.nextLine();
        try {
            clsUtil.Clear();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Show();
    }

    private static enMainMenuChoice ReadMainMenuChoice() {

        int Choice = clsInput.ReadInt("\t\t\tEnter Your Choice [1-8] : ", 1, 8);

        switch (Choice) {
            case 1:
                return enMainMenuChoice._Client_List;
            case 2:
                return enMainMenuChoice._Accounts_List;
            case 3:
                return enMainMenuChoice._NewClintScreen;
            case 4:
                return enMainMenuChoice._UpdateClintScreen;
            case 5:
                return enMainMenuChoice._DeleteClintScreen;
            case 6:
                return enMainMenuChoice._FindClintScreen;
            case 7:
                return enMainMenuChoice._My_Account;
            default:
                return enMainMenuChoice._Logout;
        }
    }

    private static void _Preform_Main_Menu_Choice(enMainMenuChoice Choice) {
        clsUtil.Clear();
        switch (Choice) {
            case _Client_List: {
                clsClientsListScreen.Show();
                GoToMainMenu();
            }
                break;
            case _Accounts_List: {
                clsAccountsListScreen.Show();
                GoToMainMenu();
            }
                break;
            case _NewClintScreen: {
                clsAddClientScreen.Show();

                GoToMainMenu();
            }
                break;
            case _UpdateClintScreen: {
                clsUpdateClientScreen.Show();
                GoToMainMenu();
            }
                break;
            case _FindClintScreen: {
                clsFindClientScreen.Show();
                GoToMainMenu();
            }
                break;
            case _DeleteClintScreen: {
                clsDeleteClientScreen.Show();
                GoToMainMenu();
            }
                break;
            case _My_Account: {
                clsEmployeeAccountScreen.Show();
                Show();
            }
                break;

            default: {

            }
                break;
        }
    }

    public static void Show() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tM a i n  M e n u  S c r e e n \n");

        System.out.println("\n\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\t  ----> M a i n  M e n u  <----  << Employee >>\n");
        System.out.println("\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t[1]  Clients List .");
        System.out.println("\t\t\t[2]  Accounts List .");
        System.out.println("\t\t\t[3]  Add New Client.");
        System.out.println("\t\t\t[4]  Update Client.");
        System.out.println("\t\t\t[5]  Delete Client.");
        System.out.println("\t\t\t[6]  Find Client.");
        System.out.println("\t\t\t[7]  My Account.");
        System.out.println("\t\t\t[8]  Logout.");
        System.out.println("\n\t\t\t----------------------------------------------------------------\n");

        _Preform_Main_Menu_Choice(ReadMainMenuChoice());
    }
}
