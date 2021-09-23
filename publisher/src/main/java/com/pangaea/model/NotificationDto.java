package com.pangaea.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class NotificationDto implements Serializable {
    private String topic;
    private String data;
}
