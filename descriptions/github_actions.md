## GitHub Actions

`GitHub Actions` — это `CI/CD`-инструмент, который позволяет 
автоматизировать сборку, тестирование и развертывание кода. 

Он используется для:
- ✅ Запуска тестов при каждом `push/pull` request в `master`.
- ✅ Кэширования зависимостей `Maven` (ускоряет сборку).
- ✅ Генерации отчетов (`Surefire`, `ExtentReport`, `Allure`).

Файл располоагается в `.github/workflows`

Пример `CI` файла :

```yaml
name: Test and Report

on:
  push:
    branches: [ master ]
  pull_request:
    branches: [ master ]
  workflow_dispatch:

jobs:
  build:
    runs-on: windows-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Set up JDK 22
        uses: actions/setup-java@v3
        with:
          java-version: '22'
          distribution: 'temurin'

      - name: Cache Maven packages
        uses: actions/cache@v3
        with:
          path: ~/.m2/repository
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            ${{ runner.os }}-m2-

      - name: Build and test with Maven
        run: mvn clean test

      - name: Archive Surefire reports
        if: always()  # Загружает отчеты, даже если тесты упали
        uses: actions/upload-artifact@v3
        with:
          name: surefire-reports
          path: target/surefire-reports/

      - name: Generate Allure Report
        if: always() && success()
        run: |
          mvn allure:report
      - name: Upload Allure Report
        uses: actions/upload-artifact@v3
        with:
          name: allure-report
          path: target/allure-results/
```

Пример отчетов и логов после прохожения `CI` :
//TODO