package com.zair.services;

import com.zair.entities.ChatMessage;
import com.zair.repositories.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    private final CharRoomService charRoomService;

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        Optional<String> chatId = charRoomService.findChatRoomId(senderId, recipientId, false);
        return chatId.map(chatMessageRepository::findAllByChatId).orElse(new ArrayList<>());
    }

    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = charRoomService.findChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
        ).orElseThrow();

        chatMessage.setChatId(chatId);

        return chatMessageRepository.save(chatMessage);
    }
}
