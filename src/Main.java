import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TODO ThreadPool вместо ручной генерации

        /* Создание массива случайных чисел */
//        Random rand = new Random();
//        List<Integer> randArrayInt = new ArrayList<>();
//        for (int i=0; i<10; i++){
//            int temp = rand.nextInt(10);
//            randArrayInt.add(temp);
//        }
        /* Создание массива случайных чисел, используя потоки и лямбду */
        int[] tempRandArrayInt = new int[10];
        List<Integer> randArrayInt = new ArrayList<>();
        Collections.addAll(randArrayInt, Arrays.stream(tempRandArrayInt).boxed().toArray(Integer[]::new));
        Random rand = new Random();
        randArrayInt.replaceAll(value -> {return value+rand.nextInt(10);});
        System.out.println("Массив случайных чисел: " + randArrayInt);

        /* Создание массива для добавления объектов класса MyThread */
        List<MyThread> arrayMyThread = new ArrayList<>();

        /* Инстанцирование объектов класса MyThread со значениями из массива случайных чисел */
//        for (int i = 0; i<randArrayInt.size(); i++){
//            arrayMyThread.add(new MyThread(randArrayInt.get(i)));
//        }
        /* Инстанцирование объектов класса MyThread со значениями из массива случайных чисел,
        * используя ссылку на метод функциональный интерфейс */
        MyThreadCreator myThreadCreated = new MyThreadCreatorImpl(randArrayInt, arrayMyThread)::myThreadCreatorImpl;
        arrayMyThread = myThreadCreated.myThreadCreatorImpl();

        /* Создание массива для добавления объектов класса Thread */
        List<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i<randArrayInt.size(); i++){
            arrayThread.add(new Thread(arrayMyThread.get(i)));
        }

        /* Запуск потоков на исполнение */
        for (int i = 0; i<randArrayInt.size(); i++){
            arrayThread.get(i).start();
        }

        /* Завершение потоков исполнения */
        for (int i = 0; i<randArrayInt.size(); i++){
            try {
                arrayThread.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* Создание массива для хранения объектов типа BigInteger и записи вычисленных факториалов */
        List<BigInteger> randArrayBigInt = new ArrayList<>();

        /* Добавление вычисленных факториалов в массив */
        for (int i = 0; i<randArrayInt.size(); i++){
            randArrayBigInt.add(BigInteger.valueOf(arrayMyThread.get(i).getIterable()));
        }

        /* Выведение результатов вычисления факториалов */
        System.out.println("Вычисленные факториалы: ");
//        for (int i = 0; i<randArrayInt.size(); i++){
//            System.out.print(randArrayBigInt.get(i)+ ", ");
//        }
        /* Выведение результатов вычисления факториалов, используя лямбду */
        randArrayBigInt.forEach(value -> System.out.print(value + ", "));
    }
}