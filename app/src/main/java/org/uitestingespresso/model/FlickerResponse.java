package org.uitestingespresso.model;

import java.io.Serializable;
import java.util.List;


public class FlickerResponse implements Serializable{

    private String title;
    private String link;
    private String description;
    private String modified;
    private String generator;
    private List<ItemsBean> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements Serializable {
        private String title;
        private String link;
        private MediaBean media;
        private String date_taken;
        private String description;
        private String published;
        private String author;
        private String author_id;
        private String tags;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public MediaBean getMedia() {
            return media;
        }

        public void setMedia(MediaBean media) {
            this.media = media;
        }

        public String getDate_taken() {
            return date_taken;
        }

        public void setDate_taken(String date_taken) {
            this.date_taken = date_taken;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public static class MediaBean implements Serializable {

            private String m;

            public String getM() {
                return m;
            }

            public void setM(String m) {
                this.m = m;
            }
        }
    }
}
