package csc.colleguescheduller.Models.Room;

/*
Ahmed Abd El Aziz
 */

public class Room {
    private String Roomid;
    private RoomType Type;
    private int Capacity;
    private RoomStatus Status;


    public Room()
    {

    }
    public void SetRoomId(String id)
    {
        this.Roomid=id;
    }
    public String GetRoomId()
    {
        return this.Roomid;
    }

    public void SetType(RoomType type)
    {
        this.Type=type;
    }
    public RoomType GetType()
    {
        return Type;
    }

    public void SetCapacity(int capacity)
    {
        this.Capacity=capacity;
    }
    public int GetCapacity()
    {
        return this.Capacity;
    }


    public void SetStatus(RoomStatus status)
    {
        this.Status=status;
    }
    public RoomStatus GetStatus()
    {
        return this.Status;
    }
}
