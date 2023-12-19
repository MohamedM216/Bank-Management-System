package Screens.Transactions;

import CORE.Bank;
import CORE.clsAccount;
import CORE.clsWithdraw;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;

public class clsWithdrawScreen extends Main_Screen {
    private static double Amount;

    public static void Reset() {
        clsUtil.Clear();
        Main_Screen.DrawScreenHeader("\t\tW  i  t  h  d  r  a  w    S  c  r  e  e  n");

    }
    public static void Withdraw()
    {

    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tW  i  t  h  d  r  a  w    S  c  r  e  e  n");

        if (Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index)
                .GetAccount_State() != clsAccount.enAccountState.CLOSED) {

            Amount = clsInput.ReadDoublePositive("\nEnter Amount To Withdraw : ");

            if (Amount > clsWithdraw.MAX_WITHDRAW_AMOUNT) {
                Reset();
                System.out.println("\n\tInvalid Amount , You Entered Amount more than "+ clsWithdraw.MAX_WITHDRAW_AMOUNT + " EGP");

            } else if (Amount > Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index).GetAccount_Balance()) {
                Reset();
                System.out.println("\n\tYour balance doesn't allow the operation to be carried out ");
                System.out.println(" \n\t\t You can withdraw up to   "+ Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index).GetAccount_Balance());
            } else {

            }
            clsWithdraw.withdraw(Bank.CurrentAccountNumber, Amount);
            clsUtil.Write_Withdraw_Record_To_File(Bank.CurrentAccountNumber, Amount);
            Reset();
            System.out.println("\n\nProcess Done Successfully");
            System.out.println("\nYour Current Balance : "
                    + Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index).GetAccount_Balance());
        } else {
            Reset();
            System.out.println("\n\t\tYour Account Is Closed");
        }
    }
}