package Screens.ClientScreens;

import CORE.Bank;
import CORE.Client;
import CORE.clsAccount;
import FK_Lib.clsGlobal;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;

public class clsAddClientScreen extends Main_Screen {
    public static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tA d d  C l i e n t  S c r e e n");
    }

    private static void _Print(Client Object, int Account_Index) {
        // No GUI Inside Core Class
        System.out.println("\n\n\n\t\t\t--------------------->> Client Card <<---------------------");
        System.out.println("\t\t\t   ID               : " + Object.GetID());
        System.out.println("\t\t\t   Full Name        : " + Object.GetFirstName() + " " + Object.GetLastName());
        System.out.println("\t\t\t   Phone            : " + Object.GetPhone());
        System.out.println("\t\t\t   Username         : " + Object.GetUsername());
        System.out.println("\t\t\t   Password         : " + Object.GetPassword());
        System.out.println("\t\t\t   Account Number   : " + Object.Accounts.get(Account_Index).GetAccount_Number());
        System.out.println(
                "\t\t\t   State Of Account : " + Object.Accounts.get(Account_Index).GetAccount_State().toString());
        System.out.println(
                "\t\t\t   Type Of Account  : " + Object.Accounts.get(Account_Index).GetAccount_Type().toString());
        System.out.println("\t\t\t   Balance          : "
                + Double.toString(Object.Accounts.get(Account_Index).GetAccount_Balance()));
        System.out.println("\t\t\t-----------------------------------------------------------");
    }

    public static clsAccount ReadNewAccount() {
        clsAccount Account_To_Read = new clsAccount(clsGlobal.Generate_Account_Number(), null, null, 0);
        System.out.println("\n\t\t-----> Account State <------");
        System.out.println("\t\t  [1] Active ");
        System.out.println("\t\t  [2] Closed ");
        System.out.println("\n\t\t----------------------------");
        int State = clsInput.ReadInt("\nEnter State [1 -2] : ");
        if (State == 1) {

            Account_To_Read.SetAccount_State(clsAccount.enAccountState.ACTIVE);
        } else {
            Account_To_Read.SetAccount_State(clsAccount.enAccountState.CLOSED);

        }
        Reset();
        System.out.println("\n\t\t-----> Account Type <------");
        System.out.println("\t\t  [1] Saving ");
        System.out.println("\t\t  [2] Current ");
        System.out.println("\n\t\t----------------------------");
        int Type = clsInput.ReadInt("\nEnter Type [1 -2] : ");

        if (Type == 1) {

            Account_To_Read.SetAccount_Type(clsAccount.enAccountType.SAVING);
        } else {
            Account_To_Read.SetAccount_Type(clsAccount.enAccountType.CURRENT);

        }
        return Account_To_Read;

    }

    public static Client ReadNewClient(String FirstName, String LastName) {

        Client client_To_Add = Client.Get_Client_To_Add();

        client_To_Add.SetFirstName(FirstName);
        client_To_Add.SetLastName(LastName);
        client_To_Add.SetPhone(LastName);
        client_To_Add.SetPhone(clsInput.ReadText("\nEnter Phone Number : "));
        Reset();
        client_To_Add.SetUsername(clsInput.ReadText("Enter Username : "));
        Reset();
        client_To_Add.SetPassword(clsInput.ReadText("Enter Password : "));
        Reset();
        // ========================
        clsAccount NewAccount = ReadNewAccount();
        client_To_Add.Accounts.get(0).SetAccount_State(NewAccount.GetAccount_State());

        client_To_Add.Accounts.get(0).SetAccount_Type(NewAccount.GetAccount_Type());

        return client_To_Add;
    }

    public static void AddNewClient() {
        String FirstName = clsInput.ReadText("Enter First Name : ");
        Reset();
        String LastName = clsInput.ReadText("Enter Last Name  : ");
        Reset();
        String FullName = FirstName + " " + LastName;

        if (!Client.IsExist_By_Full_Name(FullName)) {
            Client NewClient = ReadNewClient(FirstName, LastName);
            NewClient.Save();
            Bank.TOTAL_ACCOUNTS++;
            Reset();
            _Print(NewClient, 0);

        } else {
            Client client = (Client) Client.Find_By_Full_Name(FullName);
            System.out.println("T h i s  P  e r s o n   A l r e a d y   H a s   A c c o u n t (s)\n\n");
            char Answer = clsInput.ReadAnswer("Do You Want To Create New Account [Y-N] : ");

            if (Answer == 'Y' || Answer == 'y') {
                Reset();
                client.Accounts.add(ReadNewAccount());
                client.Save();
                Bank.TOTAL_ACCOUNTS++;
                _Print(client, client.Accounts.size() - 1);
            } else {
                Reset();
                System.out.println("\nProses Has Been Canceled :-) :-)");
            }

        }
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tA d d  C l i e n t  S c r e e n");
        AddNewClient();

    }

}