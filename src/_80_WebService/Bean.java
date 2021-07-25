package _80_WebService;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.Date;

@JsonSerialize
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bean {
    private int id = 9;
    private String prenom = "Julien";
    private Date date = new Date(2021, Calendar.MARCH,4);
    private Internal infos = new Internal();

    @Data
    @JsonSerialize
    @XmlAccessorType(XmlAccessType.PROPERTY)
    public class Internal{
        private String adresse = "mon adresse";
    }
}
