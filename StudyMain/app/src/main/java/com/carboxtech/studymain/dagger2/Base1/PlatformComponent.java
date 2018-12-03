package com.carboxtech.studymain.dagger2.Base1;

import com.carboxtech.studymain.dagger2.Base2.ActivityModule;
import com.carboxtech.studymain.dagger2.Base2.ShangJiaModule;
import com.carboxtech.studymain.dagger2.ZhaiNan;

import dagger.Component;

/**
 * Created by admin on 2018/11/19.
 *
 * @Inject 和  @Component   需要配合使用
 * <p>
 * <p>
 * Component需要注解在一个接口上就好了,   Dagger2 会自动帮我们生成一个实现类，生成的代码位置在 app 模块 build 文件夹中
 * 实现类  的名字都是 Dagger+接口名称,比如本接口的实现类名字是： DaggerPlatform
 * 有了 DaggerPlatform，我们就能够使用 Dagger2 进行代码的依赖注入了。
 *
 */

@Component(modules = {ShangJiaModule.class ,ActivityModule.class }  )
public interface PlatformComponent {

    ZhaiNan waimai();

}
