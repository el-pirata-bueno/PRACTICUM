/*
Программа для перевода буквенного номера телефона в цифровой

Например:
CALL-ME = 225563
CALL-1-ME = 2255163

Словарь
2 = A B C
3 = D E F
4 = G H I
5 = J K L
6 = M N O
7 = P Q R S
8 = T U V
9 = W X Y Z

 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class phonenumbers
{
   public static void main(String[] args)
   {
		String[][] symbols = { 								// создаём массив исходных данных
			{"2", "A", "B", "C"},
			{"3", "D", "E", "F"},
			{"4", "G", "H", "I"},
			{"5", "J", "K", "L"},
			{"6", "M", "N", "O"},
			{"7", "P", "Q", "R", "S"},
			{"8", "T", "U", "V"},
			{"9", "W", "X", "Y", "Z"},
		};

		HashMap<String, String> map = new HashMap<>(); 		// создаём словарь из исходных данных: ключ - символ, значение - цифра
		
		for (int i = 0; i < symbols.length; i++) { 			// заполняем словарь парамми буква-цифра
			for (int j = 1; j < symbols[i].length; j++) {
				map.put(symbols[i][j], symbols[i][0]);
			}
		}
		
		Scanner scanner = new Scanner(System.in); 			
		System.out.println("Введите номер телефона (допустимые символы: +, -, (, ), 0...9, A...Z)");
		String phoneNumberFinal;							
		while (true) {
			String phoneNumberStart = scanner.nextLine();	// считываем номер телефона с консоли
			phoneNumberFinal = "";
			for (int k = 0; k < phoneNumberStart.length(); k++) { 	// проверяем поочередно каждый введенный символ и сравниваем его с условиями
				String checkedSymbol = String.valueOf(phoneNumberStart.charAt(k)); 		
				if ((checkedSymbol.equals("+")) || (checkedSymbol.equals("-")) || (checkedSymbol.equals("(")) || (checkedSymbol.equals(")"))) {
					phoneNumberFinal = phoneNumberFinal + "";
				}
				else if ((checkedSymbol.equals("0"))  || (checkedSymbol.equals("1")) || map.containsValue(checkedSymbol)) { // здесь для сокращения кода, проверяем, нет ли символа в значениях словаря
					phoneNumberFinal = phoneNumberFinal + checkedSymbol;
				}	
				else if (map.containsKey(checkedSymbol)) {			// условия для введенной буквы - заменяем на цифру
					phoneNumberFinal = phoneNumberFinal + map.get(checkedSymbol);
				}
				else {
					System.out.println("Ошибка! Повторите ввод. Допустимые символы: +, -, (, ), 0...9, A...Z)");
					break;
				}	
			}
			break;
		}
		System.out.println("Номер телефона в выбранном формате: " + phoneNumberFinal);
	}		
}
