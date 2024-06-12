import java.util.Date;

public class CheckAttendance {
    public static Boolean presensiMasuk(Date jadwalMasuk, Date waktuPresensi) {
        Boolean presensiHadir;
        if (waktuPresensi.after(jadwalMasuk)) {
            presensiHadir = false;
        } else {
            presensiHadir = true;
        }
        return presensiHadir;
    }

    public static Boolean presensiKeluar(Date jadwalKeluar, Date waktuPresensi) {
        Boolean presensiHadir;
        if (waktuPresensi.after(jadwalKeluar)) {
            presensiHadir = false;
        } else {
            presensiHadir = true;
        }
        return presensiHadir;

    }

}