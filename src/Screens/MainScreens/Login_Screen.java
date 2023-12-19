package Screens.MainScreens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import CORE.Bank;
import CORE.Client;
import CORE.Employee;
import CORE.Person;
import FK_Lib.clsInput;
import FK_Lib.clsUtil;

public class Login_Screen extends Main_Screen {
	private final static String _Logo_Path = System.getProperty("user.dir") + "/Files/Logo.txt";

	public static void Reset() {
		clsUtil.Clear();
		Art();
	}

	public static void Art() {
		clsUtil.Clear();
		File file = new File(_Logo_Path);

		if (file.exists()) {
			try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
				String Line;
				while ((Line = BR.readLine()) != null) {
					System.out.println(Line);
				}
				BR.close();
			} catch (IOException e) {
				// Handle IOException
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist: " + _Logo_Path);
		}
	}

	public static void Write_Client_Login_Record() {
		// ClientName#//#Username#//#Password#//#Time-Date
		String[] Array = new String[5];
		Array[0] = Bank.CurrentClient.GetFirstName() + " " + Bank.CurrentClient.GetLastName();
		Array[1] = Bank.CurrentClient.GetUsername();
		Array[2] = Bank.CurrentClient.GetPassword();
		Array[3] = LocalDate.now() + "";
		Array[4] = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
				+ String.format("%03d", LocalTime.now().getSecond());
		try (
				BufferedWriter BW = new BufferedWriter(new FileWriter(Bank.LOGIN_FILE, true))) {
			BW.write(String.join(Bank.LOGIN_FILE_DELIMITER, Array));
			BW.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Write_Employee_Login_Record() {
		// ClientName#//#Username#//#Password#//#Time-Date
		String[] Array = new String[5];
		Array[0] = Bank.CurrentEmployee.GetFirstName() + " " + Bank.CurrentEmployee.GetLastName();
		Array[1] = Bank.CurrentEmployee.GetUsername();
		Array[2] = Bank.CurrentEmployee.GetPassword();
		Array[3] = LocalDate.now() + "";
		Array[4] = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
				+ String.format("%03d", LocalTime.now().getSecond());
		try (
				BufferedWriter BW = new BufferedWriter(new FileWriter(Bank.LOGIN_FILE, true))) {
			BW.write(String.join(Bank.LOGIN_FILE_DELIMITER, Array));
			BW.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean Show() {

		Art();

		do {
			Reset();
			Bank.CurrentClient = Client._Get_Empty_Client_Object();
			Bank.CurrentEmployee = Employee._Get_Empty_Employee_Object();
			String Username = clsInput.ReadText("\n\nEnter Username : ");
			String Password = clsInput.ReadText("Enter Password : ");
			if (Client.IsExist_By_Username(Username)) {

				Client current = (Client) Client.Find_By_Username(Username);
				for (int i = 4; i >= 1; i--) {
					Reset();
					if (current.GetPassword().equals(Password)) {
						Bank.CurrentClient = current;

						if (Bank.CurrentClient.Accounts.size() > 1) {
							System.out
									.println("\nThis Person Has [" + Bank.CurrentClient.Accounts.size() + "] Accounts");
							System.out.println("\n\t\t\t\t--------------");
							for (int j = 1; j <= Bank.CurrentClient.Accounts.size(); j++) {
								System.out.printf("\t\t\t\t  [%d] %s\n", j,
										Bank.CurrentClient.Accounts.get(j - 1).GetAccount_Number());
							}
							System.out.println("\t\t\t\t--------------\n");
							String AccountNumber = clsInput.ReadText("\nEnter Account Number : ");

							if (Client.IsExist_By_Account_Number(AccountNumber)) {

								for (int k = 0; k < Bank.CurrentClient.Accounts.size(); k++) {
									if (Bank.CurrentClient.Accounts.get(k).GetAccount_Number().equals(AccountNumber)) {
										Bank.CurrentAccountNumber = AccountNumber;
										Bank.CurrentAccountNumber_Index = k;

									}
								}
							} else {
								Reset();
								System.out.println("\n\tInvalid Account Number !");
								clsInput.ReadText("\nPress Any Key To Go Back ....");

								return true;
							}

						} else {
							Bank.CurrentAccountNumber = Bank.CurrentClient.Accounts.get(0).GetAccount_Number();
							Bank.CurrentAccountNumber_Index = 0;
						}
						Write_Client_Login_Record();
						Client_Main_Menu_Screen.Show();
						return true;
					}
					if (i == 1) {
						clsUtil.Clear();
						return false;
					} else {

						System.out.println("\nInvalid Password");
						System.out.printf("\n\tYou Have [%d] Trials Left\n", i - 1);
						Password = clsInput.ReadText("\nEnter Password : ");
					}
				}
			}
			// ========================================================================
			else if (Employee.IsExist_By_Username(Username)) {

				Employee current = (Employee) Employee.Find_By_Username(Username);

				if (current.GetRule() == Person.enRule.ADMIN) {
					for (int i = 4; i >= 1; i--) {
						Reset();
						if (current.GetPassword().equals(Password)) {
							Bank.CurrentEmployee = current;
							Write_Employee_Login_Record();
							Admin_Main_Menu_Screen.Show();
							return true;
						} else if (i == 1) {
							clsUtil.Clear();
							return false;
						} else {
							System.out.println("\nInvalid Password");
							System.out.printf("\n\tYou Have [%d] Trials Left\n", i - 1);
							Password = clsInput.ReadText("\nEnter Password : ");
						}
					}
				} else if (current.GetRule() == Person.enRule.EMPLOYEE) {
					for (int i = 4; i >= 1; i--) {
						Reset();
						if (current.GetPassword().equals(Password)) {
							Bank.CurrentEmployee = current;
							Write_Employee_Login_Record();
							Employee_Main_Menu_Screen.Show();
							return true;
						} else if (i == 1) {
							clsUtil.Clear();
							return false;
						} else {

							System.out.println("\nInvalid Password");
							System.out.printf("\n\tYou Have [%d] Trials Left\n", i - 1);
							Password = clsInput.ReadText("\nEnter Password : ");
						}
					}
				}

			}
			Reset();
			System.out.println("\nUsername Not Found!");
			clsInput.ReadText("\n\tPress Any Key To Go Back ....");

		} while (true);
	}
}
