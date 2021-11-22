package hungry.D05_enum;

/**
 * enum：
 *      本身也是一个类哈
 *
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
