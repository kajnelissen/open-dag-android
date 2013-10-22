package com.zuyd.fict.opendag.model;

/**
 * Created by Erwin on 19-10-13.
 */
public class Photo extends Entity {

    private int _id;

    private String _image;


    private String _fileName;

    public Photo(int id, String image, String fileName) {
        super(id);
        this.setId(id);
        this.setImage(image);
        this.setFileName(fileName);
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setImage(String _image) {
        this._image = _image;
    }

    public void setFileName(String _fileName) {
        this._fileName = _fileName;
    }

    public int getId() {
        return _id;
    }

    public String getFileName() {
        return _fileName;
    }

    public String getImage() {
        return _image;
    }
}
