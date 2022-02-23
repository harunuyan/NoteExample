package Model;

public class NoteModel {
    private final String id;
    private String title;
    private String content;
    private Long publishDateInMillis;

    public NoteModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPublishDateInMillis() {
        return publishDateInMillis;
    }

    public void setPublishDateInMillis(Long publishDateInMillis) {
        this.publishDateInMillis = publishDateInMillis;
    }

    @Override
    public String toString() {
        return "NoteModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishDateInMillis=" + publishDateInMillis +
                '}';
    }
}
