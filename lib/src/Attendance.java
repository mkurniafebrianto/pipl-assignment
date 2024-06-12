import java.time.LocalTime;

public class Attendance {

  public static String checkAttendanceInAndOut(LocalTime time, boolean isCheckIn, boolean isButtonEnabled) {

    final LocalTime startCheckIn = LocalTime.of(6, 0, 0);
    final LocalTime endCheckIn = LocalTime.of(8, 30, 0);
    final LocalTime maxToleranceCheckIn = endCheckIn.plusMinutes(30);

    final LocalTime startCheckOut = LocalTime.of(16, 30, 0);
    final LocalTime endCheckOut = LocalTime.of(17, 0, 0);

    if (isCheckIn) {
      // check whether checkin time in range or not
      if ((time.isAfter(startCheckIn) || time.equals(startCheckIn))
          && (time.isBefore(maxToleranceCheckIn) || time.equals(maxToleranceCheckIn))) {
        // if button enabled
        if (isButtonEnabled) {
          if ((time.isAfter(startCheckIn) || time.equals(startCheckIn))
              && (time.isBefore(endCheckIn) || time.equals(endCheckIn))) {
            return "presensi masuk berhasil dan kamu tepat waktu, MANTAB!";
          } else if ((time.isAfter(endCheckIn))
              && (time.isBefore(maxToleranceCheckIn) || time.equals(maxToleranceCheckIn))) {
            return "presensi masuk berhasil tapi sayang kamu terlambat";
          }
        }
      } else {
        // if not in range of checkin time & button disabled
        return "maaf presensi masuk gagal karena diluar waktu yang ditentukan";
      }
    } else {
      // check whether checkout time in range or not
      if ((time.isAfter(startCheckOut) || time.equals(startCheckOut))
          && (time.isBefore(endCheckOut) || time.equals(endCheckOut))) {
        return "presensi keluar berhasil, pulang pulang!";
      } else {
        return "maaf presensi keluar gagal karena diluar waktu yang ditentukan";
      }
    }

    return null;
  }

}