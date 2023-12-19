// package Screens.EmployeeScreens;

// import FK_Lib.clsInput;
// import FK_Lib.clsUtil;
// import Screens.MainScreens.Main_Screen;
// import CORE.Employee;

// public class clsUpdateEmployeeScreen extends Main_Screen {
//     public static void Reset() {
//         clsUtil.Clear();
//         Main_Screen.DrawScreenHeader("\t\tU p d a t e  E m p l o y e e  S c r e e n");
//     }

//     private static void Go_Back_To_Update_Menu(Employee employee) {
//         clsInput.ReadText("\n\n\tPress Any Key To Go Back To Update Menu... ");
//         Reset();
//         ShowUpdateMenu(employee);

//     }

//     public static void Preform_Update_Menu_Choice(int choice, Employee employee) {
//         Reset();
//         if (choice == 1) {
//             employee.SetFirstName(clsInput.ReadText("\n\nEnter First Name: "));
//             Go_Back_To_Update_Menu(employee);

//         } else if (choice == 2) {
//             employee.SetLastName(clsInput.ReadText("\n\nEnter Last Name: "));
//             Go_Back_To_Update_Menu(employee);
//         } else if (choice == 3) {
//             employee.SetAddress(clsInput.ReadText("\n\nEnter Address: "));
//             Go_Back_To_Update_Menu(employee);

//         } else if (choice == 4) {
//             employee.SetPhone(clsInput.ReadText("\n\nEnter Phone: "));
//             Go_Back_To_Update_Menu(employee);

//         } else if (choice == 5) {
//             employee.SetPosition(clsInput.ReadText("\n\nEnter Position: "));
//             Go_Back_To_Update_Menu(employee);

//         } else if (choice == 6) {
//             employee.SetUsername(clsInput.ReadText("\n\nEnter Username: "));
//             Go_Back_To_Update_Menu(employee);
//         } else if (choice == 7) {
//             employee.SetGraduated_Collage(clsInput.ReadText("\n\nEnter Graduated Collage : "));
//             Go_Back_To_Update_Menu(employee);

//         } else if (choice == 8) {
//             employee.SetTotal_Grade(clsInput.ReadText("\n\nEnter Total Grade: "));
//             Go_Back_To_Update_Menu(employee);

//         } else if (choice == 9) {
//             employee.SetYear_Of_Graduation(clsInput.ReadText("\n\nEnter Year of Graduation: "));
//             Go_Back_To_Update_Menu(employee);

//         } else {

//             employee.Save();
//             Reset();
//             System.out.println("\nEmployee Updated Successfully\n");
//             clsUtil.PrintEmployee(employee);
//         }

//     }

//     public static void ShowUpdateMenu(Employee employee) {
//         Reset();
//         System.out.println("\n\n\t\t\t\t-----------------------------------------------------------");
//         System.out.println("\n\t\t\t\t           ---- >> U p d a t e  M e n u  << ----");
//         System.out.println("\n\t\t\t\t-----------------------------------------------------------");
//         System.out.println("\t\t\t\t [1] First Name");
//         System.out.println("\t\t\t\t [2] Last Name");
//         System.out.println("\t\t\t\t [3] Address");
//         System.out.println("\t\t\t\t [4] Phone");
//         System.out.println("\t\t\t\t [5] Position");
//         System.out.println("\t\t\t\t [6] Username");
//         System.out.println("\t\t\t\t [7] Graduated Collage");
//         System.out.println("\t\t\t\t [8] Total Grade");
//         System.out.println("\t\t\t\t [9] Year Of Graduation");
//         System.out.println("\t\t\t\t [10] Exit");
//         System.out.println("\t\t\t\t-----------------------------------------------------------");
//         Preform_Update_Menu_Choice(clsInput.ReadInt("\nEnter Your Choice [1 - 10] : ", 1, 10), employee);

//     }

//     public static void UpdateEmployee() {

//         Employee employee = Employee.Find(clsInput.ReadText("\nEnter username or Full Name: "));

