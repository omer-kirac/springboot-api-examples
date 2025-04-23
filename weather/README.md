# Hava Durumu API Servisi

Bu proje, dış hava durumu API'sine bağlanan ve sonuçları Redis önbelleği ile optimize eden Spring Boot tabanlı bir servistir.

## Özellikler

- Şehir bazlı hava durumu verileri
- Önbellekleme ile API çağrı sayısını azaltma (Redis)
- 6 saatlik TTL ile otomatik önbellek yenileme

## Teknolojiler

- Spring Boot 3.4.4
- Spring Data Redis
- Java 17
- Maven



### Uygulamayı Çalıştırma

```bash
mvn spring-boot:run
```

## API Kullanımı

### Şehir için Hava Durumu Bilgisi Alma

```
GET /weather?city={şehir_adı}
```

**Örnek:**
```bash
curl "http://localhost:8080/weather?city=Istanbul"
```

**Yanıt örneği:**
```json
{
  "datetime": "2023-09-30",
  "address": "Istanbul, Turkey",
  "temperature": 22.7,
  "conditions": "Partly cloudy",
  "description": "Partly cloudy throughout the day with a chance of showers."
}
```

## Yapılandırma

Uygulama, `application.properties` dosyasında yapılandırılabilir:

```properties
# API yapılandırması
weather.api.url=https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{city}
weather.api.key=YOUR-API-KEY

# Redis yapılandırması
spring.data.redis.host=localhost
spring.data.redis.port=6379
redis.ttl.hours=6
```

## Önbellekleme Stratejisi

- Hava durumu verileri 6 saat süreyle önbelleğe alınır
- Aynı şehir için 6 saat içinde yapılan istekler API'ye ulaşmadan önbellekten yanıtlanır
- TTL süresi dolduğunda veriler otomatik olarak güncellenir

## Katkıda Bulunma

1. Bu depoyu fork edin
2. Yeni bir özellik dalı oluşturun (`git checkout -b yeni-ozellik`)
3. Değişikliklerinizi commit edin (`git commit -am 'Yeni özellik eklendi'`)
4. Dalınıza push yapın (`git push origin yeni-ozellik`)
5. Bir Pull Request oluşturun

## Lisans

Bu proje [MIT Lisansı](LICENSE) altında lisanslanmıştır. 