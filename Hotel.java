public class Hotel {

    String name;
    double income;
    Room [] rooms;

    Hotel (String n , int r )
    {
        name = n;
        rooms = new Room[r];
    }

    public double getIncome() {
        return income;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public String getName() {
        return name;
    }

    public boolean isFull ()
    {
        for(int i = 0;i<rooms.length;i++)
        {
            if(rooms[i].reserved)
                return false;
        }
        return true;
    }

    public boolean reserveRoom (Room r , int days)
    {
        if(!r.reserved)
        {
            r.reserved = true;
            income+= days*r.getPrice();
            return true;
        }else {
            return false;
        }
    }

    public int nuEmpty()
    {
        int empty = 0;
        for(int i = 0;i<rooms.length;i++)
        {
            if(!rooms[i].reserved)
                empty++;
        }
        return empty;
    }

    public String toString()
    {
        String s = "Name : "+name+"\n"+"Total Number of Rooms : "+rooms.length+
                   "\n"+"Number of Empty rooms : "+nuEmpty()+"\n"+"Income : "+getIncome();
        return s;
    }

}
abstract class Room {

    int roomNumber;
    boolean reserved;

    Room(int n)
    {
     roomNumber = n;
     reserved = false;
    }

    public int getRoomNumber()
    {
        return roomNumber;
    }

    public void setReserved(boolean r)
    {
        reserved = r;
    }

    public abstract double getPrice();

}

class SingleRoom extends Room {

    SingleRoom (int n)
    {
        super(n);
        reserved = false;
    }

    @Override
    public double getPrice() {
        return 200;
    }
}

class DoubleRoom extends Room {

    DoubleRoom (int n)
    {
        super(n);
        reserved = false;
    }

    @Override
    public double getPrice() {
        return 300;
    }
}

class test61 {
    public static void main(String[] args) {

        Hotel h = new Hotel("Alexandria", 6);

        h.rooms[0] = new SingleRoom(1);
        h.rooms[1] = new SingleRoom(2);
        h.rooms[2] = new SingleRoom(3);
        h.rooms[3] = new DoubleRoom(4);
        h.rooms[4] = new DoubleRoom(5);
        h.rooms[5] = new DoubleRoom(6);

            h.reserveRoom(h.rooms[1], 3);

        System.out.println(h);
    }
}