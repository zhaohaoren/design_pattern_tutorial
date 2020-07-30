# 工厂模式

通常我们说的工厂模式是指**工厂方法模式**。工厂模式的目的是**将对象的创建和使用分离**，用来移除一些类创建对象 和对象操作行为之间的耦合，让客户端类不创建对象交给工厂来创建对象。如果一个类没有太多变数，构造也简单就不要使用工厂类，不然只会导致工厂泛滥。

工厂模式是一种**创建型模式**。

## 模式背景

开发中经常会出现需要根据不同的条件，去创建不同的对象并调用其特有方法的情况。比如我要实现一个需求，依据用户需求创建不同的图形，然后打印出来。在不使用工厂模式的情况下，我们代码可能会长成这样：

```java
public class BadCase {

    private String name;

    public BadCase(String shape) {
        if ("circle".equals(shape)) {
            this.name = "circle";
        } else if ("rect".equals(shape)) {
            this.name = "rect";
        } else if ("triangle".equals(shape)) {
            this.name = "triangle";
        }
        //else if ...
    }

    public void draw() {
        if ("circle".equals(this.name)) {
            System.out.println("i am circle");
        } else if ("rect".equals(this.name)) {
            System.out.println("i am rect");
        } else if ("triangle".equals(this.name)) {
            System.out.println("i am triangle");
        }
        //else if ...
    }

    public static void main(String[] args) {
        BadCase bad = new BadCase("rect");
        bad.draw();
    }
}
```

当然这是故意这么写成这么最糟糕样子的，这种写法显然毫无任何优雅可言，完全面向过程式写法。他存在哪些问题呢？

1. 毫无对象的概念！完全是面向过程的写法。
2. 太多的`if-else`判断，在创建的时候使用`if-else`来判断进行创建，输出的时候又一次判断再输出，不仅性能差，代码还冗余。
3. 如果此时我们希望加入五角星形状，我们就需要修改该类。这违反了开闭原则。
4. 这个`BaseCase`的类，职责过重，既负责创建又负责使用，违反了单一职责原则。
5. main函数相当于客户端，客户端需要使用new来创建，每要一个图像，就要new一个该`BaseCase`实例。在实际中new实例可能需要很多初始化工作，这就会在代码中耦合大量创建对象的代码，而且每使用一次就需要耦合一堆初始化代码，对象的创建和使用都在一起，编码复杂且耦合性强。

工厂模式就是为了一定程度上解决该问题的，一般工厂模式有下面3种：

- 简单工厂模式（Simple Factory），又称静态工厂方法模式（Static Factory Method Pattern）。
- 工厂方法模式（Factory Method），又称多态性工厂模式（Polymorphic Factory）；

- 抽象工厂模式（Abstract Factory），又称工具箱模式（Kit 或Toolkit）。

**先解决问题1：**

我们一般都不会像上面那么写。一般我们都会将每个图形，对应成一种类型的对象。既然说工厂模式，我们设定这些对象就是一个个的商品：

```java
// 产品A
class ProductA {
    public void printName() {
        System.out.println("i am A");
    }
}
// 产品B
class ProductB{
    public void printName() {
        System.out.println("i am B");
    }
}
```

这才是Java工程中最常见的，我们的项目中散落着大量的各种实体类，并且他们之间有关联。下面就使用那三种工厂模式来解决其他的问题。

## 简单工厂模式

简单工厂模式不属于GoF的23种设计模式里面，但他是学习其他工厂模式的基础。他的设计思想比较简单：主要**目的是将对象的创建和使用分离**（即解决问题5）。使用的所有对象都是通过工厂类来创建的，然后客户端来使用。

### UML

![SimpleFactory](D:\workspace\blog-docs\docs\设计模式\SimpleFactory.jpg)

### **原理**

1. 将需要创建的对象，封装到不同的类中，这些类我们设定为产品类。
2. 对这些产品类的共性部分，我们需要抽象出来，封装到抽象产品类中。
3. 提供一个工厂类，并提供一个静态方法，该方法依据传入参数，创建不同的对象。

**基本要素**

1. 产品的抽象接口或类
2. 工厂类
3. 静态工厂方法

### 实现

**先抽象封装好产品类**

```java
// 所有工厂里面的产品，抽象一个接口。便于产品的扩展不会影响到工厂类和客户端类去改动。
interface Product {
    void printName();
}
// 产品A
class ProductA implements Product {
    @Override
    public void printName() {
        System.out.println("i am A");
    }
}
// 产品B
class ProductB implements Product {
    @Override
    public void printName() {
        System.out.println("i am B");
    }
}
```

**实现工厂类**

```java
public class SimpleFactory {
  	// 静态工厂方法
    public static Product getProduct(String name) {
        switch (name.toLowerCase()) {
            case "a":
                return new ProductA();
            case "b":
                return new ProductB();
            default:
                return null;
        }
    }
	// 模拟客户端使用
    public static void main(String[] args) {
        SimpleFactory.getProduct("a").printName();
    }
}

```

### 优缺点

#### 优点

