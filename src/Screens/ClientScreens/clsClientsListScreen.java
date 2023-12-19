package Screens.ClientScreens;

import CORE.Bank;
import Screens.MainScreens.Main_Screen;

public class clsClientsListScreen extends Main_Screen {

    
    public static void Clients_Table() {
        System.out.println("\n\t\t  ---------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\t    L i s t  o f  < " + Bank.Client_List.size() + " >  C l i e n t ( s )\n");
        System.out.println("\t\t  --------------------------------------------------------------------------------");
        System.out.printf("\t\t  | %-4s | %-15s | %-15s | %-15s | %-15s |\n",
        "ID", "First Name", "Last Name", "Phone", "Username");
        System.out.println("\t\t  --------------------------------------------------------------------------------");
        
        for (int i = 0; i < Bank.Client_List.size(); i++) {
            String id = Bank.Client_List.get(i).GetID();
            String firstName = Bank.Client_List.get(i).GetFirstName();
            String lastName = Bank.Client_List.get(i).GetLastName();
            String phone = Bank.Client_List.get(i).GetPhone();
            String username = Bank.Client_List.get(i).GetUsername();
            
            System.out.printf("\t\t  | %-4s | %-15s | %-15s | %-15s | %-15s |\n",
            id, firstName, lastName, phone, username);
        }
        
        System.out.println("\t\t  --------------------------------------------------------------------------------");
    }
    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tC l i e n t s  L i s t  S c r e e n");
        Clients_Table();
    }

}