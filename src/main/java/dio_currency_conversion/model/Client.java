package dio_currency_conversion.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    private CurrencyConversion currencyConversion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrencyConversion getCurrencyConversion() {
        return currencyConversion;
    }

    public void setCurrencyConversion(CurrencyConversion currencyConversion) {
        this.currencyConversion = currencyConversion;
    }
}
