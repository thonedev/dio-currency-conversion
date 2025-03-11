package dio_currency_conversion.repository;

import dio_currency_conversion.model.CurrencyConversion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends CrudRepository<CurrencyConversion, Long> {
}
