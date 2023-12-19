package Screens.MainScreens;

import java.util.Scanner;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.ClientScreens.clsAccountsListScreen;
import Screens.ClientScreens.clsClientsListScreen;
import Screens.ClientScreens.clsFindClientScreen;

public class Admin_Main_Menu_Screen extends Main_Screen {
    private static enum enMainMenuChoice {
        _Clients_List, _Accounts_List, _FindClintScreen, _ManageEmployees, _Login_History, Logout
    };

    private static Scanner scanner = new Scanner(System.in);

    private static void GoToMainMenu() {
        System.out.print("\nPress Any Key to Go Back To Main Menu...");
        scanner.nextLine();
        clsUtil.Clear();
        Show();
    }

    private static enMainMenuChoice ReadMainMenuChoice() {
        int Choice = clsInput.ReadInt("\t\t\tEnter Your Choice [1-6] : ", 1, 6);

        switch (Choice) {
            case 1:
                return enMainMenuChoice._Clients_List;
            case 2:
                return enMainMenuChoice._Accounts_List;
            case 3:
                return enMainMenuChoice._FindClintScreen;
            case 4:
                return enMainMenuChoice._ManageEmployees;
            case 5:
                return enMainMenuChoice._Login_History;
            default:
                return enMainMenuChoice.Logout;
        }
    }

    private static void _Preform_Main_Menu_Choice(enMainMenuChoice Choice) {
        clsUtil.Clear();
        switch (Choice) {
            case _Clients_List: {

                clsClientsListScreen.Show();

                GoToMainMenu();
            }
                break;
            case _Accounts_List: {

                clsAccountsListScreen.Show();

                GoToMainMenu();
            }
                break;
            case _FindClintScreen: {
                clsFindClientScreen.Show();
                GoToMainMenu();
            }
                break;
            case _ManageEmployees: {
                Manage_Employees_Menu_Screen.Show();
                Show();
            }
                break;
            case _Login_History: {
                Login_History_Screen.Show();
                GoToMainMenu();
            }
                break;
            case Logout: {

            }
                break;
        }
    }

    public static void Show() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tM a i n  M e n u  S c r e e n \n");

        System.out.println("\n\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\t  ----> M a i n  M e n u  <----    << Admin >>\n");
        System.out.println("\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t[1] Show Clients List.");
        System.out.println("\t\t\t[2] Show Accounts List.");
        System.out.println("\t\t\t[3] Find Client.");
        System.out.println("\t\t\t[4] Manage Employees.");
        System.out.println("\t\t\t[5] Login History.");
        System.out.println("\t\t\t[6] Logout.");
        System.out.println("\n\t\t\t----------------------------------------------------------------\n");

        _Preform_Main_Menu_Choice(ReadMainMenuChoice());
    }
}
