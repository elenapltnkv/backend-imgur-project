package dao;

import lombok.Data;

import java.util.ArrayList;
@Data
public class AccountSettings {
    private Data data;
    private boolean success;
    private int status;

    @lombok.Data
    public static class Data{
        private String account_url;
        private String email;
        private String avatar;
        private Object cover;
        private boolean public_images;
        private String album_privacy;
        private boolean pro_expiration;
        private boolean accepted_gallery_terms;
        private ArrayList<Object> active_emails;
        private boolean messaging_enabled;
        private boolean comment_replies;
        private ArrayList<Object> blocked_users;
        private boolean show_mature;
        private boolean newsletter_subscribed;
        private boolean first_party;
    }
}
