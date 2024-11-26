import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//Задание 31. Даны две действительные квадратные матрицы порядка n.
// По¬лучить новую  матрицу умножением  элементов каждой строки первой матрицы
// на наибольшее из значений элементов соответствующей строки  второй матрицы.


//Новое задание: Задание: Даны две действительные квадратные матрицы порядка n. 
Необходимо получить новую матрицу, в которой каждый элемент будет равен разности соответствующего элемента
первой матрицы и среднего значения элементов соответствующей строки второй матрицы.


public class task_31 {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int n = sc.nextInt();
        
        // Объявляем матрицы
        double[][] matrixA = new double[n][n];
        double[][] matrixB = new double[n][n];
        double[][] resultMatrix = new double[n][n];

        // Ввод первой матрицы
        System.out.println("Введите элементы первой матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = sc.nextDouble();
            }
        }

        // Ввод второй матрицы
        System.out.println("Введите элементы второй матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixB[i][j] = sc.nextDouble();
            }
        }

        // Вычисление результирующей матрицы
        for (int i = 0; i < n; i++) {
            double sum = 0;
            // Суммируем элементы строки второй матрицы
            for (int j = 0; j < n; j++) {
                sum += matrixB[i][j];
            }
            double average = sum / n; // Среднее значение

            // Вычисляем разность для каждого элемента
            for (int j = 0; j < n; j++) {
                resultMatrix[i][j] = matrixA[i][j] - average;
            }
        }

        // Вывод результирующей матрицы
        System.out.println("Результирующая матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.1f ", resultMatrix[i][j]);
            }
            System.out.println();
        }

        sc.close(); // Закрываем сканер
    }
}
