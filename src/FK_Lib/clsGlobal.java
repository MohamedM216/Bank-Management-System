package FK_Lib;

import CORE.Bank;
import CORE.Client;
import CORE.Employee;
import CORE.clsAccount;

public class clsGlobal {
    public static String Generate_Account_Number() {
        int Account_Number = 0;
        for (Client client : Bank.Client_List) {
            for (clsAccount Account : client.Accounts) {
                if (Integer.parseInt(Account.GetAccount_Number()) >= Account_Number) {
                    Account_Number = Integer.parseInt(Account.GetAccount_Number()) + 5;
                }
            }
        }
        return Integer.toString(Account_Number);
    }

    public static String Generate_ID() {
        int ID = 100;
        for (Employee employee : Bank.Admins_List) {
            if (Integer.parseInt(employee.GetID()) == ID) {
                ID += 5;
            }
        }
        for (Employee employee : Bank.Employee_List) {
            if (Integer.parseInt(employee.GetID()) == ID) {
                ID += 5;
            }
        }
        for (Client client : Bank.Client_List) {
            if (Integer.parseInt(client.GetID()) == ID) {
                ID += 5;
            }
        }
        return Integer.toString(ID);

    }
}