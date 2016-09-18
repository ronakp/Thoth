package com.digitalsquad.thoth;

/**
 * Created by ronak on 2016-09-17.
 */
public class MessageData {
    private long id;
    private boolean isMe;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIsme() {
        return isMe;
    }

    public void setMe(boolean isMe) {
        this.isMe = isMe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
