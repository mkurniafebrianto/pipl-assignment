import java.util.Date;

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

}