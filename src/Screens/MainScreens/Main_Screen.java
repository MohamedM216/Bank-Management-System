package Screens.MainScreens;

import java.time.LocalDate;

import CORE.Bank;

public abstract class Main_Screen {

    public static void DrawScreenHeader(String Screen_Name) {
        System.out.println("\t\t ================================================================================");
        System.out.println("\n\t\t\t" + Screen_Name);
        System.out.println("\t\t ================================================================================");

        // System.out.println();//UserName
        System.out.println(" ------------------------------");
        if (!Bank.CurrentClient.IsEmpty()) {
            System.out.println("      Date            : " + LocalDate.now());// System Date
            System.out.println("      Current Client  : " + Bank.CurrentClient.GetFirstName() + " "
            + Bank.CurrentClient.GetLastName());
            System.out.println("      Account Number  : " + Bank.CurrentAccountNumber);
        } else {
            System.out.println("      Date         : " + LocalDate.now());// System Date
            System.out.println(
                    "      Current User : " + Bank.CurrentEmployee.GetFirstName() + " "
                            + Bank.CurrentEmployee.GetLastName());

        }
        System.out.println("\t------------------------------");
    }
}
