# 【设计模式详解】单例模式

单例模式属于**创建型模式**。它应该是接触到的各种模式中最简单的，也是最普遍能见到的了。类似于Spring等很多框架里面都大量的采用了单例模式。本文将介绍所有网络上流传的单例模式的各种写法，如有不足欢迎补充！

## 模式背景

在某些情况下，我们需要系统中的某些对象，在**`全局只有唯一的存在`**，就是整个程序只会有一个实例。比如windows的任务管理器，我们只能打开一个，无同时打开多个。对于面向对象的语言来讲，单例模式就是一个类创建唯一实例之后，在当前系统（严谨点应该是和该系统关联的所有相关系统）都无法再创建该实例。

## UML

![https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm](D:\workspace\blog-docs\docs\设计模式\singleton_pattern_uml_diagram.jpg)

## 原理

对于Java来说，单例模式需要这3个基本的要素：

1. **构造函数private**
   - 让外界无法通过new的方式来创建新的对象。
2. **内部能够持有一个自己的实例**
   - 因为我们没法new对象，所以我们可以认为该对象和其类一样的唯一。所以这个对象就最好交给这个类来保管。
   - 所以整个类内部需要一个能保管自己实例对象的引用。
3. **对外使用静态方法获取单例的实例**
   - 我们没法使用new了，需要对外提供一个静态方法，让外部通过静态方法获取单例对象。

但是考虑程序在初始化和使用该单例时候的性能问题，单例可以有很多种实现方式，但是他的思想基础就是这三个基本的要素。

## 实现

单例模式有4种写法，各有优劣，下面逐个说明。

### 饿汉式

这是最简单单例写法，我们假设使用者很"饥饿"，**在单例类初始化的时候，我们就要给他这个对象**。如果在资源开销不是很大的时候，且没有明确延迟加载需求的时候我们可以直接使用饿汉式。

**实现**

```java
public class EagerSingleton {
    //2: 内置一个单例对象
    private static final EagerSingleton singleton = new EagerSingleton();
    //1: 构造函数私有化
    private EagerSingleton() {
    }
    //3: 提供静态方法获取数据
    public static EagerSingleton getInstance() {
        return singleton;
    }
}
```

- 优点
  - 实现简单，因为类加载就已经new对象了，所以单例是**线程安全的**。
- 缺点
  - 不是懒加载的，会消耗过多资源。**比如系统大量的单例，80%都不一定用到，那么在系统加载的时候会很耗时间和资源**。

> 多数情况下**不推荐**（当然不绝对，如果只是少量该类的话，实现这个时间成本最低了。）

### 懒汉式

我们需要对饿汉式存在的问题改良：所以设定使用者不那么饿，还很懒，让类在在我们使用的时候创建这个对象就可以了。

#### 简单懒汉

简单懒汉就是对该单例实现延迟加载，**将创建的过程放到 `getInstance()` 过程中！** 因为第一次获取的时候没有对象，所以我们先要判断该类是否已经初始化了一个对象在里面。

**实现**

```java
public class LazySingleton {
    //1: 内置单例对象引用
    private static LazySingleton singleton = null;
    //2: 构造函数私有化
    private LazySingleton() {
    }
    //3: 提供获取对象的静态方法
    public static LazySingleton getInstance() {
        // 4：判断如果还没有创建就先创建
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
```

- 优点
  - 确实懒加载的，解决了饿汉式可能占资源的问题。
- 缺点
  - 多线程会出问题。比如当线程t1已经创建了单例，线程t2也同时调用了`getInstance`方法，此时因为没有同步机制，t1方法走完了创建了实例，t2再走一次，对象会被创建2次。
  - **线程不安全。**

> **不推荐**（该写法是**线程不安全的**。但是他不能保证获取的单例都是唯一的）

#### 简单线程安全懒汉

在简单懒汉基础上加了线程同步机制。只不过这个同步是直接**对 ` getInstance() `方法进行同步**。

**同步静态方法体的实现**

```java
//3: 提供获取对象的静态方法
synchronized public static LazySingleton getInstance() {
    // 判断如果还没有创建就先创建
    if (singleton == null) {
        singleton = new LazySingleton();
    }
    return singleton;
}
```

- 优点
  - 线程安全，较为简单。
- 缺点
  - get对象完全串行化，并发访问效率差。

> **不推荐**（并发性能差）

#### 双重校验锁懒汉（DCL）

