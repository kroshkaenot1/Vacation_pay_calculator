# Калькулятор отпускных

Микросервис Spring Boot для расчета отпускных. Поддерживает расчет отпускных
с указанием среднемесячной зарплаты и дней в отпуске, также можно указать дату ухода
в отпуск, тогда расчет отпускных будет производиться с учетом праздничных дней.
Дату необходимо указывать в формате год-месяц-день.

В микросервисе задействовано API производственного календаря https://www.isdayoff.ru/ посредством средства Spring Openfeign,
для расчета отпускных при указании даты ухода в отпуск.
API позволяет проверить является день выходным/праздничным.

        @FeignClient(name = "isDayOff", url = "https://isdayoff.ru")
        public interface DayOffFeignClient {
            @GetMapping("/{date}")
            String getDayOff(@DateTimeFormat(pattern = "yyyy-MM-dd")@PathVariable LocalDate date);
        }


### Для работы с микросервисом необходимо осуществлять GET запросы:

    localhost:8080/calculacte&salary=среднемесячная_зарплата&days=количество_дней_отпуска&date=дата_ухода_в_отпуск
    localhost:8080/calculacte&salary=среднемесячная_зарплата

#### Примеры запросов:

    http://localhost:8080/calculacte?salary=40000&days=14&date=2023-05-01
    http://localhost:8080/calculacte?salary=40000&days=14

#### Микросервис возвращает при корректно введенных данных json-массив данных

    {"salary":40000.0,
    "days":14,
    "startVacationDate":"2023-05-01",
    "amountOfVacationPay":15017.064846416382}

    {"salary":40000.0,
    "days":14,
    "startVacationDate":null,
    "amountOfVacationPay":19112.62798634812}
