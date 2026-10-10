package com.api2.core.recommendation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Recommendation {
    private int productId;
    private int recommendationId;
    private String author;
    private int rate;
    private String content;
    private String serviceAddress;

    public Recommendation() {
        productId = 0;
        recommendationId = 0;
        rate = 0;
    }
}
