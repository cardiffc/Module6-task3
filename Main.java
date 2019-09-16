import Clients.Client;
import Clients.ClientIp;
import Clients.ClientLLC;
import Clients.ClientPerson;
import jdk.jfr.DataAmount;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Client ipClient = new ClientIp(1, 0.);
        Client perClient = new ClientPerson(2, 0.);
        Client llcClient = new ClientLLC(3, 0.);
        while (true) {
            System.out.println("Выберите тип клиента:\n1 - ИП\n2 - Юридическое лицо\n3 - Физическое лицо ");
            Scanner scanner = new Scanner(System.in);
            String clientType = scanner.nextLine();
            if (!checkInput(clientType))
            {
                getErrorMsg();
                continue;
            }
            System.out.println("Выберите операцию:\n1 - Пополнить счет\n2 - Снять деньги\n3 - Посмореть баланс");
            String operType = scanner.nextLine();
            if (!checkInput(operType))
            {
                getErrorMsg();
                continue;
            }
            if (clientType.equals("1")) {
                if (operType.equals("1") || operType.equals("2")) {
                    caseMoneyInOut(ipClient, operType);
                } else {
                    getBalance(ipClient);
                }
            } else if (clientType.equals("2"))
            {
                if (operType.equals("1") || operType.equals("2")) {
                    caseMoneyInOut(llcClient, operType);
                }
                else {
                    getBalance(llcClient);
                }
            }
            else {
                if (operType.equals("1") || operType.equals("2")) {
                    caseMoneyInOut(perClient, operType);
                } else {
                    getBalance(perClient);
                }
            }
        }
    }
    private static boolean checkInput (String input)
    {
        return input.matches("^(1|2|3)$");
    }
    private static void getErrorMsg()
    {
        System.out.println("Вы ввели недопустимое значение!");
    }
    private static void caseMoneyInOut (Client client, String choice)
    {
        System.out.println("Введите сумму:");
        Scanner scanner = new Scanner(System.in);
        String strAmount = scanner.nextLine();
        if(!strAmount.matches("\\d+"))
        {
            getErrorMsg();
        }
        else {
            double amount = Double.parseDouble(strAmount);
            if (choice.equals("1")) {
                client.setAccAmount(amount);
            } else if (choice.equals("2")) {
                client.setAccAmount(-amount);
            }
        }
    }
    private static void getBalance (Client client)
    {
        System.out.println("Баланс Вашего счета: " + client.getAccAmount() + "рублей");
    }
}
