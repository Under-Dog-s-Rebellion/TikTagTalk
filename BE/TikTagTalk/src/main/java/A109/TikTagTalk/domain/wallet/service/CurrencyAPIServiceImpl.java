package A109.TikTagTalk.domain.wallet.service;

import A109.TikTagTalk.domain.wallet.dto.CurrencyDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class CurrencyAPIServiceImpl implements CurrencyAPIService{
    @Value("${currencyLayer.accessKey}")
    private String accessKey;
    @Value("${currencyLayer.url}")
    private String url;
    @Value("${currencyLayer.source}")
    private String source;
    @Value("${currencyLayer.currencies}")
    private String currencies;
    @Value("${currencyLayer.cycleTime}")
    private int cycleTime;

    private RestTemplate restTemplate;
    private CurrencyDto currency;

    public CurrencyAPIServiceImpl(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
            }

    @Override
    public CurrencyDto getCurrency() {
        if(ischeck()){
            currency = restTemplate.getForObject(
                    url + "?access_key=" + accessKey
                    + "&currencies=" + currencies
                            + "&source=" + source
                            + "&format=1",
                    CurrencyDto.class
            );
            System.out.println(currency.getSource());
        }
        return currency;
    }

    //현재 시간과 API를 통해 호출한 timestamp의 차이가
    //application.properties에 저장해 놓은 주기 시간보다 크면 API를 호출하도록 하는 메소드
    private boolean ischeck(){
        if(currency == null){
            return true;
        }
        long currentTime = TimeUnit.MICROSECONDS.toMinutes(System.currentTimeMillis());
        return currentTime - currency.getTimestamp() > cycleTime;
    }
}










