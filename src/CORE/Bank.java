package CORE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import CORE.Client.enMode;

public class Bank {
    private static final String BANK_FILE = System.getProperty("user.dir") + "/Files/BANK_FILE.txt";
    public static final String LOGIN_FILE = System.getProperty("user.dir") + "/Files/LOGIN_FILE.txt";
    public static final String TRANSACTIONS_FILE = System.getProperty("user.dir") + "/Files/TRANSACTIONS_FILE.txt";
    public static final String FILE_DELIMITER = "#//#";
    public static final String LOGIN_FILE_DELIMITER = "#//#";
    public static final String Account_DELIMITER = "#///#";
    public static final String Accounts_DELIMITER = "%%%";
    public static final String TRANSACTION_DELIMITER = "&&&&";
    private static ArrayList<String> Records = new ArrayList<>();
    public static ArrayList<Employee> Employee_List = new ArrayList<>();
    public static ArrayList<Employee> Admins_List = new ArrayList<>();
    public static ArrayList<Client> Client_List = new ArrayList<>();
    public static Client CurrentClient = Client._Get_Empty_Client_Object();
    public static String CurrentAccountNumber;
    public static int CurrentAccountNumber_Index;
    public static Employee CurrentEmployee = Employee._Get_Empty_Employee_Object();
    public static int TOTAL_ACCOUNTS;

    // =========================================================================================================================
    public Bank() {
        Records = Get_ALL_Records_From_File();
        Fill_All_Lists_With_Data();
        TOTAL_ACCOUNTS = Get_Total_Accounts();

    }

    private int Get_Total_Accounts() {
        int Counter = 0;
        for (Client client : Client_List) {
            Counter += client.Accounts.size();
        }
        return Counter;
    }

    private static Employee Convert_Line_To_Employee_Object(String record) {
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#Address#//#Position#//#Graduated_Collage#//#YOG#//#Total_Grade
        String[] Data = record.split(FILE_DELIMITER);
        return new Employee(Data[0], Data[1], Data[2], Data[3], Data[4], Data[5], Person.enRule.EMPLOYEE,
                Employee.enMode.UPDATE, Data[7],
                Data[8], Data[9], Data[10], Data[11]);
    }

    private static Employee Convert_Line_To_Admin_Object(String record) {

        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#Address#//#Position#//#Graduated_Collage#//#YOG#//#Total_Grade
        String[] Data = record.split(FILE_DELIMITER);
        return new Employee(Data[0], Data[1], Data[2], Data[3], Data[4], Data[5],
                Person.enRule.ADMIN, Employee.enMode.UPDATE, Data[7], Data[8],
                Data[9], Data[10], Data[11]);
    }

    private static ArrayList<clsAccount> Convert_Accounts_Record_To_ArrayList(String Accounts_Record) {
        String[] Accounts_Array = Accounts_Record.split(Accounts_DELIMITER);
        ArrayList<clsAccount> Accounts_List = new ArrayList<>();

        for (int i = 0; i < Accounts_Array.length; i++) {
            String[] SubArray = Accounts_Array[i].split(Account_DELIMITER);
            Accounts_List.add(new clsAccount(SubArray[0], clsAccount.enAccountState.valueOf(SubArray[1]),
                    clsAccount.enAccountType.valueOf(SubArray[2]), Double.parseDouble(SubArray[3])));
            TOTAL_ACCOUNTS++;
        }
        return Accounts_List;
    }

    private static Client Convert_Line_To_Client_Object(String record) {
        // ID#//#FirstName#//#LastName#//#Phone#//#Username#//#Password#//#Rule#//#-----#//#AccountNumber#//#State#//#Type#//#Balance
        String[] Data = record.split(FILE_DELIMITER);
        Client client = new Client(Data[0], Data[1], Data[2], Data[3], Data[4], Data[5], Person.enRule.CLIENT,
                enMode.UPDATE,
                Convert_Accounts_Record_To_ArrayList(Data[7]));
        return client;
    }

    private void Fill_All_Lists_With_Data() {
        for (String Record : Records) {
            String[] Record_Data = Record.split(FILE_DELIMITER);

            if (Record_Data[6].equals(Person.enRule.ADMIN.toString())) {
                Admins_List.add(Convert_Line_To_Admin_Object(Record));
            } else if (Record_Data[6].equals(Person.enRule.EMPLOYEE.toString())) {
                Employee_List.add(Convert_Line_To_Employee_Object(Record));
            } else if (Record_Data[6].equals(Person.enRule.CLIENT.toString())) {

                Client_List.add(Convert_Line_To_Client_Object(Record));
            }
        }

    }

    // Method To Read Form Bank File
    private static ArrayList<String> Get_ALL_Records_From_File() {
        ArrayList<String> Records = new ArrayList<>();

        try (BufferedReader BR = new BufferedReader(new FileReader(BANK_FILE))) {
            String Line;

            while ((Line = BR.readLine()) != null) {
                Records.add(Line);
            }

        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace(); // You might want to log the exception or handle it in a different way
        }

        return Records;
    }

    // Method To Write To Bank File
    public static void Save_ALL_Records_To_File() {
        try (BufferedWriter BW = new BufferedWriter(new FileWriter(BANK_FILE))) {
            for (Employee employee : Admins_List) {
                if (!employee.Is_Mark_For_Deleted()) {
                    BW.write(employee.toString());
                    BW.newLine();
                }
            }
            for (Employee employee : Employee_List) {
                if (!employee.Is_Mark_For_Deleted()) {
                    BW.write(employee.toString());
                    BW.newLine();
                }
            }
            for (Client client : Client_List) {
                if (!client.Is_Mark_For_Deleted()) {
                    BW.write(client.toString());
                    BW.newLine();
                }
            }
            BW.flush();
            BW.close();
            Admins_List.clear();
            Employee_List.clear();
            Client_List.clear();
        } catch (IOException e) {
            System.out.println("Bank File Not Found !!");
            e.printStackTrace();
        }

    }

}