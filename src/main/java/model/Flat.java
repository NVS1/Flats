package model;

public class Flat {
    private int id;
    private String district;
    private String address;
    private int area;
    private int numOfRoom;
    private long price;

    public Flat(String district, String address, int area, int numOfRoom, long price) {
        this.district = district;
        this.address = address;
        this.area = area;
        this.numOfRoom = numOfRoom;
        this.price = price;
    }

    public Flat(String district, String address) {
        this.district = district;
        this.address = address;
    }

    public Flat() {
    }

    public int getId() {
        return id;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }

    public long getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", numOfRoom=" + numOfRoom +
                ", price=" + price +
                '}';
    }
}
