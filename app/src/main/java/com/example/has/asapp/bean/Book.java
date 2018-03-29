package com.example.has.asapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by has on 2018/3/27.
 */
public class Book implements Parcelable {
    public int bookId;
    public String bookName;

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(bookId);
        out.writeString(bookName);

    }
    @Override
    public int describeContents() {
        return 0;
    }


    public  static final Parcelable.Creator<Book> CREATOR=new Parcelable.Creator<Book>(){
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }
        @Override
        public Book[] newArray(int zise) {
            return new Book[zise];
        }
    };

    private Book(Parcel in){
        bookId=in.readInt();
        bookName=in.readString();
    }

}
