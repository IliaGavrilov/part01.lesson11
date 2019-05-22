import java.util.stream.IntStream;

class MyThread extends Thread {

    /* Поля класса MyThread */
    int varInt;
    int iterable;

    /* Конструктор класса MyThread */
    MyThread(int givenVarInt) {
        this.varInt = givenVarInt;
        this.iterable = 1;
    }

    /* Переписаный метод run() для вычисления факториала переданного числа, используя стримы */
    @Override
    public synchronized void run() {
        try {
//            for (int i = 1; i <= varInt; i++) {
//                System.out.println("Дoчepний поток элемента массива "+ varInt +", "+ "итерация: " + i);
//                Thread.sleep(500);
//                iterable = iterable * i;
//              }
            iterable = IntStream.rangeClosed(2, varInt).reduce(1, (x, y) -> x * y);

        } catch (Exception e) {
            System.out.println("Дoчepний поток элемента массива " + varInt + " прерван.");
        }
        System.out.println("Дoчepний поток элемента массива " + varInt + " завершен.");
        System.out.println("Результат: " + iterable + "\n");
        setIterable(iterable);
    }

    /* Геттер для вызова поля класса, содержащей результат вычисления факториала */
    public int getIterable() {
        return iterable;
    }

    /* Сеттер для назначения результата вычисления факториала в поле класса */
    public void setIterable(int temp) {
        this.iterable = temp;
    }
}