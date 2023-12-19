import CORE.Bank;
import Screens.MainScreens.Login_Screen;

public class App {
    public static void main(String[] args) {

        while (true) {
            Bank bank = new Bank();

            if (!Login_Screen.Show()) {
                break;
            }
            Bank.Save_ALL_Records_To_File();
        }

    }
}
