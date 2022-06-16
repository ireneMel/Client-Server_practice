package tictak;

public class Worker extends Thread {

    private final int id;
    private final Data data;

    public Worker(int id, Data d) {
        this.id = id;
        data = d;
        this.start();
    }

    @Override
    public void run() {
        super.run();
        //synchronized дає можливість сказати,
        // що змінна може бути використана тільки в одному НЕ СПЛЯЧОМУ потоку
        for (int i = 0; i < 5; i++) {
            synchronized (data) {
                try {
                    if (id != data.getState()) {
                        //каже, що поточний потік може почекати
                        data.wait();
                    }
                    if (id == 2) data.Toe();
                    else if (id == 3) data.Tic();
                    else data.Tac();

                    data.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}