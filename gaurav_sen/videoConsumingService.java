interface database{
    WatchedVideo getWatchedVideo(String userid,String videoid);
}
public class videoConsumingService{
    database database;
    videoConsumingService(database db){
        this.database=db;
    }
    public int seekTime(String userId, String videoId){
        WatchedVideo w=database.getWatchedVideo(userId,videoId);
        return w.getSeekTime();
    }    
}
class VideoService{
    private FileSystem f;
    public Frame getFrame(String video, int timeStamp){
        Video v=f.getVideo(video);
        Frame f=v.getFrame(timeStamp);
        return f;
    }

}
class FileSystem{
    Video getVideo(String videoId){
        return null;
    }
}
class Video{
    Frame [] frames;
    String metaData;
    String id;
    Frame getFrame(int timeStamp){
        for(Frame f:frames){
            if(f.startTimeStamp<timeStamp&&f.endTimeStamp>timeStamp){
                return f;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
class Frame{
    byte[] bytes;
    int startTimeStamp;
    int endTimeStamp;
    int frameTime=10;
}
class User{
    String id;
    String Name;
    String email;
    String getID(){
        return id;
    }
}
class WatchedVideo{
    String id;
    String videoid;
    String Userid;
    int seekTime;
    public int getSeekTime(){
        return seekTime;
    }
}