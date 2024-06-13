import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class TestCheckAttendance {

    public Date jadwalMasuk;
    public Date jadwalKeluar;
    public Date waktuPresensiMasuk;
    public Date waktuPresensiKeluar;

    public TestCheckAttendance(Date jadwalMasuk, Date jadwalKeluar, Date waktuPresensiMasuk, Date waktuPresensiKeluar) {
        this.jadwalMasuk = jadwalMasuk;
        this.jadwalKeluar = jadwalKeluar;
        this.waktuPresensiMasuk = waktuPresensiMasuk;
        this.waktuPresensiKeluar = waktuPresensiKeluar;
    }

    @Parameters
    public static Collection<Object[]> data() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            return Arrays.asList(new Object[][] {
                    { sdf.parse("2024-06-12 09:00:00.000"), sdf.parse("2024-06-12 17:00:00.000"),
                            sdf.parse("2024-06-12 08:00:00.000"), sdf.parse("2024-06-12 17:00:00.000") },
                    { sdf.parse("2024-06-12 09:00:00.000"), sdf.parse("2024-06-12 17:00:00.000"),
                            sdf.parse("2024-06-12 08:45:00.000"), sdf.parse("2024-06-12 17:00:00.000") }
            });
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testPresensiHadirOnTime() {
        Boolean presensiHadir = CheckAttendance.presensiMasuk(jadwalMasuk, waktuPresensiMasuk);
        assertTrue(presensiHadir); // Expecting true because waktuPresensi is on time
    }

    @Test
    public void testPresensiKeluarOnTime() {
        Boolean presensiHadir = CheckAttendance.presensiMasuk(jadwalKeluar, waktuPresensiKeluar);
        assertTrue(presensiHadir); // Expecting true because waktuPresensi is on time
    }
}