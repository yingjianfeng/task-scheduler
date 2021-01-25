package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapi.IDubboProvider;
import springbootapi.Response;

/**
 * Title: DemoConsumerController
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/22 10:59
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}")
    private IDubboProvider dubboProvider;

    @RequestMapping("/sayHello")
    public Response sayHello() {
        return dubboProvider.sayHello();
    }

}