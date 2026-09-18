package com.product_service.services;

import com.util.ServiceUtil;
import com.api.core.product.Product;
import com.api.core.product.ProductService;
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
