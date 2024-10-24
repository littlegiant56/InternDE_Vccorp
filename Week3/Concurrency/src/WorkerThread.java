public class WorkerThread implements Runnable {
    private String message;

    // Constructor nhận vào một thông báo (message)
    public WorkerThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) Message = " + message);
        processMessage();  // Giả lập quá trình xử lý công việc
        System.out.println(Thread.currentThread().getName() + " (End)");
    }

    private void processMessage() {
        try {
            Thread.sleep(2000);  // Giả lập thời gian xử lý công việc
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
