import java.util.List;

public class MyThreadCreatorImpl {

    private List<Integer> randArrayInt;
    private List<MyThread> arrayMyThread;

    MyThreadCreatorImpl(List<Integer> randArrayInt, List<MyThread> arrayMyThread){
        this.randArrayInt = randArrayInt;
        this.arrayMyThread = arrayMyThread;
    }

    /* Метод для инстанцирования объектов класса MyThread, имплементирующего функциональный интерфейс */
    public List myThreadCreatorImpl() {
        for (int i = 0; i<randArrayInt.size(); i++){
            arrayMyThread.add(new MyThread(randArrayInt.get(i)));
        }
        return arrayMyThread;
    }
}
