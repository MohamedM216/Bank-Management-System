// package Screens.EmployeeScreens;

// import FK_Lib.clsInput;
// import FK_Lib.clsUtil;
// import Screens.MainScreens.Main_Screen;
// import CORE.Employee;

// public class clsDeleteEmployeeScreen extends Main_Screen {

//     public static void Reset() {
//         clsUtil.Clear();
//         Main_Screen.DrawScreenHeader("\t\tD e l e t e  E m p l o y e e  S c r e e n");
//     }

//     public static void DeleteEmployee() {

//         Employee employee = Employee.Find(clsInput.ReadText("\nEnter Username or Full Name: "));

//         if (!employee.IsEmpty()) {
//             clsUtil.PrintEmployee(employee);
//             char answer = clsInput.ReadAnswer("\nAre you sure you want to delete this employee?\n");
//             if (answer == 'Y' || answer == 'y') {
//                 employee.Set_Mark_For_Delete(true);
//                 Reset();
//                 System.out.println("\nDeletion done successfully\n");

//             } else {
//                 Reset();
//                 System.out.println("\nDeletion canceled successfully\n");
//             }

//         } else {
//             Reset();
//             System.out.println("\n\tThis Employee doesn't exist!\n");
//         }

//     }

//     public static void Show() {
//         Main_Screen.DrawScreenHeader("\t\tD e l e t e  E m p l o y e e  S c r e e n");
//         DeleteEmployee();
//     }
// }
package Screens.EmployeeScreens;

import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;
import CORE.Bank;
import CORE.Employee;
import java.util.Scanner;

public class clsDeleteEmployeeScreen extends Main_Screen {

    public static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tD e l e t e  E m p l o y e e  S c r e e n");
    }

    public static void DeleteEmployee() {
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

                char answer = clsInput.ReadAnswer("\nAre you sure you want to delete this employee?\n");
                if (answer == 'Y' || answer == 'y') {
                    employee.Set_Mark_For_Delete(true);
                    System.out.println("\nDeletion done successfully\n");

                } else {
                    System.out.println("\nDeletion canceled successfully\n");
                }
                return;
            }
            Reset();
            System.out.println("\n\tThis Employee doesn't exist! Try again.\n");
        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tD e l e t e  E m p l o y e e  S c r e e n");
        DeleteEmployee();
    }
}
