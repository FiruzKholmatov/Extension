package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode


public class Smartphone extends Product {
    protected String manufacturer;

    public Smartphone (int id, String name, int price, String manufacturer){
        super (id, name, price);

        this.manufacturer = manufacturer;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Smartphone that = (Smartphone) o;
//        return Objects.equals(manufacturer, that.manufacturer);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), manufacturer);
//    }
}
