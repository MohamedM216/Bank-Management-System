package Screens.Transactions;

import CORE.Bank;
import CORE.clsAccount;
import CORE.clsDeposit;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;
import Screens.MainScreens.Main_Screen;

public class clsDepositScreen extends Main_Screen {
    public static void Reset() {
        Main_Screen.DrawScreenHeader("\t\tW  i  t  h  d  r  a  w    S  c  r  e  e  n");
        clsUtil.Clear();

    }

    public static double ReadDepositAmount() {
        double Amount;
        do {
            Amount = clsInput.ReadDoublePositive("\nEnter Amount To Deposit : ");
            if (Amount > clsDeposit.MAX_DEPOSIT_AMOUNT) {
                Reset();
                System.out.println(
                        "\n\tInvalid Amount , You Entered Amount more than " + clsDeposit.MAX_DEPOSIT_AMOUNT + " EGP");
            } else {
                break;
            }
        } while (true);
        return Amount;
    }

    public static void Show() {
        Main_Screen.DrawScreenHeader("\t\tD  e  p  o  s  i  t     S  c  r  e  e  n");
        if (Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index)
                .GetAccount_State() == clsAccount.enAccountState.ACTIVE) {
            double Amount = ReadDepositAmount();
            clsDeposit.Deposit(Bank.CurrentAccountNumber, Amount);
            clsUtil.Write_Deposit_Record_To_File(Bank.CurrentAccountNumber, Amount);
            Reset();
            System.out.println("\n\n\tProcess Done Successfully");
            System.out.println("\n\n\tYour Current Balance : "
                    + Bank.CurrentClient.Accounts.get(Bank.CurrentAccountNumber_Index).GetAccount_Balance());
        } else {
            System.out.println("Your Account Is Closed");
        }
    }
}
