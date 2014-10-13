/* Part 3. Write a short program that creates two threads,
one of which successively sets a variable to the integers
 from 1 to 10, and another that reads the values, printing
 each one as it goes. Use synchronized methods, wait() and
 notify(). Use a separate condition variable to signify that
  the integer variable is empty. Since the whole point of the
  exercise is to make sure that every written value is read,
   without any values being skipped or overwritten, pay special
   attention to access control. Look at the sample code in
   Section 7 of this module's commentary for an idea of how to proceed.
 */

/**
 * Created by IntelliJ IDEA.
 * User: joann
 * Date: 5/1/12
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadedNumbers{
    private int num;
    private boolean numSet = false;

    public synchronized void SetVariable(int aNum){
         while (numSet){
            try{
                wait();
            } catch (InterruptedException ie){
                System.out.print("writer: Exception, " + ie);
            }
        }
        num = aNum;
        numSet = true;
        notify();
    }

    public synchronized int ReadVariable(){
        int theNum = -1;
        while (!numSet){
            try{
                wait();
            } catch (InterruptedException ie){
                System.out.print("reader: Exception, " + ie);
            }
        }
        theNum = num;
        numSet = false;
        notify();
        return theNum;
    }
}
