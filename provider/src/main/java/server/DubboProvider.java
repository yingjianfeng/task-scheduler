package server;

import com.alibaba.dubbo.config.annotation.Service;
import springbootapi.IDubboProvider;
import springbootapi.Response;

/**
 * Title: DubboProvider
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/22 11:02
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DubboProvider implements IDubboProvider {

    public Response sayHello() {
        return new Response("connect success!!");
    }
}