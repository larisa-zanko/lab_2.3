import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//31. Даны две действительные квадратные матрицы порядка n.
// По¬лучить новую  матрицу умножением  элементов каждой строки первой матрицы
// на наибольшее из значений элементов соответствующей строки  второй матрицы.

public class task_31 {
    // Метод для создания случайной квадратной матрицы
    public static ArrayList<ArrayList<Double>> createRandomMatrix(int size) {
        Random random = new Random();// создаём обьект для генерации случайных чисел
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(random.nextDouble() * 100); // Случайные числа от 0 до 100
            }
            matrix.add(row);
        }
        return matrix;
    }

    // Метод для нахождения максимального элемента в строке матрицы
    public static double findMaxInRow(ArrayList<Double> row) {
        double max = row.get(0);
        for (double value : row) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Метод для умножения строк первой матрицы на максимальные элементы соответствующих строк второй матрицы
    public static ArrayList<ArrayList<Double>> multiplyMatrices(ArrayList<ArrayList<Double>> matrixA, ArrayList<ArrayList<Double>> matrixB) {
        int size = matrixA.size();
        ArrayList<ArrayList<Double>> resultMatrix = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            ArrayList<Double> rowResult = new ArrayList<>();
            double maxInRowB = findMaxInRow(matrixB.get(i)); // Нахождение максимального элемента в строке второй матрицы
            for (double value : matrixA.get(i)) {
                rowResult.add(value * maxInRowB); // Умножение
            }
            resultMatrix.add(rowResult);
        }
        return resultMatrix;
    }

    // Метод для вывода матрицы на экран
    public static void printMatrix(ArrayList<ArrayList<Double>> matrix) {
        for (ArrayList<Double> row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f ", value); // Форматированный вывод
            }
            System.out.println();
        }
    }

    // Метод для вывода наибольших элементов каждой строки второй матрицы
    public static void printMaxInRows(ArrayList<ArrayList<Double>> matrix) {
        System.out.println("Наибольшие элементы каждой строки второй матрицы:");
        for (int i = 0; i < matrix.size(); i++) {
            double max = findMaxInRow(matrix.get(i));
            System.out.printf("Строка %d: %.2f%n", i + 1, max);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите порядок квадратной матрицы n: ");
        int n = scanner.nextInt();

        // Проверка на положительность размера
        if (n <= 0) {
            System.out.println("Порядок матрицы должен быть положительным");
            return;
        }

        // Создание двух случайных квадратных матриц
        ArrayList<ArrayList<Double>> matrixA = createRandomMatrix(n);
        ArrayList<ArrayList<Double>> matrixB = createRandomMatrix(n);


        System.out.println("Первая матрица:");
        printMatrix(matrixA);
        System.out.println("Вторая матрица:");
        printMatrix(matrixB);

        // Вывод наибольших элементов каждой строки второй матрицы
        printMaxInRows(matrixB);

        // Умножение матриц
        ArrayList<ArrayList<Double>> resultMatrix = multiplyMatrices(matrixA, matrixB);

        // Вывод результирующей матрицы
        System.out.println("Результирующая матрица:");
        printMatrix(resultMatrix);

        scanner.close();
    }
}