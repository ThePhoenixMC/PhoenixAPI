package com.lss233.phoenix.command;

import com.lss233.phoenix.permissions.Permissible;

/**
 * .
 */
public interface CommandSender extends Permissible {
    void sendMessage(String message);

    void sendMessage(String[] message);
}
