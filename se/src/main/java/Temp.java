/**
 * Created by jur on 04.01.2019.
 */
public class Temp {

    public static void main(String [] args){
        int[][] multiplyTab  = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiplyTab[i][j] = (i+1)*(j+1);
                //вывод ряда чисел разделенных знаком табуляции
                System.out.print(String.format("%12.3f", Float.valueOf(multiplyTab[i][j])));
//                System.out.printf("%1$+6d", multiplyTab[i][j]);
            }
            System.out.println();
        }
        System.out.println(String.format("%1$+020.10f", Math.PI));

        Integer i=675;
        double root;
        root = Math.sqrt(i);
        System.out.println(String.format("корень числа %-3d равен %3.4f",i,root));
    }
}
