import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Tạo ThreadPool với 3 luồng
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Gửi 5 nhiệm vụ đến ThreadPool
        for (int i = 1; i <= 5; i++) {
            Runnable worker = new WorkerThread("message " + i);
            executor.execute(worker);  // Thực thi nhiệm vụ
        }

        // Đóng ThreadPool sau khi tất cả nhiệm vụ được hoàn thành
        executor.shutdown();

        // Kiểm tra xem ThreadPool đã hoàn tất xử lý tất cả nhiệm vụ chưa
        while (!executor.isTerminated()) {
        }

        System.out.println("Tất cả nhiệm vụ đã được hoàn thành.");
    }
}
