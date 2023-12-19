package Screens.EmployeeScreens;

import CORE.Bank;
import Screens.MainScreens.Main_Screen;

public class clsEmployeesListScreen extends Main_Screen {
        public static void Show() {
                Main_Screen.DrawScreenHeader("\t\tE m p l o y e e s  L i s t  S c r e e n");
                Display_All_Employees();
        }

        public static void Display_All_Employees() {
                System.out.println(
                                "\n  --------------------------------------------------------------------------------------------------------------------------\n");
                System.out.println("\t\t\t\t        L i s t  o f  < " + Bank.Employee_List.size()
                                + " >  E  m p l o y e e ( s )\n");
                System.out.println(
                                "  --------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("  | %-4s | %-18s | %-12s | %-8s | %-10s | %-8s | %-12s | %-12s | %-11s |\n",
                                "ID", "Full Name", "Phone", "Username", "Address", "Position", "Grad College",
                                "Year of Grad",
                                "Total Grade");

                System.out.println(
                                "\n  --------------------------------------------------------------------------------------------------------------------------");

                for (int i = 0; i < Bank.Employee_List.size(); i++) {
                        String id = Bank.Employee_List.get(i).GetID();
                        String fullname = Bank.Employee_List.get(i).GetFirstName() + " "
                                        + Bank.Employee_List.get(i).GetLastName();
                        String phone = Bank.Employee_List.get(i).GetPhone();
                        String username = Bank.Employee_List.get(i).GetUsername();
                        String address = Bank.Employee_List.get(i).GetAddress();
                        String position = Bank.Employee_List.get(i).GetPosition();
                        String grad_college = Bank.Employee_List.get(i).GetGraduated_Collage();
                        String year_grad = Bank.Employee_List.get(i).GetYear_Of_Graduation();
                        String total_grade = Bank.Employee_List.get(i).GetTotal_Grade();

                        System.out.printf("  | %-4s | %-18s | %-12s | %-8s | %-10s | %-8s | %-12s | %-12s | %-11s |\n",
                                        id, fullname, phone, username, address, position, grad_college, year_grad,
                                        total_grade);
                }

                System.out.println(
                                "  --------------------------------------------------------------------------------------------------------------------------");
        }

}