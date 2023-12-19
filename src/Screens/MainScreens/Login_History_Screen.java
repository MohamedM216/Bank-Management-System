package Screens.MainScreens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import CORE.Bank;

public class Login_History_Screen extends Main_Screen {
    public static ArrayList<String> Get_Login_Records() {
        ArrayList<String> Records = new ArrayList<>();
        String Line;
        try (BufferedReader BR = new BufferedReader(new FileReader(Bank.LOGIN_FILE))) {
            while ((Line = BR.readLine()) != null) {
                Records.add(Line);
            }
        } catch (IOException e) {
            System.out.println("Login File Not Found");
        }
        return Records;
    }

    public static void Draw_Login_Table() {
        ArrayList<String> Records = Get_Login_Records();
        System.out.println("\n\t\t     --------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\t     L i s t  o f  < " + Records.size() + " >  R e c o r d ( s )\n");
        System.out.println("\t\t     --------------------------------------------------------------------------");
        System.out.printf("\t\t     | %-20s| %-10s | %-10s | %-10s | %-10s |\n", "Name", "Username", "Password",
                "Date", "Time");
        System.out.println("\t\t     ------------------------------------------------------------------------");
        for (int i = 0; i < Records.size(); i++) {
            String[] Data = Records.get(i).split(Bank.LOGIN_FILE_DELIMITER);
            System.out.printf("\t\t     | %-20s| %-10s | %-10s | %-10s | %-10s |\n", Data[0], Data[1], Data[2], Data[3],
                    Data[4]);
            System.out.println("\t\t     --------------------------------------------------------------------------");
        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tL o g i n   H i s t o r y  S c r e e n");
        Draw_Login_Table();
    }

}