`DCL：double-checked locking`。上面的并发性能差，其**主要原因是我们加锁同步的范围太大了**。我们可以对同步的代码块进一步缩小到new Singleton的时候。但是当两个线程都执行到singleton == null的代码块里面了，这时候同步阻塞了，那么当第一个线程创建完成后，第二个线程进入的时候还是需要进一步判断当前系统中是否已经有了单例，这样才能保证线程安全。

**疑问**

- 既然有第二重还要判断，那为啥还要第一重？
  - 如果去掉了和上面方法体同步。
  - 这个二重校验锁其实应该这样看：我们确实只是对上面那个整个方法体`synchronized (LazySingletonV2.class) `加了锁。这样性能和上面的方法同步就没区别了。所以锁和第二重判断是保证我们创建单例安全的。 而第一重，是做了一个优化！**第一重的核心作用并不是重复检验，而是优化！**
  - 第一重判断保证一旦实例创建好了，后面的线程不需要走同步块就可以直接返回实例，但是上面那个单例不可以（执行必须都走同步）。
  - 而第二重才是阻止并发创建单例的时候。
  - **也就是说该单例，加了第一重判断后，只有在创建单例对象的那段时间效率会差些，一旦创建完，效率还是很高，后面都不会走同步区域**。

**二重校验实现**

- 这里主要需要注意到两点：
  - **二重检验**
  - **`singleton`引用需要加`volatile`关键字，保证内存可见性。**

```java
//6: 因为线程可见性，需要使用volatile修饰。
private volatile static LazySingletonV2 singleton = null;
//3: 提供获取对象的静态方法
public static LazySingletonV2 getInstance() {
    //4: 第一重判断
    if (singleton == null) {
        synchronized (LazySingletonV2.class) {
            //5: 第二重判断
            if (singleton == null) {
                singleton = new LazySingletonV2();
            }
        }
    }
    return singleton;
}
```

- 优点
  - 这是饿汉式最完美的实现方案了。**线程安全**又懒加载。
- 缺点
  - 比同步方法效率要高些，但是依然性能不是很高，特别用了`volatile`关键字后，会屏蔽jvm的底层一些优化，性能也不是很完美。

> **不推荐**（实现麻烦，而且后面有更好的！）



### 静态内部类（IoDH）

`IoDH：Initialization on Demand Holder`

有没有一种可以懒加载，还线程安全的？这就要说这个IoDH了。该单例主要利用了java的**内部类和静态内部类都是延时加载**的这一加载机制。

**实现**

```java
public class IoDHSingleton {

    //1: 构造私有化
    private IoDHSingleton() {
    }

    //2: 静态内部类
    private static class HolderClass {
        private final static IoDHSingleton instance = new IoDHSingleton();
        /*
         * 利用了java的类加载机制：
         * 加载IoDHSingleton的时候不会初始化HolderClass，而是在getInstance的时候才会加载。
         * */
    }

    //3: 静态方法
    public static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }


    public static void main(String[] args) {
        IoDHSingleton s1 = IoDHSingleton.getInstance();
        IoDHSingleton s2 = IoDHSingleton.getInstance();
        System.out.println(s1 == s2);
    }
}
```

- 优点
  - 懒加载，**线程安全**。
- 缺点
  - 对语言依赖性很强，不是java或者和java类似的加载机制的语言可能不支持。
  - 序列化不能保证单例。也就是我将一个对象序列化到磁盘上，然后再读取到内存，这样内存中还是会出现2个对象。只不过这种场景就太少见了。

> **推荐**（比较完美的方案了，在内部类被使用而加载的时候创建了单例，不仅是懒加载还自然保证单例。）

### 枚举

这是《Effective Java》里面推荐的方式。

```java
public enum EnumSingleton {
    INSTANCE;
}
```

- 优点
  - 线程安全，序列化单例保证
- 缺点
  - 没啥缺点

> **强烈推荐**（单例能用枚举就是用枚举吧。如果不习惯就用IoDH。）



## 优缺点

### 优点

- 可以严格控制外部如何访问这个对象。
- 系统中只存在一个，节省系统资源。

### 缺点

- 单例模式没有抽象层，不好对单例类进行扩展。
- 单例模式职责太重，既负责创建又负责业务方法。一定程度违背单一职责原则。

## 使用场景

1. 网站计数器
2. 线程池实例
3. windows资源管理器等等
4. 主要系统中需要的东西是唯一的，就会使用这个。
5. 如果一个东西创建和销毁也很耗性能，考虑单例让他常驻内存。

# 附

相关代码：https://github.com/zhaohaoren/design_pattern_tutorial

如有代码和文章问题，还请指正！感谢！