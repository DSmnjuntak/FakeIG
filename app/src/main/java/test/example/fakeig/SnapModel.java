package test.example.fakeig;

import android.os.Parcel;
import android.os.Parcelable;

public class SnapModel implements Parcelable {
    private String name;
    private String images;

    public SnapModel(String name, String images) {
        this.name = name;
        this.images = images;
    }

    public SnapModel() {

    }

    protected SnapModel(Parcel in) {
        name = in.readString();
        images = in.readString();
    }

    public static final Creator<SnapModel> CREATOR = new Creator<SnapModel>() {
        @Override
        public SnapModel createFromParcel(Parcel in) {
            return new SnapModel(in);
        }

        @Override
        public SnapModel[] newArray(int size) {
            return new SnapModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(images);
    }
}
