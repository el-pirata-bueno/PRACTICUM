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
import java.util.HashSet;

public class phonenumbers
{
   public static void main(String[] args)
   {
		String[][] symbols = { 									// создаём массив исходных данных
			{"0", "0"},
			{"1", "1"},
			{"2", "A", "B", "C"},
			{"3", "D", "E", "F"},
			{"4", "G", "H", "I"},
			{"5", "J", "K", "L"},
			{"6", "M", "N", "O"},
			{"7", "P", "Q", "R", "S"},
			{"8", "T", "U", "V"},
			{"9", "W", "X", "Y", "Z"},
		};
		
		int numbers = 0;
		
		HashMap<String, String> map = new HashMap<>(); 			// создаём словарь из исходных данных: ключ - символ, значение - цифра
		
		HashSet<String> ignoredSymbols = new HashSet<String>();	// создаем и заполняем множество игнорируемых символов при вводе пользователя: +, -, (, ), пробел
		ignoredSymbols.add("+");
		ignoredSymbols.add("-");
		ignoredSymbols.add(" ");
		ignoredSymbols.add("(");
		ignoredSymbols.add(")");
		
		StringBuilder phoneNumberFinal = new StringBuilder("");
		
		for (int i = 0; i < symbols.length; i++) { 				// заполняем словарь парами буква-цифра
			for (int j = 1; j < symbols[i].length; j++) {
				map.put(symbols[i][j], symbols[i][0]);
			}
		}
		
		Scanner scanner = new Scanner(System.in); 			
		System.out.println("Введите номер телефона (допустимые символы: +, -, (, ), 0...9, A...Z)");
		
		while (numbers == 0) {
			String phoneNumberStart = scanner.nextLine();						// считываем номер телефона с консоли
			
			for (int k = 0; k < phoneNumberStart.length(); k++) { 				// проверяем поочередно каждый введенный символ и сравниваем его с условиями
				String checkedSymbol = String.valueOf(phoneNumberStart.charAt(k)).toUpperCase(); 		
				
				if (map.containsValue(checkedSymbol)) { 						// условие для введенной цифры
					phoneNumberFinal.append(checkedSymbol);
				}	
				
				else if (map.containsKey(checkedSymbol)) {						// условие для введенной буквы - заменяем на цифру
					phoneNumberFinal.append(map.get(checkedSymbol));
				}
				
				else if (ignoredSymbols.contains(checkedSymbol)) {				// условие для игнорируемых символов
				}
				
				else {															// условие для ошибочного символа
					System.out.println("Ошибка! Повторите ввод. Допустимые символы: +, -, (, ), 0...9, A...Z)");
					phoneNumberFinal.delete(0, k);
					numbers = 0;
					break;
				}
			numbers++;
			}
			if (numbers != 0) {
				break;
			}			
		}
		System.out.println("Номер телефона в выбранном формате: " + phoneNumberFinal);		
	}		
}

