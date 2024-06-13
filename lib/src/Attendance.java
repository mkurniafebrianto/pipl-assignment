import java.time.LocalTime;

public class Attendance {

  public static String checkAttendanceInAndOut(LocalTime time, boolean isCheckIn) {

    // define range of attendance in and out
    final LocalTime startCheckIn = LocalTime.of(6, 0, 0); // 06:00:00
    final LocalTime endCheckIn = LocalTime.of(8, 30, 0); // 08:30:00
    final LocalTime maxToleranceCheckIn = endCheckIn.plusMinutes(30);

    final LocalTime startCheckOut = LocalTime.of(16, 30, 0); // 16:30:00
    final LocalTime endCheckOut = LocalTime.of(17, 0, 0); // 17:00:00

    // define initial state for button
    boolean isButtonEnabled = false;

    // if checkin
    if (isCheckIn) {

      // check whether checkin time in range or not
      if ((time.isAfter(startCheckIn) || time.equals(startCheckIn))
          && (time.isBefore(maxToleranceCheckIn) || time.equals(maxToleranceCheckIn))) {

        // enable button
        isButtonEnabled = true;

        // check attendance and return str
        if ((time.isAfter(startCheckIn) || time.equals(startCheckIn))
            && (time.isBefore(endCheckIn) || time.equals(endCheckIn))) {
          return "presensi masuk berhasil dan kamu tepat waktu, MANTAB!";
        } else if ((time.isAfter(endCheckIn))
            && (time.isBefore(maxToleranceCheckIn) || time.equals(maxToleranceCheckIn))) {
          return "presensi masuk berhasil tapi sayang kamu terlambat";
        }

      } else {

        // disable button
        isButtonEnabled = false;

        // return str
        return "maaf presensi masuk gagal karena diluar waktu yang ditentukan";
      }

      // if checkout
    } else {

      // check whether checkout time in range or not
      if ((time.isAfter(startCheckOut) || time.equals(startCheckOut))
          && (time.isBefore(endCheckOut) || time.equals(endCheckOut))) {

        // disable button
        isButtonEnabled = true;

        // return str
        return "presensi keluar berhasil, pulang pulang!";

      } else {

        // return str
        return "maaf presensi keluar gagal karena diluar waktu yang ditentukan";
      }
    }

    // if there is no condition match, return null
    return null;
  }

}