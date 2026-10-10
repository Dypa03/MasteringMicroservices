package com.product_composite_service.services;

import com.api2.core.product.Product;
import com.api2.core.product.ProductService;
import com.api2.core.recommendation.Recommendation;
import com.api2.core.recommendation.RecommendationService;
import com.api2.core.review.Review;
import com.api2.core.review.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

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
            @Value("${app.recommendation.service.port}")
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
        return restTemplate.getForObject(url, Product.class);
    }


    @Override
    public List<Recommendation> getRecommendations(int productId) {
        String url = recommendationServiceUrl+productId;
        return restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Recommendation>>() {}).getBody();
    }

    @Override
    public List<Review> getReviews(int productId) {
        String url = reviewServiceUrl+productId;
        return restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Review>>() {}).getBody();

    }
}