- 对象的创建和使用分离：创建由工厂类完成，客户端只是使用。
- 一定程度上减轻了类的职责，对象的使用封装到对象的内部。

#### 缺点

- 工厂类职责依然过重：还是太多判断，并且一旦不能正常工作，所有该工厂的对象都将受到影响。
- 系统扩展的话，需要修改工厂类：如果添加产品，还需要修改工厂类的代码。
- 因为使用了静态工厂方法，所以工厂类不能形成基于继承的等级结构。
- 会增加系统中的类个数：需要引入工厂类，这可能会增加系统的复杂度。

### 适用场景*

- 工厂类负责**创建的对象比较少**。因为比较少的时候，工厂类内部的业务不会太复杂。
- 客户端只想传参得对象，对如何创建对象不关心。

> Tips：
>
> 我们可能感觉在客户端中使用工厂类需要传递参数这种方式不好，每次想要更换的时候，需要修改客户端代码。这个问题可以通过将该参数通过读取配置文件的方式来解决。这也正是Spring的思想。



## 工厂方法模式

**简单工厂模式存在一个问题：**当要引入新的产品的时候，就需要修改工厂类，违背开闭原则。而工厂方法模式就是为了解决该问题做的简单延伸。目的是要**解决工厂职责太重问题**。

思考一下：想要通过动态添加类，而不是修改原代码的方式来修改工厂类，该怎么做？没错！就是再抽取一个抽象层，然后只要添加子类就完成了动态的扩展。工厂方法模式也是基于这个思想，让工厂可以动态扩展。

### UML

![MethodFactory](D:\workspace\blog-docs\docs\设计模式\MethodFactory.jpg)

### **原理**

上面我重点抽象的是产品类，而工厂方法模式我们重点**是对工厂也进行抽象**。

我们将工厂的工厂方法抽象出一层**抽象工厂类**，该类是该模式的核心。具体产品的创建交给了工厂的子类去完成。

**每个产品类都对应着一个具体工厂实现类**，后面将通过该工厂类来创建该产品类对象。

这个工厂方法相当于对简单工厂模式的工厂类进行进一步的减轻职责：多创建一些工厂让他们分别负责自己的产品，客户端使用时相当于在产品外面都包了一层抽象工厂类，直接面向抽象工厂编程。客户端就不需要知道产品的类，只需要知道产品的工厂类就行了。那么产品类就和客户端隔离了。我们就可以查询代码中有哪些工厂就行了。

**基本要素**

1. 产品及产品的抽象
2. 工厂的抽象（接口或者类）
3. 具体的工厂，每个产品对应一个工厂，工厂的具体实现类。

### **实现**

```java
// 抽象工厂
interface ProductFactory {
    Product getProduct();
}
// 生产A的抽象工厂
class AProductFactory implements ProductFactory {
    @Override
    public Product getProduct() {
        return new ProductA();
    }
}
// 生产B的抽象工厂
class BProductFactory implements ProductFactory {
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
// 客户端使用
ProductFactory factory = new AProductFactory(); // 可以使用配置文件来指定加载哪个工厂
Product product = factory.getProduct();
product.printName();
```

> 这种模式，当添加产品时候，不需要该代码，但是需要添加大量的类。

### 优缺点

#### 优点

- 更加符合开闭原则，新加产品不需要修改工厂类。
  - 我们只需要对新加的产品，添加一个对应的工厂类，然后加入项目中即可。
- 没有了静态方法，可以形成基于继承体系的工厂了。
- 每个产品只负责创建一个产品，符合单一职责。

#### 缺点

- 加一个（或者说一类）产品，就要加一个对应的工厂类，很烦，会产生大量工厂类！
- 虽然不用修改工厂类代码，但是新加的工厂实现类，还是需要通过配置的方式才能指定客户端用哪个具体实现类加载。所以客户端代码一般都要使用DOM，反射等技术来支持具体实例化配置，会增加系统的理解难度。
  - 注意：我们开闭原则，不代表我们什么都不改动！这是不可能的！
  - 我们不要改动的应该是封装的部分，而客户端使用方肯定还是需要有改动的。之所以不能改，设想一下，你写的功能是以第三方包的形式给别人用的，你一旦改动出问题了，影响的是所有用你第三方包的人，你再让他们去为你改动再修改，明显不可能，所以对于第三方包这种性质的类，我们只允许添加不允许修改。

### 适用场景*

- **这个模式是工厂方法使用频率最高的模式！**所以一般情况下，你都应该尝试看是否适合使用它。
- 我们不希望把产品类的信息交给客户端（其实就是客户端知道的参数是和具体的实体对象有关的），而是希望客户端感知的只有专门用于创建该对象的工厂类。这样即创建封装在工厂层，使用封装在产品实体层。



## 抽象工厂模式

上面工厂方法模式，会导致系统中**存在大量的工厂类**。我们可以将一些相关产品组成一个产品组，然后交给同一个工厂来统一生产。

**解决问题**

- 添加新产品需要添加大量的类，如何减少系统类的个数。
- 同一种风格的产品，希望他们可以绑定在一起。

