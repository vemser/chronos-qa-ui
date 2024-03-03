package chronos.utils;

import java.time.LocalDate;

public class FormatarData {

    public String formatarData(LocalDate data) {
        return String.format("%02d/%02d/%d", data.getDayOfMonth(), data.getMonthValue(), data.getYear());
    }
}
