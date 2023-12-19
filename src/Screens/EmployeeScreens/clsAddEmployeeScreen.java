package Screens.EmployeeScreens;

import CORE.Employee;
import Screens.MainScreens.Main_Screen;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;

public class clsAddEmployeeScreen extends Main_Screen {

    public static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tA d d  E m p l o y e e  S c r e e n");

    }

    public static Employee Read(String FirstName, String LastName) {
        Employee employee = Employee._Get_Employee_To_Add();

        employee.SetFirstName(FirstName);
        Reset();
        employee.SetLastName(LastName);
        Reset();
        employee.SetUsername(clsInput.ReadText("\n\nEnter Username: "));
        Reset();
        employee.SetPassword(clsInput.ReadText("\n\nEnter Password: "));
        Reset();
        employee.SetPhone(clsInput.ReadText("\n\nEnter Phone: "));
        Reset();
        employee.SetAddress(clsInput.ReadText("\n\nEnter Address: "));
        Reset();
        employee.SetPosition(clsInput.ReadText("\n\nEnter Position: "));
        Reset();
        employee.SetGraduated_Collage(clsInput.ReadText("Enter Graduated Collage"));
        Reset();
        employee.SetYear_Of_Graduation(clsInput.ReadText("\n\nEnter Year of Graduation: "));
        Reset();
        employee.SetTotal_Grade(clsInput.ReadText("\n\nEnter Total Grade: "));
        Reset();

        return employee;
    }

    public static void AddNewEmployee() {
        String FirstName = clsInput.ReadText("\nEnter First Name : ");
        String LastName = clsInput.ReadText("\nEnter Last Name : ");
        String FullName = FirstName + " " + LastName;
        // --------------
        if (!Employee.IsExist(FullName)) {
            Employee employee = Read(FirstName, LastName);
            System.out.println("New Employee Added Successfully!\n");
            clsUtil.PrintEmployee(employee);
            employee.Save();
        } else {
            Reset();
            System.out.println("\n\tThis Employee already exists!");
        }
        // --------------

    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tA d d  E m p l o y e e  S c r e e n");
        AddNewEmployee();
    }

}