package entities;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillBean {
    private int uid;
    private int gid;
    private int number;
    private double price;
    private Date time;
}
