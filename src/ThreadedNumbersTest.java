/**
 * Created by IntelliJ IDEA.
 * User: joann
 * Date: 5/2/12
 * Time: 6:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadedNumbersTest {
    public static void main(String[] argv){
        ThreadedNumbers tn = new ThreadedNumbers();
        SetNumbers sn = new SetNumbers(tn);
        GetNumbers gn = new GetNumbers(tn);
        Thread alpha = new Thread(sn);
        Thread beta = new Thread(gn);
        alpha.setName("alpha thread");
        beta.setName("beta thread");
        alpha.start();
        beta.start();

    }
}
