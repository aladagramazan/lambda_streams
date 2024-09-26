package com.rem.streams_lambda.distinct;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private Integer productId;
    private String productName;

}
