package lk.ijse.hibernate.hostalManagementSystem.dto.dtm;

public class RoomTM {
    private String roomTypeId;
    private String type;
    private String key_money;
    private int qty;

    public RoomTM() {
    }

    public RoomTM(String roomTypeId, String type, String key_money, int qty) {
        this.roomTypeId = roomTypeId;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey_money() {
        return key_money;
    }

    public void setKey_money(String key_money) {
        this.key_money = key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
