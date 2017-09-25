# MobikeOfoAnimation
Mobell bike stickers dynamic effect and ofo effect of big eyes yellow car
### Use the jbox2d framework to build the physics engine Mobell bike sticker animation
 
When one use v-mobile APP, accidentally discovered the v-mobile label stickers advertising effect, the effect is very cool, very beautiful. 

Then the Internet search cool animation, inadvertently discovered the jbox2d engine, and then back in under the v-mobile bicycle APK, found that the use of libgdx-box2d, so that the v-mobile is this effect using libgdx-box2d physics engine to achieve: 
 
**Jbox2d and libgdx-box2d**:  

What's the difference between jbox2d and libgdx-box2d? What's the relationship between them?  

**Jbox2d**:  

Jbox2d Baidu encyclopedia describes: jbox2D physics engine, the original Box2D is written in C++, and later extended to Java, as and other versions. Popular mobile games, angry birds is the use of jbox2D physics engine. However, the Java version of the jbox2D engine doesn't perform as well as the C++ environment. On the mobile phone with better performance, the jbox2D effect is also good.  

**Libgdx**:  

Libgdx Baidu encyclopedia describes this: libGdx is a cross platform 2D/3D game development framework, which is written in Java/C/C++ language.  

May read Baidu encyclopedia, or more obscure, we only know that they are both physical engines, and know the angry birds, that is developed with jbox2d engines.  

Later, through the search to understand, such a sentence: Libgdx using JNI encapsulates the box2d version of c++, making it more efficient than other counterparts of the physical engine, such as jbox2d faster. So the final conclusion is that jbox2d is java oriented and runs slowly. While libgdx is c/c++ oriented, the operation efficiency is fast.  

The implementation of this effect is based on jbox2d, and the final effect is as follows:  
 ![image](https://github.com/createBean/MobikeOfoAnimation/blob/master/gif/mobike.gif
)    
A brief description of jbox2d physics engine in An Zhuozhong's usage, jbox2d physics engine is not responsible for the rendering of view, only the calculation and analysis of negative physical data, such as the density, quality, speed, friction, collision force, restoring force......  

Generally speaking, in a Zhuozhong view represents an object that is rigid and rigid body bound by view and set the initial parameters, the last stop of draw, and then removed from the binding rigid drawing parameter to the interface, so the cycle. And all the physical parameters of the object are completed by the jbox2d physics engine.
