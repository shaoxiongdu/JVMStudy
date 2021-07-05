package cn.shaoxiongdu.chapter2;
/*

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

public class OOMTestMetaSpace extends ClassLoader {
    public static void main(String[] args) {
        int count = 0;
        try {
            OOMTestMetaSpace test = new OOMTestMetaSpace();
            for (int i = 0; i < 10000000; i++) {
                //创建ClassWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                //类的加载
                test.defineClass("Class" + i, code, 0, code.length);//Class对象
                count++;
            }
        } finally {
            System.out.println(count);
        }
    }
}*/
