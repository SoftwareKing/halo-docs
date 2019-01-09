package org.xujin.halo.docs.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xujin.halo.docs.common.DocsResource;
import org.xujin.halo.docs.common.ResultData;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class HaloDocsController {

    private final Logger logger = LoggerFactory.getLogger(HaloDocsController.class);

    private final RouteLocator routeLocator;

    @Autowired
    private SwaggerResourcesProvider swaggerResources;


    @Autowired
    private DiscoveryClient client;


    public HaloDocsController(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @GetMapping("/docsMeteData")
    public ResultData docsMeteData() {
        List<DocsResource> resources = new ArrayList<DocsResource>();
        try {
            List<Route> routes = routeLocator.getRoutes();
            //在这里遍历的时候，可以排除掉敏感微服务的路由
            routes.forEach(route -> resources.add(docsResource(route.getId(),
                    route.getFullPath().replace("**", "docs"))));
            for (DocsResource dosc: resources) {
                List<String> ipList=new ArrayList<>();
                List<ServiceInstance> instances = client.getInstances(dosc.getName());
                for (int i = 0; i < instances.size(); i++) {
                    ipList.add(instances.get(i).getHost()+":"+instances.get(i).getPort());
                }
                dosc.setInstanceInfoList(ipList);
            }
        } catch (Exception e) {
            logger.info("docs center docsMeteData  exception:{}",e.getMessage());
            return ResultData.error(500).data("swaggerMeteData exception:"+e).build();
        }
        return ResultData.ok(resources).build();

    }
    private DocsResource docsResource(String name, String location) {
        DocsResource swaggerResource = new DocsResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        return swaggerResource;
    }

    @GetMapping("/swaggerMeteData")
    public ResultData swaggerMeteData() {
        List<DocsResource> resources = new ArrayList<DocsResource>();
        try {
            List<SwaggerResource> list=swaggerResources.get();
            for (SwaggerResource dosc: list) {
                DocsResource docsResource=new DocsResource();
                docsResource.setName(dosc.getName());
                docsResource.setLocation(dosc.getLocation());
                docsResource.setSwaggerVersion(dosc.getSwaggerVersion());
                List<String> ipList=new ArrayList<>();
                List<ServiceInstance> instances = client.getInstances(dosc.getName());
                for (int i = 0; i < instances.size(); i++) {
                    ipList.add(instances.get(i).getHost()+":"+instances.get(i).getPort());
                }
                docsResource.setInstanceInfoList(ipList);
                resources.add(docsResource);
            }
        } catch (Exception e) {
            logger.info("swaggerMeteData  exception:{}",e);
            return ResultData.error(500).data("docs center swaggerMeteData exception:"+e).build();
        }
        return ResultData.ok(resources).build();
    }

}
