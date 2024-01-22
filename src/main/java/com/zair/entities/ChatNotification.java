package com.zair.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ChatNotification {

    private String id;

    private String senderId;

    private String recipientId;

    private String content;
}
