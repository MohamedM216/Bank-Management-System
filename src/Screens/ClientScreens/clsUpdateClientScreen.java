package Screens.ClientScreens;

import CORE.Client;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;

public class clsUpdateClientScreen extends Main_Screen {
    private static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tU p d a t e  C l i e n t  S c r e e n");
    }

    private static void Print(Client Object) {
        // No GUI Inside Core Class
        System.out.println("\n\t\t\t--------------------->> Client Card <<---------------------");
        System.out.println("\t\t\t   ID               : " + Object.GetID());
        System.out.println("\t\t\t   Full Name        : " + Object.GetFirstName() + " " + Object.GetLastName());
        System.out.println("\t\t\t   Phone            : " + Object.GetPhone());
        System.out.println("\t\t\t   Username         : " + Object.GetUsername());
        System.out.println("\t\t\t   Password         : " + Object.GetPassword());
        System.out.println("\t\t\t-----------------------------------------------------------");
    }

    public static Client ReadClient(Client Client_To_Read) {

        Reset();
        Client_To_Read.SetFirstName(clsInput.ReadText("Enter First Name : "));
        Reset();
        Client_To_Read.SetLastName(clsInput.ReadText("Enter Last Name : "));
        Reset();
        Client_To_Read.SetPhone(clsInput.ReadText("\nEnter Phone Number : "));
        Reset();
        Client_To_Read.SetUsername(clsInput.ReadText("Enter Username : "));
        Reset();
        Client_To_Read.SetPassword(clsInput.ReadText("Enter Password : "));
        Reset();
        // ========================

        return Client_To_Read;
    }

    private static void UpdateClient() {
        String FullName_Or_AccountNumber = clsInput.ReadText("Enter Full Name Or Account Number  : ");
        char Answer;
        Reset();
        if (Client.IsExist(FullName_Or_AccountNumber)) {
            Client Client_To_Update = Client.Find(FullName_Or_AccountNumber);
            Print(Client_To_Update);
            Answer = clsInput.ReadAnswer("\n\nAre You Sure You Want To Update This Account[Y-N] : ");
            if (Answer == 'Y' || Answer == 'y') {

                Client_To_Update = ReadClient(Client_To_Update);
                System.out.println("\nClient Updated Successfully :-) :-)");
                Print(Client_To_Update);
                Client_To_Update.Save();
            } else {
                Reset();
                System.out.println("\nProcess Has Been Canceled :-) :-)");
            }
        } else {
            System.out.println("\n\tClient Not Found!!");
        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tU p d a t e  C l i e n t  S c r e e n");
        UpdateClient();

    }

}
