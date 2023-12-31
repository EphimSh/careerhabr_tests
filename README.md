# [career.habr.com](https://career.habr.com/) autotests

<h1>Демопроект автоматизации тестов на поиск вакансии и специалистов на сайте career.habr</h1>

##  Содержание 

* <a href="#tools">Технологии и инструменты</a>

* <a href="#console">Запуск тестов из терминала</a>

* <a href="#jenkins">Запуск тестов в Jenkins</a>

* <a href="#telegram">Уведомления в Telegram</a>

* <a href="#allure">Allure Report отчеты</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>


<a id="tools"></a>
## Технологии и инструменты

| Java | IntelliJ Idea | Allure | Allure TestOps | GitHub | JUnit 5 | Gradle | REST Assured | Jenkins | Jira | Selenoid |
| ---- | ------------- | ------ | ------------- | ------ | -------| ------ | ------------| --------| ----- | -------- |
| <a href="https://www.java.com/"><img src="media/logos/Java.svg" width="50" height="50"  alt="Java"/></a> | <div align="center"><a id ="tech" href="https://www.jetbrains.com/idea/"><img src="media/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a></div> | <a href="https://github.com/allure-framework"><img src="media/logos/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a> | <div align="center"><a href="https://qameta.io/"><img src="media/logos/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a></div> | <a href="https://github.com/"><img src="media/logos/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <div align="center"><a href="https://rest-assured.io/"><img src="media/logos/RestAssured.svg" width="50" height="50"  alt="RestAssured"/></a></div>  |   <a href="https://www.jenkins.io/"><img src="media/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/ru/software/jira"><img src="media/logos/Jira.svg" width="50" height="50"  alt="Jira"/></a> | <a href="https://aerokube.com/selenoid/"><img src="media/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> |


Автотесты в этом проекте написаны на Java.

- <code>Gradle</code> — используется как инструмент автоматизации сборки.
- <code>JUnit5</code> — для выполнения тестов.
- <code>REST Assured</code> — для тестирования REST-API сервисов.
- <code>Allure Report</code> — для визуализации результатов тестирования.
- <code>Allure TestOps</code> — как система управления тестированием.
- <code>Jira</code> — как инструмент управления проектом и таск-трекер.
- <code>Telegram Bot</code> — для уведомлений о результатах тестирования.
- <code>Selenoid</code> — использовался для быстрого прогона тестов с возможностью получения видеозаписей тестов.

```mermaid
---
title: "Путь пользователя при поиске вакансии"
---
graph TD
    A[Соискатель] -->|Заходит на сайт| B(Начать поиск)
    B -->|Ищет по ключевому слову| C(Результаты поиска)
    C -->|Может отфильтровать по:| D(Отфильтрованные результаты)
    D -->|Специализация| E
    D -->|Квалификация| F
    D -->|Зарплата| G
    D -->|Местоположение| H
    D -->|Тип занятости| I
    D -->|Компания| J
    E -->|Просмотр вакансий| K
    F -->|Просмотр вакансий| K
    G -->|Просмотр вакансий| K
    H -->|Просмотр вакансий| K
    I -->|Просмотр вакансий| K
    J -->|Просмотр вакансий| K
    K -->|Выбор подходящей вакансии| L(Просматривает вакансию)
    L -->|Откликается| M(Отправляет резюме)
```



***Удалённый запуск реализован через сборку в  Jenkins:***

```bash  
clean test
```


<a id="jenkins"></a>
## <img src="media/logos/Jenkins.svg" width="25" height="25"/></a> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/career_habr_tests/)

<p align="center">

> Для запуска необходимо нажать "Собрать с параметрами".

<a href="https://jenkins.autotests.cloud/job/AD_demo_api_reqres/"><img src="media/screenshots/jenkins_build.png" alt="Jenkins"/></a>

## <img alt="Selenoid" height="25" src="media/logos/Selenoid.svg" width="25"/></a> Пример видео выполнения тестов на Selenoid
____
<p align="left">
<img title="Selenoid Video" src="media/screenshots/sidebar-filter-autotest.gif" width="720"   alt="video">   
</p>

<a id="telegram"></a>
## <img src="media/screenshots/telegram-notification.png" width="25" height="25"/></a> Уведомления в Telegram

<p >
> С помощью настроенного бота после завершения прогона в Jenkins поступают уведомления в Telegram.

<img title="telegram bot" src="media/screenshots/telegram.png">
</p>

<a id="allure"></a>
## <img src="media/logos/Allure_Report.svg" width="25" height="25"/></a> [Allure Report](https://jenkins.autotests.cloud/job/career_habr_tests/allure/) отчеты
### Основное окно

<p align="center">
<img title="Allure Dashboard" src="media/screenshots/allure-report-dashboard.png">
</p>

### Отчеты по тестам

<p align="center">

> В отчете по тестам присутствует развернутая информация по запросам и ответам.

<img title="Allure Tests" src="media/screenshots/allure-report-testcase.png">
</p>

<a id="allure-testops"></a>
## <img src="media/logos/AllureTestOps.svg" width="25" height="25"/></a> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3704/dashboards)

### Основное окно

<p align="center">
<img title="Allure TestOps" src="media/screenshots/allure-testops-dashboard.png">
</p>

### Иерархия тестов в ветке

<p align="center">
<img title="Allure TestOps" src="media/screenshots/allure-testops-testcase.png">
</p>

<a id="jira"></a>
## <img src="media/logos/Jira.svg" width="25" height="25"/></a> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-908)

<p align="center">
<img title="Jira" src="media/screenshots/jira.png">
</p>
