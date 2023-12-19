package FK_Lib;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import CORE.Bank;
import CORE.Employee;

public class clsUtil {
    public static enum enTransactionType {
        DEPOSIT, WITHDRAW, TRANSFER
    }

    public static void Clear() {
        try {

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime();
            }

        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void Write_Deposit_Record_To_File(String AccountNumber, double Amount) {
        // Type&&&&Amount&&&&Time&&&&Date&&&&From_AccountNumber[&&&&To_AccountNumber]
        String[] RecordData = new String[5];
        RecordData[0] = clsUtil.enTransactionType.DEPOSIT.toString();
        RecordData[1] = Double.toString(Amount);
        RecordData[2] = LocalDate.now() + "";
        RecordData[3] = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
                + String.format("%03d", LocalTime.now().getSecond());
        RecordData[4] = AccountNumber;
        try (BufferedWriter BW = new BufferedWriter(new FileWriter(Bank.TRANSACTIONS_FILE, true))) {
            BW.write(String.join(Bank.TRANSACTION_DELIMITER, RecordData));
            BW.newLine();
        } catch (IOException e) {

            System.out.println("Transactions File Not Found!!");
        }
    }

    public static void Write_Withdraw_Record_To_File(String AccountNumber, double Amount) {
        // Type&&&&Amount&&&&Time&&&&Date&&&&From_AccountNumber[&&&&To_AccountNumber]
        String[] RecordData = new String[5];
        RecordData[0] = clsUtil.enTransactionType.WITHDRAW.toString();
        RecordData[1] = Double.toString(Amount);
        RecordData[2] = LocalDate.now() + "";
        RecordData[3] = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
                + String.format("%03d", LocalTime.now().getSecond());
        RecordData[4] = AccountNumber;
        try (BufferedWriter BW = new BufferedWriter(new FileWriter(Bank.TRANSACTIONS_FILE, true))) {
            BW.write(String.join(Bank.TRANSACTION_DELIMITER, RecordData));
            BW.newLine();
        } catch (IOException e) {

            System.out.println("Transactions File Not Found!!");
        }
    }

    public static void Write_Transfer_Record_To_File(String From_AccountNumber, String To_AccountNumber,
            double Amount) {
        // Type&&&&Amount&&&&Time&&&&Date&&&&From_AccountNumber[&&&&To_AccountNumber]
        String[] RecordData = new String[6];
        RecordData[0] = clsUtil.enTransactionType.TRANSFER.toString();
        RecordData[1] = Double.toString(Amount);
        RecordData[2] = LocalDate.now() + "";
        RecordData[3] = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
                + String.format("%03d", LocalTime.now().getSecond());
        RecordData[4] = From_AccountNumber;
        RecordData[5] = To_AccountNumber;
        try (BufferedWriter BW = new BufferedWriter(new FileWriter(Bank.TRANSACTIONS_FILE, true))) {
            BW.write(String.join(Bank.TRANSACTION_DELIMITER, RecordData));
            BW.newLine();
        } catch (IOException e) {

            System.out.println("Transactions File Not Found!!");
        }
    }

    public static void PrintEmployee(Employee employee) {
        System.out.println("\n\t------------------------ > Employee Card < ------------------------ \n");
        System.out.println("\t\tID                  :     " + employee.GetID());
        System.out.println("\t\tFullname            :     " + employee.GetFirstName() + " " + employee.GetLastName());
        System.out.println("\t\tAddress             :     " + employee.GetAddress());
        System.out.println("\t\tPhone               :     " + employee.GetPhone());
        System.out.println("\t\tPosition            :     " + employee.GetPosition());
        System.out.println("\t\tUsername            :     " + employee.GetUsername());
        System.out.println("\t\tGraduated Collage   :     " + employee.GetGraduated_Collage());
        System.out.println("\t\tTotal Grade         :     " + employee.GetTotal_Grade());
        System.out.println("\t\tYear Of Graduation  :     " + employee.GetYear_Of_Graduation());
        System.out.println("\n\t-------------------------------------------------------------------- \n");
    }
}