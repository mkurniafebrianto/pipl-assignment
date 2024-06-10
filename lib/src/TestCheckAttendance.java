import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Date;

public class TestCheckAttendance {

    @Test
    public void testPresensiHadirOnTime() {
        Date batasWaktu = new Date(System.currentTimeMillis() + 1000); // 1 second in the future
        Date waktuPresensi = new Date(); // current time

        Boolean presensiHadir = CheckAttendance.presensi(batasWaktu, waktuPresensi);
        assertTrue(presensiHadir); // Expecting true because waktuPresensi is on time
    }

    @Test
    public void testPresensiHadirLate() {
        Date batasWaktu = new Date(System.currentTimeMillis() - 1000); // 1 second in the past
        Date waktuPresensi = new Date(); // current time

        Boolean presensiHadir = CheckAttendance.presensi(batasWaktu, waktuPresensi);
        assertFalse(presensiHadir); // Expecting false because waktuPresensi is late
    }
}