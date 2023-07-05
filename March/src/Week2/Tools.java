package Week2;

/**
 * @Author Aurora_zh
 * @Date 2023/3/10 20:52
 */
public abstract class Tools {
    public final void getRuntime(){
        long starttime = System.currentTimeMillis();
        run();
        long endtime = System.currentTimeMillis();
        System.out.print("程序运行时间：" + (endtime - starttime));
    };
    public abstract void run();
}
