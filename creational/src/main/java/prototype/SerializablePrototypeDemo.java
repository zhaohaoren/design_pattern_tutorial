package prototype;

import java.io.*;

/**
 * 序列化方式实现原型模式
 * 可以用于深克隆
 *
 * @author zhaohaoren
 */
public class SerializablePrototypeDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialObj obj = new SerialObj();
        obj.setName("out");
        Attachment attachment = new Attachment();
        attachment.setName("in");
        obj.setAttachment(attachment);
        SerialObj objClone = obj.deepClone();
        System.out.println(obj == objClone);
        System.out.println(objClone.getAttachment() == attachment);
    }
}

class SerialObj implements Serializable {
    private String name;
    private Attachment attachment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public SerialObj deepClone() throws IOException, ClassNotFoundException {
        // 将对象写入流中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        // 从流中取出对象
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (SerialObj) ois.readObject();
    }
}

class Attachment implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}