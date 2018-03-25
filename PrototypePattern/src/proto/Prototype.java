package proto;

import java.io.*;

/**
 * 深浅复制的例子：
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 6196587363529076566L;

    private String name;

    private SerializableObject obj;

    /* 浅复制 */
    public Object clone()throws CloneNotSupportedException{
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }


    /* 深复制 */
    public Object deepClone()throws IOException,ClassNotFoundException{
        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }
}
