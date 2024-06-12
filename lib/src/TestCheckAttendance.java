import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCheckAttendance {

    @Test
    public void testPresensiHadirOnTime() {
        Date jadwalMasuk = new Date(System.currentTimeMillis() + 1000); // 1 second in the future
        Date waktuPresensi = new Date(); // current time
        Boolean presensiHadir = CheckAttendance.presensiMasuk(jadwalMasuk, waktuPresensi);
        assertTrue(presensiHadir); // Expecting true because waktuPresensi is on time
    }

    @Test
    public void testPresensiHadirOnTime2() {
        // Create the date objects using the correct format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date jadwalMasuk;
        Date waktuPresensi;
        try {
            jadwalMasuk = sdf.parse("2024-06-12 07:00:00.000");
            waktuPresensi = sdf.parse("2024-06-12 06:30:00.000");
        } catch (ParseException e) {
            e.printStackTrace();
            return; // Exit the test method if there's an error parsing the dates
        }
        Boolean presensiHadir = CheckAttendance.presensiMasuk(jadwalMasuk, waktuPresensi);
        assertTrue(presensiHadir); // Expecting true because waktuPresensi is on time
    }

    @Test
    public void testPresensiHadirLate() {
        Date jadwalMasuk = new Date(System.currentTimeMillis() - 1000); // 1 second in the past
        Date waktuPresensi = new Date(); // current time

        Boolean presensiHadir = CheckAttendance.presensiMasuk(jadwalMasuk, waktuPresensi);
        assertFalse(presensiHadir); // Expecting false because waktuPresensi is late
    }
}