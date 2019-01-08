package org.xujin.halo.docs.Controller;

import org.xujin.halo.docs.DocsResource;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class HaloDocsController {

    private final RouteLocator routeLocator;

    public HaloDocsController(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @GetMapping("/docsMeteData")
    public List<DocsResource> addUser() {
        List<DocsResource> resources = new ArrayList<DocsResource>();
        List<Route> routes = routeLocator.getRoutes();
        //在这里遍历的时候，可以排除掉敏感微服务的路由
        routes.forEach(route -> resources.add(docsResource(route.getId(),
                route.getFullPath().replace("**", "docs"))));
        return resources;

    }
    private DocsResource docsResource(String name, String location) {
        DocsResource swaggerResource = new DocsResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        return swaggerResource;
    }


}
