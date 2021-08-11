package com.sun.jni;

public class HelloWorld {

    /**
     * JNI Demo
     * 1、javac ./com/sun/jni/HelloWorld.java
     * 2、生成C语言代码 javah -jni com.sun.jni.HelloWorld
     * 3、创建 jni_helloworldImpl.cpp
     * 4、生成 .so 文件 g++ -shared -I /Library/Developer/CommandLineTools/SDKs/MacOSX10.14.sdk/System/Library/Frameworks/
     *    JavaVM.framework/Versions/A/Headers jni_helloworldImpl.cpp -o Helloworld.so
     */

    {
        //绝对路径
        System.load("/Users/hongweisun/Development/JavaDev/LeetCode/src/main/java/com/sun/jni/Helloworld.so");
    }

    public native void sayHello();

    public static void main(String[] args) {
        new HelloWorld().sayHello();
    }
}
