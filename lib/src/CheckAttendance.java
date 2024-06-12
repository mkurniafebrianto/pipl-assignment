import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckAttendance {
    public static Boolean presensi(Date batasWaktu, Date waktuPresensi) {
        Boolean presensiHadir;
        if (waktuPresensi.after(batasWaktu)) {
            presensiHadir = false;
        } else {
            presensiHadir = true;
        }
        return presensiHadir;
    }

    private static final Map<String, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Daftar karyawan");
            System.out.println("2. Absen masuk");
            System.out.println("3. Absen keluar");
            System.out.println("4. Lihat rekap presensi");
            System.out.println("5. Keluar");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline character

            switch (choice) {
                case 1:
                    registerEmployee(scanner);
                    break;
                case 2:
                    markAttendanceIn(scanner);
                    break;
                case 3:
                    markAttendanceOut(scanner);
                    break;
                case 4:
                    viewAttendanceReport();
                    break;
                case 5:
                    running = false;
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    private static void registerEmployee(Scanner scanner) {
        System.out.print("Masukkan nama karyawan: ");
        String name = scanner.nextLine();
        employees.put(name, new Employee(name));
        System.out.println("Karyawan berhasil didaftarkan.");
    }

    private static void markAttendanceIn(Scanner scanner) {
        System.out.print("Masukkan nama karyawan: ");
        String name = scanner.nextLine();
        Employee employee = employees.get(name);
        if (employee != null) {
            employee.markAttendanceIn();
            System.out.println("Absen masuk berhasil dicatat.");
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    private static void markAttendanceOut(Scanner scanner) {
        System.out.print("Masukkan nama karyawan: ");
        String name = scanner.nextLine();
        Employee employee = employees.get(name);
        if (employee != null) {
            employee.markAttendanceOut();
            System.out.println("Absen keluar berhasil dicatat.");
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    private static void viewAttendanceReport() {
        System.out.println("Rekap presensi karyawan:");
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            System.out.println("Nama: " + employee.getName());
            System.out.println("Waktu masuk: " + employee.getCheckInTime());
            System.out.println("Waktu keluar: " + employee.getCheckOutTime());
            System.out.println();
        }
    }

    private static class Employee {
        private final String name;
        private LocalDateTime checkInTime;
        private LocalDateTime checkOutTime;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getCheckInTime() {
            return checkInTime != null ? checkInTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    : "Belum absen masuk";
        }

        public String getCheckOutTime() {
            return checkOutTime != null ? checkOutTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    : "Belum absen keluar";
        }

        public void markAttendanceIn() {
            checkInTime = LocalDateTime.now();
        }

        public void markAttendanceOut() {
            checkOutTime = LocalDateTime.now();
        }
    }

}