package Screens.MainScreens;

import java.util.Scanner;

import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.EmployeeScreens.clsAddEmployeeScreen;
import Screens.EmployeeScreens.clsDeleteEmployeeScreen;
import Screens.EmployeeScreens.clsEmployeesListScreen;
import Screens.EmployeeScreens.clsFindEmployeeScreen;
import Screens.EmployeeScreens.clsUpdateEmployeeScreen;

public class Manage_Employees_Menu_Screen extends Main_Screen {

    private static Scanner scanner = new Scanner(System.in);

    private enum enChoice {
        _Employees_List, _AddNewEmployee, _DeleteEmployee, _UpdateEmployee, _FindEmployee, _MainMenu
    };

    private static void _Go_To_Manage_Users_Menu() {
        System.out.print("\n\tPress Any Key to Go Back To Manage Employees Menu...");
        scanner.nextLine();
        clsUtil.Clear();
        Show();
    }

    private static enChoice _Read_ManageEmployees_Choice() {
        int Choice = clsInput.ReadInt("\n\t\t\tEnter Your Choice [ 1 - 6 ] : ", 1, 6);

        switch (Choice) {
            case 1:
                return enChoice._Employees_List;
            case 2:
                return enChoice._AddNewEmployee;
            case 3:
                return enChoice._DeleteEmployee;
            case 4:
                return enChoice._UpdateEmployee;
            case 5:
                return enChoice._FindEmployee;
            default:
                return enChoice._MainMenu;
        }
    }

    private static void _Preform_ManageEmployees_Choice(enChoice Choice) {

        clsUtil.Clear();
        switch (Choice) {
            case _Employees_List: {

                clsEmployeesListScreen.Show();
                _Go_To_Manage_Users_Menu();
            }
                break;
            case _AddNewEmployee: {

                clsAddEmployeeScreen.Show();
                _Go_To_Manage_Users_Menu();
            }
                break;
            case _DeleteEmployee: {
                clsDeleteEmployeeScreen.Show();
                _Go_To_Manage_Users_Menu();
            }
                break;
            case _UpdateEmployee: {
                clsUpdateEmployeeScreen.Show();
                _Go_To_Manage_Users_Menu();
            }
                break;
            case _FindEmployee: {
                clsFindEmployeeScreen.Show();
                _Go_To_Manage_Users_Menu();
            }
                break;

            default: {

            }
                break;
        }

    }

    public static void Show() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tM a n a g e  E m p l o y e e s  S c r e e n\n");
        System.out.println("\n\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\tM a n a g e  E m p l o y e e s  M e n u \n");
        System.out.println("\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t[1] Employees List.");
        System.out.println("\t\t\t[2] Add New Employee.");
        System.out.println("\t\t\t[3] Delete Employee.");
        System.out.println("\t\t\t[4] Update Employee.");
        System.out.println("\t\t\t[5] Find Employee.");
        System.out.println("\t\t\t[6] Main Menu.");
        System.out.println("\n\t\t\t----------------------------------------------------------------\n");
        _Preform_ManageEmployees_Choice(_Read_ManageEmployees_Choice());
    }
}
