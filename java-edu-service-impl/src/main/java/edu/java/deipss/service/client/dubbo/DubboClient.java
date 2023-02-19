package edu.java.deipss.service.client.dubbo;

import edu.java.deipss.service.client.BaseClient;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;

public class DubboClient implements BaseClient<DubboRequest> {

    @Override
    public Object execute(DubboRequest request) {
        // 引用远程服务
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setInterface(request.getService());
        reference.setVersion("1.0.0");
        reference.setApplication(new ApplicationConfig("workbench"));
        reference.setGeneric(true);
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://" + request.getRegistryAddress());
        reference.setCheck(false);
        reference.setRegistry(registryConfig);
        GenericService genericService = reference.get();
        Object result = genericService.$invoke(request.getMethod(), request.getParameterTypes(), request.getParameterList());
        return result;

    }
}
