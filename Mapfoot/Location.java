import greenfoot.*;
import java.util.*;

public class Location extends Actor
{
    private int x;
    private int y;
    private double distance;

    private ArrayList<Edge> connectedEdges;
    
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        distance = Integer.MAX_VALUE;
        connectedEdges = new ArrayList<>();
    }
    
    public void act() 
    {

    }   
    
    public boolean equals(Location l) {
        return l.x == this.x && l.y == this.y;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void setDistance(double newDistance) {
        distance = newDistance;
    }

    public double getDistance() {
        return distance;
    }

    public double getDistance(Location l) {
        return Math.sqrt((Math.pow(l.getX() - getX(), 2) + Math.pow(l.getY() - getY(), 2)));
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public static Location[] getClosest(List<Location> connected, List<Location> notConnected) {
        Location[] pair = {connected.get(0), notConnected.get(0)};
        for (int i = 0; i < connected.size(); i++) {
            for (int j = 0; j < notConnected.size(); j++) {
                if (connected.get(i).getDistance(notConnected.get(j)) < pair[0].getDistance(pair[1])) {
                    pair[0] = connected.get(i);
                    pair[1] = notConnected.get(j);
                }
            }
        }
        return pair;
    }
}
