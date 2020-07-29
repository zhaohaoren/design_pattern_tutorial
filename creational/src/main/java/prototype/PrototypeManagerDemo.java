package prototype;

import java.util.HashMap;

/**
 * 原型管理器：将多个原型对象存储在一个集合中给客户端使用。是一个专门负责克隆对象的工厂。
 * 就是一个管理器里面存了一系列的对象，就相当于给客户端一套模板，然后客户端想要哪个具体模板的时候就克隆哪个模板。
 *
 * @author zhaohaoren
 */
public class PrototypeManagerDemo {
    public static void main(String[] args) {
        IObj obj = PrototypeManager.getManager().getObj("1");
        obj.say();
    }
}


//1: 一个该管理器管理原型类的公共接口
interface IObj extends Cloneable {
    IObj clone();

    void say();
}

//2: 原型类定义，需要自己实现clone
class Obj1 implements IObj {
    @Override
    public IObj clone() {
        try {
            return (IObj) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void say() {
        System.out.println("i am 1");
    }
}

class Obj2 implements IObj {

    @Override
    public IObj clone() {
        try {
            return (IObj) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void say() {
        System.out.println("i am 2");
    }
}

//3: 原型对象管理器
class PrototypeManager {
    /*
     * 对于管理器这种对象，使用饿汉式单例。
     * */

    private HashMap<String, IObj> hm = new HashMap<>();

    private static final PrototypeManager manager = new PrototypeManager();

    private PrototypeManager() {
        hm.put("1", new Obj1());
        hm.put("2", new Obj2());
    }

    public IObj getObj(String key) {
        return (hm.get(key)).clone();
    }

    public static PrototypeManager getManager() {
        return manager;
    }
}


