package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodBean {
    private int gid;
    private String name;
    private String introduce;
    private int type;
    private double price;
    private int mid;

    public GoodBean(String name, String introduce, int type, double price, int mid) {
        this.name = name;
        this.introduce = introduce;
        this.type = type;
        this.price = price;
        this.mid = mid;
    }
}