//         if (!employee.IsEmpty()) {
//             clsUtil.PrintEmployee(employee);
//             char answer = clsInput.ReadAnswer("\nAre you sure you want to update this employee? [Y-N] : ");
//             if (answer == 'Y' || answer == 'y') {
//                 ShowUpdateMenu(employee);

//             } else {
//                 System.out.println("\nUpdate Canceled Successfully\n");
//             }
//             return;
//         } else {
//             System.out.println("\n\tThis Employee doesn't exist!\n");
//         }

//     }

//     public static void Show() {
//         Main_Screen.DrawScreenHeader("\t\tU p d a t e  E m p l o y e e  S c r e e n");
//         UpdateEmployee();
//     }
// }

package Screens.EmployeeScreens;

import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;
import CORE.Employee;
import java.util.Scanner;

public class clsUpdateEmployeeScreen extends Main_Screen {

    public static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tU p d a t e  E m p l o y e e  S c r e e n");
    }

    public static int Readchoice(int lower, int higher) {
        System.out.println("Enter number in range [ " + lower + ", " + higher + " ]");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice >= lower && choice <= higher)
            return choice;

        System.out.println("Invalid Choice! Try again\n");
        ;
        return Readchoice(lower, higher);
    }

    public static void UpdateEmployeeChoices(Employee employee) {
        Scanner in = new Scanner(System.in);
        String str = "";
        while (true) {
            System.out.println("\n\tWhich info you need to update:\n");
            System.out.println("\t[1] Update ID\n" +
                    "\t[2] Update First Name\n" +
                    "\t[3] Update Last Name\n" +
                    "\t[4] Update Address\n" +
                    "\t[5] Update Phone\n" +
                    "\t[6] Update Position\n" +
                    "\t[7] Update Username\n" +
                    "\t[8] Update Total Grade\n" +
                    "\t[9] Update Year Of Graduation\n" +
                    "\t[10]Finish\n");

            int choice = Readchoice(1, 10);

            if (choice == 1) {
                System.out.println("Enter ID: ");
                in.nextLine();
                employee.SetID(str);
            } else if (choice == 2) {
                System.out.println("Enter First Name: ");
                in.nextLine();
                employee.SetFirstName(str);
            } else if (choice == 3) {
                System.out.println("Enter Last Name: ");
                in.nextLine();
                employee.SetLastName(str);
            } else if (choice == 4) {
                System.out.println("Enter Address: ");
                in.nextLine();
                employee.SetAddress(str);
            } else if (choice == 5) {
                System.out.println("Enter Phone: ");
                in.nextLine();
                employee.SetPhone(str);
            } else if (choice == 6) {
                System.out.println("Enter Position: ");
                in.nextLine();
                employee.SetPosition(str);
            } else if (choice == 7) {
                System.out.println("Enter Username: ");
                in.nextLine();
                employee.SetUsername(str);
            } else if (choice == 8) {
                System.out.println("Enter Total Grade: ");
                in.nextLine();
                employee.SetTotal_Grade(str);
            } else if (choice == 9) {
                System.out.println("Enter Year of Graduation: ");
                in.nextLine();
                employee.SetYear_Of_Graduation(str);
            } else {
                break;
            }
        }
        employee.Save();
    }

    public static void UpdateEmployee() {
        Scanner in = new Scanner(System.in);
        String str;

        while (true) {
            System.out.print("\nEnter username or Full Name: ");
            str = in.nextLine();

            Employee employee = Employee.Find_By_Fullname(str);
            if (employee == null) {
                employee = (Employee) Employee.Find_By_Username(str);
            }

            if (!employee.IsEmpty()) {
                clsUtil.PrintEmployee(employee);

                char answer = clsInput.ReadAnswer("\nAre you sure you want to update this employee?\n");
                if (answer == 'Y' || answer == 'y') {
                    UpdateEmployeeChoices(employee);
                    System.out.println("\nUpdated Successfully\n");
                } else {
                    System.out.println("\nUpdate Canceled Successfully\n");
                }
                return;
            }
            Reset();
            System.out.println("\n\tThis Employee doesn't exist! Try again.\n");
        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tU p d a t e  E m p l o y e e  S c r e e n");
        UpdateEmployee();
    }
}
