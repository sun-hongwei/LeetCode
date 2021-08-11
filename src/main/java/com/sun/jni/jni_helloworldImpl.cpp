#include <jni.h>
#include "com_sun_jni_HelloWorld.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_com_sun_jni_HelloWorld_sayHello
(JNIEnv *env, jobject obj)
{
    printf("Hello world ! \n");
    return;
}