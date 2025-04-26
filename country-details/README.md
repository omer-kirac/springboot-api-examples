# Country Details API

Bu proje, ülke bilgilerini REST Countries API kullanarak sorgulayan bir Spring Boot uygulamasıdır.

## Teknolojiler

- Java 17
- Spring Boot 3.4.5
- Lombok
- Spring Web
- RESTful API

## Sistem Mimarisi

Proje, katmanlı bir mimariye sahiptir:

- **Controller**: Gelen HTTP isteklerini karşılar
- **Service**: İş mantığını yönetir
- **Provider**: Harici API ile iletişim kurar
- **Domain**: Veri modellerini içerir

## Endpoint

Uygulama, aşağıdaki endpoint'i sağlar:

- `GET /country/{name}`: Belirtilen isimle ülke bilgilerini getirir

### Örnek Yanıt

```json
{
  "name": "Turkey",
  "code": "TR",
  "currency": "TRY",
  "capital": "Ankara",
  "language": "Turkish",
  "border": ["Armenia, Azerbaijan, Bulgaria, Georgia, Greece, Iran, Iraq, Syria"],
  "flag": "https://flagcdn.com/w320/tr.png"
}
```

## Çalıştırma

Uygulamayı başlatmak için:

```bash
./mvnw spring-boot:run
```

Uygulama varsayılan olarak 8080 portunda çalışır.

## Kullanılan Dış Servis

Bu uygulama [REST Countries API](https://restcountries.com/) servisini kullanarak ülke verilerini alır.

## Geliştirme

Projeyi geliştirmek için:

1. Kodu klonlayın
2. Maven ile bağımlılıkları yükleyin
3. IDE'nizde çalıştırın veya `./mvnw spring-boot:run` komutunu kullanın

## Lisans

Bu proje özel kullanım içindir. 