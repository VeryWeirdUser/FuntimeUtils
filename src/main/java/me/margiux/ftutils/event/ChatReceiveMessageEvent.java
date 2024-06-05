package me.margiux.ftutils.event;

import net.minecraft.text.Text;

public class ChatReceiveMessageEvent extends Event {
    public final Text message;

    public ChatReceiveMessageEvent(Text message) {
        this.message = message;
    }
}
