package csc.colleguescheduller.Models.Room;

public class Room {
    private String id;
    private RoomType type;
    private int capacity;
    private RoomStatus status;

    public Room() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public RoomType getType() {
        return type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public RoomStatus getStatus() {
        return this.status;
    }
}
