package Screens.Transactions;

import CORE.Bank;
import CORE.clsAccount;
import CORE.clsTransfer;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;

public class clsTransferScreen extends Main_Screen {

    public static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tT  r  a  n  s  f  e  r    S  c  r  e  e  n");
    }

    public static void Transfer() {
        // 1- Read And Check Account Number <To>

        String AccountNumber_To = clsInput.ReadText("\nEnter Account Number of the Recipient Account : ");

        for (int i = 0; i < Bank.Client_List.size(); i++) {
            for (int j = 0; j < Bank.Client_List.get(i).Accounts.size(); j++) {
                if (AccountNumber_To.equals(Bank.Client_List.get(i).Accounts.get(j).GetAccount_Number())) {
                    Reset();
                    double Amount = clsInput.ReadDouble("\n\nEnter Amount To Transfer : ");

                    if (Amount > Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index)
                            .GetAccount_Balance()) {
                        System.out.println("Transfer amount exceeds your balance");
                        System.out.println("You Can Transfer Up To : " + Bank.CurrentClient.Accounts
                                .get(Bank.CurrentAccountNumber_Index).GetAccount_Balance());
                        return;
                    }
                    clsTransfer.Transfer(Bank.CurrentAccountNumber, AccountNumber_To, Amount);
                    clsUtil.Write_Transfer_Record_To_File(Bank.CurrentAccountNumber, AccountNumber_To, Amount);
                    Reset();
                    System.out.println("\nT r a n s f e r  D o n e  S u c c e s s f u l l y :-)\n\n");
                    System.out.println("\t\t\t\t----------------------------------------------");
                    System.out.println("\t\t\t\t------> T r a n s f e r  S u m m a r y <------");
                    System.out.println("\t\t\t\t----------------------------------------------");
                    System.out.println("\t\t\t\t From Account Number :  " + Bank.CurrentAccountNumber);
                    System.out.println("\t\t\t\t To Account Number   :  " + AccountNumber_To);
                    System.out.println("\t\t\t\t Transfer Amount     :  " + Amount);
                    System.out.println("\t\t\t\t----------------------------------------------");
                    System.out.println("\t\t\t\t New Balance : "
                            + Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index).GetAccount_Balance());
                    System.out.println("\t\t\t\t----------------------------------------------");
                    return;
                }
            }
        }
        System.out.println("\n\tThe Receiver Account Number Doesn't Exist");
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tT  r  a  n  s  f  e  r    S  c  r  e  e  n");
        if (Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index)
                .GetAccount_State() == clsAccount.enAccountState.CLOSED) {
            System.out.println("Your Account Is Closed");
        } else {

            Transfer();
        }
    }

}