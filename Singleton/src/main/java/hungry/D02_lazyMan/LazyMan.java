package hungry.D02_lazyMan;

/**
 * 懒汉式单例：
 *      当需要用的时候，我再去初始化出来
 *
 * 问题：
 *      单线程是没问题的，但是多线程就会产生问题
 *
 * 解决：加锁解决
 */
public class LazyMan {

    public LazyMan() {
        System.out.println(Thread.currentThread().getName() + "-ok");
    }

    private static LazyMan lazyMan;

    public static LazyMan getInstance() {
        if (lazyMan == null) {
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }
}
