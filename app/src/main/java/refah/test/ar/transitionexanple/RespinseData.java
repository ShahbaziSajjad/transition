package refah.test.ar.transitionexanple;

public class RespinseData {
    String ImageUrl;
    String Title;

    public String getImageUrl() {
        return ImageUrl;
    }

    public RespinseData(String imageUrl, String title) {
        ImageUrl = imageUrl;
        Title = title;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
