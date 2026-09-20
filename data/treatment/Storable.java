package data.treatment;

public interface Storable {
    public String toStore();
    public void toRead(String readableString);
}