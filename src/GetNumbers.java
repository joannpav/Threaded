/**
 * Created by IntelliJ IDEA.
 * User: joann
 * Date: 5/5/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetNumbers implements Runnable{

    private ThreadedNumbers tn;

    GetNumbers(ThreadedNumbers tn){
        System.out.println("reader: Creating thread ");
        this.tn = tn;
    }

    public void run(){
        int myNum;

        do{
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running");
            myNum = tn.ReadVariable();
            System.out.println("reader: I just got this number: " + myNum);
        } while (myNum <= 10);
    }
}
