package com.sun.chat.queue;

public interface MessagePublisher {

    void publish(final String message);
}