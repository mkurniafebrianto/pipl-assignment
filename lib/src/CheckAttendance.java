import java.util.Date;

public class CheckAttendance {
    public static Boolean presensiMasuk(Date jadwalMasuk, Date waktuPresensiMasuk) {
        Boolean presensiHadir;
        if (waktuPresensiMasuk.after(jadwalMasuk)) {
            presensiHadir = false;
        } else {
            presensiHadir = true;
        }
        return presensiHadir;
    }

    public static Boolean presensiKeluar(Date jadwalKeluar, Date waktuPresensiKeluar) {
        Boolean presensiHadir;
        if (waktuPresensiKeluar.after(jadwalKeluar)) {
            presensiHadir = true;
        } else {
            presensiHadir = false;
        }
        return presensiHadir;

    }

}