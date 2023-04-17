package net.mds.newstory.story.managers;

public class EntryPoints {
    private String PointsName;
    private boolean Active;
    private int PointsCount = 0;

    public EntryPoints(int pointsCount, boolean active, String pointsName) {
        this.PointsCount = pointsCount;
        this.PointsName = pointsName;
        this.Active = active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public boolean getActive() {
        return Active;
    }
    public int getPointsCount() {
        return PointsCount;
    }
    public String getPointsName() {
        return PointsName;
    }
}