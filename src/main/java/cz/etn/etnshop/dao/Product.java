package cz.etn.etnshop.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = -2739622030641073946L;

    private int id;

    private String name;

    private int serialNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(unique = true, name = "serial_number")
    @SequenceGenerator(name = "serial_number_sequence", initialValue = 1, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial_number_sequence")
    public int getSerialNumber() {
        return serialNumber;
    }


    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Product {id: " + id + ",  name: " + name + ", sn: " + serialNumber + " }";
    }
}
