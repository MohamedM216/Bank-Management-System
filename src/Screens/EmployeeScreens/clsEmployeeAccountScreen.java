package Screens.EmployeeScreens;

import java.util.Scanner;

import CORE.Bank;
import CORE.Employee;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;

public class clsEmployeeAccountScreen extends Main_Screen {

    private static Scanner scanner = new Scanner(System.in);

    private static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tU p d a t e  A c c o u n t  S c r e e n");
    }

    private static enum enChoice {
        _Display_Account, _Update_Account, _Logout
    };

    private static void Print(Employee Object) {
        // No GUI Inside Core Class
        System.out.println("\n\t\t\t--------------------->> Employee Card <<---------------------");
        System.out.println("\t\t\t   ID                 : " + Object.GetID());
        System.out.println("\t\t\t   Full Name          : " + Object.GetFirstName() + " " + Object.GetLastName());
        System.out.println("\t\t\t   Phone              : " + Object.GetPhone());
        System.out.println("\t\t\t   Username           : " + Object.GetUsername());
        System.out.println("\t\t\t   Password           : " + Object.GetPassword());
        System.out.println("\t\t\t   Address            : " + Object.GetAddress());
        System.out.println("\t\t\t   Position           : " + Object.GetPosition());
        System.out.println("\t\t\t   GraduatedCollage   : " + Object.GetGraduated_Collage());
        System.out.println("\t\t\t   Year Of Graduation : " + Object.GetYear_Of_Graduation());
        System.out.println("\t\t\t   Total Grade        : " + Object.GetTotal_Grade());
        System.out.println("\t\t\t--------------------------------------------------------------");
    }

    public static Employee ReadEmployee(Employee Employee_To_Read) {

        Reset();
        Employee_To_Read.SetPosition(clsInput.ReadText("\nEnter Position : "));
        Reset();
        Employee_To_Read.SetAddress(clsInput.ReadText("\nEnter Address : "));
        Reset();
        // ========================

        return Employee_To_Read;
    }

    private static void _Go_To_Main_Menu() {
        System.out.print("\n\tPress Any Key to Go Back To Main Menu...");
        scanner.nextLine();
        clsUtil.Clear();
        Show();
    }

    private static enChoice _Read_Main_Menu_Choice() {
        int Choice = clsInput.ReadInt("\t\t\tEnter Your Choice [1-3] : ", 1, 3);

        switch (Choice) {
            case 1:
                return enChoice._Display_Account;
            case 2:
                return enChoice._Update_Account;
            default:
                return enChoice._Logout;
        }

    }

    private static void _Preform_Main_Menu_Choice(enChoice Choice) {
        clsUtil.Clear();
        switch (Choice) {
            case _Display_Account: {

                Print(Bank.CurrentEmployee);
                _Go_To_Main_Menu();
            }
                break;
            case _Update_Account: {
                Bank.CurrentEmployee = ReadEmployee(Bank.CurrentEmployee);
                Bank.CurrentEmployee.Save();
                Reset();
                Print(Bank.CurrentEmployee);
                _Go_To_Main_Menu();
            }
                break;
            case _Logout: {

            }

        }

    }

    public static void Show() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tM y  A c c o u n t  S c r e e n \n");

        System.out.println("\n\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t\t     ----> M y  A c c o u n t  <----    << Employee >>\n");
        System.out.println("\t\t\t----------------------------------------------------------------\n");
        System.out.println("\t\t\t[1]  Display Account.");
        System.out.println("\t\t\t[2]  Update Account.");
        System.out.println("\t\t\t[3]  Main Menu.");
        System.out.println("\n\t\t\t----------------------------------------------------------------\n");

        _Preform_Main_Menu_Choice(_Read_Main_Menu_Choice());

    }

}
