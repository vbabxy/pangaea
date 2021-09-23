package com.pangaea.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Data
public class SubscriberRequest implements Serializable {
    @NotBlank(message = "Subscriber url missing")
    private String url;
}
