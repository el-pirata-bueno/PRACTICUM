import java.util.*;

/**
 * Считает, сколько карт останется рубашкой вниз после кучи переворотов от каждой первой до каждой N-ой.
 * @version 1.0 08.08.2022
 * @author Dmitry Zharinov
 */
public class cardsRotate
{
    public static void main(String[] args)
   {
		Scanner in = new Scanner(System.in);
		System.out.print("Сколько карт всего на столе рубашкой вверх?\n");
		int cardsTotal = in.nextInt();
		System.out.print("Рубашкой вниз на столе останется " + cards(cardsTotal) + " карт. \n(Допустимое число - от 1 до N, -1 - ошибка исходных данных).\n");
   }
   
    public static int cards(int cardsTotal)
	{
		if (cardsTotal < 1) {
			return -1;
		}
		
		int[] cardsRotated = new int[cardsTotal];
		int sum = 0;
		int step = 1;
		
		// Заполняем массив значениями, считаем, что -1 - карта рубашкой вверх, 1 - карта рубашкой вниз
		for (int i = 0; i < cardsRotated.length; i++) {
			cardsRotated[i] = -1;
		}
		
		while (step <= cardsTotal) {
			for (int i = step - 1; i < cardsRotated.length; i = i + step) {
				cardsRotated[i] = -cardsRotated[i];
			}
			step++;
		}
				
		for (int element: cardsRotated)
			sum = sum + element;
			
		return (((cardsTotal - sum)/2) + sum);
	}	
}
