package _80_WebService;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@JsonSerialize
@Data
public class Bean {
    private int toto = 9;
    private String truc = "trep";
    private Date date = new Date(2021, Calendar.MARCH,7);
}