### UML

![AbstractFactory](D:\workspace\blog-docs\docs\设计模式\AbstractFactory.jpg)

### **原理**

先了解两个概念：

**产品等级：**产品等级结构即产品的继承结构，如一个抽象类是电视机，其子类有海尔电视机、海信电视机、TCL电视机，则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机是其子类。

**产品族：**在抽象工厂模式中，产品族是指由**同一个工厂生产的**，位于不同产品等级结构中的一组产品，如海尔电器工厂生产的海尔电视机、海尔电冰箱，海尔电视机位于电视机产品等级结构中，海尔电冰箱位于电冰箱产品等级结构中。海尔产的电视，电冰箱就是一个产品族。

上面两个概念看不懂我觉得也无所谓，没要扣字眼。**理解的话，就是系统中有几类产品，同时有几种风格。每种风格都可以当做是一个工厂，这个工厂就生产该风格下的所有类的产品。**（再举个例子：`UI`界面有明亮风格，暗黑风格等。`UI`组成有button，text框，文字等控件。那么抽象工厂就是相当于有一个暗黑工厂，这个工厂的工厂方法生产出的是一套控件，他们可以看做一个模板）。

抽象工厂模式相当于是对工厂方法模式的那些工厂类做进一步收缩。将一个系列的产品绑定在一起形成一个产品族。然后只要该产品族的工厂类就行了。

**基本要素**

1. 产品的抽象，可以是若干个。以及这些抽象的具体产品。 比如：`UI` 的按钮是抽象，红色按钮，黄色按钮是具体实现。
2. 一个产品族的工厂抽象。以及具体实现。比如：按钮，文本框，选择框这三个当做一个产品族，工厂抽象就要有创建这三个的抽象方法。在一个族里面的产品需要有共同的约束，比如上面的那些控件都是依据不同`UI`会有不同变化的。

### **实现**

**产品族**

所有的类如果全的话就是：种类*风格 的个数

```java
//A1 A2 和 A 是不同的产品等级。 A是某一种产品 A1 A2 是该种产品的不同风格（不同厂家或者不同UI风格）
interface Product_A {}
//A1 B1 是产品族
class ProductA1 implements Product_A {}
class ProductA2 implements Product_A {}
//....
//B 同理
interface Product_B {}
class ProductB1 implements Product_B {}
class ProductB2 implements Product_B {}
```

**抽象工厂**

顶层抽象是包含了创建所有种类的抽象。

具体工厂的工厂方法是去创建属于该风格下的所有类型产品。

```java
// 产品族工厂抽象
interface IAbstractFactory {
    Product_A createA();
    Product_B createB();
}

// 产品族为1的所有产品
class Factory1Impl implements IAbstractFactory {
    @Override
    public Product_A createA() {
        return new ProductA1();
    }
    @Override
    public Product_B createB() {
        return new ProductB1();
    }
}

// 产品族为2的所有产品
class Factory2Impl implements IAbstractFactory {
    @Override
    public Product_A createA() {
        return new ProductA2();
    }
    @Override
    public Product_B createB() {
        return new ProductB2();
    }
}
```

客户端

```java
public static void main(String[] args) {
    IAbstractFactory factory = new Factory1Impl();
    Product_A a = factory.createA();
    Product_B b = factory.createB();
    a.printName();
    b.printName();
}
```

### 优缺点

#### 优点

- 减少了工厂方法模式中工厂类的个数：多个根据特征合成一个工厂。然后一个工厂来创建这些对象。
- 可以很方便的添加新的产品族

#### 缺点

- 添加新的产品很费劲，可能需要修改很多代码。

### 适用场景*

首先我们业务需要使用工厂模式来创建对象，然后我们这些对象还有一个特性：这些对象若干个可以做为一个整体的产品的模板。那么就可以考虑使用抽象工厂模式。

- UI换肤，组件布局都一样，只是每个小控件UI不一样，这个布局就是一个族。（**这个模式很看重族的概念**）
- 为不同操作系统生成程序。长得都一样，无非操作系统api层调用不同。



## 总结

### 速记

方便方便理清和记忆这些工厂模式，粗糙的总结下：

他们三个都是需要产品有抽象层。

- 简单工厂
  - 一个工厂类，有个静态工厂方法。
  - 工厂方法通过`if-else`或者`switch-case`来new对象。
- 工厂方法
  - 对工厂进行抽闲，有很多工厂实现类，每个工厂实现类创建一个产品。
  - 一个产品一个工厂类，每个工厂类对应一个产品，工厂方法new一个对象。
- 抽象工厂
  - 将多个不同类型产品合入一个工厂类中构成一个套件或者模板，每个工厂实现类就是一套不同的套件，这个工厂实现类专门生产属于该风格下的各类产品。
  - 一套风格对应一个工厂类，每个工厂类对应多个产品，提供多个new对象的工厂方法。



# 附

相关代码：https://github.com/zhaohaoren/design_pattern_tutorial

如有代码和文章问题，还请指正！感谢！