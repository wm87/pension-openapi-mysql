# Pensionen-Rechner REST API

Ein Java/Spring Boot basierter RESTful Webservice zur Berechnung und Verwaltung von Pensionsdaten für Beamte. Die API stellt Endpunkte zur Erfassung von Dienstdaten, Dienstzeiten, Versorgungsgründen, Beamtenkategorien und weiteren relevanten Informationen bereit. Grundlage bildet die Oberfläche der [Versorgungsauskunft](https://www.lff.rlp.de/service/versorgungsauskunft/versorgungsauskunftsprogramm) des Landesamtes für Finanzen (LfF) in Rheinland-Pfalz.

## 🌟 Features

* REST API zur Verwaltung von Pensionsinformationen
* Datenbankintegration mit JPA (H2/MySQL)
* Dokumentation via Swagger UI
* Import von Initialdaten via `curl`

---

## 🚀 Schnellstart

### Voraussetzungen

* Java 22
* Maven 3.9+

### Build und Start (lokal)

```bash
sudo apt install maven
mvn -N io.takari:maven:wrapper
mvn clean install
```

---

## ⚡️ Start

### Mit Docker Compose

```bash
docker-compose build
docker-compose up
```

---

## 🔍 Aufruf

Swagger UI ist unter folgender Adresse erreichbar:

```
http://localhost:8090/swagger-ui/index.html
```

---

## 📂 Datenmodell (Auszug)

* **Pension**: Geburtstag, Eintritt in den Ruhestand, Kategorie, Grund, Dienstzeiten, Familienstand
* **DutyHour**: Teilzeitverhältnisse, Zeiträume, Einschränkungen
* **OfficialCategory**: z. B. Lehrer, Professor, Feuerwehrbeamter
* **RetirementReason**: z. B. Regelaltersgrenze, Dienstunfähigkeit
* **OfficialTimeKey**: verschiedene Anrechnungszeiten
* **FamilyAllowance**: Familienzuschlag

---

## 🌐 API-Beispielaufrufe

Die folgenden `curl`-Befehle können zur Initialbefüllung verwendet werden:

```bash
# Beispiel: Pension anlegen
curl -X POST "http://localhost:8090/api/pensions" \
  -H "accept: */*" \
  -H "Content-Type: application/json" \
  -d '{
    "birthday": "2022-03-27",
    "firstRetirementDay": "2022-03-27",
    "justificationOfficialRelationship": "2022-03-27",
    "idAbbreviation": 0,
    "officialCategory": "string",
    "retirementReason": "string",
    "dutyHoursDto": [
        { "beginning": "2022-03-27", "ending": "2022-03-27", "officialId": 0, "restriction": "string" }
    ]
}'
```

Weitere `curl`-Beispiele zur Befüllung aller Entitäten findest du im Abschnitt *import-daten* (siehe Datei `import.sh` oder siehe oben).

---

## 🚜 Endpunkte (Auswahl)

| Methode | Pfad                                    | Beschreibung                     |
| ------- | --------------------------------------- | -------------------------------- |
| POST    | `/api/pensions`                         | Neue Pension erfassen            |
| POST    | `/api/dutyhours`                        | Neue Dienstzeit erfassen         |
| POST    | `/api/officialcategory`                 | Neue Beamtenkategorie anlegen    |
| POST    | `/api/retirementreason`                 | Versorgungsgrund erfassen        |
| POST    | `/api/officialtimekey`                  | Dienstzeit-Schlüssel erfassen    |
| POST    | `/api/familyallowance`                  | Familienzuschlag erfassen        |
| POST    | `/api/pensions/{id}/dutyhours/{id}/add` | Verknüpfung Pension → Dienstzeit |

---

## ⚙️ Technologiestack

* **Java 22**
* **Spring Boot 3.3.2**
* **Spring Data JPA**
* **MySQL/H2**
* **Swagger / OpenAPI (springdoc)**
* **Lombok**

---

## 🖊️ Hinweise

* **Java-Version**: Beachte Kompatibilitätsprobleme zwischen **Lombok** und **Java 24**. Verwende daher **Java 22**.
* **Swagger UI**: automatisiert generiert via `springdoc-openapi`
* **H2-Konsole** für Testdatenbank ggf. unter `http://localhost:8090/h2-console` verfügbar
* **Konfiguration** erfolgt über `application.properties` / `application.yml`

---

## 📦 Build Info (pom.xml)

Projekt basiert auf folgendem `pom.xml`:

```xml
<groupId>rlp.pension</groupId>
<artifactId>pension</artifactId>
<version>v2</version>
<description>Spring data jpa</description>
<dependencies>
  spring-boot-starter-web,
  spring-boot-starter-data-jpa,
  spring-boot-starter-validation,
  mysql-connector-j,
  h2,
  lombok,
  springdoc-openapi-starter-webmvc-ui
</dependencies>
```

---

## Meine Inspiration

Für die die Entwicklung meiner ersten REST-API hat mir folgende Seite entscheidend weitergeholfen:

[This repository belongs to Spring boot Rest Api+swagger+MySQL+Docker tutorial](https://mshaeri.com/blog/restful-spring-boot-application-swagger-mysql-docker-a-real-world-example/)

---

## 📃 Lizenz

Dieses Projekt steht unter der **MIT License**.




