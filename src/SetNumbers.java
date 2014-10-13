/**
 * Created by IntelliJ IDEA.
 * User: joann
 * Date: 5/5/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class SetNumbers implements Runnable{
    private  ThreadedNumbers tn;

    public SetNumbers(ThreadedNumbers tn){
        this.tn = tn;
    }

     public void run() {
         for (int i=0; i<=10;i++){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running");
            tn.SetVariable(i);
            System.out.println("writer: I just set the number to: " + i);
         }
    }




}
