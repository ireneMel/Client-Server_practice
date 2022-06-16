package tictak;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Data d = new Data();

        Worker w1 = new Worker(1, d); //tak
        Worker w2 = new Worker(2, d); //tic
        Worker w3 = new Worker(3, d); //toe

        w3.join();
        System.out.println("end of main...");
    }
}