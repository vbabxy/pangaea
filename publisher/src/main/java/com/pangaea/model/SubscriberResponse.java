package com.pangaea.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class SubscriberResponse implements Serializable {
    private String url;
    private String topic;
}
