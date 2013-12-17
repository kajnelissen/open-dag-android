package com.zuyd.fict.opendag.model;

/**
 * Created by Erwin on 19-10-13.
 */
public class Photo extends Entity {

    private String _image;


    private String _fileName;

    public Photo(int id, String image, String fileName) {
        super(id);
        this.setImage(image);
        this.setFileName(fileName);
    }

    public void setImage(String _image) {
        this._image = _image;
    }

    public void setFileName(String _fileName) {
        this._fileName = _fileName;
    }

    public String getFileName() {
        return _fileName;
    }

    public String getImage() {
        return _image;
    }
}
