package com.lss233.phoenix.command;

/**
 * .
 */
public interface CommandSender {
    void sendMessage(String message);

    void sendMessage(String[] message);
}
