**设计模式之委派模式**

 原理就是类 B和类 A 是两个互相没有任何关系的类，B 具有和 A 一模一样的方法和属性;并且调用 B 中的方法，属性就
 是调用 A 中同名的方法和属性。B 好像就是一个受 A 授权委托的中介。第三方的代码不需要知道 A 的 存在，也不需要和
 A 发生直接的联系，通过 B 就可以直接使用 A 的功能，这样既能够使用到 A 的各种功能，又能够很好的将 A 保护起
 来了，一举两得。也是一种行为型的设计模式。

 员工类StuffA,StuffB实现接口Stuff，项目经理manager，将具体任务进行分配执行，Boss是直接调用manger下达命令


 ![委派模式](https://github.com/lwx57280/Java_Design_Patterns/blob/master/DelegatePattern/img-folder/delegate_pattern.jpg)


    可以看到在实际实现中和代理模式以及策略模式稍微有点相似。实际上可以这样理解：代理模式注重的是过程，委派模式注重的是

    结果，策略模式注重的是可扩展（外部扩展），委派模式注重的是内部的灵活和复用。委派模式的核心是分发，调度，派遣。委派
    模式可以看做是静态代理和策略模式的一种特殊组合。
    
    
   在实际的Sping中有大量使用到委派模式，在Spring中以Delegate，Dispatcher结尾的类名中，就使用到了委派模式。
   
   
  https://blog.csdn.net/harryptter/article/details/84824834