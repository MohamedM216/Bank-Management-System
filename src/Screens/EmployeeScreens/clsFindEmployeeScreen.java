// package Screens.EmployeeScreens;

// import FK_Lib.clsInput;
// import FK_Lib.clsUtil;
// import Screens.MainScreens.Main_Screen;
// import CORE.Employee;

// public class clsFindEmployeeScreen extends Main_Screen {

//     public static void Reset() {
//         clsUtil.Clear();
//         Main_Screen.DrawScreenHeader("\t\tF i n d  E m p l o y e e  S c r e e n");
//     }

//     public static void FindEmployee() {

//          Employee Employee_To_Find = Employee.Find(clsInput.ReadText("\nEnter username or Full Name: "));

//         if (!Employee_To_Find.IsEmpty()) {
//             Reset();
//             clsUtil.PrintEmployee(Employee_To_Find);
//         } else {
//             Reset();
//             System.out.println("\n\tThis Employee doesn't exist! Try again.\n");
//         }
//     }

//     public static void Show() {
//         Main_Screen.DrawScreenHeader("\t\tF i n d  E m p l o y e e  S c r e e n");
//         FindEmployee();
//     }
// }
package Screens.EmployeeScreens;

import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;
import CORE.Employee;
import java.util.Scanner;

public class clsFindEmployeeScreen extends Main_Screen {

    public static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tF i n d  E m p l o y e e  S c r e e n");
    }

    public static void FindEmployee() {
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
                return;
            }
            Reset();
            System.out.println("\n\tThis Employee doesn't exist! Try again.\n");
        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tF i n d  E m p l o y e e  S c r e e n");
        FindEmployee();
    }
}