package singleton;

/**
 * 枚举单例
 * -
 * 优点：可以实现真正的单例，没有序列化等问题
 * 缺点：1.5后才能使用
 *
 * @author zhaohaoren
 */
public enum EnumSingleton {
    INSTANCE;
}
