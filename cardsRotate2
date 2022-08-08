import java.util.*;

/**
 * Считает, сколько карт останется рубашкой вниз после кучи переворотов от каждой первой до каждой N-ой.
 * @version 2.0 08.08.2022
 * @author Dmitry Zharinov
 */
public class cardsRotate2
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

		int cardsDown = 0;

		for (int i = 1; i <= cardsTotal; i++) {
			int divNumbers = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					divNumbers ++;
				}
			}
			if (divNumbers % 2 == 1) {
				cardsDown++;
			}
		}
			
		return (cardsDown);
	}	
}
