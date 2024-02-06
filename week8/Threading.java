class DisplayMessage extends Thread{
private String message;
private int interval;

public DisplayMessage(String message,int interval){
this.message=message;
this.interval=interval;
}
@Override
    public void run(){
        while(true) {
            System.out.println(message);
            try{
                Thread.sleep(interval*1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class Threading{
    public static void main(String[] args){
        DisplayMessage thread1 = new DisplayMessage("BMS College of Engineering", 10);
        DisplayMessage thread2 = new DisplayMessage("CSE", 2);
        thread1.start();
        thread2.start();
}
}
