package com.amar.fullstack.springAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam("q") String query) {
        String responseContent = this.chatClient
                .prompt(query)
                .call()
                .content();

        return ResponseEntity.ok(responseContent);
    }
}