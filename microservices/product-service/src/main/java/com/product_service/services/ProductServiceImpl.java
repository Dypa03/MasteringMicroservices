package com.product_service.services;

import com.api2.core.product.Product;
import com.api2.core.product.ProductService;

import com.util.http.ServiceUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService {
    private final ServiceUtil serviceUtil;
    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }


    @Override
    public Product getProduct(int productId) {
        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}
