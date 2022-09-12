# API Entegrasyon Testi #
Bu projede Hepsiburada tarafından verilen case oluşturulmuş olup JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi yapılmıştır.   <br /><br />

## Proje Özellikleri
* Rest-Assured ile Java dilinde API entegrasyon otomasyonu projesi.
* Url: http://generator.swagger.io
* Seçilen Endpoint: /api/gen/clients
* Projedeki istek metodları : GET ve POST
* Assertion için JUnit kütüphanesi kullanıldı.
* Proje çıktısı, Response body ve response status code bilgileridir. 
* Başarılı response için Status code 200, başarısız için 500 ve 400 olarak "Assertion Error" vermekte.

## Task İsterleri
-JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi yazınız. <br />
(Örnek url: http://generator.swagger.io)  <br />
-Tarafınızdan seçilecek birer tane GET ve POST endpointleri için Http status code 200 verirse başarılı,
değilse başarısız olarak rapor edilmelidir.

## Test Çıktısı
Başarılı POST datası ile sonuç  <br />
```
Response POST Body is =>  {"code":"d40029be-eda6-4d62-b1ef-d05e2e91a72a","link":"http://generator.swagger.io:80/api/gen/download/d40029be-eda6-4d62-b1ef-d05e2e91a72a"} 
Response POST Status Code =>  200 
```

Hatalı POST datası ile sonuç  <br />
```
PostClientsWithGetData : Response POST Body is =>  {"code":500,"type":"unknown","message":"something bad happened"}
PostClientsWithGetData : Response POST Status Code =>  500
```

Başarılı GET datası ile sonuç  <br />
```
GetClients : Response GET Body is =>  ["ada","akka-scala","android","apex","bash","clojure","cpprest","csharp","csharp-dotnet2","cwiki","dart","dart-jaguar","dynamic-html","eiffel","elixir","elm","erlang-client","flash","go","groovy","haskell-http-client","html","html2","java","javascript","javascript-closure-angular","jaxrs-cxf-client","jmeter","kotlin","lua","objc","perl","php","powershell","python","qt5cpp","r","ruby","rust","scala","scalaz","swagger","swagger-yaml","swift","swift3","swift4","swift5","tizen","typescript-angular","typescript-angularjs","typescript-aurelia","typescript-fetch","typescript-inversify","typescript-jquery","typescript-node","ue4cpp"]
GetClients : Response GET Status Code =>  200
```

Hatalı GET datası ile sonuç  <br />
```
getClientBadRequest : Response GET Body is =>  {"code":1,"type":"error","message":"Unsupported target 33 supplied. java.lang.RuntimeException: Can't load config class with name 33 Available: ada\nada-server\nakka-scala\nandroid\napache2\napex\naspnetcore\nbash\ncsharp\nclojure\ncwiki\ncpprest\ncsharp-dotnet2\ndart\ndart-jaguar\nelixir\nelm\neiffel\nerlang-client\nerlang-server\nfinch\nflash\npython-flask\ngo\ngo-server\ngroovy\nhaskell-http-client\nhaskell\njmeter\njaxrs-cxf-client\njaxrs-cxf\njava\ninflector\njaxrs-cxf-cdi\njaxrs-spec\njaxrs\nmsf4j\njava-pkmst\njava-play-framework\njaxrs-resteasy-eap\njaxrs-resteasy\njavascript\njavascript-closure-angular\njava-vertx\nkotlin\nlua\nlumen\nnancyfx\nnodejs-server\nobjc\nperl\nphp\npowershell\npistache-server\npython\nqt5cpp\nr\nrails5\nrestbed\nruby\nrust\nrust-server\nscala\nscala-lagom-server\nscalatra\nscalaz\nphp-silex\nsinatra\nslim\nspring\ndynamic-html\nhtml2\nhtml\nswagger\nswagger-yaml\nswift5\nswift4\nswift3\nswift\nphp-symfony\ntizen\ntypescript-aurelia\ntypescript-angular\ntypescript-inversify\ntypescript-angularjs\ntypescript-fetch\ntypescript-jquery\ntypescript-node\nue4cpp\nundertow\nze-ph\nkotlin-server\n"}
getClientBadRequest : Response GET Status Code =>  400
```