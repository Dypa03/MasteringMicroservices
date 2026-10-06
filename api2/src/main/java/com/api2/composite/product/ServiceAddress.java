package com.api2.composite.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAddress {
    private String cmp;
    private String pro;
    private String rev;
    private String rec;
}
