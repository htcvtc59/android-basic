package app.appreadjson;

public class RowItem {
    private String author;
    private String title;
    private String desc;
    private String url;
    private String urltoimage;
    private String publishedat;

    public RowItem() {
    }

    public RowItem(String author, String title, String desc, String url, String urltoimage, String publishedat) {
        this.author = author;
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.urltoimage = urltoimage;
        this.publishedat = publishedat;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public void setUrltoimage(String urltoimage) {
        this.urltoimage = urltoimage;
    }

    public String getPublishedat() {
        return publishedat;
    }

    public void setPublishedat(String publishedat) {
        this.publishedat = publishedat;
    }
}
