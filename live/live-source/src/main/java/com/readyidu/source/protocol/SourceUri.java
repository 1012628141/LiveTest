package com.readyidu.source.protocol;

/**
 * Created by yuzhang on 17/6/9.
 * sourceUri://hangzhou/htv1/source_hulu_htv1
 */
public class SourceUri {
    private static final String SOURCE_SCHEME = "sourceUri://";

    private String local;
    private String channel;
    private String source;

    public SourceUri(String uri) {
        if (SourceUri.isSourceUri(uri)) {
            uri = uri.replace(SOURCE_SCHEME, "");
            String[] uriSplit = uri.split("/");
            local = uriSplit[0];
            channel = uriSplit[1];
            source = uriSplit[2];
        }
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static boolean isSourceUri(String uri) {
        if(!uri.startsWith(SOURCE_SCHEME)){
            return false;
        }
        String uriContent = uri.replace(SOURCE_SCHEME, "");
        String[] uriSplit = uriContent.split("/");
        return uriSplit.length == 3;
    }

    @Override
    public String toString() {
        return "SourceUri{" +
                "local='" + local + '\'' +
                ", channel='" + channel + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
