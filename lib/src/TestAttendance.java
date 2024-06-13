import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAttendance {

        @Parameterized.Parameter(0)
        public String testName;

        @Parameterized.Parameter(1)
        public LocalTime time;

        @Parameterized.Parameter(2)
        public boolean isCheckIn;

        @Parameterized.Parameter(3)
        public boolean isButtonEnabled;

        @Parameterized.Parameter(4)
        public String expectedResult;

        @Parameters(name = "{index}: {0} - {1} - {2} - {3}")
        public static Collection<Object[]> data() {
                return Arrays.asList(new Object[][] {
                                { "Presensi Masuk Tepat di Batas Awal", LocalTime.of(6, 0, 0), true, true,
                                                "presensi masuk berhasil dan kamu tepat waktu, MANTAB!" },
                                { "Presensi Masuk Dalam Rentang Waktu yang Diperbolehkan", LocalTime.of(8, 0, 0), true,
                                                true,
                                                "presensi masuk berhasil dan kamu tepat waktu, MANTAB!" },
                                { "Presensi Masuk Tepat di Batas Akhir ", LocalTime.of(8, 30, 0), true, true,
                                                "presensi masuk berhasil dan kamu tepat waktu, MANTAB!" },
                                { "Presensi Masuk Tepat Setelah Batas Akhir ", LocalTime.of(8, 30, 1), true, true,
                                                "presensi masuk berhasil tapi sayang kamu terlambat" },
                                { "Presensi Masuk Tepat di Batas Akhir Toleransi", LocalTime.of(9, 0, 0), true, true,
                                                "presensi masuk berhasil tapi sayang kamu terlambat" },
                                { "Presensi Masuk Di Luar Batas Waktu Toleransi ", LocalTime.of(9, 0, 1), true, false,
                                                "maaf presensi masuk gagal karena diluar waktu yang ditentukan" },

                                { "Presensi Keluar Tepat di Batas Awal", LocalTime.of(16, 30, 0), false, true,
                                                "presensi keluar berhasil, pulang pulang!" },
                                { "Presensi Keluar Dalam Rentang Waktu yang Diperbolehkan", LocalTime.of(16, 45, 0),
                                                false, true,
                                                "presensi keluar berhasil, pulang pulang!" },
                                { "Presensi Keluar Tepat di Batas Akhir ", LocalTime.of(17, 0, 0), false, true,
                                                "presensi keluar berhasil, pulang pulang!" },
                                { "Presensi Keluar Tepat Setelah Batas Akhir ", LocalTime.of(17, 0, 1), false, false,
                                                "maaf presensi keluar gagal karena diluar waktu yang ditentukan" }
                });
        }

        @Test
        public void testCheckAttendanceInAndOut() {
                assertEquals(expectedResult, Attendance.checkAttendanceInAndOut(time, isCheckIn));
        }

        @Test
        public void checkAttendanceIsButtonEnabled() {
                assertEquals(isButtonEnabled, Attendance.checkAttendanceIsButtonEnabled(time));
        }
}
