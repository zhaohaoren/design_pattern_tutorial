package top.zhaohaoren.dp.flyweight;

import java.util.HashMap;

/**
 * 享元工厂类
 *
 * @author zhaohaoren
 */
public class FlyweightFactory {
    /**
     * 单例
     */
    private static FlyweightFactory instance = new FlyweightFactory();
    /**
     * 缓存池
     */
    private HashMap<String, Flyweight> flyweights = new HashMap<>();

    /**
     * 存入共享享元对象
     */
    public FlyweightFactory() {
        Flyweight fw1 = new ConcreteFlyweight1();
        Flyweight fw2 = new ConcreteFlyweight2();
        flyweights.put("1", fw1);
        flyweights.put("2", fw2);

    }

    /**
     * 获取
     */
    public Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            //缓存存在则直接返回
            return flyweights.get(key);
        } else {
            //不存在则创建并缓存再返回
            Flyweight fw = new ConcreteFlyweight1();
            flyweights.put(key, fw);
            return fw;
        }
    }

    public static FlyweightFactory getInstance() {
        return instance;
    }
}
