package com.api2.composite.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductServiceComposite {

    @GetMapping(
            value = "/product-composite/{productId}",
            produces = "application/json"
    )
    ProductAggregate getProduct(@PathVariable int productId);
}
