package FK_Lib;

import java.util.Scanner;

public class clsInput {
	private static Scanner _scanner = new Scanner(System.in);

	// Read Answer [Y-N]
	public static char ReadAnswer(String Message) {
		String StrInput;

		do {
			System.out.print(Message);
			StrInput = _scanner.next();
			_scanner.nextLine();
			if (StrInput.toUpperCase().equals("Y") || StrInput.toUpperCase().equals("N")) {
				break;
			}
			System.out.println("\n\tInvalid Number! Enter A valid one");
		} while (true);

		return StrInput.charAt(0);
	}

	// Read Long
	public static long ReadLong(String Message) {
		long Number = 0;
		String StrInput;
		boolean Valid = false;

		while (Valid == false) {
			System.out.print(Message);
			StrInput = _scanner.nextLine();

			try {
				Number = Long.parseLong(StrInput);
				Valid = true;
			} catch (NumberFormatException e) {
				System.out.println("\n\tInvalid Number! Enter An Integer Number");
			}

		}

		return Number;
	}

	// Read Integer
	public static int ReadInt(String Message) {
		int Number = 0;
		String StrInput;
		boolean Valid = false;

		while (Valid == false) {
			System.out.print(Message);
			StrInput = _scanner.nextLine();

			try {
				Number = Integer.parseInt(StrInput);
				Valid = true;
			} catch (NumberFormatException e) {
				System.out.println("\n\tInvalid Number! Enter An Integer Number");
			}

		}

		return Number;
	}

	public static int ReadInt(String Message, int From, int To) {
		int Number = 0;
		String StrInput;
		boolean Valid = false;

		while (Valid == false) {
			System.out.print(Message);
			StrInput = _scanner.nextLine();

			try {
				Number = Integer.parseInt(StrInput);

				if (Number >= From && Number <= To) {
					Valid = true;
					break;
				} else {
					System.out.println("\n\tNumber Out of Range!");
				}

			} catch (NumberFormatException e) {
				System.out.println("\n\tInvalid Number! Enter An Integer Number");
			}
		}

		return Number;
	}

	// Read Double
	public static double ReadDouble(String Message) {
		double Number = 0;
		String StrInput;
		boolean Valid = false;

		while (Valid == false) {
			System.out.print(Message);
			StrInput = _scanner.nextLine();

			try {
				Number = Double.parseDouble(StrInput);
				Valid = true;
			} catch (NumberFormatException e) {
				System.out.println("\n\tInvalid Number! Enter a Double Number");
			}
		}
		return Number;
	}

	public static double ReadDoublePositive(String Message) {
		double Number = 0;
		String StrInput;
		boolean Valid = false;

		while (Valid == false) {
			System.out.print(Message);
			StrInput = _scanner.nextLine();

			try {
				Number = Double.parseDouble(StrInput);
				if (Number < 0) {
					System.out.println("\n\tInvalid Number!Please Enter A Positive Number");
				} else {

					Valid = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("\n\tInvalid Number! Enter a Double Number");
			}
		}
		return Number;
	}

	public static double ReadDouble(String Message, int From, int To) {
		double Number = 0;
		String StrInput;
		boolean Valid = false;

		while (Valid == false) {
			System.out.print(Message);
			StrInput = _scanner.nextLine();

			try {
				Number = Double.parseDouble(StrInput);

				if (Number >= From && Number <= To) {
					Valid = true;
					break;
				} else {
					System.out.println("\n\tNumber Out of Range!");
				}

			} catch (NumberFormatException e) {
				System.out.println("\n\tInvalid Number! Enter A Double Number");
			}
		}

		return Number;
	}

	public static String ReadText(String Message) {
		System.out.print(Message);
		return _scanner.nextLine();
	}
}
