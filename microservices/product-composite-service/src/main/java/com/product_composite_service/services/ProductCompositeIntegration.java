package com.product_composite_service.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

@Component
public class ProductCompositeIntegration implements ProductService, RecommendationService, ReviewService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,

            @Value("${app.product-service.host}")
            String productServiceHost,
            @Value("${app.product-service.port}")
            int productServicePort,
            @Value("${app.recommendation-service.host}")
            String recommendationServiceHost,
            @Value("${app.reccomendation.service.port}")
            int recommendationServicePort,
            @Value("${app.review-service.host}")
            String reviewServiceHost,
            @Value("${app.review.service.port}")
            int reviewServicePort
    ) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        productServiceUrl = "http://" + productServiceHost + ":" +
                productServicePort + "/product/";
        recommendationServiceUrl = "http://" + recommendationServiceHost
                + ":" + recommendationServicePort + "/recommendation?productId="; reviewServiceUrl = "http://" + reviewServiceHost +
        ":" + reviewServicePort + "/review?productId=";
    }

    public Product getProduct(int productId) {
        String url = productServiceUrl+productId;
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

}
