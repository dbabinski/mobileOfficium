package pl.mobile.divinumofficium;

public class ViewCardModel {

    int title;
    int image;

    public ViewCardModel(int title, int image) {
        this.title = title;
        this.image = image;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
